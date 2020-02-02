package com.capgemini.forestmanagementsystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="customer")
public class CustomerBean {
	@Id
	@Column
	private int customerId;
	@Column
	private String customerName;
	@Column
	private String customerTown;
	@Column
	private String customerAddress;
	@Column
	private String customerPostal;
	@Column
	private String customerEmail;
	@Column
	private  String customerPhone;
}
