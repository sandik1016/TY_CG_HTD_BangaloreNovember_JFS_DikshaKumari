package com.capgemini.forestrymanagementsystem.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.forestrymanagementsystem.dto.UserBean;
import com.capgemini.forestrymanagementsystem.dto.UserResponse;
import com.capgemini.forestrymanagementsystem.service.AdminService;
	@RestController
	@CrossOrigin(origins ="*",allowedHeaders="*",allowCredentials ="true")
	public class UserController {
		@Autowired
		private AdminService service;
		
		@PostMapping(path="/clientRegister",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
		public UserResponse clientRegister(@RequestBody UserBean bean) {
			UserResponse response = new UserResponse();

			if(service.clientRegister(bean)) {
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription("client registered successfully");
				
			}else {
				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("email already exists");
			}


			return response;
		}
		
		
		@PostMapping(path="/schedulerRegister",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
		public UserResponse schedulerRegister(@RequestBody UserBean bean) {
			UserResponse response = new UserResponse();

			if(service.schedulerRegister(bean)) {
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription("scheduler registered successfully");	
				
			}else {
				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("email already exists");
			}


			return response;
		}
		
		@DeleteMapping(path="/remove-scheduler/{email}",produces = MediaType.APPLICATION_JSON_VALUE) //make it handler method and send it as path variabl
		public UserResponse removeScheduler(@PathVariable ("email")String email) {
		     UserResponse response = new UserResponse();
			if(service.removeScheduler(email))
			{
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription("scheduler account deleted successfully");
			}else {
				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("Failed to delete scheduler account");
			}
			return response;
			
		}
		@DeleteMapping(path="/remove-client/{email}",produces = MediaType.APPLICATION_JSON_VALUE) //make it handler method and send it as path variabl
		public UserResponse removeClient(@PathVariable ("email")String email) {
		     UserResponse response = new UserResponse();
			if(service.removeClient(email))
			{
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription("client account deleted successfully");
			}else {
				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("Failed to delete client account");
			}
			return response;
			
		}
		@GetMapping(path = "/getAll-scheduler", produces = MediaType.APPLICATION_JSON_VALUE)
		public UserResponse showScheduler() {
			UserResponse response = new UserResponse();
			List<UserBean> bean = service.showScheduler();
			if(bean.size()==0) {

				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("Record  doesn't exit");

			} else {
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription("Scheduler account found");
				response.setUserBean(bean);

			}
			return response;

		}
		@GetMapping(path = "/getAll-client", produces = MediaType.APPLICATION_JSON_VALUE)
		public UserResponse showClients() {
			UserResponse response = new UserResponse();
			List<UserBean> bean = service.showClients();
			if(bean.size()==0) {

				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("Record  doesn't exit");

			} else {
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription("Client account found");
				response.setUserBean(bean);

			}
			return response;

		}
		
//		@GetMapping(path = "/view-account",produces = MediaType.APPLICATION_JSON_VALUE)
//		public UserResponse viewAccounts(@RequestBody UserBean bean ) {
//			SchedulerResponse response = new SchedulerResponse();
//			SchedulerBean beans =service.getSchedule(id);
//			if(beans!=null)
//			{
//				response.setStatusCode(201);
//			response.setMessage("success");
//			response.setDescription("Scheduled details found");
//				response.setGetOneScheduler(beans);
//			}else {
//				response.setStatusCode(401);
//				response.setMessage("failure");
//				response.setDescription("Record with particular id doesn't found");
//				
//			}
//			return response;
//		}
		
		
		@PutMapping(path ="/change-password",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
		public UserResponse changePassword(@RequestBody UserBean bean) {
			UserResponse response = new UserResponse();
			if(service.changePassword(bean.getEmail(), bean.getPassword())) {
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
}
