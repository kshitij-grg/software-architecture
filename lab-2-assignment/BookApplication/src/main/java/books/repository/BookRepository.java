package books.repository;

import books.model.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@Repository
public class BookRepository {
    private final ConcurrentMap<String, Book> books = new ConcurrentHashMap<>();

    public Book save(Book book) {
        books.put(book.getIsbn(), book);
        return book;
    }

    public Optional<Book> findByIsbn(String isbn) {
        return Optional.ofNullable(books.get(isbn));
    }

    public List<Book> findAll() {
        return new ArrayList<>(books.values());
    }

    public Optional<Book> deleteByIsbn(String isbn) {
        return Optional.ofNullable(books.remove(isbn));
    }

    public boolean existsByIsbn(String isbn) {
        return books.containsKey(isbn);
    }
}
