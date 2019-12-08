package com.tyss.access.pack1;

public class Student {
protected String studName;

protected Student(String studName) {
	this.studName=studName;
}
protected void studDetails() {
	System.out.println("Student name is "+studName);
}
}
