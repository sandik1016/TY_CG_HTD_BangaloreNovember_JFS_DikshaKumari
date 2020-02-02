package com.capgemini.forestrymanagementsystem.service;

import java.util.List;

import com.capgemini.forestrymanagementsystem.dto.ContractBean;

public interface ContractService {
	public boolean addContract(ContractBean contract);
	public boolean deleteContract(int contractId);
	public List<ContractBean> getAllContract();
	public boolean modifyContract(int contractId,ContractBean contract);
	public ContractBean getContract(int contractId);
	public boolean searchCustomerId(int customerId);
	public boolean searchProductId(int productId) ;
}
