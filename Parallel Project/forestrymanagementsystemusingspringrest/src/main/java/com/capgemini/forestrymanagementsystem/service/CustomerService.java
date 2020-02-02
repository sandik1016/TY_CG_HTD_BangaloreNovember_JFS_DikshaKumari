package com.capgemini.forestrymanagementsystem.service;

import java.util.List;

import com.capgemini.forestrymanagementsystem.dto.CustomerBean;

public interface CustomerService {
	public boolean addCustomer(CustomerBean customer);
	public boolean deleteCustomer(int customerId);
	public List<CustomerBean> getAllCustomers();
	public boolean modifyCustomer(int customerId,CustomerBean customer);
	public CustomerBean getCustomer(int customerId);
}
