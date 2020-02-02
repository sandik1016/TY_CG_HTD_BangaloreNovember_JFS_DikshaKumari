package com.capgemini.forestrymanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="scheduler")
public class SchedulerBean {
	@Id
	@Column
	@GeneratedValue
	private int scheduleId;
	@Column
    private int contractId;
	@Column
	private String deliveryDate;
	@Column
	private String status;
}
