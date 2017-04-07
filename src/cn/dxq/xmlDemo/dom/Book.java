package cn.dxq.xmlDemo.dom;

public class Book {
	private String bookid;
	private String bookname;
	private String author;
	private String publisher;
	private float price;
	public String getBookid() {
		return bookid;
	}
	public void setBookid(String bookid) {
		this.bookid = bookid;
	}
	public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public String toString(){
		return "《"+bookname+"》，书号："+bookid+",作者："+author+",出版社："+publisher+",价格："+price;
	}
}
