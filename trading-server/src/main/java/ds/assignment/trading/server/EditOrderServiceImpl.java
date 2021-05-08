package ds.assignment.trading.server;

import ds.assignment.trading.grpc.generated.*;
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

public class EditOrderServiceImpl extends EditOrderServiceGrpc.EditOrderServiceImplBase implements DistributedTxListener {
    private ManagedChannel channel = null;
    EditOrderServiceGrpc.EditOrderServiceBlockingStub clientStub = null;
    private TradingServer server;
    private AbstractMap.SimpleEntry<String, Order> tempDataHolder;
    private boolean transactionStatus = false;

    public EditOrderServiceImpl(TradingServer server) {
        this.server = server;
    }

    private void startDistributedTx(String orderId, Order order) {
        try {
            server.getEditOrderTransaction().start(orderId, String.valueOf(UUID.randomUUID()));
            tempDataHolder = new AbstractMap.SimpleEntry<>(orderId, order);
        } catch (IOException e) {
            e.printStackTrace();
        }
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

        //Act as Primary
        if(server.isLeader()) {
            try {
                System.out.println("Editing Order as Primary");
                startDistributedTx(orderId, newOrder);
                updateSecondaryServers(newOrder);
                System.out.println("going to perform");
                if (newOrder != null){
                    ((DistributedTxCoordinator)server.getEditOrderTransaction()).perform();
                } else {
                    ((DistributedTxCoordinator)server.getEditOrderTransaction()).sendGlobalAbort();
                }
            } catch (Exception e) {
                System.out.println("Error while editing the order" + e.getMessage());
                e.printStackTrace();
            }
        } else {
            if(request.getIsSentByPrimary()) {
                System.out.println("Editing order on secondary, on Primary's command");
                startDistributedTx(orderId, newOrder);
                if (newOrder != null){
                    ((DistributedTxParticipant)server.getEditOrderTransaction()).voteCommit();
                } else {
                    ((DistributedTxParticipant)server.getEditOrderTransaction()).voteAbort();
                }
            } else {
                EditOrderResponse response = callPrimary(newOrder);
                if(response.getStatus()) {
                    transactionStatus = true;
                }
            }
        }
        EditOrderResponse response = EditOrderResponse.newBuilder().setStatus(transactionStatus).build();
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

    @Override
    public void onGlobalCommit() {
        editOrderUpdate();
    }

    @Override
    public void onGlobalAbort() {
        tempDataHolder = null;
        System.out.println("Transaction Aborted by the Coordinator");
    }

    private void editOrderUpdate() {
        if (tempDataHolder != null) {
            Order order = tempDataHolder.getValue();
            server.editOrder(order);
            tempDataHolder = null;
        }
    }
}
