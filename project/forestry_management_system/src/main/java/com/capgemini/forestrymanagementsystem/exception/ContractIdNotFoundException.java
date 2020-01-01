package com.capgemini.forestrymanagementsystem.exception;

public class ContractIdNotFoundException extends Exception {
	String str;
	public ContractIdNotFoundException(String message) {
		str=message;
	}
	@Override
	public String toString() {
		return "ContractIdNotFoundException [Exception=" + str + "]";
	}
	
}
