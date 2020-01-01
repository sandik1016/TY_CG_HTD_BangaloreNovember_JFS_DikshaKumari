package com.capgemini.springcore.beans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
@Component
public class Pet {
  public Pet() {
		
	}
public Pet(String name, Animal animal) {
		
		this.name = name;
		this.animal = animal;
	}
private String name;
@Autowired//only required is possible ...in order to make use of byName 
@Qualifier("dog")//use qualifier for byName  we are using name of the bean to get object
  private Animal animal;
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public Animal getAnimal() {
	return animal;
}
public void setAnimal(Animal animal) {
	this.animal = animal;
}
  //autowired can be used for method variable and constructor,annotation,parameter
//example: @Autowired
//setAnimal(Animal animal)
//for this Animal reference variable particular object will be passed 
//if u use for constructor it will pass object for parameter

}
