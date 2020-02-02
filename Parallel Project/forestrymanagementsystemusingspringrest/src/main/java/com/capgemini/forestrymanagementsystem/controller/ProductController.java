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
import com.capgemini.forestrymanagementsystem.dto.ProductBean;
import com.capgemini.forestrymanagementsystem.dto.ProductResponse;
import com.capgemini.forestrymanagementsystem.service.ProductService;

@RestController
@CrossOrigin(origins ="*",allowedHeaders="*",allowCredentials ="true")
public class ProductController {
	@Autowired
	private ProductService service;

	@PostMapping(path="/add-product",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse register(@RequestBody ProductBean bean) {
		ProductResponse response = new ProductResponse();

		if(service.addProduct(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("product added successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Failed to add product details");
		}
		return response;
	}
	@GetMapping(path = "/search-product",produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse searchProduct(@RequestParam ("id")int id) {
		ProductResponse response = new ProductResponse();
	    ProductBean bean =service.getProduct(id);
	    if(bean!=null)
		{
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Details of product found");
			response.setGetOneProduct(bean);

		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Record with particular id doesn't found");
		}
		return response;
	}
	@DeleteMapping(path="/delete-product/{id}",produces = MediaType.APPLICATION_JSON_VALUE) //make it handler method and send it as path variabl
	public ProductResponse deleteProduct(@PathVariable ("id")int id) {
		ProductResponse response = new ProductResponse();
		if(service.deleteProduct(id))
		{
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("product details deleted successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Failed to delete product details");
		}
		return response;
		
	}
	@GetMapping(path = "/getAll-product", produces = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse getAllProduct() {
		ProductResponse response = new ProductResponse();
		List<ProductBean> bean = service.getAllProduct();
		if(bean.size()==0) {

			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Record doesn't exit");

		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription(" Product Record found");
			response.setProductBean(bean);

		}
		return response;

	}
	
	@PutMapping(path = "/modify-product", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ProductResponse updateProduct(@RequestBody ProductBean bean) {
		ProductResponse response = new ProductResponse();
		ProductBean productBean = new ProductBean();
		productBean.setProductId(bean.getProductId());
		productBean.setProductName(bean.getProductName());
		productBean.setProductQuantity(bean.getProductQuantity());
		
		if (service.modifyProduct(bean.getProductId(),productBean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Product updated successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("unable to update product details");
		}
		return response;
	}
}
