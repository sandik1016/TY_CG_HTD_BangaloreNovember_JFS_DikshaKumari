package com.capgemini.forestrymanagementsystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.capgemini.forestrymanagementsystem.dto.CustomerResponse;
import com.capgemini.forestrymanagementsystem.exception.CustomerException;

@RestControllerAdvice 
public class CustomerControllerAdvice {
	@ExceptionHandler(CustomerException.class)
	public CustomerResponse handleCustomerException(CustomerException e) {
		CustomerResponse customerResponse = new CustomerResponse();
		customerResponse.setStatusCode(501);
		customerResponse.setMessage("Exception");
		customerResponse.setDescription(e.getMessage());
		return customerResponse;
	}
}
