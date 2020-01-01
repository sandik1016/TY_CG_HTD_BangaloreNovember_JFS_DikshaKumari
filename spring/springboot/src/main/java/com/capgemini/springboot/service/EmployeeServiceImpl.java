package com.capgemini.springboot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.capgemini.springboot.dao.EmployeeDAO;
import com.capgemini.springboot.dto.EmployeeAddressBean;
import com.capgemini.springboot.dto.EmployeeBean;
@Service
public class EmployeeServiceImpl implements EmployeeService{
	@Autowired//it is like interface search for employeedao type ie employeedaoimpl
      private EmployeeDAO dao;//bydefault value is null...we will not create by oursel we will tell spring to do
      
	@Override
	public EmployeeBean auth(String email, String password) {
		//encyrption of password
		return dao.auth(email, password);
	}

	@Override
	public boolean register(EmployeeBean bean) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();//encyrption of password
		String encodedPassword = encoder.encode(bean.getPassword());
		bean.setPassword(encodedPassword);
		
		
		List<EmployeeAddressBean> addressBean = bean.getOther();
		for (EmployeeAddressBean employeeAddressBean : addressBean) {
			employeeAddressBean.setBean(bean);
		}
		return dao.register(bean);
	}

	@Override
	public List<EmployeeBean> getEmployees(String key) {
		
		return dao.getEmployees(key);
	}

	@Override
	public boolean changePassword(int id, String password) {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();//encode and pass so that we can set into db
		return dao.changePassword(id, encoder.encode(password));//it is hashing technique so we cannot decrypt it
	}
//controller accepting req n forward req to jspand resp
	//dao interact to db
	//service if we have othr business logic such as validation apart from db operation...it supports dao

	@Override
	public boolean deleteEmployee(int id) {
		
		return dao.deleteEmployee(id);
	}
	
}
