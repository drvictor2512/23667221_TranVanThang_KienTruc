package factory;

public class Main {
	public static void main(String[] args) {

        Payment payment1 = PaymentFactory.createPayment("cash");
        payment1.pay(100000);

        Payment payment2 = PaymentFactory.createPayment("credit");
        payment2.pay(500000);
    }
}
