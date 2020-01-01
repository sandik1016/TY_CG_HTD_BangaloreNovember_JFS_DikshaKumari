package com.capgemini.forestrymanagementsystem.controller;

import java.util.List;

import java.util.Scanner;

import com.capgemini.forestrymanagementsystem.bean.ProductBean;
import com.capgemini.forestrymanagementsystem.factory.Factory;
import com.capgemini.forestrymanagementsystem.service.ProductServices;
public class Product {
	public void product() {
		Scanner sc=new Scanner(System.in);

		while (true) {
			System.out.println("-----WELCOME TO PRODUCT MODULE-----");
			System.out.println("Press 1 to add product");
			System.out.println("Press 2 to search product");
			System.out.println("Press 3 to update product");
			System.out.println("Press 4 to remove product");
			System.out.println("Press 5 to get all product");
			System.out.println("Press 6 to return HOME");

			int choice=sc.nextInt();	



			switch (choice) {
			
			case 1:
				ProductServices services=Factory.instanceOfProductServices();
				ProductBean user=new ProductBean();
				Scanner sc1= new Scanner(System.in);
				System.out.println("enter product id....");
				user.setProductId(sc1.nextInt());
				System.out.println("enter  product name....");
				user.setProductName(sc1.next());
				if(services.addProduct(user)) {
					System.out.println("product inserted....");
				}
				else {
					System.err.println("something went wrong");
				}
				break;
			case 2:
				break;
			case 3:
				ProductServices services4=Factory.instanceOfProductServices();
				
				Scanner sc4= new Scanner(System.in);
				System.out.println("Enter the product ID:");
				int ctid=sc.nextInt();
				ProductBean user4=new ProductBean();
				user4.setProductId(ctid);
				System.out.println("Enter the product name: ");
				String pnm=sc4.next();
				user4.setProductName(pnm);
				boolean result4 =services4.updateProduct(ctid,user4);
				
						if(result4){
					System.out.println("product updated....");
				}
				else {
					System.err.println("something went wrong");
				}
				break;
			case 4:
				ProductServices services2=Factory.instanceOfProductServices();
			ProductBean user3=new ProductBean();
			Scanner sc2= new Scanner(System.in);
			System.out.println("enter product id....");
			user3.setProductId(sc2.nextInt());
			boolean result1 =services2.deleteProduct(user3.getProductId());
			if(result1) {
			
				System.out.println("product deleted....");
			}
			else {
				System.err.println("something went wrong");
			}
				break;
			case 5:ProductServices services1 =  Factory.instanceOfProductServices();
			List<ProductBean> list=services1.getAllProduct();//return type is list so i'll be creating a list of generic type 
			if(list !=null) {
				for(ProductBean user1 : list) {
					System.out.println(user1);
				}
			}
              
			break;
				
		default:System.out.println("Invalid option! please choose correct one...");

			}

	}
	

	}
}
