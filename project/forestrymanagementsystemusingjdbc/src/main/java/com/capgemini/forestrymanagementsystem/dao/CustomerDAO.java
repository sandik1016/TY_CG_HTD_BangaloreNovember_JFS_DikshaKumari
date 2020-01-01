package com.capgemini.forestrymanagementsystem.dao;

import java.util.List;

import com.capgemini.forestrymanagementsystem.bean.CustomerBean;

public interface CustomerDAO {
	
	public List<CustomerBean> getAllCustomer();
    public CustomerBean customerLogin(int cid,String name);
	public boolean updateCustomer(int cid,CustomerBean customerUpdate);
	public boolean deleteCustomer(int cid);
	//create CustomerBean object and pass to insert all values
	public boolean addCustomer(CustomerBean customer);
	public CustomerBean searchCustomer(int cid);        


}
