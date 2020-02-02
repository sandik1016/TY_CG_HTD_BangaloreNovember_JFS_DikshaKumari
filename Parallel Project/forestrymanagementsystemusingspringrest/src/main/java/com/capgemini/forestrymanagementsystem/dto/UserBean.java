package com.capgemini.forestrymanagementsystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "account_login")
public class UserBean {
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;
	@Column(name = "email",unique=true,nullable=false)
	private String email;
	@Column(name = "password")
	private String password;
	@Column(name = "user_type")
	private String user_type;

}
