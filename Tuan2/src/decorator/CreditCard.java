package decorator;

public class CreditCard implements Payment {

	@Override
	public double pay(double amount) {
		 System.out.println("Thanh toán bằng Thẻ tín dụng");
	     return amount;
	}
	
}
