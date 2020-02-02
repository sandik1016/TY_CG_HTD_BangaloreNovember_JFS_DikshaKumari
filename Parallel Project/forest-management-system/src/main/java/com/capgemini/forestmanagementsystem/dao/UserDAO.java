package com.capgemini.forestmanagementsystem.dao;

import java.util.List;

import com.capgemini.forestmanagementsystem.bean.UserBean;

public interface UserDAO {
	
public boolean addUser(UserBean user);
public boolean removeUser(String email);
public List<UserBean> showUser();
public boolean authenticate(String email,String password);//throws CustomerIdNotFoundException;
public boolean searchUserType(String role);
public boolean authenticateClient(String email,String password);
public boolean authenticateScheduler(String email,String password);
}
