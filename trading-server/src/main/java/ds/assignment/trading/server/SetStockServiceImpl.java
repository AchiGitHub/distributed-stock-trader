package ds.assignment.trading.server;

import ds.assignment.trading.grpc.generated.SetStockRequest;
import ds.assignment.trading.grpc.generated.SetStockResponse;
import ds.assignment.trading.grpc.generated.SetStockServiceGrpc;
import ds.assignment.trading.synchronizer.lock.tx.DistributedTxCoordinator;
import ds.assignment.trading.synchronizer.lock.tx.DistributedTxListener;
import ds.assignment.trading.synchronizer.lock.tx.DistributedTxParticipant;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.AbstractMap;
import java.util.List;
import java.util.UUID;

public class SetStockServiceImpl extends SetStockServiceGrpc.SetStockServiceImplBase implements DistributedTxListener {
    private ManagedChannel channel = null;
    SetStockServiceGrpc.SetStockServiceBlockingStub clientStub = null;
    private TradingServer server;
    private AbstractMap.SimpleEntry<Double, Integer> tempDataHolder;
    private boolean transactionStatus = false;

    public SetStockServiceImpl(TradingServer server) {
        this.server = server;
    }

    private void startDistributedTx(double price, int units) {
        try {
            server.getSetStockTransaction().start("D", String.valueOf(UUID.randomUUID()));
            tempDataHolder = new AbstractMap.SimpleEntry<>(price, units);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void setStock(ds.assignment.trading.grpc.generated.SetStockRequest request,
                         io.grpc.stub.StreamObserver<ds.assignment.trading.grpc.generated.SetStockResponse> responseObserver) {
        double price = request.getPrice();
        int units = request.getUnits();

        if (server.isLeader()){
            // Act as primary
            try {
                System.out.println("Updating Stock as Primary");
                startDistributedTx(price, units);
                updateSecondaryServers(price, units);
                System.out.println("going to perform");
                if (price > 0) {
                    ((DistributedTxCoordinator)server.getSetStockTransaction()).perform();
                } else {
                    ((DistributedTxCoordinator)server.getSetStockTransaction()).sendGlobalAbort();
                }
            } catch (Exception e) {
                System.out.println("Error while updating the stock" + e.getMessage());
                e.printStackTrace();
            }
        } else {
            // Act As Secondary
            if (request.getIsSentByPrimary()) {
                System.out.println("Updating Stock on secondary, on Primary's command");
                startDistributedTx(price, units);
                if (price > 0){
                    ((DistributedTxParticipant)server.getSetStockTransaction()).voteCommit();
                } else {
                    ((DistributedTxParticipant)server.getSetStockTransaction()).voteAbort();
                }
            } else {
                SetStockResponse response = callPrimary(price, units);
                if (response.getStatus()) {
                    transactionStatus = true;
                }
            }
        }
        SetStockResponse response = SetStockResponse.newBuilder().setStatus(transactionStatus).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void setTradingStock(double price, int units) {
        server.setStock(price, units);
        System.out.println("Stock Updated!");
    }

    private SetStockResponse callServer(double price, int units, boolean isSentByPrimary, String IPAddress, int port) {
        System.out.println("Call Server " + IPAddress + ":" + port);
        channel = ManagedChannelBuilder.forAddress(IPAddress, port)
                .usePlaintext()
                .build();
        clientStub = SetStockServiceGrpc.newBlockingStub(channel);
        SetStockRequest request = SetStockRequest.newBuilder()
                .setPrice(price)
                .setUnits(units)
                .setIsSentByPrimary(isSentByPrimary)
                .build();
        SetStockResponse response = clientStub.setStock(request);
        return response;
    }

    private SetStockResponse callPrimary(double price, int units) {
        System.out.println("Calling Primary server");
        String[] currentLeaderData = server.getCurrentLeaderData();
        String IPAddress = currentLeaderData[0];
        int port = Integer.parseInt(currentLeaderData[1]);
        return callServer(price, units, false, IPAddress, port);
    }

    private void updateSecondaryServers(double price, int units) throws KeeperException, InterruptedException {
        System.out.println("Updating secondary servers");
        List<String[]> othersData = server.getOthersData();
        for (String[] data : othersData) {
            String IPAddress = data[0];
            int port = Integer.parseInt(data[1]);
            callServer(price, units, true, IPAddress, port);
        }
    }

    @Override
    public void onGlobalCommit() {
        setStockUpdate();
    }

    @Override
    public void onGlobalAbort() {
        tempDataHolder = null;
        System.out.println("Transaction Aborted by the Coordinator");
    }

    private void setStockUpdate() {
        if (tempDataHolder != null) {
            double price = tempDataHolder.getKey();
            int units = tempDataHolder.getValue();
            setTradingStock(price, units);
            tempDataHolder = null;
        }
    }
}
