package com.capgemini.forestrymanagementsystem.service;

import java.util.List;
import com.capgemini.forestrymanagementsystem.dto.ProductBean;

public interface ProductService {
	public boolean addProduct(ProductBean product);
	public boolean deleteProduct(int productId);
	public List<ProductBean> getAllProduct();
	public boolean modifyProduct(int productId,ProductBean product);
	public ProductBean getProduct(int productId);
}
