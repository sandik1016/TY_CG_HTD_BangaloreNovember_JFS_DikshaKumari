package com.capgemini.forestrymanagementsystem.exception;

public class HaulierIdNotFoundException extends Exception {
	String str;
		public HaulierIdNotFoundException(String message) {
			str=message;
		}
		@Override
		public String toString() {
			return "HaulierIdNotFoundException [Exception=" + str + "]";
		}
}

