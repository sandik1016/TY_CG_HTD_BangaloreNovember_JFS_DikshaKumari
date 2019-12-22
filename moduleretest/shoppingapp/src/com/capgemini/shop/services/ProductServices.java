package com.capgemini.shop.services;

import java.util.List;

import com.capgemini.shop.beans.ProductBean;

public interface ProductServices {
	public boolean addProduct(ProductBean product);
    public ProductBean searchProduct(String productName);
    public List<ProductBean> getAllProduct();
}
