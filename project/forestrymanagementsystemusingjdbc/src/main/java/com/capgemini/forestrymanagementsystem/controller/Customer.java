package com.capgemini.forestrymanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystem.bean.CustomerBean;
import com.capgemini.forestrymanagementsystem.factory.Factory;
import com.capgemini.forestrymanagementsystem.service.CustomerServices;
public class Customer {

	public void customer() {
		CustomerServices services=Factory.instanceOfUserServices();
		Scanner sc=new Scanner(System.in);

		while (true) {
			System.out.println("-----WELCOME TO CUSTOMER MODULE-----");
			System.out.println("Press 1 to add customer");
			System.out.println("Press 2 to search customer");
			System.out.println("Press 3 to update customer");
			System.out.println("Press 4 to remove customer");
			System.out.println("Press 5 to get all customer");
			System.out.println("Press 6 to return HOME");

			int choice=sc.nextInt();	

			switch (choice) {
			
			case 1:CustomerBean user=new CustomerBean();
			
			System.out.println("enter customerid....");
			user.setCustomerId(sc.nextInt());
			System.out.println("enter customername....");
			user.setCustomerName(sc.next());
			System.out.println("enter customer town....");
			user.setTown(sc.next());
			System.out.println("enter street address....");
			user.setStreetAddress1(sc.next());
			System.out.println("enter another street address....");
			user.setStreetAddress2(sc.next());
			System.out.println("enter postal....");
			user.setPostalCode(sc.nextInt());
			System.out.println("enter email....");
			user.setEmail(sc.next());
			System.out.println("enter phone....");
			user.setPhoneNumber(sc.next());
			
		
			if(services.addCustomer(user)) {
				System.out.println("user inserted....");
			}
			else {
				System.err.println("something went wrong");
			}
					
			        break;
			case 2: 
				break;
			case 3:
				
				 System.out.println("enter your option for updating");
			      
			      System.out.println("Press 1 to update customer name");
					System.out.println("Press 2 to update town  ");
					System.out.println("Press 3 to update address");
					System.out.println("Press 4 to update address");
					System.out.println("Press 5 to update postal");
					System.out.println("Press 6 to update email");
					System.out.println("Press 7 to update contact number");
			      int option = sc.nextInt();
					
					
					System.out.println("enter customer id....");
					int csid = sc.nextInt();
					CustomerBean user1=new CustomerBean();
					user1.setCustomerId(csid);
					switch(option) {
						
					case 1:
					System.out.println("enter customer name....");
					String name=sc.next();
					user1.setCustomerName(name);
					break;
					case 2:
					System.out.println("enter customer town....");
					String town=sc.next();
					user1.setTown(town);
					break;
					case 3:
					System.out.println("enter street address....");
					String add1=sc.next();
					user1.setStreetAddress1(add1);
					break;
					case 4:
					System.out.println("enter another street address....");
					String add2=sc.next();
					user1.setStreetAddress2(add2);
					break;
					case 5:
					System.out.println("enter postal....");
				    int postal=sc.nextInt();
					user1.setPostalCode(postal);
					break;
					case 6:
					System.out.println("enter email....");
					String email=sc.next();
					user1.setEmail(email);
					break;
					case 7:
					System.out.println("enter phone....");
					String phonenm=sc.next();
					user1.setPhoneNumber(phonenm);
					}
					boolean result =services.updateCustomer(csid,user1);
					
							if(result){
						System.out.println("customer updated....");
					}
					else {
						System.err.println("something went wrong");
					}
				
			    
			     break;
			case 4:
				CustomerBean customer=new CustomerBean();
				
				System.out.println("enter customerid....");
				customer.setCustomerId(Integer.parseInt(sc.nextLine()));
				boolean isDeleted =services.deleteCustomer(customer.getCustomerId());
				if(isDeleted) {
				
					System.out.println("customer account deleted....");
				}
				else {
					System.err.println("something went wrong");
				}
				
				break;
			case 5: List<CustomerBean> list=services.getAllCustomer();//return type is list so i'll be creating a listof generic type 
			if(list !=null) {
				for(CustomerBean customer1 : list) {
					System.out.println(customer1);
				}
			}
			        break;
			case 6:HomeForestApp m=new HomeForestApp();
			       m.main(null);
				   break;
		default: System.out.println("Invalid option..please choose valid one!");
		
			}

	}

	}
}
