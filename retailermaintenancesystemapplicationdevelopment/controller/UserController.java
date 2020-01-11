package com.capgemini.retailermaintenancesystemapplicationdevelopment.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.UserBean;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.UserResponse;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.service.UserService;

@RestController
public class UserController {
	@Autowired
	private UserService service;

	@PostMapping(path = "/auth", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse authentication(@RequestBody UserBean bean) {
		UserBean userBean = service.authentication(bean.getEmail(), bean.getPassword());

		UserResponse response = new UserResponse();
		if (userBean != null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("user found for given credential");
			response.setUserBean(Arrays.asList(userBean));

		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("invalid credential");
		}
		return response;
	}

	@PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse register(@RequestBody UserBean bean) {
		UserResponse response = new UserResponse();

		if (service.registerUser(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Yeah....user registered successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Failed...email already exists");
		}

		return response;
	}

	@PutMapping(path = "/change-password", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public UserResponse changePassword(@RequestBody UserBean bean) {
		UserResponse response = new UserResponse();
		if (service.changePassword(bean.getEmail(), bean.getPassword())) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("password changed successfully");

		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("unable to change password");
		}
		return response;

	}
}
