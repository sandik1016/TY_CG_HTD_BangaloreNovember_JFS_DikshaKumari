package com.capgemini.forestrymanagementsystem.service;

import java.util.List;

import com.capgemini.forestrymanagementsystem.dto.UserBean;

public interface AdminService {
	
	public boolean clientRegister(UserBean clientBean);
	public boolean schedulerRegister(UserBean schedulerBean);
	public boolean removeClient(int id);
	public List<UserBean> showClients();
	public boolean removeScheduler(int id);
	public List<UserBean> showScheduler();
	public boolean changePassword(int id,String password);
}
