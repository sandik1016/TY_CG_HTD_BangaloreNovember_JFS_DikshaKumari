package com.capg.jpawithhibernate.manttomany;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import com.capge.jpawithhibernate.onetoone.EmployeeInfo;

public class TestManyToMany {
	public static void main(String args[]) {
		EmployeeInfo empInfo =  new EmployeeInfo();
		
		empInfo.setEid(37);//setting the value for data fields
		empInfo.setEname("Arun");
		empInfo.setEmail("ar@gmail.com");
		empInfo.setPassword("123345");
		
		EmployeeInfo empInfo1 =  new EmployeeInfo();
		empInfo1.setEid(91);//setting the value for data fields
		empInfo1.setEname("Anika");
		empInfo1.setEmail("at@gmail.com");
		empInfo1.setPassword("127345");
		
		ArrayList<EmployeeInfo> aList =new ArrayList<EmployeeInfo>();
		aList.add(empInfo);
		aList.add(empInfo1);
		
		TrainingInfo tInfo = new TrainingInfo();
		tInfo.setTid(101);
		tInfo.setTname("MeanStack FS");
		tInfo.setEmp(aList);
		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		
		try {
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");//persistenceunit name
			entityManager = entityManagerFactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(tInfo);
			//pass the object of entity class
			transaction.commit();
		} catch (Exception e) {
			
			e.printStackTrace();
			transaction.rollback();
		}
		
		entityManager.close();
	}

}
