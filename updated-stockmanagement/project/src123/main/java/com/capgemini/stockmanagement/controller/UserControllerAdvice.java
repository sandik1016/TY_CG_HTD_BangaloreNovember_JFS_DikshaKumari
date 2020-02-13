package com.capgemini.stockmanagement.controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.capgemini.stockmanagement.dto.UserResponse;
import com.capgemini.stockmanagement.exception.ValidationException;

@RestControllerAdvice 
public class UserControllerAdvice {
	@ExceptionHandler(ValidationException.class)
	public UserResponse handleUserException(ValidationException e) {
		UserResponse userResponse = new UserResponse();
		userResponse.setStatusCode(501);
		userResponse.setMessage("Exception");
		userResponse.setDescription(e.getMessage());
		return userResponse;
	}
}
