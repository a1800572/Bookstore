package c24.Bookstore.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import c24.Bookstore.domain.Book;
import c24.Bookstore.domain.BookRepository;
import c24.Bookstore.domain.CategoryRepository;

@Controller
public class RestController {
	
	@Autowired
	private BookRepository repository;
	
	// crepositoriota ei tarvita tallähetkellä
	@SuppressWarnings("unused")
	@Autowired
	private CategoryRepository crepository;
	
	
		//Book id alkaa 31 eteenpäin
		//Rest kaikki kirjat
		@RequestMapping(value="/books", method=RequestMethod.GET)
		public @ResponseBody List<Book> bookListRest(){
			return(List<Book>) repository.findAll();
		}
		
		//Book id alkaa 31 eteenpäin
		//Rest id:n avulla
		@RequestMapping(value="/book/{id}", method=RequestMethod.GET)
		public @ResponseBody Optional <Book> findBookRest(@PathVariable("id") Long bookId){
			return repository.findById(bookId);
		}

}
