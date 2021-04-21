package maciej.grochowski.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping(value = "/booksAvailable")
    public ResponseEntity<List<Book>> getSomeBooks() {
        List<Book> booksList = bookService.getAllBooks();
        if (booksList.size() < 1) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        return ResponseEntity.of(Optional.of(booksList));
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/sell")
    public void sellBook(@PathVariable int id) {
        bookService.sellBook(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category/{category}")
    public List<Book> getBookByCategory(@PathVariable String category) {
        return bookService.getBookByCategory(category);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/author/{author}")
    public List<Book> getBookByAuthor(@PathVariable String author) {
        return bookService.getBookByAuthor(author);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/title/{title}")
    public List<Book> getBookByTitle(@PathVariable String title) {
        return bookService.getBookByTitle(title);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void addBook(@RequestBody Book book) {
        bookService.addBook(book);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable Integer id) {
        bookService.updateBook(book, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteBook(id);
    }
}