package com.capgemini.retailermaintenancesystemapplicationdevelopment.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "product_info")
public class ProductBean {
	@Id
	@Column
	@GeneratedValue
	int productId;
	@Column
	String name;
	@Column
	int quantity;
	@Column
	String details;
	@Column
	double price;

}
