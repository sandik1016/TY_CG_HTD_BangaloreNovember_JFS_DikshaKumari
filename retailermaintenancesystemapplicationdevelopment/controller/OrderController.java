package com.capgemini.retailermaintenancesystemapplicationdevelopment.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.OrderBean;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.dto.OrderResponse;
import com.capgemini.retailermaintenancesystemapplicationdevelopment.service.OrderService;

@RestController // in order to make it handler method
public class OrderController {
	@Autowired
	private OrderService service;

	@PostMapping(path = "/add-order", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public OrderResponse addOrder(@RequestBody OrderBean bean) {
		OrderResponse response = new OrderResponse();

		if (service.addOrder(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("order added successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Failed to add order details");
		}
		return response;
	}

	@GetMapping(path = "/search-order/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderResponse searchCustomer(@RequestParam("key") int key) {
		OrderResponse response = new OrderResponse();
		OrderBean beans = service.getOrder(key);
		if (beans == null) {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Record with particular key doesn't found");

		} else {

			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Details of Order found");
		}
		return response;
	}

	@GetMapping(path = "/getAll-order", produces = MediaType.APPLICATION_JSON_VALUE)
	public OrderResponse getAllProduct() {
		OrderResponse response = new OrderResponse();
		List<OrderBean> bean = service.getAllOrders();
		if (bean.size() == 0) {

			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Record  doesn't exists");

		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Order Record found");
			response.setOrderBean(bean);

		}
		return response;

	}
}
