package com.capgemini.retailermaintenancesystemapplicationdevelopment.service;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.UserBean;
public interface UserService {
	public boolean registerUser(UserBean userBean);

	public UserBean authentication(String email, String password);

	public boolean changePassword(String userEmail, String password);
}
