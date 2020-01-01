package com.capgemini.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.capgemini.springcore.beans.Animal;
import com.capgemini.springcore.beans.Hello;
import com.capgemini.springcore.beans.Pet;


public class App 
{
    public static void main( String[] args )
    {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello hello = context.getBean(Hello.class);
        Hello hello1 = context.getBean(Hello.class);
        System.out.println("*************************************************");
        System.out.println(hello==hello1);//must return falseeeeeeee but it will return true as spring creates only one object ie singleton class
        System.out.println("*************************************************");
        System.out.println("*************************************************");
        
        System.out.println(hello);//same hashcode instead of diffrent hashcode
        System.out.println(hello1);
        
        //in order to create different object give scope =prototype
        System.out.println("*************************************************");
        System.out.println(hello.getMsg());//we have not created object of hello class it was created by spring
        
        
        
        
       Animal animal = context.getBean(Animal.class);//use class name or interface name
       animal.makesound();
       
       System.out.println("*************************************************");
       //it is wiring connecting one object to anothr object dog object to reference variable of animal......ref="dog"
       Pet pet=context.getBean(Pet.class);
       System.out.println(pet.getName());//suki
       pet.getAnimal().makesound();//baoo baoo
    }
}
