package com.cape.jpawithhibernate.manytoone;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.capge.jpawithhibernate.onetoone.EmployeeInfo;
import com.capge.jpawithhibernate.onetoone.EmployeeOthrInfo;

import lombok.Data;

@Data
@Entity
@Table(name="EmployeeExperience")

public class EmployeeExperience {
	@Id
	@Column
	private int expId;    
	@Column
	private String compName;
	@Column
	private int expYrs;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="eid")
	private EmployeeInfo empInfo;
	
	

}
