package com.capgemini.forestrymanagementsystem.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.forestrymanagementsystem.dto.ContractBean;
import com.capgemini.forestrymanagementsystem.exception.ContractException;


@Repository
public class ContractDAOImpl implements ContractDAO{
	@PersistenceUnit
	private EntityManagerFactory factory;
	@Override
	public boolean addContract(ContractBean contract) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(contract);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new ContractException("contract details already exists");
		}
	}

	@Override
	public boolean deleteContract(int contractId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		ContractBean bean = manager.find(ContractBean.class, contractId);
		if (bean != null) {
			manager.remove(bean);
			transaction.commit();
			return true;
		}
		throw new ContractException("Contract Id not found");
	}

	@Override
	public List<ContractBean> getAllContract() {
		String jpql = "from ContractBean";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<ContractBean> query = manager.createQuery(jpql, ContractBean.class);
		if (query != null)
			return query.getResultList();
		throw new ContractException("Sorry!No Records Found");
	}

	@Override
	public boolean modifyContract(int contractId, ContractBean contract) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		ContractBean bean1 = manager.find(ContractBean.class,contractId);
		if (bean1 != null) {
			bean1.setContractId(contract.getContractId());
			bean1.setCustomerId(contract.getCustomerId());
			bean1.setProductId(contract.getProductId());
			bean1.setQuantity(contract.getQuantity());
			bean1.setDeliveryDate(contract.getDeliveryDate());
			transaction.commit();
			return true;
		}
		throw new ContractException("Unable to retrieve provided contract id");
	}


	@Override
	public ContractBean getContract(int contractId) {
		String jpql = "from ContractBean where contractId=:contractId";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<ContractBean> query = manager.createQuery(jpql, ContractBean.class);
		query.setParameter("contractId", contractId);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
				throw new ContractException("contract id not found");
			}
	}

	@Override
	public boolean searchCustomerId(int customerId) {
		try {
			
			EntityManager entityManager = factory.createEntityManager();
			String jpql = "from CustomerBean where customerId=:customerId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("customerId", customerId);
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean searchProductId(int productId) {
		try {
		
			EntityManager entityManager = factory.createEntityManager();
			String jpql = "from ProductBean where productId=:productId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("productId",productId);
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

}
