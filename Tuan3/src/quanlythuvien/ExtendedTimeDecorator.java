package quanlythuvien;

public class ExtendedTimeDecorator extends BorrowDecorator {
    public ExtendedTimeDecorator(Borrow b) {
        super(b);
    }

    public String getDescription() {
        return borrow.getDescription() + ", gia hạn thời gian";
    }

    public double getCost() {
        return borrow.getCost() + 10;
    }
}
