package ds.assignment.trading.server;

import ds.assignment.trading.grpc.generated.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.apache.zookeeper.KeeperException;

import java.util.List;

public class EditOrderServiceImpl extends EditOrderServiceGrpc.EditOrderServiceImplBase {
    private ManagedChannel channel = null;
    EditOrderServiceGrpc.EditOrderServiceBlockingStub clientStub = null;
    private TradingServer server;

    public EditOrderServiceImpl(TradingServer server) {
        this.server = server;
    }

    @Override
    public void editOrder(ds.assignment.trading.grpc.generated.EditOrderRequest request,
                            io.grpc.stub.StreamObserver<ds.assignment.trading.grpc.generated.EditOrderResponse> responseObserver) {
        String orderId = request.getOrderId();
        String symbol = request.getSymbol();
        double price = request.getPrice();
        String type = request.getType();
        int quantity = request.getQuantity();

        Order newOrder = new Order(orderId, symbol, type, price, quantity);

        boolean status = false;

        //Act as Primary
        if(server.isLeader()) {
            try {
                System.out.println("Creating Order as Primary");
                editTradeOrder(newOrder);
                updateSecondaryServers(newOrder);
                status = true;
            } catch (Exception e) {
                System.out.println("Error while editing the order" + e.getMessage());
                e.printStackTrace();
            }
        } else {
            if(request.getIsSentByPrimary()) {
                System.out.println("Creating order on secondary, on Primary's command");
                editTradeOrder(newOrder);
            } else {
                EditOrderResponse response = callPrimary(newOrder);
                if(response.getStatus()) {
                    status = true;
                }
            }
        }
        EditOrderResponse response = EditOrderResponse.newBuilder().setStatus(status).build();
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    private void editTradeOrder(Order order){
        server.editOrder(order);
    }

    private EditOrderResponse callServer(Order order, boolean isSentByPrimary, String IPAddress, int port) {
        System.out.println("Call Server " + IPAddress + ":" + port);
        channel = ManagedChannelBuilder.forAddress(IPAddress, port).usePlaintext().build();
        clientStub = EditOrderServiceGrpc.newBlockingStub(channel);

        EditOrderRequest request = EditOrderRequest.newBuilder()
                .setOrderId(order.orderId)
                .setSymbol(order.symbol)
                .setPrice(order.price)
                .setType(order.type)
                .setQuantity(order.quantity)
                .setIsSentByPrimary(isSentByPrimary)
                .build();

        EditOrderResponse response = clientStub.editOrder(request);
        return response;
    }

    private EditOrderResponse callPrimary(Order order) {
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
