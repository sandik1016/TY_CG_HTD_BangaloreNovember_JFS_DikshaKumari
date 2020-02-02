package com.capgemini.forestrymanagementsystem.dao;

import java.util.List;

import com.capgemini.forestrymanagementsystem.dto.UserBean;

public interface AdminDAO {	
	public boolean clientRegister(UserBean clientBean);
	public boolean schedulerRegister(UserBean schedulerBean);
	public boolean removeClient(String clientEmail);
	public List<UserBean> showClients();
	public boolean removeScheduler(String schedulerEmail);
	public List<UserBean> showScheduler();
	public boolean changePassword(String email,String password);

}
