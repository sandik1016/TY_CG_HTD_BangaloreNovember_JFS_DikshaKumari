package com.capgemini.forestrymanagementsystem.dto;

import java.util.List;

public class ProductResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<ProductBean> productBean;
	private ProductBean getOneProduct;

	public ProductBean getGetOneProduct() {
		return getOneProduct;
	}
	public void setGetOneProduct(ProductBean getOneProduct) {
		this.getOneProduct = getOneProduct;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public List<ProductBean> getProductBean() {
		return productBean;
	}
	public void setProductBean(List<ProductBean> productBean) {
		this.productBean = productBean;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
