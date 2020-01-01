package com.capgemini.forestrymanagementsystem.exception;

public class CustomerIdNotFoundException extends Exception {
	String str;
	public CustomerIdNotFoundException(String message) {
		str=message;
	}
	@Override
	public String toString() {
		return "CustomerIdNotFoundException [Exception=" + str + "]";
	}
	

}
