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
import com.capgemini.forestrymanagementsystem.dto.LandBean;
import com.capgemini.forestrymanagementsystem.dto.LandResponse;
import com.capgemini.forestrymanagementsystem.service.LandService;

@RestController
@CrossOrigin(origins ="*",allowedHeaders="*",allowCredentials ="true")
public class LandController {
	@Autowired
	private LandService service;

	@PostMapping(path="/add-land",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public LandResponse register(@RequestBody LandBean bean) {
		LandResponse response = new LandResponse();

		if(service.addLand(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("land registered successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Failed to add land details");
		}
		return response;
	}
	@GetMapping(path = "/search-land",produces = MediaType.APPLICATION_JSON_VALUE)
	public LandResponse searchLand(@RequestParam ("id")int id) {
		LandResponse response = new LandResponse();
		LandBean beans =service.getLand(id);
		if(beans!=null)
		{
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Details of land found");
			response.setGetOneLand(beans);

		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Record with particular id doesn't found");
		}
		return response;
	}
	@DeleteMapping(path="/delete-land/{id}",produces = MediaType.APPLICATION_JSON_VALUE) //make it handler method and send it as path variabl
	public LandResponse deleteLand(@PathVariable ("id")int id) {
		LandResponse response = new LandResponse();
		if(service.deleteLand(id))
		{
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("land details deleted successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Failed to delete land details");
		}
		return response;
		
	}
	@GetMapping(path = "/getAll-land", produces = MediaType.APPLICATION_JSON_VALUE)
	public LandResponse getAllLand() {
		LandResponse response = new LandResponse();
		List<LandBean> bean = service.getAllLand();
		if(bean.size()==0) {

			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Record  doesn't exit");

		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Land Record found");
			response.setLandBean(bean);

		}
		return response;

	}
	
	@PutMapping(path = "/modify-land", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public LandResponse updateLand(@RequestBody LandBean bean) {
		LandResponse response = new LandResponse();
		LandBean landBean = new LandBean();
		landBean.setLandId(bean.getLandId());
		landBean.setLandCost(bean.getLandCost());
		landBean.setLandLocation(bean.getLandLocation());
		landBean.setAcquiredDate(bean.getAcquiredDate());
		if (service.modifyLand(bean.getLandId(),landBean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription(" Land updated successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("unable to update land details");
		}
		return response;
	}
	
	
}
