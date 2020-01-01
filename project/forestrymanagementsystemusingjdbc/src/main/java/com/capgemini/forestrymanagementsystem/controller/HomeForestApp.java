package com.capgemini.forestrymanagementsystem.controller;

import java.util.Scanner;



public class HomeForestApp {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("WELCOME TO FORESTRY MANAGEMENT SYSTEM");
		System.out.println("***HOME***");
		System.out.println("Enter Options To Proceed Further");
		System.out.println("1.Customer Module");
		System.out.println("2.Contractor Module");
		System.out.println("3.Product Module");
		int choice=sc.nextInt();
		switch (choice) {
		case 1:
			Customer c= new Customer();
			c.customer();
			
			break;
		case 2:
			Contractor c1=new Contractor();			
			c1.contractor();
			break;
		case 3:
			Product p=new Product();
			p.product();
			break;
		default:System.out.println("OOPS! User you have entered incorrect option.");

		}
	}
}


