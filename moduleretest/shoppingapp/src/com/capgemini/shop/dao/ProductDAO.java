package com.capgemini.shop.dao;

import java.util.List;

import com.capgemini.shop.beans.ProductBean;

public interface ProductDAO {
      public boolean addProduct(ProductBean product);
      public ProductBean searchProduct(String productName);
      public List<ProductBean> getAllProduct();
}
