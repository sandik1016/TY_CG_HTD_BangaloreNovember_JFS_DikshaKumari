package com.capgemini.forestrymanagementsystem.service;

import java.text.ParseException;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementsystem.dao.ContractDAO;
import com.capgemini.forestrymanagementsystem.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystem.dao.ProductDAO;
import com.capgemini.forestrymanagementsystem.dto.ContractBean;
import com.capgemini.forestrymanagementsystem.exception.ContractException;
import com.capgemini.forestrymanagementsystem.util.Validation;
@Service
public class ContractServiceImpl implements ContractService{
	@Autowired
    private ContractDAO contractDao;
	@Autowired
	private CustomerDAO customerDao;
	@Autowired
	private ProductDAO productDao;
	@Override
	public boolean addContract(ContractBean contract) {
	     if(customerDao.getCustomer(contract.getCustomerId()) == null ||
	    		 productDao.getProduct(contract.getProductId()) == null){
		   System.out.println("Given id doesn't exists");
	     }
	     Validation v = new Validation();
			String date = contract.getDeliveryDate();
			try {
				if(v.dateValidation(date)) {
					contract.setDeliveryDate(date);
				}else{
					throw new ContractException("Enter valid date.. only present and future date allowed");
				}
			} catch (ParseException e) {
				throw new ContractException("Enter valid date.. only present and future date allowed");
			}
	     return contractDao.addContract(contract);
	}

	@Override
	public boolean deleteContract(int contractId) {
		
		return contractDao.deleteContract(contractId);
	}

	@Override
	public List<ContractBean> getAllContract() {
		
		return contractDao.getAllContract();
	}

	@Override
	public boolean modifyContract(int contractId, ContractBean contract) {
		Validation v = new Validation();
		String date = contract.getDeliveryDate();
		try {
			if(v.dateValidation(date)) {
				contract.setDeliveryDate(date);
			}else{
				throw new ContractException("Enter valid date.. only present and future date allowed");
			}
		} catch (ParseException e) {
			throw new ContractException("Enter valid date.. only present and future date allowed");
		}
		return contractDao.modifyContract(contractId, contract);
	}

	@Override
	public ContractBean getContract(int contractId) {
		
		return contractDao.getContract(contractId);
	}

	@Override
	public boolean searchCustomerId(int customerId) {
		
		return contractDao.searchCustomerId(customerId);
	}

	@Override
	public boolean searchProductId(int productId) {
		
		return contractDao.searchProductId(productId);
	}

}
