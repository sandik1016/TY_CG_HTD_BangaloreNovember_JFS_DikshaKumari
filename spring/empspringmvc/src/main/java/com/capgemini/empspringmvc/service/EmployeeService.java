package com.capgemini.empspringmvc.service;

import java.util.List;

import com.capgemini.empspringmvc.manytoone.EmployeeBean;

public interface EmployeeService {
	public EmployeeBean auth(String email,String password);
	public boolean register(EmployeeBean bean);
	//public EmployeeBean getEmployee(String email);
	public List<EmployeeBean> getEmployees(String key);
	public boolean changePassword(int id,String password);
}
