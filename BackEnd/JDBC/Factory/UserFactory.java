package com.capgemini.jdbc.factory;

import com.capgmn.jdbc.dataacessobject.UserDAO;
import com.capgmn.jdbc.dataacessobject.UserDAOImpl;
import com.capgmn.jdbc.services.UserServices;
import com.capgmn.jdbc.services.UserServicesImpl;

public class UserFactory {
	private UserFactory() {
		
	}
	public static UserDAO instanceOfUserDAOImpl () {
	UserDAO dao = new UserDAOImpl();//want to call mthod of userdao and userservices at any time it is to be called using creating object
	return dao;
	
	}
    
	public static UserServices instanceOfUserServices() {
		UserServices services = new UserServicesImpl();
		return services;
	}
}
