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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.forestrymanagementsystem.dto.CustomerBean;
import com.capgemini.forestrymanagementsystem.dto.CustomerResponse;
import com.capgemini.forestrymanagementsystem.service.CustomerService;


	@RestController
	@CrossOrigin(origins ="*",allowedHeaders="*",allowCredentials ="true")
	public class CustomerController {
		@Autowired
		private CustomerService service;

		@PostMapping(path="/add-customer",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
		public CustomerResponse register(@RequestBody CustomerBean bean) {
			CustomerResponse response = new CustomerResponse();

			if(service.addCustomer(bean)) {
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription("customer registered successfully");
			}else {
				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("Failed to add customer details");
			}
			return response;
		}
		@GetMapping(path = "/search-customer",produces = MediaType.APPLICATION_JSON_VALUE)
		public CustomerResponse searchCustomer(@RequestParam ("id")int id) {
			CustomerResponse response = new CustomerResponse();
			CustomerBean beans =service.getCustomer(id);
			if(beans!=null)
			{
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription("Details of Customer found");
				response.setGetOneCustomer(beans);
			}else {
				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("Record with particular id doesn't found");
				
			}
			return response;
		}
		@DeleteMapping(path="/delete-customer/{id}",produces = MediaType.APPLICATION_JSON_VALUE) //make it handler method and send it as path variabl
		public CustomerResponse deleteCustomer(@PathVariable ("id")int id) {
			CustomerResponse response = new CustomerResponse();
			if(service.deleteCustomer(id))
			{
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription("customer details deleted successfully");
			}else {
				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("Failed to delete customer details");
			}
			return response;
			
		}
		@GetMapping(path = "/getAll-customer", produces = MediaType.APPLICATION_JSON_VALUE)
		public CustomerResponse getAllProduct() {
			CustomerResponse response = new CustomerResponse();
			List<CustomerBean> bean = service.getAllCustomers();
			if(bean.size()==0) {

				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("Record  doesn't exit");

			} else {
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription("Customer Record found");
				response.setCustomerBean(bean);

			}
			return response;

		}
		
		@PutMapping(path = "/modify-customer", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
		public CustomerResponse updateCustomer(@RequestBody CustomerBean bean) {
			CustomerResponse response = new CustomerResponse();
			CustomerBean customerBean = new CustomerBean();
			customerBean.setCustomerId(bean.getCustomerId());
			customerBean.setCustomerName(bean.getCustomerName());
			customerBean.setCustomerAddress(bean.getCustomerAddress());
			customerBean.setCustomerEmail(bean.getCustomerEmail());
			customerBean.setCustomerPhone(bean.getCustomerPhone());
			customerBean.setCustomerPostal(bean.getCustomerPostal());
			customerBean.setCustomerTown(bean.getCustomerTown());
			if (service.modifyCustomer(bean.getCustomerId(), customerBean)) {
				response.setStatusCode(201);
				response.setMessage("success");
				response.setDescription(" Customer updated successfully");
			} else {
				response.setStatusCode(401);
				response.setMessage("failure");
				response.setDescription("unable to update customer details");
			}
			return response;
		}
		
		

	}


