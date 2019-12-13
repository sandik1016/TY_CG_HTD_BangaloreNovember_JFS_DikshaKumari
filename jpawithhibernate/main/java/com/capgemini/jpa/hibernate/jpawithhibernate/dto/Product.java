package com.capgemini.jpa.hibernate.jpawithhibernate.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
@Data
@Entity
@Table(name="product_info")
public class Product {
	@Id
	@Column
	private int pid;
	@Column
	private String name;
	

}
