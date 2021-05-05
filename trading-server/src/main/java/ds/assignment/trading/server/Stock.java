package ds.assignment.trading.server;

public class Stock {
    String symbol;
    double price;
    int units;

    public Stock(String symbol, double price, int units) {
        this.symbol = symbol;
        this.price = price;
        this.units = units;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setUnits(int units) {
        this.units = units;
    }
}
