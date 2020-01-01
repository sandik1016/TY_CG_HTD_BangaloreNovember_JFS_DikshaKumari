package com.capgemini.forestrymanagementsystem.bean;

import java.io.Serializable;

public class ProductBean implements Serializable{
	@Override
	public String toString() {
		return "ProductBean [productId=" + productId + ", productName=" + productName + "]";
	}
	private int productId;
	private String productName;//it will set the file in bytecode
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	

}