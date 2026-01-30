package quanlythuvien;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = Library.getInstance();
        library.registerObserver(new Librarian("Thủ thư A"));

        Book b1 = BookFactory.createBook("PAPER", "Java Programming", "James", "IT");
        Book b2 = BookFactory.createBook("EBOOK", "Design Patterns", "Erich Gamma", "IT");

        library.addBook(b1);
        library.addBook(b2);


        Borrow borrow = new BasicBorrow();
        borrow = new ExtendedTimeDecorator(borrow);
        borrow = new SpecialVersionDecorator(borrow);

        System.out.println(borrow.getDescription());
        System.out.println("Chi phí: " + borrow.getCost());
    }
}


