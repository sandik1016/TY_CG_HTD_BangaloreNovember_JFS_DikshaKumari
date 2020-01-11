package com.capgemini.retailermaintenancesystemapplicationdevelopment.dto;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "user_info")
public class UserBean {
	@Id
	@Column
	@GeneratedValue
	int userId;
	@Column
	String name;
	@Column(nullable = false, unique = true)
	String email;
	@Column
	String password;
}
