package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.Factory.Factory;
import com.capgemini.forestmanagementsystem.bean.ProductBean;
import com.capgemini.forestmanagementsystem.dao.ProductDAO;
import com.capgemini.forestmanagementsystem.exception.ProductException;

public class ProductServicesImpl implements ProductServices{
ProductDAO dao=Factory.productDAOInstance();
	
	public boolean insertProduct(ProductBean prod) throws ProductException  {
		return dao.insertProduct(prod) ;
	}

	
	public boolean deleteProduct(int productId) throws ProductException {
		
		return dao.deleteProduct(productId);
	}


	@Override
	public List<ProductBean> getAllProducts() {
		
		return dao.getAllProducts();
	}


	@Override
	public boolean updateProduct(int productId,int quantity) throws ProductException {
		
		return dao.updateProduct(productId,quantity);
	}


	@Override
	public List<ProductBean> searchProduct(int productId) {
	
		return dao.searchProduct(productId);
	}


	@Override
	public boolean searchOneProduct(int productId) throws ProductException {
		return dao.searchOneProduct(productId);
	}
}
