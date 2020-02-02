package com.capgemini.forestmanagementsystem.service;

import java.util.List;

import com.capgemini.forestmanagementsystem.bean.ProductBean;
import com.capgemini.forestmanagementsystem.exception.ProductException;

public interface ProductServices {
	public boolean deleteProduct(int productId)throws ProductException;
	public boolean insertProduct(ProductBean prod)throws ProductException;
	public boolean updateProduct(int productId,int quantity)throws ProductException;
	
	public List<ProductBean> getAllProducts();
	public List<ProductBean> searchProduct(int productId)throws ProductException;
	public boolean searchOneProduct(int productId)throws ProductException;
}
