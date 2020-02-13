package com.capgemini.stockmanagement.exception;

public class AvaliableSharesExceedsException extends RuntimeException {

	String message;

	public AvaliableSharesExceedsException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
