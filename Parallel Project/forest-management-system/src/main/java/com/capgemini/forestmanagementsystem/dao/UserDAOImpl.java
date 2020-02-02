package com.capgemini.forestmanagementsystem.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.capgemini.forestmanagementsystem.bean.UserBean;
import com.capgemini.forestmanagementsystem.exception.UserException;

public class UserDAOImpl implements UserDAO {
	EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");

	@Override
	public boolean addUser(UserBean user) {
		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		try {
			entityManager = entityManagerfactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(user);
			System.out.println("Record successfully inserted");
			transaction.commit();
			return true;
		} catch (Exception e) {
			try {
				throw new UserException("Exception While Adding User Details");
			} catch (UserException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}

		entityManager.close();
		return false;
	}

	@Override
	public boolean removeUser(String email) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {

			if (!email.isEmpty()) {
				entityManager = entityManagerfactory.createEntityManager();
				transaction = entityManager.getTransaction();
				transaction.begin();
				UserBean record = entityManager.find(UserBean.class, email);
				entityManager.remove(record);
				transaction.commit();
				return true;
			}

			else {
				System.out.println("User details not found for that given user id");
				return false;
			}
		} catch (Exception e) {
			try {
				throw new UserException("Exception While Deleting User Details");
			} catch (UserException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}

		entityManager.close();
		return false;
	}

	@Override
	public List<UserBean> showUser() {
		try {
			EntityManager entityManager = entityManagerfactory.createEntityManager();
			String jpql = "from UserBean";
			Query query = entityManager.createQuery(jpql);
			@SuppressWarnings("unchecked")
			List<UserBean> record = query.getResultList();
			entityManager.close();

			return record;
		} catch (Exception e) {
			try {
				throw new UserException("Exception While Viewing All User Details");
			} catch (UserException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean authenticate(String email, String password) {
		EntityManager entityManager = entityManagerfactory.createEntityManager();
		String login = "from UserBean where email=:email and password=:password and user_type ='admin'";
		Query query = entityManager.createQuery(login);
		query.setParameter("email", email);
		query.setParameter("password", password);
		UserBean admin = (UserBean) query.getSingleResult();
		if (admin != null) {
			if (admin.getPassword().equals(password)) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean searchUserType(String role) {
		try {
			EntityManager entityManager = entityManagerfactory.createEntityManager();
			String jpql = "from UserBean where user_type=:user_type";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("user_type", role);
			return true;
		} catch (Exception e) {
			try {
				throw new UserException("Exception While Viewing User Details");
			} catch (UserException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean authenticateClient(String email, String password) {
		EntityManager entityManager = entityManagerfactory.createEntityManager();
		String login = "from UserBean where email=:email and password=:password and user_type ='client'";
		Query query = entityManager.createQuery(login);
		query.setParameter("email", email);
		query.setParameter("password", password);
		UserBean client = (UserBean) query.getSingleResult();
		if (client != null) {
			if (client.getPassword().equals(password)) {
				return true;
			}
			return false;
		}
		return false;
	}

	@Override
	public boolean authenticateScheduler(String email, String password) {
		EntityManager entityManager = entityManagerfactory.createEntityManager();
		String login = "from UserBean where email=:email and password=:password and user_type ='scheduler'";
		Query query = entityManager.createQuery(login);
		query.setParameter("email", email);
		query.setParameter("password", password);
		UserBean scheduler = (UserBean) query.getSingleResult();
		if (scheduler != null) {
			if (scheduler.getPassword().equals(password)) {
				return true;
			}
			return false;
		}
		return false;
	}
}
