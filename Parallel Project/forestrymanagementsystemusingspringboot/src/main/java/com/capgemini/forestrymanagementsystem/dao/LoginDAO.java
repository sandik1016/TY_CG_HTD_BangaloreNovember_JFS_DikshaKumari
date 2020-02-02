package com.capgemini.forestrymanagementsystem.dao;

import com.capgemini.forestrymanagementsystem.dto.UserBean;

public interface LoginDAO {
	public UserBean clientLogin(String clientEmail, String clientPassword);

	public UserBean adminLogin(String adminEmail, String adminPassword);

	public UserBean schedulerLogin(String schedulerEmail, String schedulerPassword);
}
