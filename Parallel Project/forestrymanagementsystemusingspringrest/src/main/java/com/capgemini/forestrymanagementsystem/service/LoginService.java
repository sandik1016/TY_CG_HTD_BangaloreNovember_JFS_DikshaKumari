package com.capgemini.forestrymanagementsystem.service;

import com.capgemini.forestrymanagementsystem.dto.UserBean;

public interface LoginService {
	public UserBean clientLogin(String clientEmail, String clientPassword);

	public UserBean adminLogin(String adminEmail, String adminPassword);

	public UserBean schedulerLogin(String schedulerEmail, String schedulerPassword);
}
