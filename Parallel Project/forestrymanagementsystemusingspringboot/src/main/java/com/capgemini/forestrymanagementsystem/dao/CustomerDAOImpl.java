package com.capgemini.forestrymanagementsystem.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.forestrymanagementsystem.dto.CustomerBean;
import com.capgemini.forestrymanagementsystem.exception.CustomerException;


@Repository
public class CustomerDAOImpl implements CustomerDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public boolean addCustomer(CustomerBean customer) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(customer);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new CustomerException("customer account already exists");
		}

	}
   @Override
	public boolean deleteCustomer(int customerId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		CustomerBean bean = manager.find(CustomerBean.class, customerId);
		if (bean != null) {
			manager.remove(bean);
			transaction.commit();
			return true;
		}
		throw new CustomerException("Employee Id not found");
	}

	@Override
	public List<CustomerBean> getAllCustomers() {
		String jpql = "from CustomerBean";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<CustomerBean> query = manager.createQuery(jpql, CustomerBean.class);
		if (query != null)
			return query.getResultList();
		throw new CustomerException("Sorry!No Records Found");
	}

	@Override
	public boolean modifyCustomer(int customerId,CustomerBean customer) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		CustomerBean bean1 = manager.find(CustomerBean.class,customerId);
		if (bean1 != null) {
			bean1.setCustomerId(customer.getCustomerId());
			bean1.setCustomerName(customer.getCustomerName());
			bean1.setCustomerAddress(customer.getCustomerAddress());
			bean1.setCustomerEmail(customer.getCustomerEmail());
			bean1.setCustomerPhone(customer.getCustomerPhone());
			bean1.setCustomerPostal(customer.getCustomerPostal());
			bean1.setCustomerTown(customer.getCustomerTown());
			transaction.commit();
			return true;
		}
		throw new CustomerException("Unable to retrieve provided customer id");
	}

	@Override
	public CustomerBean getCustomer(int customerId) {
		String jpql = "from CustomerBean where customerId=:customerId";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<CustomerBean> query = manager.createQuery(jpql, CustomerBean.class);
		query.setParameter("customerId", customerId);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
				throw new CustomerException("customer not found");
			}
	}
}

