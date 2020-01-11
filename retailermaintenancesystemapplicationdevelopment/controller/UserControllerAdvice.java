package com.capgemini.retailermaintenancesystemapplicationdevelopment.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.UserResponse;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.exception.UserException;

@RestControllerAdvice
public class UserControllerAdvice {
	@ExceptionHandler(UserException.class)
	public UserResponse handleUserException(UserException e) {
		UserResponse userResponse = new UserResponse();
		userResponse.setStatusCode(501);
		userResponse.setMessage("Exception");
		userResponse.setDescription(e.getMessage());
		return userResponse;
	}
}
