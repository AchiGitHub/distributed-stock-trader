package ds.assignment.trading.client;

import ds.assignment.trading.grpc.generated.SetStockRequest;
import ds.assignment.trading.grpc.generated.SetStockResponse;
import ds.assignment.trading.grpc.generated.SetStockServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

import java.util.Scanner;

public class SetStockServiceClient {
    private ManagedChannel channel = null;
    SetStockServiceGrpc.SetStockServiceBlockingStub clientStub = null;
    String host = null;
    int port = -1;

    public SetStockServiceClient (String host, int port) {
        this.host = host;
        this.port = port;
    }

    public void initializeConnection () {
        System.out.println("Initializing Connecting to server at " + host + ":" + port);
        channel = ManagedChannelBuilder.forAddress("localhost", port)
                .usePlaintext()
                .build();
        clientStub = SetStockServiceGrpc.newBlockingStub(channel);
    }

    public void closeConnection() {
        channel.shutdown();
    }

    public void processUserRequests() throws InterruptedException {
        while (true) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("\nEnter Stock Price,Units :");
            String input[] = userInput.nextLine().trim().split(",");
            double price = Double.parseDouble(input[0]);
            int units = Integer.parseInt(input[1]);
            System.out.println("Requesting server to set the stock price and units");
            SetStockRequest request = SetStockRequest
                    .newBuilder()
                    .setPrice(price)
                    .setUnits(units)
                    .setIsSentByPrimary(false)
                    .build();
            SetStockResponse response = clientStub.setStock(request);
            System.out.printf("Stock Rates Change " + (response.getStatus() ? "Sucessful" : "Failed"));
            Thread.sleep(1000);
        }
    }

}
