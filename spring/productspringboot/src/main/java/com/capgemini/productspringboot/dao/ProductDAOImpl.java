package com.capgemini.productspringboot.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.productspringboot.dto.ProductBean;
import com.capgemini.productspringboot.exception.ProductException;
@Repository
public class ProductDAOImpl implements ProductDAO
{
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public boolean addProduct(ProductBean bean) {
		
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		ProductBean productBean = new ProductBean();
		
		productBean.setId(bean.getId());
		productBean.setCost(bean.getCost());
		productBean.setImageUrl(bean.getImageUrl());
		productBean.setName(bean.getName());
	
		transaction.begin();
		try {
			manager.persist(productBean);
			transaction.commit();
			return true;
		} catch (Exception e) {
			
			e.printStackTrace();
			throw new ProductException("product already exists");
		}
	}

	@Override
	public ProductBean getProduct(int id) {
		String jpql = "from ProductBean where id=:id";
	    EntityManager manager=factory.createEntityManager();
		TypedQuery<ProductBean> query = manager.createQuery(jpql,ProductBean.class);
		query.setParameter("id", id);
		try {
		return query.getSingleResult();
	} catch (Exception e) {
			
			e.printStackTrace();
			throw new ProductException("product not found");
		}
	}

	@Override
	public List<ProductBean> getAllProduct() {
		String jpql = "from ProductBean";
		EntityManager manager=factory.createEntityManager();
		TypedQuery<ProductBean> query = manager.createQuery(jpql,ProductBean.class);
		return query.getResultList();
	}

	@Override
	public boolean updateProduct(int id, ProductBean bean) {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		transaction.begin();
		ProductBean bean1 = manager.find(ProductBean.class, id);
		bean1.setCost(bean.getCost());
		bean1.setName(bean.getName());
		bean1.setImageUrl(bean.getImageUrl());
		transaction.commit();
		return true;
	}

	@Override
	public boolean deleteProduct(int id) throws ProductException {
		EntityManager manager=factory.createEntityManager();
		EntityTransaction transaction =manager.getTransaction();
		transaction.begin();
		ProductBean bean = manager.find(ProductBean.class, id);
		if(bean!=null) {
			manager.remove(bean);
			transaction.commit();
			return true;
		}
		throw new ProductException("product not found");
	}

}
