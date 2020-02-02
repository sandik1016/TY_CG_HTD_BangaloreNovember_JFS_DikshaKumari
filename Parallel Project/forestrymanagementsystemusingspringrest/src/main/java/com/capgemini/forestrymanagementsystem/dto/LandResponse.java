package com.capgemini.forestrymanagementsystem.dto;

import java.util.List;
public class LandResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<LandBean> landBean;
	private LandBean getOneLand;
	public LandBean getGetOneLand() {
		return getOneLand;
	}
	public void setGetOneLand(LandBean getOneLand) {
		this.getOneLand = getOneLand;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public List<LandBean> getLandBean() {
		return landBean;
	}
	public void setLandBean(List<LandBean> landBean) {
		this.landBean = landBean;
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
