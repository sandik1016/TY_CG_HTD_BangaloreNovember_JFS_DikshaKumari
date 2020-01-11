package com.capgemini.retailermaintenancesystemapplicationdevelopment.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.OrderBean;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.exception.OrderException;

@Repository
public class OrderDAOImpl implements OrderDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public boolean addOrder(OrderBean orderBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(orderBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new OrderException("Order id already exists");
		}

	}

	@Override
	public OrderBean getOrder(int orderId) {

		String jpql = "from OrderBean where id=:id";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<OrderBean> query = manager.createQuery(jpql, OrderBean.class);
		if (query != null) {
			query.setParameter("id", orderId);
			return query.getSingleResult();
		}
		throw new OrderException("Order Id doesn't not exists");
	}

	@Override
	public List<OrderBean> getAllOrders() {
		String jpql = "from OrderBean";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<OrderBean> query = manager.createQuery(jpql, OrderBean.class);
		if (query != null)
			return query.getResultList();
		throw new OrderException("Sorry!No Records Found");

	}

}
