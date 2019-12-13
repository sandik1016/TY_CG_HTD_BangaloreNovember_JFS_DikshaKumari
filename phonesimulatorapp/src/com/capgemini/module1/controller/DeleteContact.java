package com.capgemini.module1.controller;

import java.util.Scanner;

import com.capgemini.module1.bean.ContactBean;
import com.capgemini.module1.factory.ContactFactory;
import com.capgemini.module1.services.ContactServices;

public class DeleteContact {
	void deleteContact() {
		ContactServices services =  ContactFactory.getInstanceOfContactServicesImpl();
		ContactBean bean = new ContactBean();
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter contact name");
		String name = sc.next();
		boolean result = services.deleteContact(bean.getName());
		if(result) {
			System.out.println("contact deleted");
		}
		else {
			System.out.println("somethimg went wrong");
		}
		
	}

}
