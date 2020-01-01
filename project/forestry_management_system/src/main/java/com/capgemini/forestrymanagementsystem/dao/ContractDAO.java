package com.capgemini.forestrymanagementsystem.dao;

import java.util.Map;

import java.util.Set;

import com.capgemini.forestrymanagementsystem.bean.ContractBean;
import com.capgemini.forestrymanagementsystem.exception.ContractIdNotFoundException;


public interface ContractDAO {
	public Set<ContractBean> getAllContract();
	public boolean updateContract(int cid, Map<Integer,Set<ContractBean>> contBean) throws ContractIdNotFoundException;
	public boolean deleteContract(int cid, Map<Integer,Set<ContractBean>> contBean)throws ContractIdNotFoundException;
	public boolean addContract(ContractBean contractor);
	public boolean searchContract(int cid, Map<Integer,Set<ContractBean>> contBean) throws ContractIdNotFoundException;
   
}
