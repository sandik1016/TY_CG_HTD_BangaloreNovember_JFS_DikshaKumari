package com.capgemini.forestrymanagementsystem.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestrymanagementsystem.bean.AdminBean;
import com.capgemini.forestrymanagementsystem.bean.CustomerBean;
import com.capgemini.forestrymanagementsystem.bean.LandBean;
import com.capgemini.forestrymanagementsystem.dao.CustomerDAO;
import com.capgemini.forestrymanagementsystem.dao.LandDAO;
import com.capgemini.forestrymanagementsystem.exception.ContractIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.CustomerIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.LandIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.ProductIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.SchedulerIdNotFoundException;
import com.capgemini.forestrymanagementsystem.factory.ForestryManager;


public class Land {
	static LandDAO dao=ForestryManager.getLandDAOImpl();
	static Set<LandBean> s;
	static Map<Integer,Set<LandBean>> h=new HashMap<Integer,Set<LandBean>>();
	void land() throws Exception{

	

		Scanner sc=new Scanner(System.in);
		
	
		while (true) {
			try {
			System.out.println("-----WELCOME TO LAND MODULE-----");
			System.out.println("Press 1 to add land");
			System.out.println("Press 2 to search land");
			System.out.println("Press 3 to update land");
			System.out.println("Press 4 to remove land");
			System.out.println("Press 5 to get all land");
			System.out.println("Press 6 to return HOME");

			int choice=sc.nextInt();

			switch (choice) {
			case 1:

				LandBean lb=new LandBean();
				AdminBean admin2 = new AdminBean();
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
				
				if(email2.equals("dik@gmail.com")&& password2.equals("12345")) {
				
				System.out.println("Enter land id:");
				int lid =sc.nextInt();
			   lb.setLandId(lid);
               
				boolean found1 = true;
				do {
					System.out.println("Enter land location: ");
					String loc=sc.next();
					lb.setLandLocation(loc);
					String regex0 = "^[A-Za-z]{5,15}$";
					Pattern pattern0 = Pattern.compile(regex0);
					Matcher matcher0 = pattern0.matcher(loc);
					if( !matcher0.matches()) {
						System.err.println("Please enter valid input!");
						found1=false;

					}else {

						lb.getLandLocation();
						found1=true;
					}
				}while(found1!=true);

				double landCost=0.0;
				boolean found6 = true;
				do {
					System.out.println("Enter land cost:");
					try {
						landCost=Double.parseDouble(sc.next());
						lb.setLandCost(landCost);
						found6=true;

					}catch(Exception e) {

						System.err.println("Please enter valid id!");
						found6=false;
					}
				}while (found6!=true);

				boolean found3 = true;
				do {
					System.out.println("Enter the acquired date: ");
					String date =sc.next();
					lb.setAcquiredDate(date);
					String regex2 = "";
					Pattern pattern2 = Pattern.compile(regex2);
					Matcher matcher2 = pattern2.matcher(date);
					if( !matcher2.matches()) {
						System.err.println("Please enter valid date!");
						found3=false;
					}else {
						lb.getAcquiredDate();
						found3=true;
					}
				}while(found3!=true);

				
				}
				
				boolean add=dao.addLand(lb);

				s=dao.getAllLand();//temporary list of customer
				if(add) {
					System.out.println("Land details added successfully..!");
				}else System.err.println("Something went wrong...");
				h.put(lb.getLandId(),s);

				break;
			case 2: 
				System.out.println("Enter landid to search land: ");
				int lid1=sc.nextInt();
				if(dao.searchLand(lid1, h))

					System.out.println(h.get(lid1));
				else
					System.err.println("Land details not found");
			
				break;
			case 3:

				System.out.println("Enter the land ID to update:");
				int lidUpdate =sc.nextInt();
				if(dao.searchLand(lidUpdate, h)) {

					System.out.println(h.get(lidUpdate));
					h.remove(lidUpdate);
					LandBean lb2=new LandBean();
					lb2.setLandId(lidUpdate);

					System.out.println("Enter location to update:");
					lb2.setLandLocation(sc.next());
					System.out.println("Enter cost to update:");
					lb2.setLandCost(sc.nextDouble());
					System.out.println("Enter acquired date to update:");
					lb2.setAcquiredDate(sc.next());
					
					
					dao.addLand(lb2);
					s=dao.getAllLand();
					h.put(lb2.getLandId(), s);
					System.out.println(h.get(lidUpdate));
				}
				else 
					System.err.println("Something went wrong!");
				break;

			case 4:
				System.out.println("Enter land ID to delete the account:");
				int lidDelete=sc.nextInt();
				if(dao.deleteLand(lidDelete,h)) {
					h.remove(lidDelete);
					System.out.println("land details deleted successfully");
				}
				else {
					System.err.println("Something went wrong...");
				}
				break;
			case 5:
				Set<Map.Entry<Integer,Set<LandBean>>> s1=h.entrySet();
				if(s1!=null) {
					for(Map.Entry<Integer,Set<LandBean>> e1:s1) {
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
		}catch(LandIdNotFoundException e) {
			e.printStackTrace();
		}


		}
	}}
