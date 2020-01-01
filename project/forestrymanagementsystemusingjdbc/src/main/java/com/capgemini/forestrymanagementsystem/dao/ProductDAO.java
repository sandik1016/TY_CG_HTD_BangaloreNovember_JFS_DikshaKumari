package com.capgemini.forestrymanagementsystem.dao;

import java.util.List;

import com.capgemini.forestrymanagementsystem.bean.ProductBean;

public interface ProductDAO {
	public List<ProductBean> getAllProduct();
	public boolean updateProduct(int pid,ProductBean productUpdate);
	public boolean deleteProduct(int productDelete);
	public boolean addProduct(ProductBean product);
	public ProductBean searchProduct(int pid);

}
