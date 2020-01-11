package com.capgemini.retailermaintenancesystemapplicationdevelopment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.dao.ProductDAO;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.ProductBean;

@Service
public class ProductServiceImpl implements ProductDAO {
	@Autowired
	private ProductDAO productDao;

	@Override
	public boolean addProduct(ProductBean productBean) {

		return productDao.addProduct(productBean);
	}

	@Override
	public ProductBean getProduct(int productId) {

		return productDao.getProduct(productId);
	}

	@Override
	public List<ProductBean> getAllProducts() {

		return productDao.getAllProducts();
	}
}
