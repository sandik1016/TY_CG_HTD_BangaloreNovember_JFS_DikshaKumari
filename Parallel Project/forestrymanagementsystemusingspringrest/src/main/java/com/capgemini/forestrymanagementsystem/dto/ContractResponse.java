package com.capgemini.forestrymanagementsystem.dto;

import java.util.List;

public class ContractResponse {
	private int statusCode;
	private String message;
	private String description;
	private List<ContractBean> contractBean;
	private ContractBean getOneContract;
	public ContractBean getGetOneContract() {
		return getOneContract;
	}
	public void setGetOneContract(ContractBean getOneContract) {
		this.getOneContract = getOneContract;
	}
	public int getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}
	public List<ContractBean> getContractBean() {
		return contractBean;
	}
	public void setContractBean(List<ContractBean> contractBean) {
		this.contractBean = contractBean;
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
