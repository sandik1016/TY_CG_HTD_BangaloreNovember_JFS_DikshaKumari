package com.capgemini.forestrymanagementsystem.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.forestrymanagementsystem.dto.UserBean;
import com.capgemini.forestrymanagementsystem.dto.UserResponse;

import com.capgemini.forestrymanagementsystem.service.LoginService;
@RestController
@CrossOrigin(origins ="*",allowedHeaders="*",allowCredentials ="true")
public class LoginController {
	@Autowired
	private LoginService service;
	@PostMapping(path="/adminLogin",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse adminLogin(@RequestBody UserBean bean) {
		UserResponse response = new UserResponse();
		UserBean admin = service.adminLogin(bean.getEmail(), bean.getPassword());
		if(admin!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("admin found for given credential");
			response.setUserBean(Arrays.asList(admin));
		}
		else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Invalid credential");
		}
		return response;
	}
	
	@PostMapping(path="/clientLogin",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse clientLogin(@RequestBody UserBean bean) {
		UserResponse response = new UserResponse();
		UserBean client = service.clientLogin(bean.getEmail(), bean.getPassword());
		if(client!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("client found for given credential");
			response.setUserBean(Arrays.asList(client));
		}
		else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Invalid credential");
		}
		return response;
	}
	@PostMapping(path="/schedulerLogin",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse schedulerLogin(@RequestBody UserBean bean) {
		UserResponse response = new UserResponse();
	UserBean scheduler = service.schedulerLogin(bean.getEmail(), bean.getPassword());
	if(scheduler!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("scheduler found for given credential");
			response.setUserBean(Arrays.asList(scheduler));
		}
		else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Invalid credential");
		}
		return response;
	}
}
