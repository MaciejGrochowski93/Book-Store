package maciej.grochowski.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> bookList = new ArrayList<>();
        HttpHeaders header = new HttpHeaders();
        header.set("desc", "Getting all available books");
        bookRepository.findAll().forEach(bookList::add);
        return new ResponseEntity<>(bookList, header, HttpStatus.OK);
    }

    public ResponseEntity<Book> getBookById(int id) {
        Optional<Book> book = bookRepository.findById(id);
        HttpHeaders header = new HttpHeaders();
        header.set("desc", "Returns a single book by the given ID");
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(book.get());

    }

    public ResponseEntity<Void> addBook(Book book) {
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Adds a new Book");
        bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.OK).headers(header).build();
    }

    public ResponseEntity <Void> updateBook(Book book, int id) {
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Changes attributes of the book.");
        bookRepository.save(book);
        return ResponseEntity.status(HttpStatus.OK).headers(header).build();
    }

    public ResponseEntity <Void> deleteBook(int id) {
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Removes a book from the shop's offer.");
        bookRepository.deleteById(id);
        return ResponseEntity.status(HttpStatus.OK).headers(header).build();
    }

    public ResponseEntity <Void> sellBook(int id) {
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Removes 1 copy of the particular book.");
        Optional<Book> book = bookRepository.findById(id);
        book.stream().findFirst()
                .ifPresent(e -> {
                    if (e.getAmountAvailable() > 1) {
                        e.setAmountAvailable(e.getAmountAvailable() - 1);
                        bookRepository.save(e);
                    }
                });
        return ResponseEntity.status(HttpStatus.OK).headers(header).build();
    }

    public ResponseEntity <List<Book>> getBookByCategory(String category) {
        List<Book> bookList = new ArrayList<>();
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Returns a list of books of the given category.");
        bookRepository.findAll().stream()
                .filter(e -> e.getCategory().toLowerCase().equals(category.toLowerCase()))
                .forEach(bookList::add);
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(bookList);
    }

    public ResponseEntity <List<Book>> getBookByAuthor(String author) {
        List<Book> bookList = new ArrayList<>();
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Returns a list of books of the given author.");
        bookRepository.findAll().stream()
                .filter(e -> e.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .forEach(bookList::add);
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(bookList);
    }

    public ResponseEntity<List<Book>> getBookByTitle(String title) {
        List<Book> bookList = new ArrayList<>();
        HttpHeaders header = new HttpHeaders();
        header.add("desc", "Returns a list of books containing the given word.");
        bookRepository.findAll().stream()
                .filter(e -> e.getTitle().toLowerCase().contains(title.toLowerCase()))
                .forEach(bookList::add);
        return ResponseEntity.status(HttpStatus.OK).headers(header).body(bookList);
    }
}

