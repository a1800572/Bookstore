package c24.Bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long categoryid;
	private String name;
	
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="category")
	@JsonIgnore
	private List<Book> books;
	
	
	public Category() {}
	
	
	public Category(String name) {
		super();
		this.name=name;
	}
	
	
	
	
	
	//setterit
	public void setCategoryid(Long categoryid) {
		this.categoryid=categoryid;
	}
	public void setName(String name) {
		this.name=name;
	}
	public void setBooks(List<Book> books) {
		this.books=books;
	}
	
	
	
	
	
	//getterit
	public Long getCategoryid() {
		return categoryid;
	}
	public String getName() {
		return name;
	}
	public List<Book> getBooks(){
		return books;
	}
	
	@Override
	public String toString() {
		return name+categoryid;
		
	}

}
