package com.capgemini.forestrymanagementsystem.bean;

public class HaulierBean {
	@Override
	public String toString() {
		return "HaulierBean [haulId=" + haulId + ", haulContactNo=" + haulContactNo + ", haulName=" + haulName
				+ ", productId=" + productId + ", clientId=" + clientId + ", source=" + source + ", destination="
				+ destination + "]";
	}
	private int haulId;
    private String haulContactNo;
    private String haulName;
    private int productId;
    private int clientId;
    private String source;
    private String destination;
	public int getHaulId() {
		return haulId;
	}
	
	public String getHaulContactNo() {
		return haulContactNo;
	}

	public void setHaulContactNo(String haulContactNo) {
		this.haulContactNo = haulContactNo;
	}

	public void setHaulId(int haulId) {
		this.haulId = haulId;
	}
	public String getHaulName() {
		return haulName;
	}
	public void setHaulName(String haulName) {
		this.haulName = haulName;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	
	public int getClientId() {
		return clientId;
	}

	public void setClientId(int clientId) {
		this.clientId = clientId;
	}

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
}
