package com.capgemini.forestrymanagementsystem.dto;

import java.util.List;

public class SchedulerResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<SchedulerBean> schedulerBean;
	private SchedulerBean getOneScheduler;
	public SchedulerBean getGetOneScheduler() {
		return getOneScheduler;
	}
	public void setGetOneScheduler(SchedulerBean getOneScheduler) {
		this.getOneScheduler = getOneScheduler;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	
	public List<SchedulerBean> getSchedulerBean() {
		return schedulerBean;
	}
	public void setSchedulerBean(List<SchedulerBean> schedulerBean) {
		this.schedulerBean = schedulerBean;
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
