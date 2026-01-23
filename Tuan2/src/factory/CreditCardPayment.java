package factory;

public class CreditCardPayment implements Payment {

    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán bằng thẻ tín dụng: " + amount);
    }
}

