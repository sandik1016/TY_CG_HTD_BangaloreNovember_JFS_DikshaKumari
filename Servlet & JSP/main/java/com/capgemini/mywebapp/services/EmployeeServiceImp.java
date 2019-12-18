package com.capgemini.mywebapp.services;

import java.util.List;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.dao.EmployeeDao;
import com.capgemini.mywebapp.dao.EmployeeDaoImp;

public class EmployeeServiceImp implements EmployeeService {
	private EmployeeDao dao = new EmployeeDaoImp();

	@Override
	public EmployeeInfoBean searchEmployee(int emp_id) {
	
		return dao.searchEmployee(emp_id);
		
	}

	@Override
	public EmployeeInfoBean authenticate(int empId, String password) {
		
		return dao.authenticate(empId, password);
	}

	@Override
	public boolean addEmployee(EmployeeInfoBean employeeInfoBean) {
		return dao.addEmployee(employeeInfoBean);
	}

	@Override
	public boolean deleteEmployee(int emp_id) {
		return dao.deleteEmployee(emp_id);
	}

	@Override
	public boolean updateEmployee(EmployeeInfoBean employeeInfoBean) {
		return dao.updateEmployee(employeeInfoBean);
	}

	@Override
	public List<EmployeeInfoBean> getAllEmployee() {
			return dao.getAllEmployee();
	}
	

}
