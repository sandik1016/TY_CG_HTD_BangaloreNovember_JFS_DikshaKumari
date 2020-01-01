package com.capgemini.forestrymanagementsystem.bean;

import java.io.Serializable;

public class ProductBean implements Serializable{
	int pid;
	String name;
	int quantity;
	char productClass;
	double cost;
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public char getProductClass() {
		return productClass;
	}
	public void setProductClass(char productClass) {
		this.productClass = productClass;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost2) {
		this.cost = cost2;
	}
	@Override
	public String toString() {
		return "ProductBean [pid=" + pid + ", name=" + name + ", quantity=" + quantity + ", productClass="
				+ productClass + ", cost=" + cost + "]";
	}
	
	

}
