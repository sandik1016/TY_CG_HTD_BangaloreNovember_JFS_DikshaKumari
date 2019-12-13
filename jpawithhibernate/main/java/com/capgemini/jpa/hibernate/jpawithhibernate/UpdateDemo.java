package com.capgemini.jpa.hibernate.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpa.hibernate.jpawithhibernate.dto.Movie;

public class UpdateDemo {

	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		
		try {
			EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("Test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Movie record = entityManager.find(Movie.class, 1202);
			record.setMname("Hero");
			record.setRating("good");
			
			System.out.println("Record Updated..");
			transaction.commit();
			
		}catch(Exception e) {
			e.printStackTrace();
			transaction.rollback();
			
		}
		entityManager.close();
	}

}
