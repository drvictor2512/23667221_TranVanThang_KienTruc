package observer;


public class Main {
    public static void main(String[] args) {
        Stock stock = new Stock("ABC");
        Investor investor1 = new Investor("Nguyễn Văn A");
        Investor investor2 = new Investor("Trần Thị B");

        stock.registerObserver(investor1);
        stock.registerObserver(investor2);

        stock.setPrice(100.50);
        stock.setPrice(105.75);

        Task task = new Task("Phát triển tính năng A");
        TeamMember teamMember1 = new TeamMember("Lê Văn C");
        TeamMember teamMember2 = new TeamMember("Phan Thị D");

        task.registerObserver(teamMember1);
        task.registerObserver(teamMember2);

        task.setStatus("Hoàn thành");
        task.setStatus("Đang thực hiện");
    }
}

