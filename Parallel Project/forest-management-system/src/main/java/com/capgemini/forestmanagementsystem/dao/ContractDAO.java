package com.capgemini.forestmanagementsystem.dao;

import java.util.List;

import com.capgemini.forestmanagementsystem.bean.ContractBean;
import com.capgemini.forestmanagementsystem.exception.ContractException;
import com.capgemini.forestmanagementsystem.exception.CustomerException;
import com.capgemini.forestmanagementsystem.exception.ProductException;

public interface ContractDAO {
	public boolean addContract(ContractBean contract);
	public boolean deleteContract(int contractId)throws ContractException;
	public List<ContractBean> getAllContract();
	public List<ContractBean> searchContract(int contractId);
    public boolean updateProductId(int contractId,int productId)throws ProductException;
	public boolean updateCustomerId(int contractId,int customerId)throws CustomerException;
	public boolean updateDeliveryDate(int contractId,String deliveryDate) throws ContractException;
	public boolean updateQuantity(int contractId,int quantity)throws ContractException;
	public boolean searchCustomerId(int customerId) throws CustomerException;
	public boolean searchProductId(int productId) throws ProductException;
}
