package c24.Bookstore.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface BookRepository extends CrudRepository<Book, Long>{
	
	//http://localhost:8080/api/books/search/findByAuthor?author=Dante%20Alighieri
	List<Book>findByAuthor(@Param("author") String author);
	
	//http://localhost:8080/api/books/search/findByPrice?price=25.0
	List<Book> findByPrice(@Param("price") double price);
	
	//http://localhost:8080/api/books/search/findByYear?year=1915
	List<Book> findByYear(@Param("year") int year);
	
	//http://localhost:8080/api/books/search/findByTitle?title=The%20Count%20of%20Monte%20Cristo
	List<Book> findByTitle(@Param("title") String title);
	
	//http://localhost:8080/api/books/search/findByIsbn?isbn=dfff-ghjjh-kkk
	List<Book> findByIsbn(@Param("isbn") String isbn);

}
