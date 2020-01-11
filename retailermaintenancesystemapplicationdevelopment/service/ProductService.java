package com.capgemini.retailermaintenancesystemapplicationdevelopment.service;

import java.util.List;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.ProductBean;

public interface ProductService {
	public boolean addProduct(ProductBean productBean);

	public ProductBean getProduct(int productId);

	public List<ProductBean> getAllProducts();
}
