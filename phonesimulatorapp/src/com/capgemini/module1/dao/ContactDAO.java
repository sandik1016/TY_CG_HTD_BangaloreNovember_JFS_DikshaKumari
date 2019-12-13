package com.capgemini.module1.dao;

import java.util.List;

import com.capgemini.module1.bean.ContactBean;

public interface ContactDAO {
	public List<ContactBean> getAllContact();
	public boolean addContact(ContactBean contact);
	public boolean deleteContact(String contactName);
	public boolean editContact(String contactName,ContactBean contactUpdate);
	public ContactBean searchContact(String contactName);
}
