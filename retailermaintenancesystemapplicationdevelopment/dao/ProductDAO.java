package com.capgemini.retailermaintenancesystemapplicationdevelopment.dao;
import java.util.List;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.ProductBean;
public interface ProductDAO {
	public boolean addProduct(ProductBean productBean);
	public ProductBean getProduct(int productId);
	public List<ProductBean> getAllProducts();
}
