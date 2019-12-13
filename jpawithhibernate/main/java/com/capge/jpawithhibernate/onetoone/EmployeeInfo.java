package com.capge.jpawithhibernate.onetoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode.Exclude;

@Data
@Entity
@Table (name="emp_info")
public class EmployeeInfo {
	
@Id
@Column
private int eid;
@Column
private String ename;
@Column
private String email;
@Column
private String password;
//code for bidirectional
@Exclude 
@OneToOne(cascade=CascadeType.ALL,mappedBy="empInfo")
private EmployeeOthrInfo other;
}
