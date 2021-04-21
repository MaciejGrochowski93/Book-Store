package maciej.grochowski.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks() {
        List<Book> booksList = new ArrayList<>();
        bookRepository.findAll().forEach(booksList::add);
        return booksList;
    }

    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book, int id) {
        bookRepository.save(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }

    public void sellBook(int id) {
        Optional<Book> book = bookRepository.findById(id);
        book.stream().findFirst()
                .ifPresent(e -> {
                    if (e.getAmountAvailable() > 1) {
                        e.setAmountAvailable(e.getAmountAvailable() - 1);
                        bookRepository.save(e);
                    }
                });
    }

    public List<Book> getBookByCategory(String category) {
        List<Book> bookList = new ArrayList<>();
        bookRepository.findAll().stream()
                .filter(e -> e.getCategory().toLowerCase().equals(category.toLowerCase()))
                .forEach(bookList::add);
        return bookList;
    }

    public List<Book> getBookByAuthor(String author) {
        List<Book> bookList = new ArrayList<>();
        bookRepository.findAll().stream()
                .filter(e -> e.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .forEach(bookList::add);
        return bookList;
    }

    public List<Book> getBookByTitle(String title) {
        List<Book> bookList = new ArrayList<>();
        bookRepository.findAll().stream()
                .filter(e -> e.getTitle().toLowerCase().contains(title.toLowerCase()))
                .forEach(bookList::add);
        return bookList;
    }
}

