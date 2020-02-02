package com.capgemini.stockmanagement.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "investor_share")
public class InvestorShare {
	@Column
	@Id
	private int userId;
	@Column
	private String companyId;
	@Column
	private int totalSharesSold;
	@Column
	private double totalAmountSold;
	@Column
	private double totalAmountBought;
	@Column
	private int totalSharesBought;
	@Column
	private int availableShares;
	@Column
	private double availableAmount;
}
