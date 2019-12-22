package com.capgemini.shop.controller;

import java.util.Scanner;

public class ShopApp {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
		System.out.println("WELCOME TO FLIPKART");
		System.out.println("Hello User!Please enter a valid option");
		System.out.println("Press 1 to visit the product section");
		int option = sc.nextInt();
		switch(option) {
		case 1: Product p= new Product();
		        p.product();
		        break;
		default:System.out.println("Please enter valid options");
		}
		

	}

}
}