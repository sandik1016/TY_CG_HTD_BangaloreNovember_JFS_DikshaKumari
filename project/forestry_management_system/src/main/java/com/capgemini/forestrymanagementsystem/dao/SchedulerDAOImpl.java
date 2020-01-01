package com.capgemini.forestrymanagementsystem.dao;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

import com.capgemini.forestrymanagementsystem.bean.CustomerBean;
import com.capgemini.forestrymanagementsystem.bean.SchedulerBean;
import com.capgemini.forestrymanagementsystem.exception.ProductIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.SchedulerIdNotFoundException;

public class SchedulerDAOImpl implements SchedulerDAO{
	Set<SchedulerBean> s;
	@Override
	public boolean deleteSchedule(int sid, Map<Integer, Set<SchedulerBean>> scheduleBean)
			throws SchedulerIdNotFoundException {
		if(sid < 0)
		{
			throw new SchedulerIdNotFoundException(" inserted id is invalid");
		}else {
		Set<Map.Entry<Integer,Set<SchedulerBean>>> s1 = scheduleBean.entrySet();
		for(Map.Entry<Integer,Set<SchedulerBean>> e1:s1) {
			if(e1.getKey()==sid) {

				return true;
			}
		}
		}
		return false;

	}

	@Override
	public boolean addSchedule(SchedulerBean schedule) {
		s= new HashSet<SchedulerBean>();
		s.add(schedule);
		return true;
		
	}

	@Override
	public boolean searchSchedule(int sid, Map<Integer, Set<SchedulerBean>> scheduleBean)
			throws SchedulerIdNotFoundException {
		if(sid < 0)
		{
			throw new SchedulerIdNotFoundException(" inserted id is invalid");
		}else {
		Set<Map.Entry<Integer,Set<SchedulerBean>>> s1 = scheduleBean.entrySet();
		for(Map.Entry<Integer,Set<SchedulerBean>> e1:s1) {
			if(e1.getKey()==sid) {

				return true;
			}
		}
		}
		return false;

		
	}

	@Override
	public Set<SchedulerBean> getAllSchedule() {
		return s; 
	}

	@Override
	public boolean updateSchedule(int sid, Map<Integer, Set<SchedulerBean>> scheduleBean)
			throws SchedulerIdNotFoundException {
		if(sid < 0)
		{
			throw new SchedulerIdNotFoundException(" inserted id is invalid");
		}else {
		Set<Map.Entry<Integer,Set<SchedulerBean>>> s1 = scheduleBean.entrySet();
		for(Map.Entry<Integer,Set<SchedulerBean>> e1:s1) {
			if(e1.getKey()==sid) {

				return true;
			
			}}
		}
		return false;
	}

}
