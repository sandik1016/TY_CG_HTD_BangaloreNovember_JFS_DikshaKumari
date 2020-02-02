package com.capgemini.forestrymanagementsystem.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.capgemini.forestrymanagementsystem.dto.ContractResponse;
import com.capgemini.forestrymanagementsystem.exception.ContractException;


@RestControllerAdvice
public class ContractControllerAdvice {
	@ExceptionHandler(ContractException.class)
	public ContractResponse handleContractException(ContractException e) {
		ContractResponse contractResponse = new ContractResponse();
		contractResponse.setStatusCode(501);
		contractResponse.setMessage("Exception");
		contractResponse.setDescription(e.getMessage());
		return contractResponse;
	}
}
