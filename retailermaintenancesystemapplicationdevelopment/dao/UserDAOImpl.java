package com.capgemini.retailermaintenancesystemapplicationdevelopment.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.UserBean;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.exception.ProductException;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.exception.UserException;

@Repository
public class UserDAOImpl implements UserDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean registerUser(UserBean userBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(userBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new ProductException("User id already exists");
		}
	}

	@Override
	public UserBean authentication(String email, String password) {
		EntityManager manager = factory.createEntityManager();
		String jpql = "from UserBean where email=:email";
		TypedQuery<UserBean> query = manager.createQuery(jpql, UserBean.class);
		query.setParameter("email", email);
		try {
			UserBean bean = query.getSingleResult();
			BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
			if (encoder.matches(password, bean.getPassword()))

				return bean;
			else
				throw new UserException("password invalid");
		} catch (Exception e) {

			throw new UserException("email invalid");
		}
	}

	@Override
	public boolean changePassword(String userEmail, String password) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		UserBean bean = manager.find(UserBean.class,userEmail);
		bean.setPassword(password);
		transaction.commit();
		return true;
	}
}
