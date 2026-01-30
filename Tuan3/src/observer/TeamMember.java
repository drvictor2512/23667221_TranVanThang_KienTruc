package observer;

public class TeamMember implements Observer {
    private String memberName;

    public TeamMember(String name) {
        this.memberName = name;
    }

    @Override
    public void update(String message) {
        System.out.println(memberName + " nhận thông báo: " + message);
    }
}
