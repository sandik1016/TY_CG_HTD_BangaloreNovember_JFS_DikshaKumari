package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.Factory.Factory;
import com.capgemini.forestmanagementsystem.bean.CustomerBean;
import com.capgemini.forestmanagementsystem.dao.CustomerDAO;
import com.capgemini.forestmanagementsystem.exception.CustomerException;

public class CustomerServicesImpl implements CustomerServices{
	CustomerDAO dao= Factory.customerDAOInstance();

	@Override
	public boolean addCustomer(CustomerBean customer) throws CustomerException {

		return dao.addCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(int customerId) throws CustomerException {
	
		return dao.deleteCustomer(customerId);
	}

	@Override
	public List<CustomerBean> getAllCustomer() {
		
		return dao.getAllCustomer();
	}

	@Override
	public boolean updateAddress(CustomerBean customer) throws CustomerException {
		
		return dao.updateAddress(customer);
	}

	@Override
	public boolean updateContact(CustomerBean customer) throws CustomerException {

		return dao.updateContact(customer);
	}

	@Override
	public List<CustomerBean> searchCustomer(int customerId) throws CustomerException {
		
		return dao.searchCustomer(customerId);
	}

	
}
