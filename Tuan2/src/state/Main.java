package state;

public class Main {
    public static void main(String[] args) {

        Order order = new Order();

        order.process(); // New -> Processing
        order.process(); // Processing -> Delivered
        order.process(); // Delivered
    }
}

