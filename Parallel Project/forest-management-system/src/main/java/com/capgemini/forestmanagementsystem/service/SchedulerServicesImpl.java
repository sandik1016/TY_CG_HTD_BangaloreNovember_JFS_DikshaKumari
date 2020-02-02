package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.Factory.Factory;
import com.capgemini.forestmanagementsystem.bean.SchedulerBean;
import com.capgemini.forestmanagementsystem.dao.SchedulerDAO;
import com.capgemini.forestmanagementsystem.exception.ContractException;
import com.capgemini.forestmanagementsystem.exception.SchedulerException;

public class SchedulerServicesImpl implements SchedulerServices{
	SchedulerDAO dao = Factory.schedulerDAOInstance();

	@Override
	public boolean deleteSchedule(int scheduleId) throws SchedulerException {
		
		return dao.deleteSchedule(scheduleId);
	}

	@Override
	public boolean addSchedule(SchedulerBean sch) {
		
		return dao.addSchedule(sch);
	}

	@Override
	public List<SchedulerBean> getAllSchedules() {
		
		return dao.getAllSchedules();
	}

	@Override
	public boolean updateSchedule(int scheduleId,int contractId) throws SchedulerException {
		
		return dao.updateSchedule(scheduleId,contractId);
	}

	@Override
	public boolean updateScheduleDate(int scheduleId, String date) throws SchedulerException {
		
		return dao.updateScheduleDate(scheduleId, date);
	}

	@Override
	public List<SchedulerBean> searchSchedule(int schedulerId) {
		
		return dao.searchSchedule(schedulerId);
	}

	@Override
	public boolean searchContractId(int contractId) throws ContractException {
		
		return dao.searchContractId(contractId);
	}
}
