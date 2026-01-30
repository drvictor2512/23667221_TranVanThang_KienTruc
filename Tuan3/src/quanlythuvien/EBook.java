package quanlythuvien;

public class EBook extends Book {
    public EBook(String t, String a, String c) {
        super(t, a, c);
    }
    public String getType() { return "Sách điện tử"; }
}