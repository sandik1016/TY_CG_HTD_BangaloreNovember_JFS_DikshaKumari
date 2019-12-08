package com.capgmn.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.factory.UserFactory;
import com.capgmn.jdbc.bean.UserBean;
import com.capgmn.jdbc.services.UserServices;

public class DeleteUser {

	private static int userid;

	public static void main(String[] args) {
		UserServices services=UserFactory.instanceOfUserServices();
		UserBean user=new UserBean();
		Scanner sc= new Scanner(System.in);
		System.out.println("enter userid....");
		user.setUserid(Integer.parseInt(sc.nextLine()));
		System.out.println("enter Password....");
		user.setPassword(sc.nextLine());
		
		
		boolean result =services.deleteUser(user.getUserid(),user.getPassword());
		if(result) {
		
			System.out.println("user deleted....");
		}
		else {
			System.err.println("something went wrong");
		}
		sc.close();
	

	}

}
