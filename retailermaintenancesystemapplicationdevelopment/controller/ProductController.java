package com.capgemini.retailermaintenancesystemapplicationdevelopment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.ProductBean;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.ProductResponse;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.service.ProductService;

@RestController
public class ProductController {
	@Autowired
	private ProductService service;

	@PostMapping(path = "/add-product", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse addProduct(@RequestBody ProductBean bean) {
		ProductResponse response = new ProductResponse();

		if (service.addProduct(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("product added successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Failed to add product details");
		}
		return response;
	}

	@GetMapping(path = "/search-product/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse searchProduct(@RequestParam("key") int key) {
		ProductResponse response = new ProductResponse();
		ProductBean beans = service.getProduct(key);
		if (beans == null) {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Record with particular key doesn't found");

		} else {

			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Details of Product found");
		}
		return response;
	}

	@GetMapping(path = "/getAll-product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse getAllProduct() {
		ProductResponse response = new ProductResponse();
		List<ProductBean> bean = service.getAllProducts();
		if (bean.size() == 0) {

			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Record  doesn't exists");

		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Product Record found");
			response.setProductBean(bean);

		}
		return response;

	}

}
