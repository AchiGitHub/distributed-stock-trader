package ds.assignment.trading.server;

import ds.assignment.trading.grpc.generated.SetStockRequest;
import ds.assignment.trading.grpc.generated.SetStockResponse;
import ds.assignment.trading.grpc.generated.SetStockServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.zookeeper.KeeperException;

import java.util.List;

public class SetStockServiceImpl extends SetStockServiceGrpc.SetStockServiceImplBase {
    private ManagedChannel channel = null;
    SetStockServiceGrpc.SetStockServiceBlockingStub clientStub = null;
    private TradingServer server;

    public SetStockServiceImpl(TradingServer server) {
        this.server = server;
    }

    @Override
    public void setStock(ds.assignment.trading.grpc.generated.SetStockRequest request,
                         io.grpc.stub.StreamObserver<ds.assignment.trading.grpc.generated.SetStockResponse> responseObserver) {
        double price = request.getPrice();
        int units = request.getUnits();

        boolean status = false;

        if (server.isLeader()){
            // Act as primary
            try {
                System.out.println("Updating Stock as Primary");
                setTradingStock(price, units);
                updateSecondaryServers(price, units);
                status = true;
            } catch (Exception e) {
                System.out.println("Error while updating the stock" + e.getMessage());
                e.printStackTrace();
            }
        } else {
            // Act As Secondary
            if (request.getIsSentByPrimary()) {
                System.out.println("Updating Stock on secondary, on Primary's command");
                setTradingStock(price, units);
            } else {
                SetStockResponse response = callPrimary(price, units);
                if (response.getStatus()) {
                    status = true;
                }
            }
        }
        SetStockResponse response = SetStockResponse.newBuilder().setStatus(status).build();
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
}
