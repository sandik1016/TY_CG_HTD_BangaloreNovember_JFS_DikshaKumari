package com.capgemini.module1.controller;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.module1.bean.ContactBean;
import com.capgemini.module1.factory.ContactFactory;
import com.capgemini.module1.services.ContactServices;

public class GetAllContact {
	void getAllContact() {
		ContactServices services =  ContactFactory.getInstanceOfContactServicesImpl();
		List<ContactBean> list = services.getAllContact();
		if(list!=null) {
			for(ContactBean con : list)
			{
				System.out.print("name : "+con.getName());
				System.out.print("number : "+con.getNumber());
				System.out.print("group : "+con.getGroup());
				System.out.println();
				
				
			}
		}

	}
}