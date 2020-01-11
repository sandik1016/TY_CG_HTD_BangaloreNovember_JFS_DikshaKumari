package com.capgemini.retailermaintenancesystemapplicationdevelopment.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.ProductBean;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.exception.ProductException;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addProduct(ProductBean productBean) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(productBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new ProductException("Product id already exists");
		}
	}

	@Override
	public ProductBean getProduct(int productId) {
		String jpql = "from ProductBean where id=:id";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<ProductBean> query = manager.createQuery(jpql, ProductBean.class);
		if (query != null) {
			query.setParameter("id", productId);
			return query.getSingleResult();
		}
		throw new ProductException("Product Id doesn't not exists");
	}

	@Override
	public List<ProductBean> getAllProducts() {
		String jpql = "from ProductBean";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<ProductBean> query = manager.createQuery(jpql, ProductBean.class);
		if (query != null)
			return query.getResultList();
		throw new ProductException("Sorry!No Records Found");
	}
}
