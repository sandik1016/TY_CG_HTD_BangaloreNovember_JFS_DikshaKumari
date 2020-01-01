package com.capgemini.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcore.beans.Author;
import com.capgemini.springcore.beans.Book;
import com.capgemini.springcore.beans.Hello;
import com.capgemini.springcore.config.BeansConfig;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
		Book book = context.getBean(Book.class);
		Author author = context.getBean(Author.class);
		System.out.println(book.getBookname());
		System.out.println(author.getName());
		System.out.println("***********************************");

	}

}

   