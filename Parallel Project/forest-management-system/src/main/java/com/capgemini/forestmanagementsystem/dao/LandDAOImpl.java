package com.capgemini.forestmanagementsystem.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.capgemini.forestmanagementsystem.bean.LandBean;
import com.capgemini.forestmanagementsystem.exception.ContractException;
import com.capgemini.forestmanagementsystem.exception.LandException;

public class LandDAOImpl implements LandDAO {

	@Override
	public boolean deleteLandDetails(int landId) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			List<LandBean> landbean = searchLandDetails(landId);
			if (!landbean.isEmpty()) {
				EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
				entityManager = entityManagerfactory.createEntityManager();
				transaction = entityManager.getTransaction();
				transaction.begin();
				LandBean record = entityManager.find(LandBean.class, landId);
				entityManager.remove(record);
				transaction.commit();
				return true;
			}

			else {
				System.out.println("Land details not found for that given land id");
				return false;
			}
		} catch (Exception e) {
			try {
				throw new LandException("Exception While Deleting Land Details");
			} catch (LandException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}

		entityManager.close();
		return false;
	}

	@Override
	public boolean addLandDetails(LandBean land) {
		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		try {
			EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
			entityManager = entityManagerfactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(land);
			System.out.println("Record successfully inserted");
			transaction.commit();
			return true;
		} catch (Exception e) {
			try {
				throw new LandException("Exception While Adding Land Details");
			} catch (LandException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}

		entityManager.close();
		return false;

	}

	@Override
	public List<LandBean> getAllLandDetails() {
		try {
			EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
			EntityManager entityManager = entityManagerfactory.createEntityManager();
			String jpql = "from LandBean";
			Query query = entityManager.createQuery(jpql);
			@SuppressWarnings("unchecked")
			List<LandBean> record = query.getResultList();
			entityManager.close();

			return record;
		} catch (Exception e) {
			try {
				throw new LandException("Exception While Viewing All Land Details");
			} catch (LandException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean updateLandDetails(int landId, int landValue) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {

			if (landId != 0) {
				entityManagerFactory = Persistence.createEntityManagerFactory("Test");
				entityManager = entityManagerFactory.createEntityManager();
				transaction = entityManager.getTransaction();
				transaction.begin();
				String str = "update LandBean set landValue=:landValue where landId=:landId";
				Query query = entityManager.createQuery(str);
				LandBean land = new LandBean();
				query.setParameter("landId", land.getLandId());
				query.setParameter("landValue", land.getLandCost());
				int result = query.executeUpdate();
				System.out.println(result);
				transaction.commit();
				return true;
			} else {
				System.out.println("land details not found for that given land id");
				return false;
			}
		} catch (Exception e) {
			try {
				throw new ContractException("Exception While Updating Land Details");
			} catch (ContractException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}
		entityManager.close();
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<LandBean> searchLandDetails(int landId) {
		try {
			EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
			EntityManager entityManager = entityManagerfactory.createEntityManager();
			String jpql = "from LandBean where landId=:landId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("landId", landId);
			@SuppressWarnings("rawtypes")
			List list = query.getResultList();
			return list;
		} catch (Exception e) {
			try {
				throw new LandException("Exception While Viewing Land Details");
			} catch (LandException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}
}
