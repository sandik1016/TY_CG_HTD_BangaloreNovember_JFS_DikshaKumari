package com.capgemini.productspringboot.dao;

import java.util.List;

import com.capgemini.productspringboot.dto.ProductBean;
import com.capgemini.productspringboot.exception.ProductException;
public interface ProductDAO {
	public boolean addProduct(ProductBean bean);
	public ProductBean getProduct(int id);
	public List<ProductBean> getAllProduct();
	public boolean updateProduct(int id,ProductBean bean);
	public boolean deleteProduct(int id)throws ProductException;
}
