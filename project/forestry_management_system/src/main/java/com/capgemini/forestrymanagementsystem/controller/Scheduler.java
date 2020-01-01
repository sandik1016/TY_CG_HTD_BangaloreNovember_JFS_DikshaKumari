package com.capgemini.forestrymanagementsystem.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.capgemini.forestrymanagementsystem.bean.CustomerBean;
import com.capgemini.forestrymanagementsystem.bean.HaulierBean;
import com.capgemini.forestrymanagementsystem.bean.ProductBean;
import com.capgemini.forestrymanagementsystem.bean.SchedulerBean;
import com.capgemini.forestrymanagementsystem.dao.HaulierDAO;
import com.capgemini.forestrymanagementsystem.dao.ProductDAO;
import com.capgemini.forestrymanagementsystem.dao.SchedulerDAO;
import com.capgemini.forestrymanagementsystem.exception.ContractIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.CustomerIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.LandIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.ProductIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.SchedulerIdNotFoundException;
import com.capgemini.forestrymanagementsystem.factory.ForestryManager;

public class Scheduler {
	static SchedulerDAO dao=ForestryManager.getSchedulerDAOImpl();
	static ProductDAO dao1=ForestryManager.getProductDAOImpl();
	static	HaulierDAO dao2=ForestryManager.getHaulierDAOImpl();
	static Set<SchedulerBean> s;
	static Set<HaulierBean> s1;
	static Map<Integer,Set<SchedulerBean>> h=new HashMap<Integer,Set<SchedulerBean>>();
	static Map<Integer,Set<ProductBean>> h1=new HashMap<Integer,Set<ProductBean>>();
	static 
	Map<Integer,Set<HaulierBean>> h2=new HashMap<Integer,Set<HaulierBean>>();
	public void scheduler() throws Exception {
		Scanner sc=new Scanner(System.in);

		int choice=0;
		while (true) {
			try {
			System.out.println("-----WELCOME TO SCHEDULER MODULE-----");
			System.out.println("Press 1 to add schedule");
			System.out.println("Press 2 to search schedule");
			System.out.println("Press 3 to update schedule");
			System.out.println("Press 4 to remove schedule");
			System.out.println("Press 5 to get all schedule");
			System.out.println("Press 6 to view current inventory");
			System.out.println("Press 7 to schedule transport");
			System.out.println("Press 8 to return HOME");

			choice=sc.nextInt();
			switch(choice) {
			case 1:

				SchedulerBean sb=new SchedulerBean();
				
				int schedulerId=0;
				boolean found6 = true;
				do {
					System.out.println("Enter schedule id:");
					try {
						schedulerId=Integer.parseInt(sc.next());
						sb.setSchedulerId(schedulerId);
						found6=true;

					}catch(Exception e) {

						System.err.println("Please enter valid id!");
						found6=false;
					}
				}while (found6!=true);
				
				
				int haulierId=0;
				boolean found3 = true;
				do {
					System.out.println("Enter the haulier ID:");
					try {
						haulierId=Integer.parseInt(sc.next());
						sb.setHaulId(haulierId);
						found3=true;

					}catch(Exception e) {

						System.err.println("Please enter valid id!");
						found3=false;
					}
				}while (found3!=true);

				int productId=0;
				boolean found4 = true;
				do {
					System.out.println("Enter the product ID:");
					try {
						productId=Integer.parseInt(sc.next());
						sb.setProdId(productId);
						found4=true;

					}catch(Exception e) {

						System.err.println("Please enter valid id!");
						found4=false;
					}
				}while (found4!=true);
				int quantity=0;
				boolean found1 = true;
				do {
					System.out.println("Enter the product quantity: ");
					try {
						quantity=Integer.parseInt(sc.next());
						sb.setQuantity(quantity);
						found1=true;

					}catch(Exception e) {

						System.err.println("Please enter valid id!");
						found1=false;
					}
				}while (found1!=true);
				
				
				boolean found5 = true;
				do {
					try {
		        System.out.println("Please Enter Date in this Format: \"dd-mm-yyyy\"");
		        String user_InputDate=sc.next();

		        String[] str=user_InputDate.split("-");
		        int day=Integer.parseInt(str[0]);
		        int month=Integer.parseInt(str[1]);
		        int year=Integer.parseInt(str[2]);
		        //System.out.println(day+" "+month+" "+year);

		        if(month<1||month>12||day<1||day>31)
		        {
		            System.out.println("Invalid Date:");
		            return;
		        }
		        else if(month ==2)
		        {
		            if(!((year % 4 == 0) &&  (year % 100 != 0)) ||  (year % 400 == 0))
		            {
		                if(day>28)
		                {
		                    System.out.println("Invalid Date:"); 
		                    return;
		                }
		            }
		        }
		        else if(month==4||month==6||month==9||month==11)
		        {
		            if(day==31)
		            {
		               System.out.println("Invalid Date:"); 
		               return;
		            }
		        }
		        else        
		        {

		        }

		        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		        Date currDate=new Date();
		        
		        currDate=dateFormat.parse(dateFormat.format(currDate));
		        Date user_Date=dateFormat.parse(user_InputDate);
		       
		        
		        
		        if(user_Date.compareTo(currDate)<0)
		        {
		            System.out.println("Invalid Date:");
		            found5=false;
		            
		        }
		        else
		        {
		            System.out.println("Go Ahead");
		            sb.setDeliveryDate(user_InputDate);
					found5=true;
		            
		        }
					}catch(Exception e) {
						
					}
		        
		    }while (found5!=true);	
				
				
			boolean add=dao.addSchedule(sb);

				s=dao.getAllSchedule();//temporary list of customer
				if(add) {
					System.out.println("schedule details added successfully..!");
				}else System.err.println("Something went wrong...");
				h.put(sb.getSchedulerId(),s);

				break;
			case 2:
				System.out.println("Enter schedule id to search available schedule: ");
				int sid1=sc.nextInt();
				if(dao.searchSchedule(sid1,h))

					System.out.println(h.get(sid1));
				else
					System.err.println("Schedule details not found");

				break;
			case 3:

				System.out.println("Enter the schedule id to update:");
				int sidUpdate =sc.nextInt();
				if(dao.searchSchedule(sidUpdate,h)) {

					System.out.println(h.get(sidUpdate));
					h.remove(sidUpdate);
					SchedulerBean sb1=new SchedulerBean();
					sb1.setSchedulerId(sidUpdate);

					System.out.println("Enter haulier id to update:");
					sb1.setHaulId(sc.nextInt());
					System.out.println("Enter product id to update:");
					sb1.setProdId(sc.nextInt());
					System.out.println("Enter quantity to update:");
					sb1.setQuantity(sc.nextInt());
					System.out.println("Enter delivery date to update:");
					sb1.setDeliveryDate(sc.next());

					dao.addSchedule(sb1);
					s=dao.getAllSchedule();
					h.put(sb1.getSchedulerId(), s);
					System.out.println(h.get(sidUpdate));
				}
				else 
					System.err.println("Something went wrong!");
				break;

			case 4:
				System.out.println("Enter ScheduleID to delete the account:");
				int sidDelete=sc.nextInt();
				if(dao.deleteSchedule(sidDelete, h)) {
					h.remove(sidDelete);
					System.out.println("Schedule details deleted successfully");
				}
				else {
					System.err.println("Something went wrong...");
				}
				break;
			case 5:
				Set<Map.Entry<Integer,Set<SchedulerBean>>> set=h.entrySet();
				if(set!=null) {
					for(Map.Entry<Integer,Set<SchedulerBean>> e1:set) {
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
				Set<Map.Entry<Integer,Set<ProductBean>>> set1	= h1.entrySet();
				if(set1!=null) {
					for(Map.Entry<Integer,Set<ProductBean>> e1:set1) {
						System.out.println(e1.getKey());
						System.out.println(e1.getValue());
						System.out.println("-----------------");
					}
				}
				else
				{   
					System.err.println("There is no record to display");
				}break;
			case 7:HaulierBean hb=new HaulierBean();
			System.out.println("Enter haulier id:");
			int hid1 =sc.nextInt();
			hb.setHaulId(hid1);
			System.out.println("Enter haulier contact number:");
			String hno =sc.next();
			hb.setHaulContactNo(hno);

			System.out.println("Enter haulier name:");
			String hname =sc.next();
			hb.setHaulName(hname);

			System.out.println("Enter product id:");
			int pid1 =sc.nextInt();
			hb.setProductId(pid1);

			System.out.println("Enter client id:");
			int clid =sc.nextInt();
			hb.setClientId(clid);

			System.out.println("Enter source:");
			String source =sc.next();
			hb.setSource(source);


			System.out.println("Enter destination:");
			String destination =sc.next();
			hb.setHaulName(destination);



			boolean add1=dao2.addHaulier(hb);

			s1=dao2.getAllHaulier();//temporary list of customer
			if(add1) {
				System.out.println("Haulier added successfully..!");
			}else System.err.println("Something went wrong...");
			h2.put(hb.getHaulId(),s1);

			break;

			case 8:
				HomeForestApp m=new HomeForestApp();
				m.main(null);
			default:
				break;
			}
		}catch(SchedulerIdNotFoundException e) {
			e.printStackTrace();
		}
		}
	}}




