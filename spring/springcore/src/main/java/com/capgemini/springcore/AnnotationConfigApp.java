package com.capgemini.springcore;

import org.springframework.beans.factory.wiring.BeanConfigurerSupport;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.springcore.beans.Animal;
import com.capgemini.springcore.beans.Hello;
import com.capgemini.springcore.beans.Pet;
import com.capgemini.springcore.config.BeansConfig;

public class AnnotationConfigApp {
public static void main(String[] args) {
	ApplicationContext context = new AnnotationConfigApplicationContext(BeansConfig.class);
	Hello hello = context.getBean(Hello.class);
	System.out.println(hello.getMsg());//we are creating beans /object using annotation 
	System.out.println("***********************************");
	//create another object to check prototype
	Hello hello1 = context.getBean(Hello.class);
	System.out.println(hello.getMsg());
	
	
	//prototype will create different tym object
	
	System.out.println(hello);
	System.out.println(hello1);
	System.out.println(hello==hello1);
	
	
	
	
	//achieve dependency injection
	System.out.println("***********************************");
	Animal animal = context.getBean(Animal.class);
	animal.makesound();
	
	
	
	
	
	
	
	//wire
	System.out.println("***********************************");
	Pet pet = context.getBean(Pet.class);
	System.out.println(pet.getName());
	pet.getAnimal().makesound();
	
	
	
	}
}
