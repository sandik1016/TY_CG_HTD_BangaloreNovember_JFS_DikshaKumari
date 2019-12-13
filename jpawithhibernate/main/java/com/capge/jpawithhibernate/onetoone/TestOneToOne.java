 package com.capge.jpawithhibernate.onetoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capgemini.jpa.hibernate.jpawithhibernate.dto.Movie;

public class TestOneToOne {

	public static void main(String[] args) {
		EmployeeInfo empInfo =  new EmployeeInfo();
		
		empInfo.setEid(12);//setting the value for data fields
		empInfo.setEname("Ram");
		empInfo.setEmail("ram1@gmail.com");
		empInfo.setPassword("123345");
		EmployeeOthrInfo other =  new EmployeeOthrInfo();
		other.setId(10);
		other.setPancard("EF456");
		other.setEmpInfo(empInfo);
		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");//persistenceunit name
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			//entityManager.persist(other);//pass the object of entity class
			//code for bidirectional
			EmployeeInfo e =entityManager.find(EmployeeInfo.class, 12);
			System.out.println(e.getOther().getId());
			System.out.println(e.getOther().getPancard());
			
			
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			transaction.rollback();
		}
		
		entityManager.close();

	}

}
