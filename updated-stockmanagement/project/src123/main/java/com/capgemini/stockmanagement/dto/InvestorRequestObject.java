package com.capgemini.stockmanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "investor_request")
public class InvestorRequestObject {
	@Id
	@Column
	private int userId;
	@Column
	private String companyId;
	@Column
	private int totalSharesTransacted;
	@Column
	private double totalAmount;

}
