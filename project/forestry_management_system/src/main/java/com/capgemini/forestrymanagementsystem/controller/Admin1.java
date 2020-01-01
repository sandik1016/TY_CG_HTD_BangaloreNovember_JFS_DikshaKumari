package com.capgemini.forestrymanagementsystem.controller;

import java.text.ParseException;
import java.util.HashMap;


import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestrymanagementsystem.bean.AdminBean;
import com.capgemini.forestrymanagementsystem.exception.ContractIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.CustomerIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.LandIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.ProductIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.SchedulerIdNotFoundException;


public class Admin1 {
	

	void admin() throws Exception{
		
		
	Scanner sc=new Scanner(System.in);
		Set<AdminBean> s;//here we are not creating object so we can assign it with null
		
		while (true) {
			System.out.println("Enter options to proceed further");
			System.out.println("Press 1 to perform operation on **Client**");
			System.out.println("Press 2 to perform operation on **Product/Inventory**");
			System.out.println("Press 3 to view Contract details");
			System.out.println("Press 4 to go back to main menu ");
			
            int choice = sc.nextInt();
			switch (choice) {
			case 1:

				AdminBean  admin=new AdminBean();
				String email;
				boolean found2 = true;
				do {
					System.out.println("Enter valid  email: ");
					email =sc.next();
					String regex2 = "^(.+)@(.+)$";
					Pattern pattern2 = Pattern.compile(regex2);
					Matcher matcher2 = pattern2.matcher(email);
					if( !matcher2.matches()) {
						System.err.println("Please enter valid email!");
						found2=false;
					}else {
						admin.getEmail();
						found2=true;
					}
				}while(found2!=true);

					System.out.println("Enter valid password ");
					String password=sc.next();
			        System.out.println("Welcome to Customer module... ");
					 Customer c=new Customer();
				     c.customer();				
				break;
			case 3:AdminBean  admin1=new AdminBean();
			String email1;
			boolean found = true;
			do {
				System.out.println("Enter valid email: ");
				email1 =sc.next();
			
				String regex2 = "^(.+)@(.+)$";
				Pattern pattern2 = Pattern.compile(regex2);
				Matcher matcher2 = pattern2.matcher(email1);
				if( !matcher2.matches()) {
					System.err.println("Please enter valid email!");
					found=false;
				}else {
					admin1.getEmail();
					found=true;
				}
			}while(found!=true);

				System.out.println("Enter valid password ");
				String password1=sc.next();
	
				
		if(email1.equals("dik@gmail.com")&&password1.equals("12345"))
			{
				System.out.println("Welcome to contract module");
							   Contractor con = new Contractor();
						       try {
								con.contract();
							} catch (ParseException e) {
								
								e.printStackTrace();
							}
			}else {
				System.err.println("Please enter valid credentials");
			}
						       break;
			case 2:
				AdminBean  admin2=new AdminBean();
			String email2;
			boolean found4 = true;
			do {
				System.out.println("Enter valid email: ");
				email2 =sc.next();
				String regex2 = "^(.+)@(.+)$";
				Pattern pattern2 = Pattern.compile(regex2);
				Matcher matcher2 = pattern2.matcher(email2);
				if( !matcher2.matches()) {
					System.err.println("Please enter valid email!");
					found4=false;
				}else {
					admin2.getEmail();
					found4=true;
				}
			}while(found4!=true);

				System.out.println("Enter valid password :");
				String password2=sc.next();
				
		if(email2.equals("dik@gmail.com")&& password2.equals("12345"))
			{
							System.out.println("Welcome to product module");
							   Product p =  new Product();
						       p.product();
			}
						     
						       else {
						System.err.println("Please enter valid credentials");
						}
						
						break;
						case 4:AdminBean  admin3=new AdminBean();
						String email3;
						boolean found3 = true;
						do {
							System.out.println("Enter valid email: ");
							email3 =sc.next();
							String regex2 = "^(.+)@(.+)$";
							Pattern pattern2 = Pattern.compile(regex2);
							Matcher matcher2 = pattern2.matcher(email3);
							if( !matcher2.matches()) {
								System.err.println("Please enter valid email!");
								found3=false;
							}else {
								admin3.getEmail();
								found3=true;
							}
						}while(found3!=true);

							System.out.println("Enter valid password :");
							String password3=sc.next();
							
					if(email3.equals("dik@gmail.com")&& password3.equals("12345"))
						{
										System.out.println("Welcome to land module");
										   Land l =  new Land();
									       l.land();
						}
									     
									       else {
									System.err.println("Please enter valid credentials");
									}
							
							
							break;
						case 5:
							HomeForestApp m=new HomeForestApp();
							m.main(null);
						default:System.out.println("Please enter valid options");
							break;
					}
		
		}
		
	}
	}	
			
