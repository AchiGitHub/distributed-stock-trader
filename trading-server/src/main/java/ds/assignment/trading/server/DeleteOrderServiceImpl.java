package ds.assignment.trading.server;

import ds.assignment.trading.grpc.generated.DeleteOrderRequest;
import ds.assignment.trading.grpc.generated.DeleteOrderResponse;
import ds.assignment.trading.grpc.generated.DeleteOrderServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.zookeeper.KeeperException;

import java.util.List;

public class DeleteOrderServiceImpl extends DeleteOrderServiceGrpc.DeleteOrderServiceImplBase {

    private TradingServer server;
    private ManagedChannel channel = null;
    DeleteOrderServiceGrpc.DeleteOrderServiceBlockingStub clientStub = null;


    public DeleteOrderServiceImpl(TradingServer server) {
        this.server = server;
    }

    public void deleteOrder(ds.assignment.trading.grpc.generated.DeleteOrderRequest request,
                            io.grpc.stub.StreamObserver<ds.assignment.trading.grpc.generated.DeleteOrderResponse> responseObserver) {
        String orderId = request.getOrderId();
        System.out.println("Request Received...");
        boolean status = false;

        if(server.isLeader()) {
            // Act as primary
            try {
                System.out.println("Deleting Order as Primary");
                deleteOrder(orderId);
                updateSecondaryServers(orderId);
                status = true;
            } catch (Exception e) {
                System.out.println("Error while Deleting Order" + e.getMessage());
                e.printStackTrace();
            }
        } else {
            // Act As Secondary
            if (request.getIsSentByPrimary()) {
                System.out.println("Deleting Order on secondary, on Primary's command");
                deleteOrder(orderId);
            } else {
                DeleteOrderResponse response = callPrimary(orderId);
                if (response.getStatus()) {
                    status = true;
                }
            }
        }
        DeleteOrderResponse response = DeleteOrderResponse.newBuilder().setStatus(status).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void deleteOrder(String orderId) {
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
}
