package com.capgemini.retailermaintenancesystemapplicationdevelopment.dto;

import java.util.List;

public class OrderResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<OrderBean> orderBean;

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public List<OrderBean> getOrderBean() {
		return orderBean;
	}

	public void setOrderBean(List<OrderBean> orderBean) {
		this.orderBean = orderBean;
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
