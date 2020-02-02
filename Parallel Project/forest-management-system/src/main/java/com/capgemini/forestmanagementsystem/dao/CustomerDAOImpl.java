package com.capgemini.forestmanagementsystem.dao;

import java.util.List;

import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.capgemini.forestmanagementsystem.bean.CustomerBean;
import com.capgemini.forestmanagementsystem.exception.CustomerException;

public class CustomerDAOImpl implements CustomerDAO {
	Scanner scanner = new Scanner(System.in);

	@Override
	public boolean addCustomer(CustomerBean customer) {
		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		try {
			EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
			entityManager = entityManagerfactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(customer);
			System.out.println("Record successfully inserted");
			transaction.commit();
			return true;
		} catch (Exception e) {
			try {
				throw new CustomerException("Exception while adding customer details");
			} catch (CustomerException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}

		entityManager.close();
		return false;
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			List<CustomerBean> customerbean = searchCustomer(customerId);
			if (!customerbean.isEmpty()) {
				EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
				entityManager = entityManagerfactory.createEntityManager();
				transaction = entityManager.getTransaction();
				transaction.begin();
				CustomerBean record = entityManager.find(CustomerBean.class, customerId);
				entityManager.remove(record);
				transaction.commit();
				return true;
			}

			else {
				System.out.println("Customer details not found for that given customer id");
				return false;
			}
		} catch (Exception e) {
			try {
				throw new CustomerException("Exception While Adding Customer Details");
			} catch (CustomerException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}

		entityManager.close();
		return false;
	}

	@Override
	public List<CustomerBean> getAllCustomer() {
		try {
			EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
			EntityManager entityManager = entityManagerfactory.createEntityManager();
			String jpql = "from CustomerBean";
			Query query = entityManager.createQuery(jpql);
			@SuppressWarnings("unchecked")
			List<CustomerBean> record = query.getResultList();
			entityManager.close();
			return record;
		} catch (Exception e) {
			try {
				throw new CustomerException("Exception While Viewing All Customer Details");
			} catch (CustomerException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean updateAddress(CustomerBean cust2) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			if (cust2 != null) {
				entityManagerFactory = Persistence.createEntityManagerFactory("Test");
				entityManager = entityManagerFactory.createEntityManager();
				transaction = entityManager.getTransaction();
				transaction.begin();
				String str = "update CustomerBean set customerAddress=:customerAddress where customerId=:customerId";
				Query query = entityManager.createQuery(str);
				query.setParameter("customerId", cust2.getCustomerId());// string and object value
				query.setParameter("customerAddress", cust2.getCustomerAddress());
				int result = query.executeUpdate();
				System.out.println(result);
				transaction.commit();
				return true;
			} else {
				System.out.println("Customer details not found for that given customer id");
				return false;
			}
		} catch (Exception e) {
			try {
				throw new CustomerException("Exception While Updating Customer Details");
			} catch (CustomerException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}
		entityManager.close();
		return false;
	}

	@Override
	public boolean updateContact(CustomerBean cust1) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			if (cust1 != null) {
				EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Test");
				entityManager = entityManagerFactory.createEntityManager();
				transaction = entityManager.getTransaction();
				transaction.begin();
				String str = "update CustomerBean set customerPhone=:customerPhone where customerId=:customerId";
				Query query = entityManager.createQuery(str);
				query.setParameter("customerId", cust1.getCustomerId());// string and object value
				query.setParameter("customerPhone", cust1.getCustomerPhone());
				int result = query.executeUpdate();
				System.out.println(result);
				transaction.commit();
				return true;
			} else {
				System.out.println("Customer details not found for that given customer id");
				return false;
			}
		} catch (Exception e) {
			try {
				throw new CustomerException("Exception While Updating Customer Details");
			} catch (CustomerException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}
		entityManager.close();
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CustomerBean> searchCustomer(int customerId) {
		try {
			EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
			EntityManager entityManager = entityManagerfactory.createEntityManager();
			String jpql = "from CustomerBean where customerId=:customerId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("customerId", customerId);
			@SuppressWarnings("rawtypes")
			List list = query.getResultList();
			return list;
		} catch (Exception e) {
			try {
				throw new CustomerException("Exception While Viewing Customer Details");
			} catch (CustomerException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

}
