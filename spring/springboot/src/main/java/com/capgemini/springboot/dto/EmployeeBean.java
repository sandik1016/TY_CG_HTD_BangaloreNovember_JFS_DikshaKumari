package com.capgemini.springboot.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="emp_info")
public class EmployeeBean {
	@Id
	@Column
	@GeneratedValue//it will take auto
	private int id;
	@Column
	private String name;
	@Column(unique = true,nullable = false)//bydefault it is false
	private String email;
	@Column
	private String password;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	
	public List<EmployeeAddressBean> getOther() {
		return other;
	}
	public void setOther(List<EmployeeAddressBean> other) {
		this.other = other;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@OneToMany(cascade=CascadeType.ALL,mappedBy="bean")
	private List<EmployeeAddressBean> other;

}
