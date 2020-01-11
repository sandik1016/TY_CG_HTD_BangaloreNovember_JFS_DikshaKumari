package com.capgemini.retailermaintenancesystemapplicationdevelopment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.dao.UserDAO;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.UserBean;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDAO userDao;

	@Override
	public boolean registerUser(UserBean userBean) {

		return userDao.registerUser(userBean);
	}

	@Override
	public UserBean authentication(String email, String password) {

		return userDao.authentication(email, password);
	}

	@Override
	public boolean changePassword(String userEmail, String password) {

		return userDao.changePassword(userEmail, password);
	}

}
