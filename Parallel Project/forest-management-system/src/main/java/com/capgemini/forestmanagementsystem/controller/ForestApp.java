package com.capgemini.forestmanagementsystem.controller;

import java.util.Scanner;

public class ForestApp {
	public static void main(String[] args) throws Exception {
		@SuppressWarnings("resource")
		Scanner scanner= new Scanner(System.in);
		while(true) {
			System.out.println("***WELCOME TO FOREST MANAGEMENT SYSTEM***");
			System.out.println("--------------- *Home*----------------------");
			System.out.println("1:Login as Admin");
			System.out.println("2:Login as Client");
			System.out.println("3.Login as Scheduler");
			int choice=0;	
			boolean found7 = true;
			do {
				System.out.println("Enter the valid option:");
				try {
					choice=Integer.parseInt(scanner.next());
					if(choice>0) {
					found7=true;
					}else {
						System.err.println("Enter only positive number");
						found7=false;
					}
				}catch(Exception e) {

					System.err.println("Please enter valid option!");
					found7=false;
				}
			}while (found7!=true);
			switch(choice) {
			case 1:
				Admin.admin();
				break;
			case 2:
				Client.contract();
				break;
			case 3:
				Scheduler.scheduler();
			default:
				System.out.println("Please enter valid option");
				break;
			}
		}
	}
}