package decorator;

public class PaypalPayment implements Payment {
	 @Override
	    public double pay(double amount) {
	        System.out.println("Thanh toán bằng PayPal");
	        return amount;
	    }
}
