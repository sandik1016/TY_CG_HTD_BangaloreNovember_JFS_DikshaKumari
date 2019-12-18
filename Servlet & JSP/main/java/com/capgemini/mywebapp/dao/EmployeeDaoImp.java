package com.capgemini.mywebapp.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;

public class EmployeeDaoImp implements EmployeeDao {
      private EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistenceUnitName");
	@Override
	public EmployeeInfoBean searchEmployee(int emp_id) {
		EntityManager manager = entityManagerFactory.createEntityManager();
		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, emp_id);
		manager.close();
		return employeeInfoBean;
		
	}
	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		//create the entity manager
		EntityManager manager = entityManagerFactory.createEntityManager();
		String jpql = "from EmployeeInfoBean where emp_id=:empId and password=:pwd ";//returns single result
		Query query = manager.createQuery(jpql);
		query.setParameter("empId",empId);
		query.setParameter("pwd", password);
		
		EmployeeInfoBean employeeInfoBean  = null;
		try{
			employeeInfoBean = (EmployeeInfoBean)query.getSingleResult();//noresultfound exception
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		manager.close();
		return employeeInfoBean;
		
	}
	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		boolean isAdded = false;
		
		EntityManager manager = entityManagerFactory.createEntityManager();
		EntityTransaction transaction= null;
		try {
			transaction = manager.getTransaction();
			transaction.begin();
			manager.persist(employeeInfoBean);
			transaction.commit();
			isAdded =true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		manager.close();
		return isAdded;
	}
	@Override
	public boolean deleteEmployee(int emp_id) {
		boolean isDeleted = false;
		
		EntityManager manager = entityManagerFactory.createEntityManager();
		EmployeeInfoBean employeeInfoBean = manager.find(EmployeeInfoBean.class, emp_id);
		EntityTransaction transaction= null;
		if(employeeInfoBean!=null) {
			transaction= manager.getTransaction();
			transaction.begin();
			manager.remove(employeeInfoBean);
			transaction.commit();
			isDeleted =true;
			
		}
		manager.close();
		return isDeleted;
	}
	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		boolean isUpdated =  false;
		return false;
	}
	@Override
	public List<EmployeeInfoBean> getAllEmployee() {
		EntityManager manager = entityManagerFactory.createEntityManager();
		String jpql = "from EmployeeInfoBean";
		Query query = manager.createQuery(jpql);
		List<EmployeeInfoBean> employeeList = query.getResultList();
		manager.close();
		return employeeList;
	}

}
