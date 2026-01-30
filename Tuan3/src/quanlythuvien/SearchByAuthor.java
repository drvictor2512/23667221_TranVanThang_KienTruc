package quanlythuvien;

import java.util.ArrayList;
import java.util.List;

public class SearchByAuthor implements SearchStrategy {
    public List<Book> search(List<Book> books, String k) {
        List<Book> result = new ArrayList<>();
        for (Book b : books)
            if (b.getAuthor().contains(k)) result.add(b);
        return result;
    }
}