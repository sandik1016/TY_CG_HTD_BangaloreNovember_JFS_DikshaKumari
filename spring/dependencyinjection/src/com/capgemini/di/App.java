package com.capgemini.di;

import com.capgemini.di.dao.Animal;
import com.capgemini.di.factory.AnimalFactory;

public class App {
 public static void main(String[] args) {
	Animal animal =AnimalFactory.getAnimal();//injecting dependency on animal
	animal.makeSound();
}
}
