package com.capg.jpawithhibernate.manttomany;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.capge.jpawithhibernate.onetoone.EmployeeInfo;

import lombok.Data;
@Data
@Entity
@Table(name="TrainingInfo")
public class TrainingInfo {
	@Id
	@Column
	private int tid;
	@Column
	private String tname;
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name="training_employee",//intermediate table 
	joinColumns = @JoinColumn(name="tid"),
	inverseJoinColumns = @JoinColumn(name="eid"))
private List<EmployeeInfo> emp;
	

}
