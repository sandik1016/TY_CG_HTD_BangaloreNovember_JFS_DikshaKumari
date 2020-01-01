package com.capgemini.forestrymanagementsystem.dao;


import java.util.HashMap;

import java.util.Map;
import java.util.Set;

import com.capgemini.forestrymanagementsystem.bean.CustomerBean;
import com.capgemini.forestrymanagementsystem.exception.ContractIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.CustomerIdNotFoundException;

public interface CustomerDAO {
	public Set<CustomerBean> getAllCustomer();
	public boolean updateCustomer(int cid,  Map<Integer,Set<CustomerBean>> customerUpdate) throws CustomerIdNotFoundException;
	public boolean deleteCustomer(int cid,Map<Integer,Set<CustomerBean>> customerDelete)  throws CustomerIdNotFoundException;
	public boolean addCustomer(CustomerBean customer);
    public boolean searchCustomer(int cid,Map<Integer,Set<CustomerBean>> customerSearch) throws CustomerIdNotFoundException;        

}
