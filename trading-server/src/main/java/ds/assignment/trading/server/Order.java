package ds.assignment.trading.server;

public class Order {
    String symbol, type, orderId;
    double price;
    int quantity;

    public Order(String orderId, String symbol, String type, double price, int quantity) {
        this.orderId = orderId;
        this.symbol = symbol;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
    }
}
