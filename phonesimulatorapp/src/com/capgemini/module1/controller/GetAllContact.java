package com.capgemini.module1.controller;

import java.util.ArrayList;
import java.util.List;

import com.capgemini.module1.bean.ContactBean;
import com.capgemini.module1.factory.ContactFactory;
import com.capgemini.module1.services.ContactServices;

public class GetAllContact {
	void getAllContact() {
	ContactServices services =  ContactFactory.getInstanceOfContactServicesImpl();
	List<ContactBean> list = new ArrayList<ContactBean>();
	ContactBean contact = new ContactBean();
	if(list!=null) {
		
	
	for(ContactBean con : list)
	{
		System.out.println(contact);
	}
	}

}
}