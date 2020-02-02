package com.capgemini.forestrymanagementsystem.dao;

import java.util.List;


import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.forestrymanagementsystem.dto.LandBean;
import com.capgemini.forestrymanagementsystem.exception.LandException;

@Repository
public class LandDAOImpl implements LandDAO{
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public boolean addLand(LandBean land) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(land);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new LandException("land account already exists");
		}
	}

	@Override
	public boolean deleteLand(int landId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		LandBean bean = manager.find(LandBean.class,landId);
		if (bean != null) {
			manager.remove(bean);
			transaction.commit();
			return true;
		}
		throw new LandException("Land Id not found");
	}

	@Override
	public List<LandBean> getAllLand() {
		String jpql = "from LandBean";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<LandBean> query = manager.createQuery(jpql, LandBean.class);
		if (query != null)
			return query.getResultList();
		throw new LandException("Sorry!No Records Found");
	}

	@Override
	public boolean modifyLand(int landId, LandBean land) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		LandBean bean1 = manager.find(LandBean.class,landId);
		if (bean1 != null) {
			bean1.setLandCost(land.getLandCost());
			bean1.setLandId(land.getLandId());
			bean1.setLandLocation(land.getLandLocation());
			bean1.setAcquiredDate(land.getAcquiredDate());
			transaction.commit();
			return true;
		}
		throw new LandException("Unable to retrieve provided land id");
	}

	@Override
	public LandBean getLand(int landId) {
		String jpql = "from LandBean where landId=:landId";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<LandBean> query = manager.createQuery(jpql,LandBean.class);
		query.setParameter("landId",landId);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
				throw new LandException("land not found");
			}
	}

}
