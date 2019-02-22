package c24.Bookstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import c24.Bookstore.domain.Book;
import c24.Bookstore.domain.BookRepository;


@Controller
public class BookController {
	
	@Autowired
	private BookRepository repository;
	
	@RequestMapping(value="/booklist")
	public String booklist(Model model) {
		model.addAttribute("books", repository.findAll());
		return "booklist";
	}
	
	@RequestMapping(value="/newbook", method=RequestMethod.GET)
	public String uusikirja(Model model) {
		model.addAttribute("kirja", new Book());
		return "Book";
		
	}
	
	@RequestMapping(value="/removebook/{id}", method=RequestMethod.GET)
	public String poistakirja(@PathVariable("id") Long bookId, Model model) {
		repository.deleteById(bookId);
		return "redirect:../booklist";
		
	}
	
	@RequestMapping(value="/editbook/{id}")
	public String editbook(@PathVariable("id") Long bookId, Model model) {
		model.addAttribute("kirja", repository.findById(bookId));
		return "editbook";
	}
	
	@RequestMapping(value="/savebook" ,method=RequestMethod.POST)
	public String save(Book book) {
		repository.save(book);
		return "redirect:booklist";
	}

}