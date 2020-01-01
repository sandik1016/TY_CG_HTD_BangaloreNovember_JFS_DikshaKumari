 package com.capgemini.forestrymanagementsystem.controller;

import java.text.ParseException;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystem.exception.ContractIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.CustomerIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.LandIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.ProductIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.SchedulerIdNotFoundException;

public class HomeForestApp {

	public static void main(String[] args) throws Exception{
		Scanner sc=new Scanner(System.in);
		System.out.println("*****WELCOME TO FORESTRY MANAGEMENT SYSTEM*****");
		System.out.println("---------------------------HOME-----------------------------");
		System.out.println("Enter Options To Proceed Further");
		System.out.println("1.Admin Module");
		System.out.println("2.Client Module");
		System.out.println("3.Scheduler Module");
		System.out.println("4.Land Module");
		int choice=sc.nextInt();
		switch (choice) {
		case 1: Admin1 admin = new Admin1();
		        admin.admin();
			    break;
		case 2:while(true) {
			System.out.println("Enter options to proceed further");
			System.out.println("Press 1 to perform operation on customer");
			System.out.println("Press 2 to perform operation on contract");
			System.out.println("Press 3 to request for the product");
			System.out.println("Press 4 to go back to main menu");
			
			int choice1 = sc.nextInt();
			switch(choice1) {
			case 1:   Customer c = new Customer();
			                c.customer();
			                break;
			case 2:    Contractor c1=new Contractor();			
				       c1.contract();
			             break;
			case 3:       Product p = new Product();
			             p.product();
			             break;
			case 4:    HomeForestApp.main(args);
				
			default :System.out.println("Please enter valid option");	
				break;
			}
		}
	
		case 3:
			Scheduler s =new Scheduler();
		     s.scheduler();
			
			break;
		case 4:Land land = new Land();
		       land.land();
			break;
		default:System.out.println("OOPS! User you have entered incorrect option.");

		}
	}

}
