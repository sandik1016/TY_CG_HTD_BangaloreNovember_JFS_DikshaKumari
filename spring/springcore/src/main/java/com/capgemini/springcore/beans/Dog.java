package com.capgemini.springcore.beans;

import org.springframework.stereotype.Component;

@Component
public class Dog implements Animal{

	@Override
	public void makesound() {
	System.out.println("baooo baoooo");
		
	}
  
}
