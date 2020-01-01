package com.capgemini.forestrymanagementsystem.dao;

import java.util.HashMap;

import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.capgemini.forestrymanagementsystem.bean.ContractBean;
import com.capgemini.forestrymanagementsystem.exception.ContractIdNotFoundException;


public class ContractDAOImpl implements ContractDAO{
	
	Set<ContractBean> s;
	ContractBean bean =new ContractBean();
	@Override
	public Set<ContractBean> getAllContract() {
		return s;
	}

	@Override
	public boolean updateContract(int cid, Map<Integer, Set<ContractBean>> contBean) throws ContractIdNotFoundException{
		if(cid < 0)
		{
			throw new ContractIdNotFoundException(" entered id is invalid");
		}else {
		Set<Entry<Integer,Set<ContractBean>>> s1 = contBean.entrySet();
		for(Entry<Integer,Set<ContractBean>> e1:s1) {
			if(e1.getKey()==cid) {
		
		return true;
	}
	}
		}
		return false;
	}

	@Override
	public boolean deleteContract(int cid, Map<Integer, Set<ContractBean>> contBean)throws ContractIdNotFoundException {
		if(cid < 0)
		{
			throw new ContractIdNotFoundException("enter positive id");
		}else{
		Set<Entry<Integer,Set<ContractBean>>> s1 = contBean.entrySet();
		for(Entry<Integer,Set<ContractBean>> e1:s1) {
			if(e1.getKey()==cid) {
		
		return true;
	}
			
	}
		}
		return false;
	}

	@Override
	public boolean addContract(ContractBean contractor) {
		
		s= new HashSet<ContractBean>();
		s.add(contractor);
		return true;
	}

	@Override
	public boolean searchContract(int cid, Map<Integer, Set<ContractBean>> contBean) throws ContractIdNotFoundException {
		if(cid < 0)
		{
			throw new ContractIdNotFoundException(" id is invalid...enter positive id");
		}else {
		Set<Entry<Integer,Set<ContractBean>>> s1 = contBean.entrySet();
		for(Entry<Integer,Set<ContractBean>> e1:s1) {
			if(e1.getKey()==cid) {
		
		return true;
	}
		}
	}
	return false;
}


}
