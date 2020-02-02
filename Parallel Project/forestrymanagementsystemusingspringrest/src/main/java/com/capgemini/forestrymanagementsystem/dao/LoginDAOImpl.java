package com.capgemini.forestrymanagementsystem.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import com.capgemini.forestrymanagementsystem.dto.UserBean;
import com.capgemini.forestrymanagementsystem.exception.UserException;

@Repository
public class LoginDAOImpl implements LoginDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public UserBean adminLogin(String adminEmail, String adminPassword) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from UserBean where user_type =:user_type and email=:email";
		Query query = manager.createQuery(jpql);
		query.setParameter("user_type", "admin");
		query.setParameter("email", adminEmail);
		try {
			UserBean admin = (UserBean) query.getSingleResult();
			if (admin.getPassword().equals(adminPassword)) {
				return admin;
			}
			return null;
		} catch (Exception e) {

		}
		throw new UserException("Sorry....account doesn't exists");
	}

	@Override
	public UserBean clientLogin(String clientEmail, String clientPassword) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from UserBean where user_type =:user_type and email=:email";
		Query query = manager.createQuery(jpql);
		query.setParameter("user_type", "client");
		query.setParameter("email", clientEmail);
		try {
			UserBean client = (UserBean) query.getSingleResult();
			if (client.getPassword().equals(clientPassword)) {
				return client;
			}
			return null;
		} catch (Exception e) {

		}
		throw new UserException("Sorry ...account doesn't exists");

	}

	@Override
	public UserBean schedulerLogin(String schedulerEmail, String schedulerPassword) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from UserBean where user_type =:user_type and email=:email";
		Query query = manager.createQuery(jpql);
		query.setParameter("user_type", "scheduler");
		query.setParameter("email", schedulerEmail);
		try {
			UserBean scheduler = (UserBean) query.getSingleResult();
			if (scheduler.getPassword().equals(schedulerPassword)) {
				return scheduler;
			}
			return null;
		} catch (Exception e) {

		}
		throw new UserException("Sorry ... account doesn't exists");
	}
}
