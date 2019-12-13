package com.cape.jpawithhibernate.manytoone;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.capge.jpawithhibernate.onetoone.EmployeeInfo;
import com.capge.jpawithhibernate.onetoone.EmployeeOthrInfo;

public class TestManyToOne {
	public static void main(String args[]) {
	EmployeeInfo empInfo =  new EmployeeInfo();
	
	empInfo.setEid(16);//setting the value for data fields
	empInfo.setEname("Amita");
	empInfo.setEmail("amit@gmail.com");
	empInfo.setPassword("123345");
	EmployeeExperience other =  new EmployeeExperience();
	other.setExpId(78);
	other.setExpYrs(3);
	other.setCompName("tcs");
	EmployeeExperience other1 =  new EmployeeExperience();
	other1.setExpId(89);
	other1.setExpYrs(3);
	other1.setCompName("cts");
	other.setEmpInfo(empInfo);
	other1.setEmpInfo(empInfo);
	
	EntityTransaction transaction = null;
	EntityManager entityManager = null;
	
	try {
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");//persistenceunit name
		entityManager = entityManagerFactory.createEntityManager();
		transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(other);
		entityManager.persist(other1);//pass the object of entity class
		transaction.commit();
	} catch (Exception e) {
		
		e.printStackTrace();
		transaction.rollback();
	}
	
	entityManager.close();

}
}