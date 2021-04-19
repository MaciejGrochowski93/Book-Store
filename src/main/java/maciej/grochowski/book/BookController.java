package maciej.grochowski.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookController {

    @Autowired
    private BookService bookService;

    @RequestMapping("/")
    public String home(){
        return "Hello there!";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/books")
    public List<Book> getAllBooks() {
        return bookService.getAllBooks();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/books/{id}")
    public Book getBookById(@PathVariable int id) {
        return bookService.getBookById(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/books")
    public void addBook(@RequestBody Book book){
        bookService.addBook(book);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/books/{id}")
    public void updateBook(@RequestBody Book book, @PathVariable int id){
        bookService.updateBook(book,id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/books/{id}")
    public void deleteBook(@PathVariable int id){
        bookService.deleteBook(id);
    }
}

//    @RequestMapping(method = RequestMethod.GET, value = "/books/{author}")
//    public List<Book> getBooksByAuthor(@PathVariable String author) {
//        return bookService.getBooksByAuthor(author);
//    }

//    @RequestMapping(method = RequestMethod.GET, value = "/books/{category}")
//    public List<Book> getBooksByCategory(@PathVariable String category) {
//        return bookService.getBooksByCategory(category);
//    }