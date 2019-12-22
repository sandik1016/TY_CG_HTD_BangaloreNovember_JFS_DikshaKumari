package com.capgemini.shop.services;

import java.util.List;

import com.capgemini.shop.beans.ProductBean;
import com.capgemini.shop.dao.ProductDAO;
import com.capgemini.shop.factory.Factory;

public class ProductServicesImpl implements ProductServices{
        ProductDAO dao = Factory.getInstanceOfProductDAOImpl();
	@Override
	public boolean addProduct(ProductBean product) {
		
		return dao.addProduct(product);
	}

	@Override
	public ProductBean searchProduct(String productName) {
		
		return dao.searchProduct(productName);
	}

	@Override
	public List<ProductBean> getAllProduct() {
		
		return dao.getAllProduct();
	}

}
