package com.capgemini.stockmanagement.controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.capgemini.stockmanagement.dto.InvestorResponse;
import com.capgemini.stockmanagement.exception.ValidationException;

@RestControllerAdvice 
public class InvestorControllerAdvice {
	@ExceptionHandler(ValidationException.class)
	public InvestorResponse handleInvestorException(ValidationException e) {
		InvestorResponse investorResponse = new InvestorResponse();
		investorResponse.setStatusCode(501);
		investorResponse.setMessage("Exception");
		investorResponse.setDescription(e.getMessage());
		return investorResponse;
	}
}
