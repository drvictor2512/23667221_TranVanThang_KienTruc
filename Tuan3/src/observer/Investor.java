package observer;

public class Investor implements Observer {
    private String investorName;

    public Investor(String name) {
        this.investorName = name;
    }

    @Override
    public void update(String message) {
        System.out.println(investorName + " nhận thông báo: " + message);
    }
}
