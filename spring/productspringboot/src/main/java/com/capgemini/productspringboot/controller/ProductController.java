package com.capgemini.productspringboot.controller;

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

import com.capgemini.productspringboot.dto.ProductBean;
import com.capgemini.productspringboot.dto.ProductResponse;
import com.capgemini.productspringboot.exception.ProductException;
import com.capgemini.productspringboot.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;
	
	
	@PostMapping(path="/register",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse addProduct(@RequestBody ProductBean bean){
		ProductResponse response = new ProductResponse();

		if(service.addProduct(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("product registered");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("product already exists");
		}


		return response;
	}
	
@GetMapping(path = "/get",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse getProduct(@RequestParam ("id")int id) {
		ProductResponse response = new ProductResponse();
		ProductBean beans =service.getProduct(id);
		if(beans==null)
		{
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Record with particular key doesn't found");

		}else {

			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Product found");
		}
		return response;
	}
	
	
	@GetMapping(path = "/getAll",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse getAllProduct() {
		ProductResponse response = new ProductResponse();
		List<ProductBean> beans =service.getAllProduct();
		if(beans==null)
		{
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Record doesn't found");

		}else {

			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("All Product found");
		}
		return response;
	}
	
	
	
	
	@PutMapping(path ="/change",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse updateProduct(@RequestBody ProductBean bean) {
		ProductResponse response = new ProductResponse();
		ProductBean bean1 = new ProductBean();
		bean1.setCost(bean.getCost());
		bean1.setImageUrl(bean.getImageUrl());
		bean1.setName(bean.getName());
		if(service.updateProduct(bean.getId(),bean1)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("product updated successfully");


		}
		else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("unable to change name");
		}
		return response;

	}
	
	@DeleteMapping(path="/delete/{id}",produces = MediaType.APPLICATION_JSON_VALUE) //make it handler method and send it as path variabl
	public ProductResponse deleteProduct(@PathVariable ("id")int id) throws ProductException {
		ProductResponse repsonse = new ProductResponse();
		service.deleteProduct(id);
			repsonse.setStatusCode(201);
			repsonse.setMessage("success");
			repsonse.setDescription("product details deleted successfully");
		return repsonse;
		//no @request body annotation so no consumes and we are not passing any object
		
	}
	
}
