package com.capgemini.jpa.hibernate.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.jpa.hibernate.jpawithhibernate.dto.Movie;

public class ReadDemo {

	public static void main(String[] args) {
		// TODO  
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		Movie record = entityManager.find(Movie.class, 1202);//entity classname,primarykey,we will store the object in record variable it is of movie type
	    System.out.println("id :"+record.getMid());
		System.out.println("name :"+record.getMname());//getter method to get the data
		System.out.println("rating :"+record.getRating());
		entityManager.close();
		
		}

}
