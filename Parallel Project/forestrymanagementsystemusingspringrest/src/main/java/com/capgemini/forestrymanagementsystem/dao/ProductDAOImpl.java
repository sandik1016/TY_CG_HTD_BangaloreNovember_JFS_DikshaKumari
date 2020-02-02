package com.capgemini.forestrymanagementsystem.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.forestrymanagementsystem.dto.ProductBean;
import com.capgemini.forestrymanagementsystem.exception.ProductException;
@Repository
public class ProductDAOImpl implements ProductDAO {
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public boolean addProduct(ProductBean product) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(product);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new ProductException("product account already exists");
		}
	}

	@Override
	public boolean deleteProduct(int productId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		ProductBean bean = manager.find(ProductBean.class,productId);
		if (bean != null) {
			manager.remove(bean);
			transaction.commit();
			return true;
		}
		throw new ProductException("Product Id not found");
	}

	@Override
	public List<ProductBean> getAllProduct() {
		String jpql = "from ProductBean";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<ProductBean> query = manager.createQuery(jpql,ProductBean.class);
		if (query != null)
			return query.getResultList();
		throw new ProductException("Sorry!No Records Found");
	}

	@Override
	public boolean modifyProduct(int productId, ProductBean product) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		ProductBean bean1 = manager.find(ProductBean.class,productId);
		if (bean1 != null) { 
			bean1.setProductName(product.getProductName());
			bean1.setProductId(product.getProductId());
			bean1.setProductQuantity(product.getProductQuantity());
			transaction.commit();
			return true;
		}
		throw new ProductException("Unable to retrieve provided product id");
	}

	@Override
	public ProductBean getProduct(int productId) {
		String jpql = "from ProductBean where productId=:productId";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<ProductBean> query = manager.createQuery(jpql,ProductBean.class);
		query.setParameter("productId", productId);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
				throw new ProductException("product not found");
			}
	}
}



