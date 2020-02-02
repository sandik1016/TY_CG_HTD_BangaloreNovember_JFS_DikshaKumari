package com.capgemini.forestrymanagementsystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.capgemini.forestrymanagementsystem.dto.LandResponse;
import com.capgemini.forestrymanagementsystem.exception.LandException;

@RestControllerAdvice
public class LandControllerAdvice {
	@ExceptionHandler(LandException.class)
	public LandResponse handleLandException(LandException e) {
		LandResponse landResponse = new LandResponse();
		landResponse.setStatusCode(501);
		landResponse.setMessage("Exception");
		landResponse.setDescription(e.getMessage());
		return landResponse;
	}
}
