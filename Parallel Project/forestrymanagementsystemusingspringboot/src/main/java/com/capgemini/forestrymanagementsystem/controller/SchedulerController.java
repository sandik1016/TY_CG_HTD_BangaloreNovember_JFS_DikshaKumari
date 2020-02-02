package com.capgemini.forestrymanagementsystem.controller;

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

import com.capgemini.forestrymanagementsystem.dto.SchedulerBean;
import com.capgemini.forestrymanagementsystem.dto.SchedulerResponse;
import com.capgemini.forestrymanagementsystem.service.SchedulerService;

@RestController
public class SchedulerController {
	@Autowired
	private SchedulerService service;

	@PostMapping(path="/add-scheduler",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public SchedulerResponse register(@RequestBody SchedulerBean bean) {
		SchedulerResponse response = new SchedulerResponse();

		if(service.addSchedule(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("scheduler registered successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Failed to add scheduler details");
		}
		return response;
	}
	@GetMapping(path = "/search-scheduler",produces = MediaType.APPLICATION_JSON_VALUE)
	public SchedulerResponse searchScheduler(@RequestParam ("id")int id) {
		SchedulerResponse response = new SchedulerResponse();
		SchedulerBean beans =service.getSchedule(id);
		if(beans!=null)
		{
			response.setStatusCode(201);
		response.setMessage("success");
		response.setDescription("Details of Scheduler found");
			response.setGetOneScheduler(beans);
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Record with particular id doesn't found");
			
		}
		return response;
	}
	@DeleteMapping(path="/delete-scheduler/{id}",produces = MediaType.APPLICATION_JSON_VALUE) //make it handler method and send it as path variabl
	public SchedulerResponse deleteScheduler(@PathVariable ("id")int id) {
		SchedulerResponse response = new SchedulerResponse();
		if(service.deleteSchedule(id))
		{
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("scheduler details deleted successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Failed to delete scheduler details");
		}
		return response;
		
	}
	@GetMapping(path = "/getAll-scheduler", produces = MediaType.APPLICATION_JSON_VALUE)
	public SchedulerResponse getAllSchedule() {
		SchedulerResponse response = new SchedulerResponse();
		List<SchedulerBean> bean = service.getAllSchedule();
		if(bean.size()==0) {

			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Record  doesn't exit");

		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Scheduled Record found");
			response.setSchedulerBean(bean);

		}
		return response;

	}
	
	@PutMapping(path = "/modify-scheduler", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public SchedulerResponse updateScheduler(@RequestBody SchedulerBean bean) {
		SchedulerResponse response = new SchedulerResponse();
		SchedulerBean schedulerBean = new SchedulerBean();
		schedulerBean.setScheduleId(bean.getScheduleId());
		schedulerBean.setContractId(bean.getContractId());
		schedulerBean.setDeliveryDate(bean.getDeliveryDate());
		schedulerBean.setStatus(bean.getStatus());
		if (service.modifySchedule(bean.getScheduleId(), schedulerBean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription(" Scheduler updated successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("unable to update Scheduler details");
		}
		return response;
	}
}
