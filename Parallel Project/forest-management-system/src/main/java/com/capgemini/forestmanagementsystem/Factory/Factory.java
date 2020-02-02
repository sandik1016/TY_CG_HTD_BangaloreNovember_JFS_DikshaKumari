package com.capgemini.forestmanagementsystem.Factory;

import com.capgemini.forestmanagementsystem.dao.ContractDAO;
import com.capgemini.forestmanagementsystem.dao.ContractDAOImpl;
import com.capgemini.forestmanagementsystem.dao.CustomerDAO;
import com.capgemini.forestmanagementsystem.dao.CustomerDAOImpl;
import com.capgemini.forestmanagementsystem.dao.LandDAO;
import com.capgemini.forestmanagementsystem.dao.LandDAOImpl;
import com.capgemini.forestmanagementsystem.dao.ProductDAO;
import com.capgemini.forestmanagementsystem.dao.ProductDAOImpl;
import com.capgemini.forestmanagementsystem.dao.SchedulerDAO;
import com.capgemini.forestmanagementsystem.dao.SchedulerDAOImpl;
import com.capgemini.forestmanagementsystem.dao.UserDAO;
import com.capgemini.forestmanagementsystem.dao.UserDAOImpl;
import com.capgemini.forestmanagementsystem.service.ContractServices;
import com.capgemini.forestmanagementsystem.service.ContractServicesImpl;
import com.capgemini.forestmanagementsystem.service.CustomerServices;
import com.capgemini.forestmanagementsystem.service.CustomerServicesImpl;
import com.capgemini.forestmanagementsystem.service.LandServices;
import com.capgemini.forestmanagementsystem.service.LandServicesImpl;
import com.capgemini.forestmanagementsystem.service.ProductServices;
import com.capgemini.forestmanagementsystem.service.ProductServicesImpl;
import com.capgemini.forestmanagementsystem.service.SchedulerServices;
import com.capgemini.forestmanagementsystem.service.SchedulerServicesImpl;
import com.capgemini.forestmanagementsystem.service.UserServices;
import com.capgemini.forestmanagementsystem.service.UserServicesImpl;


public class Factory {
	public static ProductDAO productDAOInstance() {
		ProductDAO prodDAO=new ProductDAOImpl();
		return prodDAO;
	}
	
	public static ProductServices productServicesInstance() {
		ProductServices services=new ProductServicesImpl();
		return services ;
	}
	
	public static UserDAO userDAOInstance() {
		UserDAO userDAO= new UserDAOImpl();
		return userDAO;
	}
	
	public static UserServices userServicesInstance() {
		UserServices userServices= new UserServicesImpl();
		return userServices;
	}
	
	public static ContractDAO contractDAOInstance() {
		ContractDAO clientDAO= new ContractDAOImpl();
		return clientDAO;
	}
	
	public static ContractServices contractServicesInstance() {
		ContractServices clientServices= new ContractServicesImpl();
		return clientServices;
	}
	
	public static LandDAO landDAOInstance() {
		LandDAO landDAO= new LandDAOImpl();
		return landDAO;
	}
	
	public static LandServices landServicesInstance() {
		LandServices landServices= new LandServicesImpl();
		return landServices;
	}
	
	public static SchedulerDAO schedulerDAOInstance() {
		SchedulerDAO schedulerDAO=new SchedulerDAOImpl();
		return schedulerDAO;
	}
	
	public static SchedulerServices schedulerServicesInstance() {
		SchedulerServices schedulerServices=new SchedulerServicesImpl();
		return schedulerServices;
	}
	
	public static CustomerServices customerServicesInstance() {
		CustomerServices customerServices = new CustomerServicesImpl();
		return customerServices;
	}
	
	public static CustomerDAO customerDAOInstance() {
		CustomerDAO customerServices = new CustomerDAOImpl();
		return customerServices;
	}
	
}
