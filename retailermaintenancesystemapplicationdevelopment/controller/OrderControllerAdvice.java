package com.capgemini.retailermaintenancesystemapplicationdevelopment.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.OrderResponse;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.exception.OrderException;

@RestControllerAdvice
public class OrderControllerAdvice {
	@ExceptionHandler(OrderException.class)
	public OrderResponse handleOrderException(OrderException e) {
		OrderResponse orderResponse = new OrderResponse();
		orderResponse.setStatusCode(501);
		orderResponse.setMessage("Exception");
		orderResponse.setDescription(e.getMessage());
		return orderResponse;
	}
}