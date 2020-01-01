package com.capgemini.springboot.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.springboot.dto.EmployeeBean;
import com.capgemini.springboot.dto.EmployeeResponse;
import com.capgemini.springboot.service.EmployeeService;
@RestController//in order to make it handler method
public class EmployeeController {
	@Autowired
	private EmployeeService service;
	@PostMapping(path="/auth",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse auth(@RequestBody EmployeeBean bean) {
		EmployeeBean employeeBean = service.auth(bean.getEmail(), bean.getPassword());

		EmployeeResponse response = new EmployeeResponse();
		if(employeeBean!=null) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("employee found for credential");
			response.setBeans(Arrays.asList(employeeBean));

		}
		else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("invalid credential");
		}
		return response;
	}
	@PostMapping(path="/register",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse register(@RequestBody EmployeeBean bean) {
		EmployeeResponse response = new EmployeeResponse();

		if(service.register(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("employee registered");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("email already exists");
		}


		return response;
	}
	@GetMapping(path = "/get",produces = MediaType.APPLICATION_JSON_VALUE)//it never has consume here get is used
	public EmployeeResponse searchEmployee(@RequestParam ("key")String key) {
		EmployeeResponse response = new EmployeeResponse();
		List<EmployeeBean> beans =service.getEmployees(key);
		if(beans.isEmpty())
		{
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Record with particular key doesn't found");

		}else {

			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Employee found");
		}
		return response;
	}
	@PutMapping(path ="/change-password",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResponse changePassword(@RequestBody EmployeeBean bean) {
		EmployeeResponse response = new EmployeeResponse();
		if(service.changePassword(bean.getId(), bean.getPassword())) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("password changed successfully");


		}
		else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("unable to change password");
		}
		return response;

	}
	
	@DeleteMapping(path="/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE) //make it handler method and send it as path variabl
	public EmployeeResponse deleteEmployee(@PathVariable ("id")int id) {
		EmployeeResponse repsonse = new EmployeeResponse();
		service.deleteEmployee(id);
			repsonse.setStatusCode(201);
			repsonse.setMessage("success");
			repsonse.setDescription("employee details deleted successfully");
		return repsonse;
		//no @request body annotation so no consumesand we are not passing any object
		
	}
}
