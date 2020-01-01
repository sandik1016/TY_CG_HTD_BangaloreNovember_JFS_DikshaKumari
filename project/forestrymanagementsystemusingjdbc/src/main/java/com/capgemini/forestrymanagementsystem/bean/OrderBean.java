package com.capgemini.forestrymanagementsystem.bean;

public class OrderBean {
	private int orderno;
    private int custid;
    private int haulid;
    private int prodid;
    private int quantity;
    private String deliverydate;
	public int getOrderno() {
		return orderno;
	}
	public void setOrderno(int orderno) {
		this.orderno = orderno;
	}
	public int getCustid() {
		return custid;
	}
	public void setCustid(int custid) {
		this.custid = custid;
	}
	public int getHaulid() {
		return haulid;
	}
	public void setHaulid(int haulid) {
		this.haulid = haulid;
	}
	public int getProdid() {
		return prodid;
	}
	public void setProdid(int prodid) {
		this.prodid = prodid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getDeliverydate() {
		return deliverydate;
	}
	public void setDeliverydate(String deliverydate) {
		this.deliverydate = deliverydate;
	}
}
