package com.capgemini.module1.bean;
import java.io.Serializable;
import lombok.Data;
@Data
public class ContactBean implements Serializable{
	private String name;
	private String number;
	private String group;
}
