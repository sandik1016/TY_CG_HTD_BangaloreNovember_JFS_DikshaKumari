package com.capgemini.module1.controller;

import java.util.Scanner;

public class PhoneApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter the valid option");
			System.out.println("Press 1 to view contact");
			System.out.println("Press 2 to search contact");
			System.out.println("Press 3 to perform CRUD operation");
			int option = sc.nextInt();
			switch(option) {
			case 1: System.out.println("Hello user! you can view contact records");
			        GetAllContact c= new GetAllContact();
			        c.getAllContact();
			        break;

			case 2:  System.out.println("Hello user! you can serach for the contact here");
			         while(true) {
				        System.out.println("Enter the valid option");
				        System.out.println("Press 1 to call");
				        System.out.println("Press 2 to message");
				        System.out.println("Press 3 to go back to main menu");
				        int option1 = sc.nextInt();
				        switch(option1) {
				               case 1:
					                   break;
				               case 2:
					                   break;
				               case 3: PhoneApp p =  new PhoneApp();
				                       p.main(null);
				            	       break;

				}

			}
			case 3:  System.out.println("Hello user! you can perform CRUD operation here");
			       while(true) {
				System.out.println("Enter the valid option");
				System.out.println("Press 1 to add contact");
				System.out.println("Press 2 to delete contact");
				System.out.println("Press 3 to edit contact");
				int option2 = sc.nextInt();
				switch(option2) {
				case 1:  AddContact add =new AddContact();
				         add.addContact();
					break;
				case 2: DeleteContact delete = new DeleteContact();
				        delete.deleteContact();
					break;
				case 3:UpdateContact update = new UpdateContact();
				       update.updateContact();
					break;

				}

            }	
			default: System.out.println("Invalid option!");


			}

		}

	}

}
