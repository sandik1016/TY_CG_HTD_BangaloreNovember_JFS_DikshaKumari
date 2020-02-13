package com.capgemini.stockmanagement.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.capgemini.stockmanagement.dto.CompanyResponse;
import com.capgemini.stockmanagement.exception.ValidationException;
@RestControllerAdvice 
public class CompanyControllerAdvice {
	@ExceptionHandler(ValidationException.class)
	public CompanyResponse handleCustomerException(ValidationException e) {
		CompanyResponse companyResponse = new CompanyResponse();
		companyResponse.setStatusCode(501);
		companyResponse.setMessage("Exception");
		companyResponse.setDescription(e.getMessage());
		return companyResponse;
	}
}
