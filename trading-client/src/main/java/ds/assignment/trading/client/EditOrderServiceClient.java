package ds.assignment.trading.client;

import ds.assignment.trading.grpc.generated.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class EditOrderServiceClient {

    private ManagedChannel channel = null;
    EditOrderServiceGrpc.EditOrderServiceBlockingStub clientStub = null;
    String host = null;
    int port = -1;

    public EditOrderServiceClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void initializeConnection() {
        System.out.println("Initializing Connecting to server at " + host + ":" +
                port);
        channel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext()
                .build();
        clientStub = EditOrderServiceGrpc.newBlockingStub(channel);
    }

    public void closeConnection() {
        channel.shutdown();
    }

    public void processUserRequest() throws InterruptedException {
        Scanner userInput = new Scanner(System.in);
        System.out.println("\nEnter OrderID, Symbol, Price,B for Buying | S for selling, Quantity");
        String input[] = userInput.nextLine().trim().split(",");
        String orderId = input[0];
        String symbol = input[1];
        double price = Double.parseDouble(input[2]);
        String type = input[3];
        int quantity = Integer.parseInt(input[4]);
        System.out.println("Requesting server to Edit Stock for " + orderId);

        EditOrderRequest request = EditOrderRequest
                .newBuilder()
                .setOrderId(orderId)
                .setSymbol(symbol)
                .setPrice(price)
                .setType(type)
                .setQuantity(quantity)
                .setIsSentByPrimary(false)
                .build();
        EditOrderResponse response = clientStub.editOrder(request);
        System.out.printf("Edit order status " + (response.getStatus() ? "Successful" : "Failed"));
        Thread.sleep(1000);
    }
}
