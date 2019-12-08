package com.capgmn.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.factory.UserFactory;
import com.capgmn.jdbc.bean.UserBean;
import com.capgmn.jdbc.services.UserServices;

public class InsertUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UserServices services=UserFactory.instanceOfUserServices();
		UserBean user=new UserBean();
		Scanner sc= new Scanner(System.in);
		System.out.println("enter userid....");
		user.setUserid(Integer.parseInt(sc.nextLine()));
		System.out.println("enter username....");
		user.setUsername(sc.nextLine());
		System.out.println("enter email....");
		user.setEmail(sc.nextLine());
		System.out.println("enter Password....");
		user.setPassword(sc.nextLine());
		
		if(services.insertUser(user)) {
			System.out.println("user inserted....");
		}
		else {
			System.err.println("something went wrong");
		}
		sc.close();
	}

}
