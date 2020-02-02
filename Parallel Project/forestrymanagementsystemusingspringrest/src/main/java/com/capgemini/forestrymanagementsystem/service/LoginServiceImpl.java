package com.capgemini.forestrymanagementsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.forestrymanagementsystem.dao.LoginDAO;
import com.capgemini.forestrymanagementsystem.dto.UserBean;

@Service
public class LoginServiceImpl implements LoginService{
	@Autowired
    private LoginDAO userDao;
	@Override
	public UserBean adminLogin(String adminEmail, String adminPassword) {
		
		return userDao.adminLogin(adminEmail, adminPassword);
	}

	@Override
	public UserBean clientLogin(String clientEmail, String clientPassword) {
		
		return userDao.clientLogin(clientEmail, clientPassword);
	}
	@Override
	public UserBean schedulerLogin(String schedulerEmail, String schedulerPassword) {
		
		return userDao.schedulerLogin(schedulerEmail, schedulerPassword);
	}

}
