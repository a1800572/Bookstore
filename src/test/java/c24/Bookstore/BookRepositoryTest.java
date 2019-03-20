package c24.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import c24.Bookstore.domain.Book;
import c24.Bookstore.domain.BookRepository;
import c24.Bookstore.domain.Category;




@RunWith(SpringRunner.class)
@DataJpaTest
public class BookRepositoryTest {
	
	@Autowired
    private BookRepository repository;

    @Test
    public void findByTitle() {
        List<Book> books = repository.findByTitle("Inferno (Dante)");
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getAuthor()).isEqualTo("Dante Alighieri");
    }
    
    @Test
    public void findByYear() {
        List<Book> books = repository.findByYear(1915);
        assertThat(books).hasSize(1);
        assertThat(books.get(0).getPrice()).isEqualTo(40);
    }
    
    @Test
    public void NewBook() {
    	Book book = new Book("Title","Author",1000, "ggggh-sdfdf-gjjj", 90, new Category("Adventure"));
    	repository.save(book);
    	assertThat(book.getId()).isNotNull();
    }
    
    @Test
    public void DeleteBook() {
    	Book book = new Book("Nineteen Eighty-Four","George Orwell",1949, "ghfgh-gh67-dfg", 23, new Category("Dystopia"));
    	repository.save(book);
    	repository.delete(book);
    	assertThat(repository.findById(book.getId())).isEmpty();
    }
    
    
    
}

