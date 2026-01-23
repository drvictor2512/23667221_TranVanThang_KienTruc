package decorator;

public class ProcessingDecorator extends PaymentDecorator {

	public ProcessingDecorator(Payment payment) {
		super(payment);
	}
	  @Override
	    public double pay(double amount) {
	        double total = super.pay(amount);
	        double fee = total * 0.05;
	        System.out.println("Thêm phí xử lý: " + fee);
	        return total + fee;
	    }
	
}
