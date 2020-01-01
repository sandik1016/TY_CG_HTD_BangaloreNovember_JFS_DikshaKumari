package com.capgemini.springcore.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.capgemini.springcore.beans.Author;
import com.capgemini.springcore.beans.Book;
import com.capgemini.springcore.beans.Cat;
import com.capgemini.springcore.beans.Dog;
import com.capgemini.springcore.beans.Hello;
import com.capgemini.springcore.beans.Pet;

@Configuration
//here we are using annotation
public class BeansConfig {
//create a bean
	//its a java class so we can create member function
	@Bean("hello")//hello is name of the bean
	@Scope("prototype")//bydefault it is singleton//map the scope..
	public Hello getHello() {//method returning an object ie factory method
		Hello hello= new Hello();
		hello.setMsg("i love shri");
		return hello;
		//we have to configure this method as bean
	}
	
	
	
	
	//achieve dependency injection
	//create object of dog ...this is not bean method so annotate using bean to make it bean
	@Bean("dog")//bydefault getDog is name same as method name
	public Dog getDog() {
		return new Dog();
	}
		
		
		//wire
	@Bean("pet")
		public Pet getPet(){
			Pet pet=new Pet();
			pet.setName("spar");
			//pet.setAnimal(getDog());we will not write it when we go for autowired
			return pet;
		}
	
	
	
	@Bean("cat")
	@Primary//it is bydefault true
	public Cat getCat() {
		return new Cat();
	}//exception will be encountered as expected 1 object but 2 object is found dog and cat so in xml we use primary to resolve it
	
	
	
	
	@Bean("book")//hello is name of the bean
	
	public Book getBook() {//method returning an object ie factory method
		Book b= new Book();
		b.setAuthor(getAuthor());
		b.setBookname("science");
		return b;
		//we have to configure this method as bean
	}
	
	
@Bean("author")//hello is name of the bean
	
	public Author getAuthor() {//method returning an object ie factory method
		Author b1= new Author();
		
		b1.setName("Rs agarwal");
		return b1;
		//we have to configure this method as bean
	}
	
	
	
	
	
	}

