package c24.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import c24.Bookstore.domain.Book;
import c24.Bookstore.domain.BookRepository;





@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository repository) {
		return (args) -> {
			log.info("kokeilu");
			// author=aaa, isbn=kateson, price=222, title=katy, year=12
			//muista parantaa järjestystä
			repository.save(new Book("The Count of Monte Cristo","Alexandre Dumas",1844, "aaa-ddf-ggg", 25));
			repository.save(new Book("Inferno (Dante)","Dante Alighieri",1400, "df-gdff-hgj", 20));
			repository.save(new Book("The Metamorphosis","Franz Kafka",1915, "dfff-ghjjh-kkk", 40));
			
			
			
			log.info("nouto");
			for (Book book : repository.findAll()) {
				log.info(book.toString());
			}

		};

}
}