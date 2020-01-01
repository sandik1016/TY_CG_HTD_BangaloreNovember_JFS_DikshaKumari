package com.capgemini.forestrymanagementsystem.exception;

public class SchedulerIdNotFoundException extends Exception {
	String str;
	public SchedulerIdNotFoundException(String message) {
		str=message;
	}
	@Override
	public String toString() {
		return "SchedulerIdNotFoundException [Exception=" + str + "]";
	}

}
