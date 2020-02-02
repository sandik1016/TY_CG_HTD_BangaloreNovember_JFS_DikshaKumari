package com.capgemini.forestrymanagementsystem.dto;

import java.util.List;

public class CustomerResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<CustomerBean> customerBean;
	private CustomerBean getOneCustomer;
	public CustomerBean getGetOneCustomer() {
		return getOneCustomer;
	}
	public void setGetOneCustomer(CustomerBean getOneCustomer) {
		this.getOneCustomer = getOneCustomer;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public List<CustomerBean> getCustomerBean() {
		return customerBean;
	}
	public void setCustomerBean(List<CustomerBean> customerBean) {
		this.customerBean = customerBean;
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


