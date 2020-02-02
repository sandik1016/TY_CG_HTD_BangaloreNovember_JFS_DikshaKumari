
package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.Factory.Factory;
import com.capgemini.forestmanagementsystem.bean.UserBean;
import com.capgemini.forestmanagementsystem.dao.UserDAO;

public class UserServicesImpl implements UserServices {
	UserDAO userDAO = Factory.userDAOInstance();

	@Override
	public boolean addUser(UserBean user) {
		
		return userDAO.addUser(user);
	}

	@Override
	public boolean removeUser(String email) {

		return userDAO.removeUser(email);
	}

	@Override
	public List<UserBean> showUser() {
		
		return userDAO.showUser();
	}

	@Override
	public boolean authenticate(String email, String password) {
	
		return userDAO.authenticate(email, password);
	}

	@Override
	public boolean searchUserType(String role) {
		
		return userDAO.searchUserType(role);
	}

	@Override
	public boolean authenticateClient(String email, String password) {
		
		return userDAO.authenticateClient(email, password);
	}

	@Override
	public boolean authenticateScheduler(String email, String password) {
		
		return userDAO.authenticateScheduler(email, password);
	}

	
}
