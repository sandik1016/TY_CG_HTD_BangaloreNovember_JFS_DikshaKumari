package com.capgemini.forestmanagementsystem.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.capgemini.forestmanagementsystem.bean.ProductBean;
import com.capgemini.forestmanagementsystem.exception.ContractException;
import com.capgemini.forestmanagementsystem.exception.ProductException;

public class ProductDAOImpl implements ProductDAO {

	public boolean insertProduct(ProductBean product) {
		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		try {
			EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
			entityManager = entityManagerfactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(product);
			System.out.println("Record successfully inserted");
			transaction.commit();
			return true;
		} catch (Exception e) {
			try {
				throw new ProductException("Exception While Adding Product Details");
			} catch (ProductException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}

		entityManager.close();
		return false;
	}

	@Override
	public boolean deleteProduct(int productId) {

		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			List<ProductBean> productbean = searchProduct(productId);
			if (!productbean.isEmpty()) {
				EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
				entityManager = entityManagerfactory.createEntityManager();
				transaction = entityManager.getTransaction();
				transaction.begin();
				ProductBean record = entityManager.find(ProductBean.class, productId);
				entityManager.remove(record);
				transaction.commit();
				return true;
			}

			else {
				System.out.println("Product details not found for that given customer id");
				return false;
			}
		} catch (Exception e) {
			try {
				throw new ContractException("Exception While Deleting Product Details");
			} catch (ContractException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}

		entityManager.close();
		return false;
	}

	public List<ProductBean> getAllProducts() {
		try {
			EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
			EntityManager entityManager = entityManagerfactory.createEntityManager();
			String jpql = "from ProductBean";
			Query query = entityManager.createQuery(jpql);
			@SuppressWarnings("unchecked")
			List<ProductBean> record = query.getResultList();
			entityManager.close();

			return record;
		} catch (Exception e) {
			try {
				throw new ProductException("Exception While Viewing All Product Details");
			} catch (ProductException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean updateProduct(int productId, int quantity) {

		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {

			if (productId != 0) {
				entityManagerFactory = Persistence.createEntityManagerFactory("Test");
				entityManager = entityManagerFactory.createEntityManager();
				transaction = entityManager.getTransaction();
				transaction.begin();
				String str = "update ProductBean set quantity=:quantity where productId=:productId";
				Query query = entityManager.createQuery(str);
				ProductBean product = new ProductBean();
				query.setParameter("productId", product.getProductId());// string and object value
				query.setParameter("quantity", product.getProductQuantity());
				int result = query.executeUpdate();
				System.out.println(result);
				transaction.commit();
				return true;
			} else {
				System.out.println("Product details not found for that given product id");
				return false;
			}
		} catch (Exception e) {
			try {
				throw new ProductException("Exception While Updating Product Details");
			} catch (ProductException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}
		entityManager.close();
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ProductBean> searchProduct(int productId) {
		try {
			EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
			EntityManager entityManager = entityManagerfactory.createEntityManager();
			String jpql = "from ProductBean where productId=:productId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("productId", productId);
			@SuppressWarnings("rawtypes")
			List list = query.getResultList();
			return list;
		} catch (Exception e) {
			try {
				throw new ProductException("Exception While Viewing Product Details");
			} catch (ProductException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean searchOneProduct(int productId) throws ProductException {
		try {
			EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
			EntityManager entityManager = entityManagerfactory.createEntityManager();
			String jpql = "from ProductBean where productId=:productId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("productId", productId);
			return true;
		} catch (Exception e) {
			try {
				throw new ProductException("Exception While Viewing Product Details");
			} catch (ProductException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}

}
