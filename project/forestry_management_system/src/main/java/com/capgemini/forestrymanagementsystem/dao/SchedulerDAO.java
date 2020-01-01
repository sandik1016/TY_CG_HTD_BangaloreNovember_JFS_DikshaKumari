
package com.capgemini.forestrymanagementsystem.dao;

import java.util.Map;
import java.util.Set;

import com.capgemini.forestrymanagementsystem.bean.ContractBean;
import com.capgemini.forestrymanagementsystem.bean.SchedulerBean;
import com.capgemini.forestrymanagementsystem.exception.ContractIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.SchedulerIdNotFoundException;

public interface SchedulerDAO {
	public boolean deleteSchedule(int sid, Map<Integer,Set<SchedulerBean>> scheduleBean)throws SchedulerIdNotFoundException;
	public boolean addSchedule(SchedulerBean schedule);
	public boolean searchSchedule(int sid, Map<Integer,Set<SchedulerBean>> scheduleBean) throws SchedulerIdNotFoundException;
	public Set<SchedulerBean> getAllSchedule();
	public boolean updateSchedule(int sid, Map<Integer,Set<SchedulerBean>> scheduleBean) throws SchedulerIdNotFoundException;
}
