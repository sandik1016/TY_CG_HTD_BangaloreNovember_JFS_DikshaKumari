package com.capgemini.forestrymanagementsystem.dao;

import java.util.List;



import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.springframework.stereotype.Repository;
import com.capgemini.forestrymanagementsystem.dto.SchedulerBean;
import com.capgemini.forestrymanagementsystem.exception.SchedulerException;
@Repository
public class SchedulerDAOImpl implements SchedulerDAO{
	@PersistenceUnit
	private EntityManagerFactory factory;

	@Override
	public boolean addSchedule(SchedulerBean schedule) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			manager.persist(schedule);
			transaction.commit();
			return true;
		} catch (Exception e) {
			throw new SchedulerException("scheduled id already exists");
		}
	
	}

	@Override
	public boolean deleteSchedule(int scheduleId) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		SchedulerBean bean = manager.find(SchedulerBean.class, scheduleId);
		if (bean != null) {
			manager.remove(bean);
			transaction.commit();
			return true;
		}
		throw new SchedulerException("Schedule Id not found");
	}

	@Override
	public List<SchedulerBean> getAllSchedule() {
		String jpql = "from SchedulerBean";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<SchedulerBean> query = manager.createQuery(jpql, SchedulerBean.class);
		if (query != null)
			return query.getResultList();
		throw new SchedulerException("Sorry!No Records Found");
	}

	@Override
	public boolean modifySchedule(int scheduleId, SchedulerBean schedule) {
		EntityManager manager = factory.createEntityManager();
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		SchedulerBean bean1 = manager.find(SchedulerBean.class,scheduleId);
		if (bean1 != null) {
			bean1.setContractId(schedule.getContractId());
			bean1.setStatus(schedule.getStatus());
			bean1.setScheduleId(schedule.getScheduleId());
			bean1.setDeliveryDate(schedule.getDeliveryDate());
			transaction.commit();
			return true;
		}
		throw new SchedulerException("Unable to retrieve provided schedule id");
	}

	@Override
	public SchedulerBean getSchedule(int scheduleId) {
		String jpql = "from  SchedulerBean where scheduleId=:scheduleId";
		EntityManager manager = factory.createEntityManager();
		TypedQuery<SchedulerBean> query = manager.createQuery(jpql,SchedulerBean.class);
		query.setParameter("scheduleId",scheduleId);
		try {
			return query.getSingleResult();
		} catch (Exception e) {
				throw new SchedulerException("schedule id not found");
			}
}

	@Override
	public boolean searchContractId(int contractId) {
		try {
			
			EntityManager entityManager = factory.createEntityManager();
			String jpql = "from ContractBean where contractId=:contractId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("contractId",contractId);
			return true;
		} catch(Exception e) {
			System.out.println(e.getMessage());
		}
		return false;
	}
}
