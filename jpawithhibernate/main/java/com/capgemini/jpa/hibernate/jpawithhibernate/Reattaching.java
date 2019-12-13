package com.capgemini.jpa.hibernate.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpa.hibernate.jpawithhibernate.dto.Movie;

public class Reattaching {
	public static void main(String[] args) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		
		
		try {
			EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("Test");
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			Movie record = entityManager.find(Movie.class, 12345);
			System.out.println(entityManager.contains(record));
			entityManager.detach(record);
			System.out.println(entityManager.contains(record));
			record.setMname("raja");
			
			Movie reattach = entityManager.merge(record);
			reattach.setMname("dil toh bcha hai ji");
			System.out.println("Record Updated..");
			transaction.commit();
			
			
		}catch(Exception e)
		{
			e.printStackTrace();
			transaction.rollback();//when we encounter inconsistency
		}
		entityManager.close();
		}

}
