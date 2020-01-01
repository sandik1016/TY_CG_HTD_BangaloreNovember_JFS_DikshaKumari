package com.capgemini.springboot.dto;

import javax.persistence.CascadeType;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="emp_adddet")
public class EmployeeAddressBean {
	@Id
	@Column
	@GeneratedValue
	private int id;
	@Column(nullable=false)
	private String add_type;
	@Column
	private String add1;
	@Column
	private String add2;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAdd_type() {
		return add_type;
	}
	public void setAdd_type(String add_type) {
		this.add_type = add_type;
	}
	public String getAdd1() {
		return add1;
	}
	public void setAdd1(String add1) {
		this.add1 = add1;
	}
	public String getAdd2() {
		return add2;
	}
	public void setAdd2(String add2) {
		this.add2 = add2;
	}
	@JsonIgnore
   @ManyToOne(cascade = CascadeType.ALL)
	
	@JoinColumn(name="emp_id",referencedColumnName="id")//if id already exists in othr tble then give (name="emp_id",referencedColumnName ="id")
	private EmployeeBean bean;

public EmployeeBean getBean() {
	return bean;
}
public void setBean(EmployeeBean bean) {
	this.bean = bean;
}


}
