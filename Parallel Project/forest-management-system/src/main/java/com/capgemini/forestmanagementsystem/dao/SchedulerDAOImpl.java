package com.capgemini.forestmanagementsystem.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import com.capgemini.forestmanagementsystem.bean.SchedulerBean;
import com.capgemini.forestmanagementsystem.exception.ContractException;
import com.capgemini.forestmanagementsystem.exception.SchedulerException;

public class SchedulerDAOImpl implements SchedulerDAO {

	@Override
	public boolean deleteSchedule(int scheduleId) {
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {
			List<SchedulerBean> contractbean = searchSchedule(scheduleId);
			if (!contractbean.isEmpty()) {
				EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
				entityManager = entityManagerfactory.createEntityManager();
				transaction = entityManager.getTransaction();
				transaction.begin();
				SchedulerBean record = entityManager.find(SchedulerBean.class, scheduleId);
				entityManager.remove(record);
				transaction.commit();
				return true;
			}

			else {
				System.out.println("Scheduler details not found for that given scheduler id");
				return false;
			}
		} catch (Exception e) {
			try {
				throw new SchedulerException("Exception While Deleting Details");
			} catch (SchedulerException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}

		entityManager.close();
		return false;
	}

	@Override
	public boolean addSchedule(SchedulerBean schedule) {
		EntityTransaction transaction = null;
		EntityManager entityManager = null;
		try {
			EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
			entityManager = entityManagerfactory.createEntityManager();
			transaction = entityManager.getTransaction();
			transaction.begin();
			entityManager.persist(schedule);
			System.out.println("Record successfully inserted");
			transaction.commit();
			return true;
		} catch (Exception e) {
			try {
				throw new SchedulerException("Exception While Adding schedule Details");
			} catch (SchedulerException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}

		entityManager.close();
		return false;
	}

	@Override
	public List<SchedulerBean> getAllSchedules() {
		try {
			EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
			EntityManager entityManager = entityManagerfactory.createEntityManager();
			String jpql = "from SchedulerBean";
			Query query = entityManager.createQuery(jpql);
			@SuppressWarnings("unchecked")
			List<SchedulerBean> record = query.getResultList();
			entityManager.close();
			return record;
		} catch (Exception e) {
			try {
				throw new SchedulerException("Exception While Viewing All Schedule Details");
			} catch (SchedulerException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean updateScheduleDate(int scheduleId, String deliveryDate) {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {

			if (scheduleId != 0) {
				entityManagerFactory = Persistence.createEntityManagerFactory("Test");
				entityManager = entityManagerFactory.createEntityManager();
				transaction = entityManager.getTransaction();
				transaction.begin();
				String str = "update SchedulerBean set deliveryDate=:deliveryDate where scheduleId=:scheduleId";
				Query query = entityManager.createQuery(str);
				SchedulerBean schedule = new SchedulerBean();
				query.setParameter("scheduleId", schedule.getScheduleId());// string and object value
				query.setParameter("deliveryDate", schedule.getDeliveryDate());
				int result = query.executeUpdate();
				System.out.println(result);
				transaction.commit();
				return true;
			} else {
				System.out.println("Scheduler details not found for that given schedule id");
				return false;
			}
		} catch (Exception e) {
			try {
				throw new SchedulerException("Exception While Updating Schedule Details");
			} catch (SchedulerException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}
		entityManager.close();
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<SchedulerBean> searchSchedule(int schedulerId) {

		try {
			EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
			EntityManager entityManager = entityManagerfactory.createEntityManager();
			String jpql = "from SchedulerBean where scheduleId=:scheduleId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("scheduleId", schedulerId);
			@SuppressWarnings("rawtypes")
			List list = query.getResultList();
			return list;
		} catch (Exception e) {
			try {
				throw new SchedulerException("Exception While Viewing Scheduler Details");
			} catch (SchedulerException e1) {
				e1.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean updateSchedule(int scheduleId, int contractId) throws SchedulerException {
		EntityManagerFactory entityManagerFactory = null;
		EntityManager entityManager = null;
		EntityTransaction transaction = null;
		try {

			if (scheduleId != 0) {
				entityManagerFactory = Persistence.createEntityManagerFactory("Test");
				entityManager = entityManagerFactory.createEntityManager();
				transaction = entityManager.getTransaction();
				transaction.begin();
				String str = "update SchedulerBean set quantity=:quantity where scheduleId=:scheduleId";
				Query query = entityManager.createQuery(str);
				SchedulerBean schedule = new SchedulerBean();
				query.setParameter("scheduleId", schedule.getScheduleId());// string and object value
				query.setParameter("contractId", schedule.getContractId());
				int result = query.executeUpdate();
				System.out.println(result);
				transaction.commit();
				return true;
			} else {
				System.out.println("Scheduler details not found for that given schedule id");
				return false;
			}
		} catch (Exception e) {
			try {
				throw new SchedulerException("Exception While Updating scheduler Details");
			} catch (SchedulerException e1) {
				e1.printStackTrace();
			}
			transaction.rollback();
		}
		entityManager.close();
		return false;
	}

	@Override
	public boolean searchContractId(int contractId) throws ContractException {
		try {
			EntityManagerFactory entityManagerfactory = Persistence.createEntityManagerFactory("Test");
			EntityManager entityManager = entityManagerfactory.createEntityManager();
			String jpql = "from ContractBean where contractId=:contractId";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("contractId", contractId);
			return true;
		} catch (Exception e) {
			try {
				throw new ContractException("Exception While Viewing Contract Details");
			} catch (ContractException e1) {
				e1.printStackTrace();
			}
		}
		return false;
	}

}
