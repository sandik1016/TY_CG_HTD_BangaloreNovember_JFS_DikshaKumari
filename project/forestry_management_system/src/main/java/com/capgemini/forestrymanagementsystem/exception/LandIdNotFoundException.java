package com.capgemini.forestrymanagementsystem.exception;

public class LandIdNotFoundException extends Exception {
	String str;
	public LandIdNotFoundException(String message) {
		str=message;
	}
	@Override
	public String toString() {
		return "LandIdNotFoundException [Exception=" + str + "]";
	}
}
