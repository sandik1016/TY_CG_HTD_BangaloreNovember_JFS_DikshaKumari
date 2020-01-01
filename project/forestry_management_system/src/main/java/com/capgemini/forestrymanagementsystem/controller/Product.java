package com.capgemini.forestrymanagementsystem.controller;

import java.util.HashMap;

import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestrymanagementsystem.bean.ProductBean;
import com.capgemini.forestrymanagementsystem.dao.ProductDAO;
import com.capgemini.forestrymanagementsystem.exception.ContractIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.CustomerIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.LandIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.ProductIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.SchedulerIdNotFoundException;
import com.capgemini.forestrymanagementsystem.factory.ForestryManager;


public class Product {
	static ProductDAO cdao=ForestryManager.getProductDAOImpl();
	static Set<ProductBean> s;//here we are not creating object so we can assign it with null
	static Map<Integer,Set<ProductBean>> h=new HashMap<Integer,Set<ProductBean>>();
	public void product() throws Exception {

	
		Scanner sc=new Scanner(System.in);
		
		while (true) {
		try {
			System.out.println("------WELCOME TO PRODUCT MODULE-----");
			System.out.println("Press 1 to add Product");
			System.out.println("Press 2 to search Product");
			System.out.println("Press 3 to update Product");
			System.out.println("Press 4 to remove Product");
			System.out.println("Press 5 to get all Product");
			System.out.println("Press 6 to return HOME");

			int option=sc.nextInt();


			switch (option) {
			case 1:
				ProductBean cb3=new ProductBean();
				
				
				
				int productId=0;
				boolean found6 = true;
				do {
					System.out.println("Enter the product id: ");
					try {
						productId=Integer.parseInt(sc.next());
						cb3.setPid(productId);
						found6=true;

					}catch(Exception e) {

						System.err.println("Please enter valid id!");
						found6=false;
					}
				}while (found6!=true);
				do {
				System.out.println("Enter the product name: ");
				String name=sc.next();
				cb3.setName(name);
				String regex0 = "^[A-Za-z]{3,15}$";
				Pattern pattern0 = Pattern.compile(regex0);
				Matcher matcher0 = pattern0.matcher(name);
				if( matcher0.matches()) {
					cb3.getName();
				}else {
					System.err.println("Please enter valid product name!");
					break;
				}
				}while(false);
				
				
				
				int quantity=0;
				boolean found1 = true;
				do {
					System.out.println("Enter the product quantity: ");
					try {
						quantity=Integer.parseInt(sc.next());
						cb3.setQuantity(quantity);
						found1=true;

					}catch(Exception e) {

						System.err.println("Please enter valid id!");
						found1=false;
					}
				}while (found1!=true);
				
				System.out.println("Enter the product class: ");
				char cls=sc.next().charAt(0);
				cb3.setProductClass(cls);
				
				double cost=0.0;
				boolean found2 = true;
				do {
					System.out.println("Enter the product cost: ");
					
					try {
						cost=Double.parseDouble(sc.next());
						cb3.setCost(cost);
						found2=true;

					}catch(Exception e) {

						System.err.println("Please enter valid id!");
						found2=false;
					}
				}while (found2!=true);


				boolean add=cdao.addProduct(cb3);
				s=cdao.getAllProduct();
				
				if(add) {
					System.out.println("Product added successfully..!");
				}else System.err.println("something went wrong..!");
				h.put(cb3.getPid(), s);
				break;


			case 2:
				System.out.println("Enter the ProductID to search product: ");
				int pid=sc.nextInt();
				if(cdao.searchProduct(pid, h))

					System.out.println(h.get(pid));
				else
					System.err.println("Product details not found");
				break;
			case 3:
				
				System.out.println("Enter your product id to update: ");
				int pidToUpdate=sc.nextInt();
				if(cdao.searchProduct(pidToUpdate, h)) {
					System.out.println(h.get(pidToUpdate));
					h.remove(pidToUpdate);
					ProductBean cb4=new ProductBean();
					cb4.setPid(pidToUpdate);

				
				System.out.println("Enter your product name to update: ");
				cb4.setName(sc.next());
				System.out.println("Enter your product class to update: ");
				cb4.setProductClass(sc.next().charAt(0));
				System.out.println("Enter your product cost to update: ");
				cb4.setCost(sc.nextInt());
				System.out.println("enter your Product quantity to update: ");
				cb4.setQuantity(sc.nextInt());
				cdao.addProduct(cb4);
				s=cdao.getAllProduct();
				h.put(cb4.getPid(), s);
				System.out.println(h.get(pidToUpdate));
				}
				else 
					System.err.println("Something went wrong!");
				break;
			case 4:
				System.out.println("Enter Product ID to delete the account:");
				int pidToDelete=sc.nextInt();
				if(cdao.deleteProduct(pidToDelete,h)) {
					h.remove(pidToDelete);
					System.out.println("Product details deleted successfully");
				}
				else {
					System.err.println("Something went wrong...");
				}
			case 5:
				Set<Map.Entry<Integer,Set<ProductBean>>> s1=h.entrySet();
				if(s1!=null) {
				for(Map.Entry<Integer,Set<ProductBean>> e1:s1) {
					System.out.println(e1.getKey());
					System.out.println(e1.getValue());
					System.out.println("-----------------");
				}
				}
				else
				{
					System.err.println("There is no record to display");
				}
			case 6:
				HomeForestApp m=new HomeForestApp();
				m.main(null);
			}
		}catch(ProductIdNotFoundException e) {
			e.printStackTrace();
		}
	}
}
}
