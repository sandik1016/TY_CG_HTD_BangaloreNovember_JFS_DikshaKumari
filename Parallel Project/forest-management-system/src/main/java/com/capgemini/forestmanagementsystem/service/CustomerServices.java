package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.bean.CustomerBean;
import com.capgemini.forestmanagementsystem.exception.CustomerException;

public interface CustomerServices {
	public boolean addCustomer(CustomerBean customer) throws CustomerException;
	public boolean deleteCustomer(int customerId)throws CustomerException;
	public boolean updateAddress(CustomerBean customer)throws CustomerException;
	public boolean updateContact(CustomerBean customer)throws CustomerException;
	
	public List<CustomerBean> getAllCustomer();	
	public List<CustomerBean> searchCustomer(int customerId)throws CustomerException;	
	
}
