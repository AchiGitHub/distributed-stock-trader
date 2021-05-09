package ds.assignment.trading.server;

import ds.assignment.trading.grpc.generated.DeleteOrderRequest;
import ds.assignment.trading.grpc.generated.DeleteOrderResponse;
import ds.assignment.trading.grpc.generated.DeleteOrderServiceGrpc;
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

public class DeleteOrderServiceImpl extends DeleteOrderServiceGrpc.DeleteOrderServiceImplBase implements DistributedTxListener {

    private TradingServer server;
    private ManagedChannel channel = null;
    DeleteOrderServiceGrpc.DeleteOrderServiceBlockingStub clientStub = null;
    private String tempDataHolder;
    private boolean transactionStatus = false;


    public DeleteOrderServiceImpl(TradingServer server) {
        this.server = server;
    }

    private void startDistributedTx(String orderId) {
        try {
            server.getDeleteOrderTransaction().start(orderId, String.valueOf(UUID.randomUUID()));
            tempDataHolder = orderId;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteOrder(ds.assignment.trading.grpc.generated.DeleteOrderRequest request,
                            io.grpc.stub.StreamObserver<ds.assignment.trading.grpc.generated.DeleteOrderResponse> responseObserver) {
        String orderId = request.getOrderId();
        System.out.println("Request Received...");

        if(server.isLeader()) {
            // Act as primary
            try {
                System.out.println("Deleting Order as Primary");
                startDistributedTx(orderId);
                updateSecondaryServers(orderId);
                System.out.println("going to perform");
                if (orderId != null){
                    ((DistributedTxCoordinator)server.getDeleteOrderTransaction()).perform();
                } else {
                    ((DistributedTxCoordinator)server.getDeleteOrderTransaction()).sendGlobalAbort();
                }
            } catch (Exception e) {
                System.out.println("Error while Deleting Order" + e.getMessage());
                e.printStackTrace();
            }
        } else {
            // Act As Secondary
            if (request.getIsSentByPrimary()) {
                System.out.println("Deleting Order on secondary, on Primary's command");
                startDistributedTx(orderId);
                if (orderId != null) {
                    ((DistributedTxParticipant)server.getDeleteOrderTransaction()).voteCommit();
                } else {
                    ((DistributedTxParticipant)server.getDeleteOrderTransaction()).voteAbort();
                }
            } else {
                DeleteOrderResponse response = callPrimary(orderId);
                if (response.getStatus()) {
                    transactionStatus = true;
                }
            }
        }
        DeleteOrderResponse response = DeleteOrderResponse.newBuilder().setStatus(transactionStatus).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void deleteTradeOrder(String orderId) {
        server.deleteOrder(orderId);
        System.out.println("Order Deleted -  " + orderId);
    }

    private DeleteOrderResponse callServer(String orderId, boolean isSentByPrimary, String IPAddress, int port) {
        System.out.println("Call Server " + IPAddress + ":" + port);
        channel = ManagedChannelBuilder.forAddress(IPAddress, port)
                .usePlaintext()
                .build();
        clientStub = DeleteOrderServiceGrpc.newBlockingStub(channel);
        DeleteOrderRequest request = DeleteOrderRequest.newBuilder()
                .setOrderId(orderId)
                .setIsSentByPrimary(isSentByPrimary)
                .build();
        DeleteOrderResponse response = clientStub.deleteOrder(request);
        return response;
    }

    private DeleteOrderResponse callPrimary(String orderId) {
        System.out.println("Calling Primary server");
        String[] currentLeaderData = server.getCurrentLeaderData();
        String IPAddress = currentLeaderData[0];
        int port = Integer.parseInt(currentLeaderData[1]);
        return callServer(orderId, false, IPAddress, port);
    }

    private void updateSecondaryServers(String orderId) throws KeeperException, InterruptedException {
        System.out.println("Updating secondary servers");
        List<String[]> othersData = server.getOthersData();
        for (String[] data : othersData) {
            String IPAddress = data[0];
            int port = Integer.parseInt(data[1]);
            callServer(orderId, true, IPAddress, port);
        }
    }

    private void deleteOrderUpdate() {
        if (tempDataHolder != null) {
            String orderId = tempDataHolder;
            server.deleteOrder(orderId);
            System.out.println("Order " + orderId + " Deleted!");
            tempDataHolder = null;
        }
    }

    @Override
    public void onGlobalCommit() {
        deleteOrderUpdate();
    }

    @Override
    public void onGlobalAbort() {
        tempDataHolder = null;
        System.out.println("Transaction Aborted by the Coordinator");
    }
}
