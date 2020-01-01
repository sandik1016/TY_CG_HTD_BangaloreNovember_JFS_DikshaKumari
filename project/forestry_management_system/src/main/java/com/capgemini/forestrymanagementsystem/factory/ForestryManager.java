package com.capgemini.forestrymanagementsystem.factory;

import com.capgemini.forestrymanagementsystem.dao.ContractDAO;
import com.capgemini.forestrymanagementsystem.dao.ContractDAOImpl;
import com.capgemini.forestrymanagementsystem.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystem.dao.CustomerDAOImpl;
import com.capgemini.forestrymanagementsystem.dao.HaulierDAO;
import com.capgemini.forestrymanagementsystem.dao.HaulierDAOImpl;
import com.capgemini.forestrymanagementsystem.dao.LandDAO;
import com.capgemini.forestrymanagementsystem.dao.LandDAOImpl;
import com.capgemini.forestrymanagementsystem.dao.ProductDAO;
import com.capgemini.forestrymanagementsystem.dao.ProductDAOImpl;
import com.capgemini.forestrymanagementsystem.dao.SchedulerDAO;
import com.capgemini.forestrymanagementsystem.dao.SchedulerDAOImpl;

public class ForestryManager {
	public static CustomerDAO getCustomerDAOImpl() {
		return new CustomerDAOImpl();
	}
	public static ContractDAO getContractDAOImpl() {
		return new ContractDAOImpl();
	}
	public static ProductDAO getProductDAOImpl() {
		return new ProductDAOImpl();
		
	}
	
	public static LandDAO getLandDAOImpl() {
		return new LandDAOImpl();
		
	}
	
	public static SchedulerDAO getSchedulerDAOImpl() {
		return new SchedulerDAOImpl();
		
	}
	
	public static HaulierDAO getHaulierDAOImpl() {
		return new HaulierDAOImpl();
		
	}
}
