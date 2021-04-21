package maciej.grochowski.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return bookService.getAllBooks();
    }


    @RequestMapping(method = RequestMethod.PUT, value = "/{id}/sell")
    public ResponseEntity<Void> sellBook(@PathVariable int id) {
        return bookService.sellBook(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/category/{category}")
    public ResponseEntity<List<Book>> getBookByCategory(@PathVariable String category) {
        return bookService.getBookByCategory(category);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/author/{author}")
    public ResponseEntity<List<Book>> getBookByAuthor(@PathVariable String author) {
        return bookService.getBookByAuthor(author);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/title/{title}")
    public ResponseEntity<List<Book>> getBookByTitle(@PathVariable String title) {
        return bookService.getBookByTitle(title);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> addBook(@RequestBody Book book) {
        return bookService.addBook(book);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/{id}")
    public ResponseEntity<Void> updateBook(@RequestBody Book book, @PathVariable Integer id) {
        return bookService.updateBook(book, id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable int id) {
        return bookService.deleteBook(id);
    }
}