package com.capgemini.retailermaintenancesystemapplicationdevelopment.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.ProductResponse;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.exception.ProductException;

@RestControllerAdvice
public class ProductControllerAdvice {
	@ExceptionHandler(ProductException.class)
	public ProductResponse handleProductException(ProductException e) {
		ProductResponse productResponse = new ProductResponse();
		productResponse.setStatusCode(501);
		productResponse.setMessage("Exception");
		productResponse.setDescription(e.getMessage());
		return productResponse;
	}
}