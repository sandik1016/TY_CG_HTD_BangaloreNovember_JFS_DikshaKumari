package com.capgemini.forestrymanagementsystem.controller;

import java.text.ParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestrymanagementsystem.bean.HaulierBean;
import com.capgemini.forestrymanagementsystem.bean.ProductBean;
import com.capgemini.forestrymanagementsystem.dao.HaulierDAO;
import com.capgemini.forestrymanagementsystem.dao.ProductDAO;
import com.capgemini.forestrymanagementsystem.exception.ContractIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.CustomerIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.HaulierIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.LandIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.ProductIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.SchedulerIdNotFoundException;
import com.capgemini.forestrymanagementsystem.factory.ForestryManager;

public class Haulier {
	static HaulierDAO dao=ForestryManager.getHaulierDAOImpl();
	static Set<HaulierBean> s;
	static Map<Integer,Set<HaulierBean>> h=new HashMap<Integer,Set<HaulierBean>>();
	
	public void haulier() throws Exception {
	
	Scanner sc=new Scanner(System.in);
	

	int choice=0;
	while (true) {
		try {
		System.out.println("-----WELCOME TO SCHEDULER MODULE-----");
		System.out.println("Press 1 to add haulier");
		System.out.println("Press 2 to update haulier");
		System.out.println("Press 3 to remove haulier");
		System.out.println("Press 4 to get all haulier");
		System.out.println("Press 5 to return HOME");

		choice=sc.nextInt();
		switch(choice) {
		case 1:

			HaulierBean hb=new HaulierBean();
			 int haulierId=0;
				boolean found7 = true;
				do {
					System.out.println("Enter haulier id:");
					try {
						
						haulierId=Integer.parseInt(sc.next());
						hb.setHaulId(haulierId);
						found7=true;

					}catch(Exception e) {

						System.err.println("Please enter valid id!");
						found7=false;
					}
				}while (found7!=true);
               
			boolean found5 = true;
				do {
					System.out.println("Enter haulier contact number:");
					String phone=sc.next();
					hb.setHaulContactNo(phone);
					String regex1 = "[6789]{1}[0-9]{9}";
					Pattern pattern1 = Pattern.compile(regex1);
					Matcher matcher1 = pattern1.matcher(phone);
					if(! matcher1.matches()) {
						System.err.println("Please enter valid number!");
						found5=false;
					}else {
						hb.getHaulContactNo();
						found5=true;
					}
				}while(found5!=true);
			
				boolean found = true;
				do {
					System.out.println("Enter haulier name:");
					String name=sc.next();
					hb.setHaulName(name);
					String regex = "^[A-Za-z]{3,15}$";
					Pattern pattern = Pattern.compile(regex);
					Matcher  matcher = pattern.matcher(name);
					if( !matcher.matches()) {

						System.err.println("Please enter valid name!");
						found=false;

					}else {
						hb.getHaulName();
						found=true;
					}
				}while (found!=true);
				 int productId=0;
					boolean found1 = true;
					do {
						System.out.println("Enter product id:");
						try {
							productId=Integer.parseInt(sc.next());
							hb.setProductId(productId);
							found1=true;

						}catch(Exception e) {

							System.err.println("Please enter valid id!");
							found1=false;
						}
					}while (found1!=true);
					
					 int clientId=0;
						boolean found2 = true;
						do {
							System.out.println("Enter the client id:");
							try {
								clientId=Integer.parseInt(sc.next());
								hb.setClientId(clientId);
								found2=true;

							}catch(Exception e) {

								System.err.println("Please enter valid id!");
								found2=false;
							}
						}while (found2!=true);
                       

						boolean found4 = true;
						do {
							System.out.println("Enter source:");
							String source=sc.next();
							hb.setSource(source);
							String regex0 = "^[A-Za-z]{5,15}$";
							Pattern pattern0 = Pattern.compile(regex0);
							Matcher matcher0 = pattern0.matcher(source);
							if( !matcher0.matches()) {
								System.err.println("Please enter valid input!");
								found4=false;

							}else {

								hb.getSource();
								found4=true;
							}
						}while(found4!=true);
			
						boolean found3 = true;
						do {
							System.out.println("Enter destination:");
							String destination =sc.next();
							hb.setDestination(destination);
							String regex0 = "^[A-Za-z]{5,15}$";
							Pattern pattern0 = Pattern.compile(regex0);
							Matcher matcher0 = pattern0.matcher(destination);
							if( !matcher0.matches()) {
								System.err.println("Please enter valid input!");
								found3=false;

							}else {

								hb.getDestination();
								found3=true;
							}
						}while(found3!=true);
			
			boolean add=dao.addHaulier(hb);

			s=dao.getAllHaulier();//temporary list of customer
			if(add) {
				System.out.println("Delivery scheduled for your product successfully..!");
			}else System.err.println("Something went wrong...");
			h.put(hb.getHaulId(),s);

			break;
		
		case 2:

			System.out.println("Enter the haulier id to update:");
			int hidUpdate =sc.nextInt();
			if(dao.searchHaulier(hidUpdate, h)) {

				System.out.println(h.get(hidUpdate));
				h.remove(hidUpdate);
				HaulierBean sb1=new HaulierBean();
				sb1.setHaulId(hidUpdate);
				System.out.println("Enter haulier name to update:");
				sb1.setHaulName(sc.next());
				System.out.println("Enter haulier contact to update:");
				sb1.setHaulContactNo(sc.next());
				System.out.println("Enter client id to update:");
				sb1.setClientId(sc.nextInt());
				System.out.println("Enter product id to update:");
				sb1.setProductId(sc.nextInt());
			
				System.out.println("Enter source to update:");
				sb1.setSource(sc.next());
				System.out.println("Enter destination to update:");
				sb1.setDestination(sc.next());
				dao.addHaulier(sb1);
				s=dao.getAllHaulier();
				h.put(sb1.getHaulId(), s);
				System.out.println(h.get(hidUpdate));
			}
			else 
				System.err.println("Something went wrong!");
			break;

		case 3:
			System.out.println("Enter HaulierID to delete the account:");
			int hidDelete=sc.nextInt();
			if(dao.deleteHaulier(hidDelete, h)) {
				h.remove(hidDelete);
				System.out.println("Haulier deleted successfully");
			}
			else {
				System.err.println("Something went wrong...");
			}
			break;
		case 4:
			Set<Map.Entry<Integer,Set<HaulierBean>>> s1=h.entrySet();
			if(s1!=null) {
				for(Map.Entry<Integer,Set<HaulierBean>> e1:s1) {
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
		
			
		case 5:
			HomeForestApp m=new HomeForestApp();
			m.main(null);
		default:
			break;
		}
	}catch(HaulierIdNotFoundException e) {
		e.printStackTrace();
	}
	}
}
}
