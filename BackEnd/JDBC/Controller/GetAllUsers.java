package com.capgmn.jdbc.controller;

import java.util.List;

import com.capgemini.jdbc.factory.UserFactory;
import com.capgmn.jdbc.bean.UserBean;
import com.capgmn.jdbc.services.UserServices;

public class GetAllUsers {

	public static void main(String[] args) {
		UserServices services =  UserFactory.instanceOfUserServices();
		List<UserBean> list=services.getAllUsers();//return type is list so i'll be creating a listof generic type 
		if(list !=null) {
			for(UserBean user : list) {
				System.out.println(user);
			}
		}
		
		
	}

}
