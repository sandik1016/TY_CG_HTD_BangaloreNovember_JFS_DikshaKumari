package com.capgemini.forestmanagementsystem.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table (name="scheduler")
public class SchedulerBean {
	@Id
	@Column
	private int scheduleId;
	@Column
    private int contractId;
	@Column
	private String deliveryDate;
	@Column
	private String status;
}
