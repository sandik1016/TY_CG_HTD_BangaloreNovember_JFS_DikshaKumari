package com.capgemini.forestrymanagementsystem.controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.capgemini.forestrymanagementsystem.dto.UserResponse;
import com.capgemini.forestrymanagementsystem.exception.UserException;

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