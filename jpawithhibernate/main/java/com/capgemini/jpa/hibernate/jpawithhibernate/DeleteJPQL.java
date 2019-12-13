package com.capgemini.jpa.hibernate.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import javax.persistence.Query;

public class DeleteJPQL {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager =  entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String str ="delete from Movie where mid=1204";
		Query query = entityManager.createQuery(str);
		query.executeUpdate();
		transaction.commit();
		entityManager.close();
		
	}

}
  