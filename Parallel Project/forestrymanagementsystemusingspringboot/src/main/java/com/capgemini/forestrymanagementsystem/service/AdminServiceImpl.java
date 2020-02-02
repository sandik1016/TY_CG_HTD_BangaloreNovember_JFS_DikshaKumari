package com.capgemini.forestrymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.capgemini.forestrymanagementsystem.dao.AdminDAO;
import com.capgemini.forestrymanagementsystem.dto.UserBean;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
    private AdminDAO userDao;
	
	@Override
	public boolean clientRegister(UserBean clientBean) {
		
		return userDao.clientRegister(clientBean);
	}

	@Override
	public boolean schedulerRegister(UserBean schedulerBean) {
		
		return userDao.schedulerRegister(schedulerBean);
	}

	@Override
	public boolean removeClient(String clientEmail) {
		
		return userDao.removeClient(clientEmail);
	}

	@Override
	public List<UserBean> showClients() {
		
		return userDao.showClients();
	}

	@Override
	public boolean removeScheduler(String schedulerEmail) {
		
		return userDao.removeScheduler(schedulerEmail);
	}

	@Override
	public List<UserBean> showScheduler() {
		
		return userDao.showScheduler();
	}

	@Override
	public boolean changePassword(String email, String password) {
		
		return userDao.changePassword(email, password);
	}

}
