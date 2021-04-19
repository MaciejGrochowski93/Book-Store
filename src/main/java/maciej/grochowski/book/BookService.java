package maciej.grochowski.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
        List<Book> booksList = new ArrayList<>();
        bookRepository.findAll().forEach(booksList::add);
        return booksList;
    }


    public Book getBookById(int id) {
        return bookRepository.findById(id).orElse(null);
    }

//    public List<Book> getBooksByAuthor(String author) {
//        return bookRepository.findAll()
//                .stream().filter(e -> e.getAuthor().equals(author))
//                .collect(Collectors.toList());
//    }

//    public List<Book> getBooksByCategory(String category) {
//        return bookRepository.findAll()
//                .stream().filter(e -> e.getCategory().equals(category))
//                .collect(Collectors.toList());
//    }

    public void addBook(Book book) {
        bookRepository.save(book);
    }

    public void updateBook(Book book, int id) {
        bookRepository.save(book);
    }

    public void deleteBook(int id) {
        bookRepository.deleteById(id);
    }
}
