package com.capgemini.forestrymanagementsystem.dao;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.capgemini.forestrymanagementsystem.bean.CustomerBean;
import com.capgemini.forestrymanagementsystem.exception.CustomerIdNotFoundException;

import java.util.Map.Entry;


public class CustomerDAOImpl implements CustomerDAO{

	Set<CustomerBean> s;


	@Override
	public Set<CustomerBean> getAllCustomer() {
		return s; 
	}


	@Override
	public boolean addCustomer(CustomerBean customer) {
		s= new HashSet<CustomerBean>();
		s.add(customer);
		return true;
	}

	@Override
	public boolean updateCustomer(int cid, Map<Integer, Set<CustomerBean>> customerUpdate) throws CustomerIdNotFoundException  {
		Set<Entry<Integer,Set<CustomerBean>>> s1 = customerUpdate.entrySet();
		if(cid < 0 )
		{
			throw  new CustomerIdNotFoundException("Please enter valid customer number");
		}else {
		for(Entry<Integer,Set<CustomerBean>> e1:s1) {
			if(e1.getKey()==cid) {

				return true;
			}
		}
		}
		return false;
	}

	@Override
	public boolean deleteCustomer(int cid, Map<Integer, Set<CustomerBean>> customerDelete) throws CustomerIdNotFoundException{
		Set<Entry<Integer,Set<CustomerBean>>> s1 = customerDelete.entrySet();
		if(cid < 0 )
		{
			throw  new CustomerIdNotFoundException("Please enter valid customer number");
		}else {
		for(Entry<Integer,Set<CustomerBean>> e1:s1) {
			if(e1.getKey()==cid) {

				return true;
			}
		}
		}
		return false;
	}

	@Override
	public boolean searchCustomer(int cid, Map<Integer, Set<CustomerBean>> customerSearch)throws CustomerIdNotFoundException {
		Set<Entry<Integer,Set<CustomerBean>>> s1 = customerSearch.entrySet();
		if(cid < 0 )
		{
		throw	new CustomerIdNotFoundException("Please enter valid customer number");
		}else {
		for(Entry<Integer,Set<CustomerBean>> e1:s1) {
			if(e1.getKey()==cid) {

				return true;
			}
		}
		}
		return false;


	}
}

