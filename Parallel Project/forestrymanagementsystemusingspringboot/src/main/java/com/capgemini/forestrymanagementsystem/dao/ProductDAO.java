package com.capgemini.forestrymanagementsystem.dao;

import java.util.List;
import com.capgemini.forestrymanagementsystem.dto.ProductBean;

public interface ProductDAO {
	public boolean addProduct(ProductBean product);
	public boolean deleteProduct(int productId);
	public List<ProductBean> getAllProduct();
	public boolean modifyProduct(int productId,ProductBean product);
	public ProductBean getProduct(int productId);
}
