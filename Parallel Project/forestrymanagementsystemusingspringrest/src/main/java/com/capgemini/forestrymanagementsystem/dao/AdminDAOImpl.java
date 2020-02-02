package com.capgemini.forestrymanagementsystem.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.forestrymanagementsystem.dto.UserBean;
import com.capgemini.forestrymanagementsystem.exception.UserException;

@Repository
public class AdminDAOImpl implements AdminDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean clientRegister(UserBean clientBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(clientBean);
			transaction.commit();
			return true;
		} catch (Exception e) {

		throw new UserException("email already exists");
		}
	}


	@Override
	public boolean schedulerRegister(UserBean schedulerBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(schedulerBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new UserException("email already exists");

		}
	}

	@Override
	public boolean removeClient(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		UserBean clientBean = manager.find(UserBean.class, id);
		if (clientBean != null) {
			manager.remove(clientBean);
			transaction.commit();
			return true;
		}
		throw new UserException("Client account doesn't exists...");
	}

	@Override
	public List<UserBean> showClients() {
		String jpql = "from UserBean where user_type ='client'";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<UserBean> query = manager.createQuery(jpql, UserBean.class);
		if (query != null)
			return query.getResultList();
		throw new UserException("Sorry!No Records Found");
	}

	@Override
	public boolean removeScheduler(int id) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		UserBean schedulerBean = manager.find(UserBean.class, id);
		if (schedulerBean != null) {
			manager.remove(schedulerBean);
			transaction.commit();
			return true;
		}
		throw new UserException("Scheduler account doesn't exists...");
	}

	@Override
	public List<UserBean> showScheduler() {
		String jpql = "from UserBean where user_type ='scheduler'";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<UserBean> query = manager.createQuery(jpql, UserBean.class);
		if (query != null)
			return query.getResultList();
		throw new UserException("Sorry!No Records Found");
	}

	@Override
	public boolean changePassword(int id, String password) {
			EntityManager manager=factory.createEntityManager();
			EntityTransaction transaction =manager.getTransaction();
			transaction.begin();
			UserBean bean = manager.find(UserBean.class,id);
			bean.setPassword(password);
			transaction.commit();
			return true;
		}

}
