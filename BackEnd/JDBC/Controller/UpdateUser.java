package com.capgmn.jdbc.controller;

import java.util.Scanner;

import com.capgemini.jdbc.factory.UserFactory;
import com.capgmn.jdbc.bean.UserBean;
import com.capgmn.jdbc.services.UserServices;

public class UpdateUser {

	public static void main(String[] args) {
            
		
		UserServices services=UserFactory.instanceOfUserServices();
		UserBean user=new UserBean();
		Scanner sc= new Scanner(System.in);
		System.out.println("enter userid....");
		user.setUserid(Integer.parseInt(sc.nextLine()));
		System.out.println("enter email....");
		user.setUsername(sc.nextLine());
		System.out.println("enter Password....");
		user.setPassword(sc.nextLine());
		
	
		boolean result =services.updateUser(user.getUserid(),user.getPassword(),user.getEmail());
				if(result){
			System.out.println("email updated....");
		}
		else {
			System.err.println("something went wrong");
		}
		sc.close();
	}

}
