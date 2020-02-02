package com.capgemini.forestrymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.forestrymanagementsystem.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystem.dto.CustomerBean;
import com.capgemini.forestrymanagementsystem.exception.CustomerException;
import com.capgemini.forestrymanagementsystem.util.Validation;
@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
    private CustomerDAO dao;
	@Override
	public boolean addCustomer(CustomerBean customer) {
		Validation v = new Validation();
		String customerName = customer.getCustomerName();
		if(v.nameValidation(customerName)) {
			customer.setCustomerName(customerName);
		}else{
			throw new CustomerException("Enter only alphabet in customer name field");
		}
		String customerTown = customer.getCustomerTown();
		if(v.townValidation(customerTown)) {
			customer.setCustomerTown(customerTown);
		}else{
			throw new CustomerException("Enter only alphabet in customer town field");
		}
		String email = customer.getCustomerEmail();
		if(Validation.userEmailValidation(email)) {
			customer.setCustomerEmail(email);
		}else{
			throw new CustomerException("Enter proper format of email such as 'Abc123@gmail.com'");
		}
		String phone = customer.getCustomerPhone();
		if(v.phoneValidation(phone)) {
			customer.setCustomerPhone(phone);
		}
		else {
			throw new CustomerException("Enter only 10 digit mobile number");
		}
		String address = customer.getCustomerAddress();
		if(v.addressValidation(address)) {
			customer.setCustomerAddress(address);
		}
		else {
			throw new CustomerException("Enter valid address");
		}
		String postal = customer.getCustomerPostal();
		if(v.postalValidation(postal)) {
			customer.setCustomerPostal(postal);
		}
		else {
			throw new CustomerException("Enter only 6 digit for postal code");
		}
		return dao.addCustomer(customer);
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		return dao.deleteCustomer(customerId);
	}

	@Override
	public List<CustomerBean> getAllCustomers() {
		
		return dao.getAllCustomers();
	}

	@Override
	public boolean modifyCustomer(int customerId,CustomerBean customer) {
		Validation v = new Validation();
		String customerName = customer.getCustomerName();
		if(v.nameValidation(customerName)) {
			customer.setCustomerName(customerName);
		}else{
			throw new CustomerException("Enter only alphabet in customer name field");
		}
		String customerTown = customer.getCustomerTown();
		if(v.townValidation(customerTown)) {
			customer.setCustomerTown(customerTown);
		}else{
			throw new CustomerException("Enter only alphabet in customer town field");
		}
		String email = customer.getCustomerEmail();
		if(Validation.userEmailValidation(email)) {
			customer.setCustomerEmail(email);
		}else{
			throw new CustomerException("Enter proper format of email such as 'Abc123@gmail.com'");
		}
		String phone = customer.getCustomerPhone();
		if(v.phoneValidation(phone)) {
			customer.setCustomerPhone(phone);
		}
		else {
			throw new CustomerException("Enter only 10 digit mobile number");
		}
		String address = customer.getCustomerAddress();
		if(v.addressValidation(address)) {
			customer.setCustomerAddress(address);
		}
		else {
			throw new CustomerException("Enter valid address");
		}
		String postal = customer.getCustomerPostal();
		if(v.postalValidation(postal)) {
			customer.setCustomerPostal(postal);
		}
		else {
			throw new CustomerException("Enter only 6 digit for postal code");
		}
		return dao.modifyCustomer(customerId,customer);
	}

	@Override
	public CustomerBean getCustomer(int customerId) {
		
		return dao.getCustomer(customerId);
	}

}
