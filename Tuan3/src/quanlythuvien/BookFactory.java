package quanlythuvien;

public class BookFactory {
    public static Book createBook(String type, String t, String a, String c) {
        switch (type) {
            case "PAPER": return new PaperBook(t, a, c);
            case "EBOOK": return new EBook(t, a, c);
            default: throw new IllegalArgumentException("Loại sách không hợp lệ");
        }
    }
}

