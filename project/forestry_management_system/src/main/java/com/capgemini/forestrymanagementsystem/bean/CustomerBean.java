
package com.capgemini.forestrymanagementsystem.bean;

import java.io.Serializable;

public class CustomerBean implements Serializable{
	private int customerId;
	private String name;
	private String town;
	private String streetAddress;
	private String postal;
	private String email;
	private  String phone;
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	
	@Override
	public String toString() {
		return "CustomerBean [customerId=" + customerId + ", name=" + name + ", town=" + town + ", streetAddress=" + streetAddress
				+ ", postal=" + postal + ", email=" + email + ", phone=" + phone + "]";
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTown() {
		return town;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getPostal() {
		return postal;
	}
	public void setPostal(String postal) {
		this.postal = postal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
}
