package state;

public class ProcessingOrderState implements OrderState {

	@Override
	public void handle(Order order) {
		  System.out.println("Đơn hàng đang xử lý: Đóng gói và vận chuyển.");
	      order.setState(new DeliveredOrderState());
		
	}
	
}
