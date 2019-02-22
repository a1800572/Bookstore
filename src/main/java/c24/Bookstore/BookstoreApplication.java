package c24.Bookstore;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import c24.Bookstore.domain.Book;
import c24.Bookstore.domain.BookRepository;
import c24.Bookstore.domain.Category;
import c24.Bookstore.domain.CategoryRepository;






@SpringBootApplication
public class BookstoreApplication {
	private static final Logger log = LoggerFactory.getLogger(BookstoreApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner studentDemo(BookRepository brepository, CategoryRepository crepository) {
		return (args) -> {
			log.info("kokeilu");
			
			
			// author=aaa, isbn=kateson, price=222, title=katy, year=12
			//muista parantaa järjestystä
			crepository.save(new Category("Arts & Music"));
			crepository.save(new Category("Biographies"));
			crepository.save(new Category("Business"));
			crepository.save(new Category("Kids"));
			crepository.save(new Category("Comics"));
			crepository.save(new Category("Computers & Tech"));
			crepository.save(new Category("Cooking"));
			crepository.save(new Category("Hobbies & Crafts"));
			crepository.save(new Category("Education & Refrence"));
			crepository.save(new Category("Health & Fitness"));
			crepository.save(new Category("History"));
			crepository.save(new Category("Home & Garden"));
			crepository.save(new Category("Horror"));
			crepository.save(new Category("Entertainment"));
			crepository.save(new Category("Literature & Fiction"));
			crepository.save(new Category("Medical"));
			crepository.save(new Category("Mysteries"));
			crepository.save(new Category("Parenting"));
			crepository.save(new Category("Social Sciences"));
			crepository.save(new Category("Religion"));
			crepository.save(new Category("Romance"));
			crepository.save(new Category("Science & Math"));
			crepository.save(new Category("Sci-Fi & Fantasy"));
			crepository.save(new Category("Self-Help"));
			crepository.save(new Category("Sports"));
			crepository.save(new Category("Teen"));
			crepository.save(new Category("Travel"));
			crepository.save(new Category("True Crime"));
			crepository.save(new Category("Westerns"));
			crepository.save(new Category("Special Edition"));
			
			
			brepository.save(new Book("The Count of Monte Cristo","Alexandre Dumas",1844, "aaa-ddf-ggg", 25, crepository.findByName("Sci-Fi & Fantasy").get(0)));
			brepository.save(new Book("Inferno (Dante)","Dante Alighieri",1400, "df-gdff-hgj", 20, crepository.findByName("Sci-Fi & Fantasy").get(0)));
			brepository.save(new Book("The Metamorphosis","Franz Kafka",1915, "dfff-ghjjh-kkk", 40, crepository.findByName("Business").get(0)));
			
			
			log.info("nouto");
			for (Book book : brepository.findAll()) {
				log.info(book.toString());
			}

		};

}
}