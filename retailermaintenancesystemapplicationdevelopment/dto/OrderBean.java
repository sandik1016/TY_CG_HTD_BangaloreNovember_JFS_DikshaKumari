package com.capgemini.retailermaintenancesystemapplicationdevelopment.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "order_info")
public class OrderBean {
	@Id
	@Column
	@GeneratedValue
	int orderId;
	@Column
	int productId;
	@Column
	int userId;
	@Column
	int productQuantity;
}
