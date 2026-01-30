package quanlythuvien;

import java.util.ArrayList;
import java.util.List;


public class Library {
    private static Library instance;
    private List<Book> books = new ArrayList<>();
    private List<Observer> observers = new ArrayList<>();

    private Library() {}

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public void addBook(Book book) {
        books.add(book);
        notifyObservers("Sách mới được thêm: " + book.getTitle());
    }

    public List<Book> getBooks() {
        return books;
    }

    // Observer methods
    public void registerObserver(Observer o) {
        observers.add(o);
    }

    public void notifyObservers(String message) {
        for (Observer o : observers) {
            o.update(message);
        }
    }
}

