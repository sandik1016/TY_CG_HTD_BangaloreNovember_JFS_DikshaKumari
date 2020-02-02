package com.capgemini.forestrymanagementsystem.dto;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="contract")
public class ContractBean {
	@Id
	@Column
	@GeneratedValue
	private int contractId;
	@Column
	private int customerId;
	@Column
	private int productId;
	@Column 
	private int quantity;
	@Column
	private String deliveryDate;
}
