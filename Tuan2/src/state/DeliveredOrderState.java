package state;

public class DeliveredOrderState implements OrderState {

	@Override
	public void handle(Order order) {
		System.out.println("Đơn hàng đã giao: Cập nhật trạng thái đã giao.");
		
	}

}
