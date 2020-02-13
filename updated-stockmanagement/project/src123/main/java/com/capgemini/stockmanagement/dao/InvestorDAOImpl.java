package com.capgemini.stockmanagement.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;

import com.capgemini.stockmanagement.dto.Company;
import com.capgemini.stockmanagement.dto.InvestorRequestObject;
import com.capgemini.stockmanagement.dto.Investor_Share;

@Repository
public class InvestorDAOImpl implements InvestorDAO {

	@PersistenceUnit
	EntityManagerFactory factory;

	@Override
	public boolean addShare(InvestorRequestObject investor) {
		boolean isAdded = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		Investor_Share record = new Investor_Share();
		System.out.println(record);
		record.setCompanyId(investor.getCompanyId());
		record.setUserId(investor.getUserId());
		record.setAvailableAmount(investor.getTotalAmount());
		record.setTotalSharesBought(investor.getTotalSharesTransacted());
		record.setTotalAmountBought(investor.getTotalAmount());
		record.setAvailableShares(investor.getTotalSharesTransacted());
		record.setTotalSharesSold(0);
		record.setTotalAmountSold(0);
		
		try {
			transaction.begin();
			manager.persist(record);
			transaction.commit();
			isAdded = true;
			updateStockAvailability(investor, true);
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
		}
		return isAdded;
	}

	@Override
	public boolean buyShare(InvestorRequestObject investor) {

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			String jpql = "from Investor_Share where userId=:userId and companyId=:companyId ";
			TypedQuery<Investor_Share> query = manager.createQuery(jpql, Investor_Share.class);
			query.setParameter("userId", investor.getUserId());
			query.setParameter("companyId", investor.getCompanyId());
			List<Investor_Share> bean = query.getResultList();
			if (!bean.isEmpty()) {
				return updateShare(bean.get(0), investor);
			} else {
				return addShare(investor);
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
			return false;
		} finally {
			manager.close();
		}
		// return isUpdated;
	}

	public boolean updateShare(Investor_Share bean, InvestorRequestObject investor) {
		boolean isUpdated = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			transaction.begin();
			bean.setTotalAmountBought(bean.getTotalAmountBought() + investor.getTotalAmount());
			bean.setTotalSharesBought(bean.getTotalSharesBought() + investor.getTotalSharesTransacted());
			bean.setAvailableAmount(bean.getAvailableAmount() + investor.getTotalAmount());
			bean.setAvailableShares(bean.getAvailableShares() + investor.getTotalSharesTransacted());
			transaction.commit();
			updateStockAvailability(investor, true);
			isUpdated = true;
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}
		return isUpdated;
	}

	public boolean sellShare(InvestorRequestObject investor) {
		boolean isUpdated = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			Investor_Share bean = manager.find(Investor_Share.class, investor.getUserId());
			if (bean != null) {
				transaction.begin();
				bean.setAvailableAmount(bean.getAvailableAmount() - investor.getTotalAmount());
				bean.setAvailableShares(bean.getAvailableShares() - investor.getTotalSharesTransacted());
				bean.setTotalSharesSold(bean.getTotalSharesSold() + investor.getTotalSharesTransacted());
				bean.setTotalAmountSold(bean.getTotalAmountSold() + investor.getTotalAmount());
				transaction.commit();
				updateStockAvailability(investor, false);
				isUpdated = true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
		}
		return isUpdated;
	}

	@Override
	public boolean updateStockAvailability(InvestorRequestObject investor, boolean flag) {
		boolean isUpdated = false;
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			Company bean = manager.find(Company.class, investor.getCompanyId());
			System.out.println(bean.getCompanyId());
			if (bean != null) {
				transaction.begin();
				if (flag) {
					bean.setStockAvailability(bean.getStockAvailability() - investor.getTotalSharesTransacted());
				} else {
					bean.setStockAvailability(bean.getStockAvailability() + investor.getTotalSharesTransacted());
				}
				transaction.commit();
				isUpdated = true;
			}
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
		}
		return isUpdated;
	}

	@Override
	public List<Investor_Share> getAllInvestors(int userId) {

		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		try {
			String jpql = "from Investor_Share where userId=:userId";
			TypedQuery<Investor_Share> record = manager.createQuery(jpql, Investor_Share.class);
			record.setParameter("userId", userId);

			List<Investor_Share> bean = record.getResultList();
			return bean;
		} catch (Exception e) {
			System.err.println(e.getMessage());
			transaction.rollback();
		} finally {
			manager.close();
		}
		return null;

	}

}
