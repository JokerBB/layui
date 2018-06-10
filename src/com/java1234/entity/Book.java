package com.java1234.entity;

public class Book {
	private Integer id;
	private String bookName;
	private String bookAuthor;
	private String publisher;
	
	
	public Book() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
	public Book(Integer id, String bookName, String bookAuthor, String publisher) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.bookAuthor = bookAuthor;
		this.publisher = publisher;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getBookAuthor() {
		return bookAuthor;
	}
	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}



	@Override
	public String toString() {
		return "Book [id=" + id + ", bookName=" + bookName + ", bookAuthor=" + bookAuthor + ", publisher=" + publisher
				+ "]";
	}
	
	
	
	

}
