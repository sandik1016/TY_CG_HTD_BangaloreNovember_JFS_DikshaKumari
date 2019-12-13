package com.capgemini.jpa.hibernate.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpa.hibernate.jpawithhibernate.dto.Movie;

public class InsertDemo  {

	public static void main(String[] args) {
		// create an object of entity class
		Movie movie = new Movie();
		movie.setMid(1204);//setting the value for data fields
		movie.setMname("DDL");
		movie.setRating("good");
		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");//persistenceunit name
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(movie);//pass the object of entity class
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			transaction.rollback();
		}
		
		entityManager.close();
	}
	  

}
