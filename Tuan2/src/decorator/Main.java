package decorator;

public class Main {
    public static void main(String[] args) {

        Payment payment = new CreditCard();

        payment = new ProcessingDecorator(payment);
        payment = new DiscountDecorator(payment);

        double finalAmount = payment.pay(100000);
        System.out.println("Số tiền phải thanh toán: " + finalAmount);
    }
}

