package com.capgemini.di.factory;

import com.capgemini.di.dao.Animal;
import com.capgemini.di.dao.Dog;

public class AnimalFactory {
	private AnimalFactory() {}//when we are having static method try to provide private constructor
           public static Animal getAnimal() {//object of type animal and calling this method in app.javsa
           return new Dog();
}
}
