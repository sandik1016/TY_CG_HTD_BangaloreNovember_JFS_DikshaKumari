package com.capgemini.jpa.jpql;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.jpa.hibernate.jpawithhibernate.dto.Movie;

public class JPQL {
   public static void main(String[] args) {
	EntityManagerFactory entityManagerFactory =  Persistence.createEntityManagerFactory("Test");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	//String q = "from Movie";
	String q="Select mname from Movie";
	
	Query query = entityManager.createQuery(q);
	List<String> list= query.getResultList();

	for(String m : list){
//		System.out.println("Movie id :"+m.getMid());
//		System.out.println("Movie name :"+m.getMname());
//		System.out.println("Movie rating :"+m.getRating());
		System.out.println(m);
	}
	entityManager.close();
}
}
  
