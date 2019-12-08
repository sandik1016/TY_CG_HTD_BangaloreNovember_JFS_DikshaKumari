package com.capgmn.jdbc.services;

import java.util.List;

import com.capgemini.jdbc.factory.UserFactory;
import com.capgmn.jdbc.bean.UserBean;
import com.capgmn.jdbc.dataacessobject.UserDAO;

public class UserServicesImpl implements UserServices {

	UserDAO dao = UserFactory.instanceOfUserDAOImpl();
	@Override
	public List<UserBean> getAllUsers() {
		
		return dao.getAllUsers();
	}

	@Override
	public UserBean userLogin(String username, String password) {
		
		return dao.userLogin(username, password);
	}

	@Override
	public boolean updateUser(int userid, String password, String email) {
		
		return dao.updateUser(userid, password, email);
	}

	@Override
	public boolean insertUser(UserBean user) {
		return dao.insertUser(user);
		
	}

	@Override
	public boolean deleteUser(int userid, String password) {
		
		return dao.deleteUser(userid, password);
	}

	

}
