package com.capgemini.stockmanagement.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.stockmanagement.dto.CompanyResponse;
import com.capgemini.stockmanagement.exception.MaxAmountExceedsException;

@RestControllerAdvice
public class AmountExceedsAdvice {
	
	@ExceptionHandler(MaxAmountExceedsException.class)
	public CompanyResponse handleException (MaxAmountExceedsException e) {
		CompanyResponse response = new CompanyResponse();
		response.setStatusCode(501);
		response.setMessage("Exception");
		response.setDescription(e.getMessage());
		return response;
	}
}
