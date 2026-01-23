package decorator;

public class DiscountDecorator extends PaymentDecorator {

    public DiscountDecorator(Payment payment) {
        super(payment);
    }

    @Override
    public double pay(double amount) {
        double total = super.pay(amount);
        double discount = total * 0.10; // giảm giá 10%
        System.out.println("Áp dụng mã giảm giá: -" + discount);
        return total - discount;
    }
}

