package com.capgemini.forestmanagementsystem.dao;

import java.util.List;

import com.capgemini.forestmanagementsystem.bean.ProductBean;
import com.capgemini.forestmanagementsystem.exception.ProductException;

public interface ProductDAO {
	public boolean deleteProduct(int productId)throws ProductException;	
	public boolean insertProduct(ProductBean product)throws ProductException;
	public boolean updateProduct(int productId,int quantity)throws ProductException;
	
	public List<ProductBean> getAllProducts();
	public List<ProductBean> searchProduct(int productId);

	public boolean searchOneProduct(int productId)throws ProductException;

}
