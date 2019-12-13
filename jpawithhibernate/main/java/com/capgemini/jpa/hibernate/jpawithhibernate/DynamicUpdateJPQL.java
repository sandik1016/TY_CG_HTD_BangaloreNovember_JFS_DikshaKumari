package com.capgemini.jpa.hibernate.jpawithhibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class DynamicUpdateJPQL {

	public static void main(String[] args) {
		EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("Test");
		EntityManager entityManager =  entityManagerFactory.createEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		String str ="update Movie set mname=:nm where mid=:id";
		Query query = entityManager.createQuery(str);
		query.setParameter("id", 12345);//string and object value
		query.setParameter("nm", "Dilli");//pass here object value from frontend input fields 
		int result = query.executeUpdate();
		System.out.println(result);
		transaction.commit();
		entityManager.close();

	}

}
