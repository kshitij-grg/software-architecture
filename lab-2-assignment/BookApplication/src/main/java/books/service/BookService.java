package books.service;

import books.model.Book;
import books.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book addBook(Book book) {
        if(bookRepository.existsByIsbn(book.getIsbn())) {
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT, "Book with ISBN " + book.getIsbn() +" already exists!"
            );
        }

        return bookRepository.save(book);
    }

    public Book updateBook(Book book) {
        if(!bookRepository.existsByIsbn(book.getIsbn())) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Book with ISBN " + book.getIsbn() +" does not exist!"
            );
        }

        return bookRepository.save(book);
    }

    public Book getBook(String isbn) {
        return bookRepository.findByIsbn(isbn)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Book with ISBN " + isbn + " was not found"
                ));
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book deleteBook(String isbn) {
        return bookRepository.deleteByIsbn(isbn)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "Book with ISBN " + isbn + " was not found"
                ));
    }


}
