package ds.assignment.trading.server;

import ds.assignment.trading.synchronizer.lock.DistributedLock;
import ds.assignment.trading.synchronizer.lock.tx.DistributedTx;
import ds.assignment.trading.synchronizer.lock.tx.DistributedTxCoordinator;
import ds.assignment.trading.synchronizer.lock.tx.DistributedTxParticipant;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.apache.zookeeper.KeeperException;

import java.io.IOException;
import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;

public class TradingServer {
    private int serverPort;
    private DistributedLock leaderLock;
    private AtomicBoolean isLeader = new AtomicBoolean(false);
    private byte[] leaderData;
    private Map<String, Order> orders = new HashMap();
    private Map<String, Stock> stocks = new HashMap();
    private Map<String, Order> successfulOrders = new HashMap();

    DistributedTx createOrderTransaction;
    DistributedTx editOrderTransaction;
    DistributedTx deleteOrderTransaction;
    DistributedTx setStockTransaction;

    CreateOrderServiceImpl createOrderService;
    EditOrderServiceImpl editOrderService;
    DeleteOrderServiceImpl deleteOrderService;
    SetStockServiceImpl setStockService;

    public TradingServer(String host, int port) throws IOException, InterruptedException, KeeperException {
        Stock stock = new Stock("Dodge", 200, 900000);
        stocks.put("D", stock);
        this.serverPort = port;
        leaderLock = new DistributedLock("TradingCluster", buildServerData(host, port));

        createOrderService = new CreateOrderServiceImpl(this);
        editOrderService = new EditOrderServiceImpl(this);
        deleteOrderService = new DeleteOrderServiceImpl(this);
        setStockService = new SetStockServiceImpl(this);

        createOrderTransaction = new DistributedTxParticipant(createOrderService);
        editOrderTransaction = new DistributedTxParticipant(editOrderService);
        deleteOrderTransaction = new DistributedTxParticipant(deleteOrderService);
        setStockTransaction = new DistributedTxParticipant(setStockService);
    }

    public DistributedTx getCreateOrderTransaction() {
        return createOrderTransaction;
    }

    public DistributedTx getEditOrderTransaction() {
        return editOrderTransaction;
    }

    public DistributedTx getDeleteOrderTransaction() {
        return deleteOrderTransaction;
    }

    public DistributedTx getSetStockTransaction() {
        return setStockTransaction;
    }

    public static String buildServerData(String IP, int port) {
        StringBuilder builder = new StringBuilder();
        builder.append(IP).append(":").append(port);
        return builder.toString();
    }

    public boolean isLeader() {
        return isLeader.get();
    }

    public synchronized String[] getCurrentLeaderData() {
        return new String(leaderData).split(":");
    }

    private synchronized void setCurrentLeaderData(byte[] leaderData) {
        this.leaderData = leaderData;
    }

    private void tryToBeLeader() throws KeeperException, InterruptedException {
        Thread leaderCampaignThread = new Thread(new LeaderCampaignThread());
        leaderCampaignThread.start();
    }

    public List<String[]> getOthersData() throws KeeperException, InterruptedException {
        List<String[]> result = new ArrayList<>();
        List<byte[]> othersData = leaderLock.getOthersData();
        for (byte[] data : othersData) {
            String[] dataStrings = new String(data).split(":");
            result.add(dataStrings);
        }
        return result;
    }

    //check if the order satisfy the price and units, if so order will be successful else kept in order book
    public void createOrder(Order order){
        Stock stock = stocks.get("D");
        if(stock.price == order.price && stock.units >= order.quantity) {
            if(order.type == "B"){
                successfulOrders.put(order.orderId, order);
                stock.setUnits(stock.units-order.quantity);
                stocks.put("D", stock);
            } else if(order.type == "S") {
                successfulOrders.put(order.orderId, order);
                stock.setUnits(stock.units+order.quantity);
                stocks.put("D", stock);
            }
        } else {
            orders.put(order.orderId, order);
        }
    }

    public void editOrder(Order order) {
        editUpdateOrder(order);
    }

    public void deleteOrder(String orderId) {
        orders.remove(orderId);
    }

    public void editUpdateOrder(Order order){
        Stock stock = stocks.get("D");
        if(stock.price == order.price && stock.units >= order.quantity) {
            if(order.type == "B"){
                successfulOrders.put(order.orderId, order);
                stock.setUnits(stock.units-order.quantity);
                orders.remove(order.orderId);
                stocks.put("D", stock);
            } else if(order.type == "S") {
                successfulOrders.put(order.orderId, order);
                stock.setUnits(stock.units+order.quantity);
                stocks.put("D", stock);
            }
        } else {
            orders.put(order.orderId, order);
        }
    }

    public void setStock(double price, int units) {
        Stock stock = stocks.get("D");
        stock.setPrice(price);
        stock.setUnits(units);

        //check if orders are available satisfying the price
        Iterator it = orders.entrySet().iterator();

        while(it.hasNext()){
            Map.Entry pair = (Map.Entry)it.next();
            Order order = (Order) pair.getValue();
            checkOrders(order, stock);
            it.remove();
        }
    }

    //check the order list which has matching orders for new stock
    private void checkOrders(Order order, Stock stock) {
        if(stock.price == order.price && stock.units >= order.quantity) {
            if(order.type == "B"){
                successfulOrders.put(order.orderId, order);
                stock.setUnits(stock.units - order.quantity);
                stocks.put("D", stock);
            } else if(order.type == "S") {
                successfulOrders.put(order.orderId, order);
                stock.setUnits(stock.units + order.quantity);
                stocks.put("D", stock);
            }
            orders.remove(order.orderId);
        }
    }

    public void startServer() throws IOException, InterruptedException, KeeperException {
        Server server = ServerBuilder
                .forPort(serverPort)
                .addService(createOrderService)
                .addService(editOrderService)
                .addService(deleteOrderService)
                .addService(setStockService)
                .build();
        server.start();
        System.out.println("Trading Server Started and ready to accept requests on port " + serverPort);

        tryToBeLeader();
        server.awaitTermination();
    }

    private void beTheLeader() {
        System.out.println("I got the leader lock. Now acting as primary");
        isLeader.set(true);
        createOrderTransaction = new DistributedTxCoordinator(createOrderService);
        editOrderTransaction = new DistributedTxCoordinator(editOrderService);
        deleteOrderTransaction = new DistributedTxCoordinator(deleteOrderService);
        setStockTransaction = new DistributedTxCoordinator(setStockService);
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        DistributedLock.setZooKeeperURL("localhost:2181");
        DistributedTx.setZooKeeperURL("localhost:2181");

        if(args.length != 1) {
            System.out.println("Usage executable-name <port>");
        }

        int serverPort = Integer.parseInt(args[0]);
        TradingServer server = new TradingServer("localhost", serverPort);
        server.startServer();
    }

    class LeaderCampaignThread implements Runnable {
        private byte[] currentLeaderData = null;
        @Override
        public void run() {
            System.out.println("Starting the leader Campaign");
            try {
                boolean leader = leaderLock.tryAcquireLock();
                while (!leader) {
                    byte[] leaderData = leaderLock.getLockHolderData();
                    if (currentLeaderData != leaderData) {
                        currentLeaderData = leaderData;
                        setCurrentLeaderData(currentLeaderData);
                    }
                    Thread.sleep(10000);
                    leader = leaderLock.tryAcquireLock();
                }
                currentLeaderData = null;
                beTheLeader();
            } catch (Exception e){
            }
        }
    }

}
