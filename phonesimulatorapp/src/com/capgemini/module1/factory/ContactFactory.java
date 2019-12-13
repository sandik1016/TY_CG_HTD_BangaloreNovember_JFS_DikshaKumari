package com.capgemini.module1.factory;
import com.capgemini.module1.dao.ContactDAO;
import com.capgemini.module1.dao.ContactDAOImpl;
import com.capgemini.module1.services.ContactServices;
import com.capgemini.module1.services.ContactServicesImpl;

public class ContactFactory {

	public static ContactDAO getInstanceOfContactDAOImpl() {
		ContactDAO  dao = new ContactDAOImpl();
		return dao;
	}
	public static ContactServices getInstanceOfContactServicesImpl() {
		ContactServices  services = new ContactServicesImpl();
		return services;
	}

}
