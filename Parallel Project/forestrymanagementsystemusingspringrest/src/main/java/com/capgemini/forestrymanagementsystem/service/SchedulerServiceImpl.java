package com.capgemini.forestrymanagementsystem.service;

import java.text.ParseException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.forestrymanagementsystem.dao.ContractDAO;
import com.capgemini.forestrymanagementsystem.dao.SchedulerDAO;
import com.capgemini.forestrymanagementsystem.dto.SchedulerBean;
import com.capgemini.forestrymanagementsystem.exception.SchedulerException;
import com.capgemini.forestrymanagementsystem.util.Validation;
@Service
public class SchedulerServiceImpl implements SchedulerService {
	@Autowired
    private SchedulerDAO dao;
	@Autowired
	private ContractDAO contractDao;
	@Override
	public boolean addSchedule(SchedulerBean schedule) {
		Validation v = new Validation();
		String status = schedule.getStatus();
			if(v.statusValidation(status)) {
				schedule.setStatus(status);
			}else{
				throw new SchedulerException("enter valid status such as active\n proposed\n pending\n");
			}	
			String date = schedule.getDeliveryDate();
			try {
				if(v.dateValidation(date)) {
					schedule.setDeliveryDate(date);
				}else{
					throw new SchedulerException("Enter valid date.. only present and future date allowed");
				}
			} catch (ParseException e) {
				throw new SchedulerException("Enter valid date.. only present and future date allowed");
			}
		 if(contractDao.getContract (schedule.getContractId()) == null){
			   System.out.println("Given id doesn't exists");
		     }
		return dao.addSchedule(schedule);
	}

	@Override
	public boolean deleteSchedule(int scheduleId) {
		
		return dao.deleteSchedule(scheduleId);
	}

	@Override
	public List<SchedulerBean> getAllSchedule() {

		return dao.getAllSchedule();
	}

	@Override
	public boolean modifySchedule(int scheduleId, SchedulerBean schedule) {
		Validation v = new Validation();
		String status = schedule.getStatus();
			if(v.statusValidation(status)) {
				schedule.setStatus(status);
			}else{
				throw new SchedulerException("enter valid status such as active\n proposed\n pending\n");
			}	
			String date = schedule.getDeliveryDate();
			try {
				if(v.dateValidation(date)) {
					schedule.setDeliveryDate(date);
				}else{
					throw new SchedulerException("Enter valid date.. only present and future date allowed");
				}
			} catch (ParseException e) {
				throw new SchedulerException("Enter valid date.. only present and future date allowed");
			}
		return dao.modifySchedule(scheduleId, schedule);
	}

	@Override
	public SchedulerBean getSchedule(int scheduleId) {
		
		return dao.getSchedule(scheduleId);
	}

	@Override
	public boolean searchContractId(int contractId) {
		
		return dao.searchContractId(contractId);
	}

}
