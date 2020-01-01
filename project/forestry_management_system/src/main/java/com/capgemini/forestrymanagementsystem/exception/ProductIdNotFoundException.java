package com.capgemini.forestrymanagementsystem.exception;

public class ProductIdNotFoundException extends Exception {
	String str;
	public ProductIdNotFoundException(String message) {
		str= message;
	}
	@Override
	public String toString() {
		return "ProductIdNotFoundException [Exception=" + str + "]";
	}

}
