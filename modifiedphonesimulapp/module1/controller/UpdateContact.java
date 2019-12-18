package com.capgemini.module1.controller;

import java.util.Scanner;

import com.capgemini.module1.bean.ContactBean;
import com.capgemini.module1.factory.ContactFactory;
import com.capgemini.module1.services.ContactServices;

public class UpdateContact {

	public void updateContact() {

		ContactServices services =  ContactFactory.getInstanceOfContactServicesImpl();
		Scanner sc= new Scanner(System.in);

		ContactBean bean = new ContactBean();
		System.out.println("Enter contact name");
		String name = sc.next();
		bean.setName(name);
		System.out.println("Enter contact number");
		String number = sc.next();
		bean.setNumber(number);
		System.out.println("Enter contact group");
		String group = sc.next();
		bean.setGroup(group);
		boolean result =services.editContact(name, bean);
		if(result) {
			System.out.println("updated successfully");
		}
		else {
			System.err.println("Something went wrong");
		}


	}


}
