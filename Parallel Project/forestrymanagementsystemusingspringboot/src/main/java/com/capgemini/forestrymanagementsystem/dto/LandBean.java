package com.capgemini.forestrymanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="land")
public class LandBean {
	@Id
	@Column
	@GeneratedValue
	private int landId;
	@Column
	private String landLocation;
	@Column
	private double landCost;
	@Column
	private String acquiredDate;
}
