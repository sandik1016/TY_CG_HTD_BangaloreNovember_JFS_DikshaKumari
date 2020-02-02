package com.capgemini.forestmanagementsystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="land")
public class LandBean {
	@Id
	@Column
	private int landId;
	@Column
	private String landLocation;
	@Column
	private double landCost;
	@Column
	private String acquiredDate;
}
