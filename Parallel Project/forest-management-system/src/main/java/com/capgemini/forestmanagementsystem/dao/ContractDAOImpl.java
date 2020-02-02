package com.capgemini.forestmanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.capgemini.forestmanagementsystem.bean.ContractBean;
import com.capgemini.forestmanagementsystem.exception.ContractException;
import com.capgemini.forestmanagementsystem.exception.CustomerException;
import com.capgemini.forestmanagementsystem.exception.ProductException;

public class ContractDAOImpl implements ContractDAO {

	public boolean addContract(ContractBean contract) {
		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
		try {
			entityManager = entityManagerfactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(contract);
			System.out.println("Record successfully inserted");
			transaction.commit();
			return true;
		} catch (Exception e) {
			try {
				throw new ContractException("Exception While Adding contract Details");
			} catch (ContractException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}

		entityManager.close();
		return false;
	}

	@Override
	public boolean deleteContract(int contractId) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			List<ContractBean> contractbean = searchContract(contractId);
			if (!contractbean.isEmpty()) {
				EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
				entityManager = entityManagerfactory.createEntityManager();
				transaction = entityManager.getTransaction();
				transaction.begin();
				ContractBean record = entityManager.find(ContractBean.class, contractId);
				entityManager.remove(record);
				transaction.commit();
				return true;
			} else {
				System.out.println("Contract details not found for that given customer id");
				return false;
			}
		} catch (Exception e) {
			try {
				throw new ContractException("Exception While Adding Contract Details");
			} catch (ContractException e1) {
				System.out.println("e.getMessage()");
			}
			transaction.rollback();
		}

		entityManager.close();
		return false;
	}

	@Override
	public List<ContractBean> getAllContract() {
		try {
			EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
			EntityManager entityManager = entityManagerfactory.createEntityManager();
			String jpql = "from ContractBean";
			Query query = entityManager.createQuery(jpql);
			@SuppressWarnings("unchecked")
			List<ContractBean> record = query.getResultList();
			entityManager.close();
			return record;
		} catch (Exception e) {
			try {
				throw new ContractException("Exception While Viewing All Contract Details");
			} catch (ContractException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	public boolean updateProductId(int contractId, int productId) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {

			if (contractId != 0) {
				entityManagerFactory = Persistence.createEntityManagerFactory("Test");
				entityManager = entityManagerFactory.createEntityManager();
				transaction = entityManager.getTransaction();
				transaction.begin();
				String str = "update ContractBean set productId=:productId where contractId=:contractId";
				Query query = entityManager.createQuery(str);
				ContractBean contract = new ContractBean();
				query.setParameter("contractId", contract.getContractId());// string and object value
				query.setParameter("productId", contract.getProductId());
				int result = query.executeUpdate();
				System.out.println(result);
				transaction.commit();
				return true;
			} else {
				System.out.println("Contract details not found for that given contract id");
				return false;
			}
		} catch (Exception e) {
			try {
				throw new ContractException("Exception While Adding Contract Details");
			} catch (ContractException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}
		entityManager.close();
		return false;
	}

	public boolean updateDeliveryDate(int contractId, String deliveryDate) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {

			if (contractId != 0) {
				entityManagerFactory = Persistence.createEntityManagerFactory("Test");
				entityManager = entityManagerFactory.createEntityManager();
				transaction = entityManager.getTransaction();
				transaction.begin();
				String str = "update ContractBean set deliveryDate=:deliveryDate where contractId=:contractId";
				Query query = entityManager.createQuery(str);
				ContractBean contract = new ContractBean();
				query.setParameter("contractId", contract.getContractId());// string and object value
				query.setParameter("deliveryDate", contract.getDeliveryDate());
				int result = query.executeUpdate();
				System.out.println(result);
				transaction.commit();
				return true;
			} else {
				System.out.println("Contract details not found for that given contract id");
				return false;
			}
		} catch (Exception e) {
			try {
				throw new ContractException("Exception While Updating Contract Details");
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
	public List<ContractBean> searchContract(int contractId) {

		try {
			EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
			EntityManager entityManager = entityManagerfactory.createEntityManager();
			String jpql = "from ContractBean where contractId=:contractId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("contractId", contractId);
			@SuppressWarnings("rawtypes")
			List list = query.getResultList();
			return list;
		} catch (Exception e) {
			try {
				throw new ContractException("Exception While Viewing Contract Details");
			} catch (ContractException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean updateCustomerId(int contractId, int customerId) throws CustomerException {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {

			if (contractId != 0) {
				entityManagerFactory = Persistence.createEntityManagerFactory("Test");
				entityManager = entityManagerFactory.createEntityManager();
				transaction = entityManager.getTransaction();
				transaction.begin();
				String str = "update ContractBean set customerId=:customerId where contractId=:contractId";
				Query query = entityManager.createQuery(str);
				ContractBean contract = new ContractBean();
				query.setParameter("contractId", contract.getContractId());// string and object value
				query.setParameter("customerId", contract.getCustomerId());
				int result = query.executeUpdate();
				System.out.println(result);
				transaction.commit();
				return true;
			} else {
				System.out.println("Contract details not found for that given contract id");
				return false;
			}
		} catch (Exception e) {
			try {
				throw new ContractException("Exception While Updating Contract Details");
			} catch (ContractException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}
		entityManager.close();
		return false;
	}

	@Override
	public boolean updateQuantity(int contractId, int quantity) throws ContractException {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {

			if (contractId != 0) {
				entityManagerFactory = Persistence.createEntityManagerFactory("Test");
				entityManager = entityManagerFactory.createEntityManager();
				transaction = entityManager.getTransaction();
				transaction.begin();
				String str = "update ContractBean set quantity=:quantity where contractId=:contractId";
				Query query = entityManager.createQuery(str);
				ContractBean contract = new ContractBean();
				query.setParameter("contractId", contract.getContractId());// string and object value
				query.setParameter("quantity", contract.getQuantity());
				int result = query.executeUpdate();
				System.out.println(result);
				transaction.commit();
				return true;
			} else {
				System.out.println("Contract details not found for that given contract id");
				return false;
			}
		} catch (Exception e) {
			try {
				throw new ContractException("Exception While Updating Contract Details");
			} catch (ContractException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}
		entityManager.close();
		return false;
	}

	@Override
	public boolean searchCustomerId(int customerId) throws CustomerException {

		try {
			EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
			EntityManager entityManager = entityManagerfactory.createEntityManager();
			String jpql = "from CustomerBean where customerId=:customerId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("customerId", customerId);
			return true;
		} catch (Exception e) {
			try {
				throw new CustomerException("Exception While Viewing Customer Details");
			} catch (CustomerException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean searchProductId(int productId) throws ProductException {
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
