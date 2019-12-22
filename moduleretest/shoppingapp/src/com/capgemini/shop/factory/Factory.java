package com.capgemini.shop.factory;

import com.capgemini.shop.dao.ProductDAO;
import com.capgemini.shop.dao.ProductDAOImpl;
import com.capgemini.shop.services.ProductServices;
import com.capgemini.shop.services.ProductServicesImpl;

public class Factory {
	public static ProductDAO getInstanceOfProductDAOImpl() {
		ProductDAO  dao = new ProductDAOImpl();
		return dao;
	}
	public static ProductServices getInstanceOfProductServicesImpl() {
		ProductServices  services = new ProductServicesImpl();
		return services;
	}

}
