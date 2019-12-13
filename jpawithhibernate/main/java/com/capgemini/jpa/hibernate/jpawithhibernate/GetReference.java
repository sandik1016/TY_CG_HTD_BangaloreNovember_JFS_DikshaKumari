package com.capgemini.jpa.hibernate.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.capgemini.jpa.hibernate.jpawithhibernate.dto.Movie;

public class GetReference {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		//Movie record = entityManager.getReference(Movie.class, 12346);
		//entity classname,primarykey,we will store the object in record variable it is of movie type
		Movie record = entityManager.find(Movie.class, 12345);
	    System.out.println(record.getClass());
		System.out.println("id :"+record.getMid());
		System.out.println("name :"+record.getMname());//getter method to get the data
		System.out.println("rating :"+record.getRating());
		entityManager.close();
		
		}

	}//difference between getReference() and find()
//1.if we are not using a object then also in find() it will unncessarily hit the db
//2.find() is giving actual object refernece


