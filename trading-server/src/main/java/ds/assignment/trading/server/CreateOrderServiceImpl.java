package ds.assignment.trading.server;

import ds.assignment.trading.grpc.generated.CreateOrderRequest;
import ds.assignment.trading.grpc.generated.CreateOrderResponse;
import ds.assignment.trading.grpc.generated.CreateOrderServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.zookeeper.KeeperException;

import java.util.List;

public class CreateOrderServiceImpl extends CreateOrderServiceGrpc.CreateOrderServiceImplBase {

    private ManagedChannel channel = null;
    CreateOrderServiceGrpc.CreateOrderServiceBlockingStub clientStub = null;
    private TradingServer server;

    public CreateOrderServiceImpl(TradingServer server) {
        this.server = server;
    }

    public void createOrder(ds.assignment.trading.grpc.generated.CreateOrderRequest request,
                            io.grpc.stub.StreamObserver<ds.assignment.trading.grpc.generated.CreateOrderResponse> responseObserver) {
        String orderId = request.getOrderId();
        String symbol = request.getSymbol();
        double price = request.getPrice();
        String type = request.getType();
        int quantity = request.getQuantity();

        Order newOrder = new Order(orderId ,symbol, type, price, quantity);

        boolean status = false;

        //Act as Primary
        if(server.isLeader()) {
            try {
                System.out.println("Creating Order as Primary");
                createTradeOrder(newOrder);
                updateSecondaryServers(newOrder);
                status = true;
            }catch (Exception e) {
                System.out.println("Error while creating the order" + e.getMessage());
                e.printStackTrace();
            }
        } else {
            if(request.getIsSentByPrimary()) {
                System.out.println("Creating order on secondary, on Primary's command");
                createTradeOrder(newOrder);
            } else {
                CreateOrderResponse response = callPrimary(newOrder);
                if(response.getStatus()) {
                    status = true;
                }
            }
        }
        CreateOrderResponse response = CreateOrderResponse.newBuilder().setStatus(status).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void createTradeOrder(Order order){
        server.createOrder(order);
        System.out.println("Order " + order.orderId + " created! ");
    }

    private CreateOrderResponse callServer(Order order, boolean isSentByPrimary, String IPAddress, int port) {
        System.out.println("Call Server " + IPAddress + ":" + port);
        channel = ManagedChannelBuilder.forAddress(IPAddress, port).usePlaintext().build();
        clientStub = CreateOrderServiceGrpc.newBlockingStub(channel);

        CreateOrderRequest request = CreateOrderRequest.newBuilder()
                .setOrderId(order.orderId)
                .setSymbol(order.symbol)
                .setPrice(order.price)
                .setType(order.type)
                .setQuantity(order.quantity)
                .setIsSentByPrimary(isSentByPrimary)
                .build();

        CreateOrderResponse response = clientStub.createOrder(request);
        return response;
    }

    private CreateOrderResponse callPrimary(Order order) {
        System.out.println("Calling Primary server");
        String[] currentLeaderData = server.getCurrentLeaderData();
        String IPAddress = currentLeaderData[0];
        int port = Integer.parseInt(currentLeaderData[1]);
        return callServer(order, false, IPAddress, port);
    }

    private void updateSecondaryServers(Order order) throws KeeperException, InterruptedException {
        System.out.println("Updating secondary servers");
        List<String[]> othersData = server.getOthersData();
        for (String[] data : othersData) {
            String IPAddress = data[0];
            int port = Integer.parseInt(data[1]);
            callServer(order, true, IPAddress, port);
        }
    }
}
