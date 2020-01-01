package com.capgemini.springcore.beans;

import org.springframework.beans.factory.annotation.Autowired;

public class Book {
      String bookname;
      public String getBookname() {
		return bookname;
	}
	public void setBookname(String bookname) {
		this.bookname = bookname;
	}
	@Autowired
      Author author;
	public Author getAuthor() {
		return author;
	}
	public void setAuthor(Author author) {
		this.author = author;
	}
	
	
	
      
	
	
	
	

}
