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
import com.capgemini.forestrymanagementsystem.dto.ContractBean;
import com.capgemini.forestrymanagementsystem.dto.ContractResponse;
import com.capgemini.forestrymanagementsystem.service.ContractService;


@RestController
public class ContractController {
	@Autowired
	private ContractService service;
	@PostMapping(path="/add-contract",produces = MediaType.APPLICATION_JSON_VALUE,consumes = MediaType.APPLICATION_JSON_VALUE)
	public ContractResponse register(@RequestBody ContractBean bean) {
		ContractResponse response = new ContractResponse();

		if(service.addContract(bean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("contract registered successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Failed to add contract details");
		}
		return response;
	}
	@GetMapping(path = "/search-contract",produces = MediaType.APPLICATION_JSON_VALUE)
	public ContractResponse searchContract(@RequestParam ("id")int id) {
		ContractResponse response = new ContractResponse();
		ContractBean beans =service.getContract(id);
		if(beans!=null)
		{
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("Details of Contract found");
			response.setGetOneContract(beans);

		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Record with particular id doesn't found");
			
		}
		return response;
	}
	@DeleteMapping(path="/delete-contract/{id}",produces = MediaType.APPLICATION_JSON_VALUE) //make it handler method and send it as path variabl
	public ContractResponse deleteContract(@PathVariable ("id")int id) {
		ContractResponse response = new ContractResponse();
		if(service.deleteContract(id)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription("contract details deleted successfully");
		}else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Failed to delete contract details");
		}
		return response;
		
	}
	@GetMapping(path = "/getAll-contract", produces = MediaType.APPLICATION_JSON_VALUE)
	public ContractResponse getAllProduct() {
		ContractResponse response = new ContractResponse();
		List<ContractBean> bean = service.getAllContract();
		if(bean.size()==0) {

			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("Record  doesn't exit");

		} else {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription(" Contract Record found");
			response.setContractBean(bean);

		}
		return response;

	}
	
	@PutMapping(path = "/modify-contract", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ContractResponse modifyContract(@RequestBody ContractBean bean) {
		ContractResponse response = new ContractResponse();

		ContractBean contractBean = new ContractBean();
		contractBean.setContractId(bean.getContractId());
		contractBean.setCustomerId(bean.getCustomerId());
		contractBean.setProductId(bean.getProductId());
		contractBean.setQuantity(bean.getQuantity());
		contractBean.setDeliveryDate(bean.getDeliveryDate());
		
		if (service.modifyContract(bean.getContractId(), contractBean)) {
			response.setStatusCode(201);
			response.setMessage("success");
			response.setDescription(" Contract updated successfully");
		} else {
			response.setStatusCode(401);
			response.setMessage("failure");
			response.setDescription("unable to update contract details");
		}
		return response;
	}
	
	
}
