package ds.assignment.trading.client;

import ds.assignment.trading.grpc.generated.DeleteOrderRequest;
import ds.assignment.trading.grpc.generated.DeleteOrderResponse;
import ds.assignment.trading.grpc.generated.DeleteOrderServiceGrpc;
import ds.assignment.trading.grpc.generated.EditOrderServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class DeleteOrderServiceClient {
    private ManagedChannel channel = null;
    DeleteOrderServiceGrpc.DeleteOrderServiceBlockingStub clientStub = null;
    String host = null;
    int port = -1;

    public DeleteOrderServiceClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void initializeConnection () {
        System.out.println("Initializing Connecting to server at " + host + ":" +
                port);
        channel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext()
                .build();
        clientStub = DeleteOrderServiceGrpc.newBlockingStub(channel);
    }
    public void closeConnection() {
        channel.shutdown();
    }

    public void processUserRequests() throws InterruptedException {
        while (true) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("\nEnter Order Id to delete");
            String input = userInput.nextLine().trim();
            String orderId = input;
            System.out.println("Requesting server to delete " + orderId);
            DeleteOrderRequest request = DeleteOrderRequest
                    .newBuilder()
                    .setOrderId(orderId)
                    .setIsSentByPrimary(false)
                    .build();
            DeleteOrderResponse response = clientStub.deleteOrder(request);
            System.out.printf("Order Delete Status " + (response.getStatus() ? "Successful" : "Failed"));
            Thread.sleep(1000);
        }
    }
}
