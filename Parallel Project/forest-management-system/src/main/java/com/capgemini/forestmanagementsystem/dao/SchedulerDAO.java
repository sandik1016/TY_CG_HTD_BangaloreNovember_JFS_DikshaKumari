package com.capgemini.forestmanagementsystem.dao;

import java.util.List;

import com.capgemini.forestmanagementsystem.bean.SchedulerBean;
import com.capgemini.forestmanagementsystem.exception.ContractException;
import com.capgemini.forestmanagementsystem.exception.SchedulerException;

public interface SchedulerDAO {
	public boolean deleteSchedule(int scheduleId)throws SchedulerException;	
	public boolean addSchedule(SchedulerBean scheduler);
	public boolean updateScheduleDate(int scheduleId,String deliveryDate)throws SchedulerException;;
	public boolean updateSchedule(int scheduleId,int contractId)throws SchedulerException;;
	
	public List<SchedulerBean> getAllSchedules();
	public List<SchedulerBean> searchSchedule(int schedulerId);
	public boolean searchContractId(int contractId)throws ContractException;


}
