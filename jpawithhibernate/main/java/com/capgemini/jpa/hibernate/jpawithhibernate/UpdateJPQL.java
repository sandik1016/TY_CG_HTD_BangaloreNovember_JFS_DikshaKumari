package com.capgemini.jpa.hibernate.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class UpdateJPQL {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager =  entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String jpql = "update Movie set mname = 'Dil' where mid=1204";
		
		Query query = entityManager.createQuery(jpql);
		query.executeUpdate();
		transaction.commit();
		entityManager.close();
	}

}
