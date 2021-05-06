package ds.assignment.trading.client;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        String host = args[0];
        int port = Integer.parseInt(args[1].trim());
        String operation = args[2];

        if(args.length != 3) {
            System.out.println("Usage <host> <port> <s(et)|c(heck)");
            System.exit(1);
        }

        if("CO".equals(operation)){
            CreateOrderServiceClient client = new CreateOrderServiceClient(host, port);
            client.initializeConnection();
            client.processUserRequest();
            client.closeConnection();
        }
    }
}
