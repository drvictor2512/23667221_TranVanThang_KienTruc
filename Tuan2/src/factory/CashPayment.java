package factory;

public class CashPayment implements Payment {

	@Override
	public void pay(double amount) {
		System.out.println("Thanh toán tiền mặt: " + amount);
		
	}
	
}
