package c24.Bookstore.domain;

public class Book {
	
	private String title;
	private String author;
	private int year;
	private String isbn;
	private int price;
	
	public Book() {
		super();
		this.title=null;
		this.author=null;
		this.year=0;
		this.isbn=null;
		this.price=0;
	}
	
	
	
	public void setTitle(String title) {
		this.title=title;
	}
	
	public void setAuthor(String author) {
		this.author=author;
	}
	
	public void setYear(int year) {
		this.year=year;
	}
	
	public void setIsbn(String isbn) {
		this.isbn=isbn;
	}
	
	public void setPrice(int price) {
		this.price=price;
	}
	
	public String getTitle() {
		return title;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public int getYear() {
		return year;
	}
	
	public String getIsbn() {
		return isbn;
	}
	
	public int getPrice() {
		return price;
	}
	
	@Override
	public String toString() {
		return title+author+year+isbn+price;
	}

}
