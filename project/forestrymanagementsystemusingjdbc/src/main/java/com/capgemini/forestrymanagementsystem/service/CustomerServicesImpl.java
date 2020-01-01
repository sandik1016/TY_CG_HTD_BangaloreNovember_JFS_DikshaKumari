package com.capgemini.forestrymanagementsystem.service;


import java.util.List;

import com.capgemini.forestrymanagementsystem.bean.CustomerBean;
import com.capgemini.forestrymanagementsystem.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystem.factory.Factory;
public class CustomerServicesImpl implements CustomerServices{
	CustomerDAO dao = Factory.instanceOfUserDAOImpl();

	@Override
public List<CustomerBean> getAllCustomer() {
		
		return dao.getAllCustomer();
	}

	@Override
	public CustomerBean customerLogin(int cid, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean updateCustomer(int cid, CustomerBean customerUpdate) {
		
		return dao.updateCustomer(cid, customerUpdate);
	}

	@Override
	public boolean deleteCustomer(int cid) {
		return dao.deleteCustomer(cid);
	}

	@Override
	public boolean addCustomer(CustomerBean customer) {
		return dao.addCustomer(customer);
		
	}

	@Override
	public CustomerBean searchCustomer(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	
	}

