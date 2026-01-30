package quanlythuvien;

public class SpecialVersionDecorator extends BorrowDecorator {
    public SpecialVersionDecorator(Borrow b) {
        super(b);
    }

    public String getDescription() {
        return borrow.getDescription() + ", phiên bản đặc biệt";
    }

    public double getCost() {
        return borrow.getCost() + 20;
    }
}
