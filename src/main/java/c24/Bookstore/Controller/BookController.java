package c24.Bookstore.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import c24.Bookstore.domain.Book;

@Controller
public class BookController {
	
	@RequestMapping(value="/newbook", method=RequestMethod.GET)
	public String uusikirja(Model model) {
		
		Book book1= new Book();
		model.addAttribute("kirja", book1);
		return "Book";
		
	}
	
	@RequestMapping(value="/addbook", method=RequestMethod.POST)
	public String lisaakirja(@ModelAttribute Book newbook, Model model) {
		model.addAttribute("kirja", newbook);
		return "addedbook";
		
	}

}
