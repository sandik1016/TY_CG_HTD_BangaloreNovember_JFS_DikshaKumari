package com.capgemini.forestrymanagementsystem.dto;

import java.util.List;

public class UserResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<UserBean> userBean;
	private UserBean getOneUser;
	
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public List<UserBean> getUserBean() {
		return userBean;
	}
	public void setUserBean(List<UserBean> userBean) {
		this.userBean = userBean;
	}
	public UserBean getGetOneUser() {
		return getOneUser;
	}
	public void setGetOneUser(UserBean getOneUser) {
		this.getOneUser = getOneUser;
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
