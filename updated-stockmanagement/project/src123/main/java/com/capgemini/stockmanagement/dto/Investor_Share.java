
package com.capgemini.stockmanagement.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name ="investor_share")
public class Investor_Share {
	@Id
	@Column
	@GeneratedValue
	private int shareId;
	@Column(nullable=false)
	private int userId;
	@Column(nullable=false)
	private String companyId;
	@Column(nullable=false)
	private int totalSharesSold;
	@Column(nullable=false)
	private double totalAmountSold;
	@Column(nullable=false)
	private double totalAmountBought;
	@Column(nullable=false)
	private int totalSharesBought;
	@Column(nullable=false)
	private int availableShares;
	@Column(nullable=false)
	private double availableAmount;

}
