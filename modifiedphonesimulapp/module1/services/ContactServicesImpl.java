package com.capgemini.module1.services;

import java.util.List;

import com.capgemini.module1.bean.ContactBean;
import com.capgemini.module1.dao.ContactDAO;
import com.capgemini.module1.factory.ContactFactory;

public class ContactServicesImpl implements ContactServices{
	ContactDAO dao = ContactFactory.getInstanceOfContactDAOImpl();
	@Override
	public List<ContactBean> getAllContact() {
		return dao.getAllContact();

	}

	@Override
	public boolean addContact(ContactBean contact) {

		return dao.addContact(contact);
	}

	@Override
	public boolean deleteContact(String contactName) {

		return dao.deleteContact(contactName);
	}

	@Override
	public boolean editContact(String contactName, ContactBean contactUpdate) {

		return dao.editContact(contactName, contactUpdate);
	}

	@Override
	public ContactBean searchContact(String contactName) {

		return dao.searchContact(contactName);
	}


}
