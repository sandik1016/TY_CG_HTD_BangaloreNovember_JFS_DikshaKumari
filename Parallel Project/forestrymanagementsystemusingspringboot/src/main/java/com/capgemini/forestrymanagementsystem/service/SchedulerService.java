package com.capgemini.forestrymanagementsystem.service;

import java.util.List;

import com.capgemini.forestrymanagementsystem.dto.SchedulerBean;

public interface SchedulerService {
	public boolean addSchedule(SchedulerBean schedule);
	public boolean deleteSchedule(int scheduleId);
	public List<SchedulerBean> getAllSchedule();
	public boolean modifySchedule(int scheduleId,SchedulerBean schedule);
	public SchedulerBean getSchedule(int scheduleId);
	public boolean searchContractId(int contractId);
}
