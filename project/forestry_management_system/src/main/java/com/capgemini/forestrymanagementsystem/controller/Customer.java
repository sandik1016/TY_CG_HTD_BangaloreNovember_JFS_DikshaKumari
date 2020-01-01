package com.capgemini.forestrymanagementsystem.controller;

import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestrymanagementsystem.bean.CustomerBean;
import com.capgemini.forestrymanagementsystem.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystem.exception.ContractIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.CustomerIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.LandIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.ProductIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.SchedulerIdNotFoundException;
import com.capgemini.forestrymanagementsystem.factory.ForestryManager;


public class Customer {
	static CustomerDAO dao=ForestryManager.getCustomerDAOImpl();
	static Set<CustomerBean> s;//here we are not creating object so we can assign it with null
	static Map<Integer,Set<CustomerBean>> h=new HashMap<Integer,Set<CustomerBean>>();
	void customer() throws Exception{

		Scanner sc=new Scanner(System.in);

		int choice=0;
		try {
			while (true) {
				System.out.println("-----WELCOME TO CUSTOMER MODULE-----");
				System.out.println("Press 1 to add customer");
				System.out.println("Press 2 to search customer");
				System.out.println("Press 3 to update customer");
				System.out.println("Press 4 to remove customer");
				System.out.println("Press 5 to get all customer");
				System.out.println("Press 6 to return HOME");

				choice=sc.nextInt();

				switch (choice) {
				case 1:

					CustomerBean cb=new CustomerBean();
					 int customerId=0;
						boolean found7 = true;
						do {
							System.out.println("Enter the customer ID:");
							//try {
								customerId=Integer.parseInt(sc.next());
								if(h.containsKey(customerId)==true && h.isEmpty())
								{
									System.err.println("Please enter valid id!");
									found7=false;
								}
								else {
									cb.setCustomerId(customerId);
									found7=true;
								}
							//}catch(Exception e) {
								//System.err.println("Please enter valid id!");
								//found7=false;
								
							//}
						}while (found7!=true);
                          

					boolean found = true;
					do {
						System.out.println("Enter customer name: ");
						String name=sc.next();
						cb.setName(name);
						String regex = "^[A-Za-z]{3,15}$";
						Pattern pattern = Pattern.compile(regex);
						Matcher  matcher = pattern.matcher(name);
						if( !matcher.matches()) {

							System.err.println("Please enter valid name!");
							found=false;

						}else {
							cb.getName();
							found=true;
						}
					}while (found!=true);

					boolean found1 = true;
					do {
						System.out.println("Enter customer town: ");
						String town=sc.next();
						cb.setTown(town);
						String regex0 = "^[A-Za-z]{5,15}$";
						Pattern pattern0 = Pattern.compile(regex0);
						Matcher matcher0 = pattern0.matcher(town);
						if( !matcher0.matches()) {
							System.err.println("Please enter valid input!");
							found1=false;

						}else {

							cb.getTown();
							found1=true;
						}
					}while(found1!=true);

					boolean found2 = true;
					do {
						System.out.println("Enter customer postal code: ");
						String code = sc.next();
						cb.setPostal(code);
						String regex4 = "[0-9]{6}";
						Pattern pattern4 = Pattern.compile(regex4);
						Matcher matcher4 = pattern4.matcher(code);
						if( !matcher4.matches()) {
							System.err.println("Please enter valid postal code!");
							found2=false;
						}else {

							cb.getPostal();
							found2=true;
						}
					}while(found2!=true);

					boolean found3 = true;
					do {
						System.out.println("Enter customer email: ");
						String email =sc.next();
						cb.setEmail(email);
						String regex2 = "^(.+)@(.+)$";
						Pattern pattern2 = Pattern.compile(regex2);
						Matcher matcher2 = pattern2.matcher(email);
						if( !matcher2.matches()) {
							System.err.println("Please enter valid email!");
							found3=false;
						}else {
							cb.getEmail();
							found3=true;
						}
					}while(found3!=true);

					boolean found4 = true;
					do {
						System.out.println("Enter customer's address: ");
						String address = sc.next();
						cb.setStreetAddress(address);

						String regex6 = "^[A-Za-z]{2,15}$";
						Pattern pattern6 = Pattern.compile(regex6);
						Matcher matcher6 = pattern6.matcher(address);
						if( !matcher6.matches()) {
							System.err.println("Please enter valid address!");
							found4=false;
						}else {
							cb.getStreetAddress();
							found4=true;
						}

					}while(found4!=true);


					boolean found5 = true;
					do {
						System.out.println("Enter customer contact number: ");
						String phone=sc.next();
						cb.setPhone(phone);
						String regex1 = "[6789]{1}[0-9]{9}";
						Pattern pattern1 = Pattern.compile(regex1);
						Matcher matcher1 = pattern1.matcher(phone);
						if(! matcher1.matches()) {
							System.err.println("Please enter valid number!");
							found5=false;
						}else {
							cb.getPhone();
							found5=true;
						}
					}while(found5!=true);
					boolean add=dao.addCustomer(cb);

					s=dao.getAllCustomer();//temporary list of customer
					if(add) {
						System.out.println("Customer added successfully..!");
					}else System.err.println("Something went wrong...");
					h.put(cb.getCustomerId(),s);

					break;
				case 2:
					System.out.println("Enter customerid to search Customer: ");
					int cid1=sc.nextInt();
					if(dao.searchCustomer(cid1, h))

						System.out.println(h.get(cid1));
					else
						System.err.println("Contract details not found");

					break;
				case 3:

					System.out.println("Enter the CID to update:");
					int cidUpdate =sc.nextInt();
					if(dao.searchCustomer(cidUpdate, h)) {

						System.out.println(h.get(cidUpdate));
						h.remove(cidUpdate);
						CustomerBean cb2=new CustomerBean();
						cb2.setCustomerId(cidUpdate);

						System.out.println("Enter name to update:");
						cb2.setName(sc.next());
						System.out.println("Enter town to update:");
						cb2.setTown(sc.next());
						System.out.println("Enter address to update:");
						cb2.setStreetAddress(sc.next());
						System.out.println("Enter postal to update:");
						cb2.setPostal(sc.next());
						System.out.println("Enter email to update:");
						cb2.setEmail(sc.next());
						System.out.println("Enter contact number to update:");
						cb2.setPhone(sc.next());

						dao.addCustomer(cb2);
						s=dao.getAllCustomer();
						h.put(cb2.getCustomerId(), s);
						System.out.println(h.get(cidUpdate));
					}
					else 
						System.err.println("Something went wrong!");
					break;

				case 4:
					System.out.println("Enter CustomerID to delete the account:");
					int cidDelete=sc.nextInt();
					if(dao.deleteCustomer(cidDelete,h)) {
						h.remove(cidDelete);
						System.out.println("Customer details deleted successfully");
					}
					else {
						System.err.println("Something went wrong...");
					}
					break;
				case 5:
					Set<Map.Entry<Integer,Set<CustomerBean>>> s1=h.entrySet();
					if(s1!=null) {
						for(Map.Entry<Integer,Set<CustomerBean>> e1:s1) {
							System.out.println(e1.getKey());
							System.out.println(e1.getValue());
							System.out.println("-----------------");
						}
					}
					else
					{
						System.err.println("There is no record to display");
					}
					break;
				case 6:
					HomeForestApp m=new HomeForestApp();
					m.main(null);
				default:
					break;
				}
			}
		}catch(CustomerIdNotFoundException e){
			e.printStackTrace();
		}
	}
}
