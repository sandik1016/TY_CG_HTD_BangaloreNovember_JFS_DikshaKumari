package com.capgemini.forestrymanagementsystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;

import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.capgemini.forestrymanagementsystem.dto.SchedulerResponse;
import com.capgemini.forestrymanagementsystem.exception.SchedulerException;
@RestControllerAdvice 
public class SchedulerControllerAdvice {
	@ExceptionHandler(SchedulerException.class)
	public SchedulerResponse handleSchedulerException(SchedulerException e) {
		SchedulerResponse schedulerResponse = new SchedulerResponse();
		schedulerResponse.setStatusCode(501);
		schedulerResponse.setMessage("Exception");
		schedulerResponse.setDescription(e.getMessage());
		return schedulerResponse;
	}
}
