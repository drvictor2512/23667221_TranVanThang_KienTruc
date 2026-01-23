package factory;

public class PaymentFactory {

    public static Payment createPayment(String type) {
        if (type.equalsIgnoreCase("cash")) {
            return new CashPayment();
        } else if (type.equalsIgnoreCase("credit")) {
            return new CreditCardPayment();
        }
        throw new IllegalArgumentException("Loại thanh toán không hợp lệ");
    }
}
