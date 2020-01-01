package com.capgemini.forestrymanagementsystem.dao;

import java.util.Map;

import java.util.Set;

import com.capgemini.forestrymanagementsystem.bean.ProductBean;
import com.capgemini.forestrymanagementsystem.exception.ProductIdNotFoundException;



public interface ProductDAO {
	public Set<ProductBean> getAllProduct();
	public boolean updateProduct(int pid,Map<Integer,Set<ProductBean>> productBean) throws ProductIdNotFoundException;
	public boolean deleteProduct(int pid,Map<Integer,Set<ProductBean>> productBean)throws ProductIdNotFoundException;
	//create ProductBean object and pass to insert all values
	public boolean addProduct(ProductBean product);
	public boolean searchProduct(int pid,Map<Integer,Set<ProductBean>> productBean)throws ProductIdNotFoundException;
	
}
