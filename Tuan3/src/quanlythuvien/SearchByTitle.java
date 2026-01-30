package quanlythuvien;

import java.util.*;

public class SearchByTitle implements SearchStrategy {
    public List<Book> search(List<Book> books, String k) {
        List<Book> result = new ArrayList<>();
        for (Book b : books)
            if (b.getTitle().contains(k)) result.add(b);
        return result;
    }
}



