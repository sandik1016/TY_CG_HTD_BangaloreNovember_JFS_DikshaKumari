 package com.capgemini.forestrymanagementsystem.service;

import java.util.List;

import com.capgemini.forestrymanagementsystem.bean.ProductBean;
import com.capgemini.forestrymanagementsystem.dao.ProductDAO;
import com.capgemini.forestrymanagementsystem.factory.Factory;


public class ProductServicesImpl implements ProductServices{
	ProductDAO dao2 = Factory.instanceOfProductDAOImpl();
	@Override
	public List<ProductBean> getAllProduct() {
		return dao2.getAllProduct();
	}

	@Override
	public boolean updateProduct(int pid, ProductBean productUpdate) {
		return dao2.updateProduct(pid, productUpdate);
	}

	@Override
	public boolean deleteProduct(int productDelete) {
		return dao2.deleteProduct(productDelete); 
	}

	@Override
	public boolean addProduct(ProductBean product) {
		return dao2.addProduct(product);
	}

	@Override
	public ProductBean searchProduct(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

}
