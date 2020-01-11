package com.capgemini.retailermaintenancesystemapplicationdevelopment.dao;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.UserBean;

public interface UserDAO {
	public boolean registerUser(UserBean userBean);

	public UserBean authentication(String email, String password);

	public boolean changePassword(String userEmail, String password);

}
