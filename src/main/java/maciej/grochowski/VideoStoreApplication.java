package maciej.grochowski;

import maciej.grochowski.book.BookRepository;
import maciej.grochowski.user.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@EnableJpaRepositories(basePackageClasses = {UserRepository.class, BookRepository.class})
public class VideoStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(VideoStoreApplication.class, args);
	}

}
