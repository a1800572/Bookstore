package c24.Bookstore;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

import c24.Bookstore.domain.Book;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestServiceTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testRest() throws Exception {
        assertThat(this.restTemplate.getForObject("http://localhost:" + port + "/books",
                String.class)).contains("id");
    }
    
    // Hakee kirjan tunnuksella 33+ päivitys
    @Test
    public void testUpdate() throws Exception {
    	Book book = restTemplate.getForObject("http://localhost:" + port + "/book/{id}", Book.class, 33);
    	book.setTitle(book.getTitle() + "TestiTesti");
    	restTemplate.put("http://localhost:" + port + "/book/{id}", book, 33);
    }
    
    // Hakee kirjan tunnuksella 31 + delete
    @Test
    public void testDelete() throws Exception {
    	Book book = restTemplate.getForObject("http://localhost:" + port + "/book/{id}", Book.class, 31);
    	book.setYear(book.getYear()+ 1995);
    	restTemplate.delete("http://localhost:" + port + "/book/{id}", book, 31);
    }
    
    //create
    @Test
    public void testCreate() throws Exception {
    	Book book = new Book();
    	book.setTitle("Testi");
    	book = restTemplate.postForObject("http://localhost:" + port + "/books", book, Book.class);
    }
}