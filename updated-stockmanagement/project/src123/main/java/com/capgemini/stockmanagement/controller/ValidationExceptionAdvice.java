package com.capgemini.stockmanagement.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.stockmanagement.dto.StockResponse;
import com.capgemini.stockmanagement.exception.ValidationException;

@RestControllerAdvice
public class ValidationExceptionAdvice {

	@ExceptionHandler(ValidationException.class)
	public StockResponse handleException (ValidationException e) {
		StockResponse response = new StockResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}
}
