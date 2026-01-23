package singleton;

public class DatabaseConnection {
	private static DatabaseConnection instance;
	private DatabaseConnection() {
		System.out.println("Khởi tạo kết nối CSDL");
	}
	public static DatabaseConnection getInstance() {
		if(instance == null) {
			instance = new DatabaseConnection();
		}
		return instance;
	}
	public void connect() {
		System.out.println("Đang kết nối tới database");
	}
	
}
