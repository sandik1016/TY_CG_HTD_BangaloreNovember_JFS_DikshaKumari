package com.capgemini.shop.controller;

import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.shop.beans.ProductBean;
import com.capgemini.shop.factory.Factory;
import com.capgemini.shop.services.ProductServices;

public class Product {
	ProductServices services = Factory.getInstanceOfProductServicesImpl();
	public void product() {

		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("*****MENU LIST*******");
			System.out.println("Enter options you want to choose");
			System.out.println("Press 1 to see all the available products");
			System.out.println("Press 2 to search for a particular product");
			System.out.println("Press 3 to buy  product");
			System.out.println("Press 4 to add product");
			System.out.println("Press 5 to go back to main menu");
			int option =  sc.nextInt();

			switch(option) {
			case 1:System.out.println("-------Available Products--------");

			List<ProductBean> list = services.getAllProduct();
			if(list!=null) {
				for(ProductBean pro : list)
				{
					System.out.println("Product Id is "+pro.getProductId());
					System.out.println("Product Name  is "+pro.getProductName());
					System.out.println("Product Cost is "+pro.getProductCost());
					System.out.println("Product Category is "+pro.getProductCategory());
					System.out.println("Product Description is "+pro.getDescription());
					System.out.println("Number of products "+pro.getNo_product());

					System.out.println("--------------------------------------------------------");


				}
			}
			break;
			case 2:System.out.println("-------Search for a product-------");

			ProductBean prod=new ProductBean();
			System.out.println("enter product name....");
			String productName= sc.next();
			prod.setProductName(productName);
			
            ProductBean product1=services.searchProduct(prod.getProductName());

			if(product1!=null) {
				System.out.println("Product Id is "+product1.getProductId());
				System.out.println("Product Name  is "+product1.getProductName());
				System.out.println("Product Cost is "+product1.getProductCost());
				System.out.println("Product Category is "+product1.getProductCategory());
				System.out.println("Product Description is "+product1.getDescription());
				System.out.println("Number of products "+product1.getNo_product());
			}
			else {
				System.err.println("Requested Product Not Found");
			}
			break;
			case 3:System.out.println("--------Buy Product---------");
			ProductBean bean2 = new ProductBean();
			System.out.println("Enter product id");
			int pid = sc.nextInt();
			bean2.setProductId(pid);
			System.out.println("Enter product name");
			String pname = sc.next();
			bean2.setProductName(pname);
			boolean found = true;
			do {
				System.out.println("Enter card number: ");
				String card = sc.next();
				String regex = "[0-9]{16}";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(card);
				if( !matcher.matches()) {
					System.err.println("Please enter valid card number!");
					found=false;
				}else {
					found=true;
				}
			}while(found!=true);

			
			boolean found1 = true;
			do {
				System.out.println("Enter card CVV: ");
				String card = sc.next();
				String regex = "[0-9]{3}";
				Pattern pattern = Pattern.compile(regex);
				Matcher matcher = pattern.matcher(card);
				if( !matcher.matches()) {
					System.err.println("Please enter valid CVV!");
					found1=false;
				}else {
					found1=true;
				}
			}while(found1!=true);

			System.out.println("Congrats User ! your request to buy this product has been accepted");
			
				break;
			case 4:System.out.println("--------Add Product---------");
			ProductBean bean1 = new ProductBean();
			System.out.println("Enter product id");
			int id = sc.nextInt();
			bean1.setProductId(id);
			System.out.println("Enter product name");
			String name = sc.next();
			bean1.setProductName(name);
			System.out.println("Enter product price");
			double cost = sc.nextDouble();
			bean1.setProductCost(cost);
			System.out.println("Enter product category");
			String category =  sc.next();
			bean1.setProductCategory(category);
			System.out.println("Enter product description");
			String description = sc.next();
			bean1.setDescription(description);
			System.out.println("Enter no of products");
			int number =  sc.nextInt();
			bean1.setNo_product(number);

			boolean isAdded = services.addProduct(bean1);
			if(isAdded) {
				System.out.println("Product Added Successfully");
			}
			else {
				System.err.println("Error!Insert Again!!!");
			}

			break;
			case 5:System.out.println("-----------Main Menu---------");
			ShopApp shop=  new ShopApp();
			shop.main(null);
			}

		}

	}
}