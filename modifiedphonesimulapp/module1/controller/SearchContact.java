package com.capgemini.module1.controller;

import java.util.Scanner;

import com.capgemini.module1.bean.ContactBean;
import com.capgemini.module1.factory.ContactFactory;
import com.capgemini.module1.services.ContactServices;

public class SearchContact {
	public void searchContact() {
	Scanner sc =  new Scanner(System.in);
    ContactServices services=ContactFactory.getInstanceOfContactServicesImpl();
		ContactBean user=new ContactBean();
		
		System.out.println("enter username....");
		user.setName(sc.nextLine());
		
		ContactBean user1=services.searchContact(user.getName());
		
		if(user1!=null) {
			System.out.println("userid is"+user1.getName());
			System.out.println("username is"+user1.getNumber());
			System.out.println("email is"+user1.getGroup());
		}
		else {
			System.err.println("something went wrong");
		}
		sc.close();
	}

}
