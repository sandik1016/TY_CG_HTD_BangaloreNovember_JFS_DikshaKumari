package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.Factory.Factory;
import com.capgemini.forestmanagementsystem.bean.ContractBean;
import com.capgemini.forestmanagementsystem.dao.ContractDAO;
import com.capgemini.forestmanagementsystem.exception.ContractException;
import com.capgemini.forestmanagementsystem.exception.CustomerException;
import com.capgemini.forestmanagementsystem.exception.ProductException;

public class ContractServicesImpl implements ContractServices{
	 ContractDAO clientDAO= Factory.contractDAOInstance();
		
		public boolean addContract(ContractBean client) {
			
			return clientDAO.addContract(client);
		}

		
		public boolean deleteContract(int contractId) throws ContractException {
			
			return clientDAO.deleteContract(contractId);
		}

		
		public List<ContractBean> getAllContract() {
			
			return clientDAO.getAllContract();
		}

		
		public boolean updateProductId(int contractId,int productId) throws ProductException {
			
			return clientDAO.updateProductId(contractId,productId);
		}

		
	

		
		public boolean updateDeliveryDate(int contractId, String deliveryDate) throws ContractException {
			
			return clientDAO.updateDeliveryDate(contractId, deliveryDate);
		}


		

		@Override
		public List<ContractBean> searchContract(int contractId) {
			
			return clientDAO.searchContract(contractId);
		}


		@Override
		public boolean updateCustomerId(int contractId, int customerId) throws CustomerException {
			
			return clientDAO.updateCustomerId(contractId, customerId);
		}


		@Override
		public boolean updateQuantity(int contractId, int quantity) throws ContractException {
			
			return clientDAO.updateQuantity(contractId, quantity);
		}


		@Override
		public boolean searchCustomerId(int customerId) throws CustomerException {
			
			return clientDAO.searchCustomerId(customerId);
		}


		@Override
		public boolean searchProductId(int productId) throws ProductException {
			return clientDAO.searchProductId(productId);
		}



}
