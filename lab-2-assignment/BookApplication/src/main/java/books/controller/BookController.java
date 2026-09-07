package books.controller;

import books.model.Book;
import books.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book addBook(@Valid @RequestBody Book book) {
        return bookService.addBook(book);
    }

    @PutMapping("/{isbn}")
    public Book updateBook(
            @PathVariable String isbn,
            @Valid @RequestBody Book book
    ) {
        if (!isbn.equals(book.getIsbn())) {
            throw new IllegalArgumentException(
                    "The ISBN in the URL must match the ISBN in the request body"
            );
        }

        return bookService.updateBook(book);
    }

    @DeleteMapping("/{isbn}")
    public Book deleteBook(@PathVariable String isbn) {
        return bookService.deleteBook(isbn);
    }

    @GetMapping("/{isbn}")
    public Book getBook(@PathVariable String isbn) {
        return bookService.getBook(isbn);
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }
}