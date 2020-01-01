package com.capgemini.forestrymanagementsystem.factory;

import com.capgemini.forestrymanagementsystem.dao.ContractorDAO;
import com.capgemini.forestrymanagementsystem.dao.ContractorDAOImpl;
import com.capgemini.forestrymanagementsystem.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystem.dao.CustomerDAOImpl;
import com.capgemini.forestrymanagementsystem.dao.ProductDAO;
import com.capgemini.forestrymanagementsystem.dao.ProductDAOImpl;
import com.capgemini.forestrymanagementsystem.service.ContractorServices;
import com.capgemini.forestrymanagementsystem.service.ContractorServicesImpl;
import com.capgemini.forestrymanagementsystem.service.CustomerServices;
import com.capgemini.forestrymanagementsystem.service.CustomerServicesImpl;
import com.capgemini.forestrymanagementsystem.service.ProductServices;
import com.capgemini.forestrymanagementsystem.service.ProductServicesImpl;

public class Factory {
private Factory() {
		
	}
	public static CustomerDAO instanceOfUserDAOImpl () {
	CustomerDAO dao = new CustomerDAOImpl();
	return dao;
	
	}
    
	public static CustomerServices instanceOfUserServices() {
		CustomerServices services = new CustomerServicesImpl();
		return services;
	}
	public static ContractorDAO instanceOfContractorDAOImpl () {
		ContractorDAO dao1 = new ContractorDAOImpl();
		return dao1;
		
		}
	    
		public static ContractorServices instanceOfContractorServices() {
			ContractorServices services1 = new ContractorServicesImpl();
			return services1;
		}
		public static ProductDAO instanceOfProductDAOImpl () {
			ProductDAO dao2 = new ProductDAOImpl();
			return dao2;
			
			}
		    
			public static ProductServices instanceOfProductServices() {
				ProductServices services2 = new ProductServicesImpl();
				return services2;
			}
}
