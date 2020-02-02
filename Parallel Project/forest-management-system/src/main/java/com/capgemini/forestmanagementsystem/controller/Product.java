package com.capgemini.forestmanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.Factory.Factory;
import com.capgemini.forestmanagementsystem.bean.ProductBean;
import com.capgemini.forestmanagementsystem.exception.ContractException;
import com.capgemini.forestmanagementsystem.exception.ProductException;
import com.capgemini.forestmanagementsystem.service.ProductServices;

public class Product {
	public static void product() throws Exception {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		ProductServices services = Factory.productServicesInstance();
		ProductBean product = new ProductBean();
		Validation validation = new Validation();
		while (true) {
			try {
				System.out.println("Enter option to perform operation");
				System.out.println(" 1.Insert product\n 2.Delete product\n 3.Update Product\n "
						+ "4.View all products\n 5.View product details\n 6.Home");
				int choice = 0;
				boolean found = true;
				do {
					System.out.println("Enter the valid option:");
					try {
						choice = Integer.parseInt(scanner.next());
						if(choice>0) {
							found = true;
							}else {
								System.err.println("Enter positive number only");
								found= false;
							}

					} catch (Exception e) {

						System.err.println("Please enter valid option!");
						found = false;
					}
				} while (found != true);

				switch (choice) {
				case 1:
					boolean found7 = true;
					do {
						System.out.println("Enter product id");
						try {
							int productId = Integer.parseInt(scanner.next());
							if (productId>0) {
								product.setProductId(productId);
								found7 = true;
								}else {
									System.err.println("Enter only positive number");
									found7 = false;
								}

						} catch (Exception e) {

							System.err.println("Please enter valid id!");
							found7 = false;
						}
					} while (found7 != true);
					boolean found11 = true;
					do {
						System.out.println("Enter product name: ");
						String name = scanner.next();
						found11 = validation.productNameValidation(name);
						if(found11==true) {
							product.setProductName(name);
						}else {
							System.err.println("Enter valid product-name");
							found11 = false;
						}
						
					} while (found11 != true);

					int quantity = 0;
					boolean found3 = true;
					do {
						System.out.println("Enter the quantity:");
						try {
							quantity = Integer.parseInt(scanner.next());
							if (quantity>0) {
							product.setProductQuantity(quantity);
							found3 = true;
							} else {
								System.err.println("Enter positive quantity");
								found3=false;
							}
						} catch (Exception e) {

							System.err.println("Please enter valid id!");
							found3 = false;
						}
					} while (found3 != true);

					if (services.insertProduct(product)) {
						System.out.println("product inserted successfully");
					} else {
						System.err.println("Failed to add product");
					}
					break;
				case 2:
					boolean found17 = true;
					int productId=0;
					do {
						System.out.println("enter product id to delete");
						try {
						 productId = Integer.parseInt(scanner.next());
							if (productId>0) {
								product.setProductId(productId);
								found17 = true;
								}else {
									System.err.println("Enter only positive number");
									found17 = false;
								}

						} catch (Exception e) {

							System.err.println("Please enter valid id!");
							found17 = false;
						}
					} while (found17 != true);
					if (services.deleteProduct(productId)) {
						System.out.println("product deleted successfully");
					} else {
						System.err.println("Failed to delete product");
					}
					break;
				case 3:
					boolean found18 = true;
					int productId1=0;
					do {
						System.out.println("enter product id ");
						try {
						 productId1 = Integer.parseInt(scanner.next());
							if (productId1>0) {
								product.setProductId(productId1);
								found18 = true;
								}else {
									System.err.println("Enter only positive number");
									found18 = false;
								}

						} catch (Exception e) {

							System.err.println("Please enter valid id!");
							found18 = false;
						}
					} while (found18 != true);
					int quantity1 = 0;
					boolean found13 = true;
					do {
						System.out.println("enter quantity to update");
						try {
							quantity1 = Integer.parseInt(scanner.next());
							if (quantity1>0) {
							product.setProductQuantity(quantity1);
							found13 = true;
							} else {
								System.err.println("Enter positive quantity");
								found13=false;
							}
						} catch (Exception e) {

							System.err.println("Please enter valid id!");
							found13 = false;
						}
					} while (found13 != true);
					if (services.updateProduct(productId1, quantity1)) {
						System.out.println("Quantity updated");
					} else {
						System.err.println("Failed to update product");
					}
					break;
				case 4:
					List<ProductBean> list = services.getAllProducts();
					if (list.size() != 0) {
						for (ProductBean productList : list) {
							System.out.println(productList);
						}
					} else {
						System.err.println("no data");
					}
					break;
				case 5:
					boolean found19 = true;
					int productId2 = 0;
					do {
						System.out.println("enter product id to view details");
						try {
							productId2 = Integer.parseInt(scanner.next());
							if (productId2>0) {
								product.setProductId(productId2);
								found19 = true;
								}else {
									System.err.println("Enter only positive number");
									found19 = false;
								}

						} catch (Exception e) {

							System.err.println("Please enter valid id!");
							found19 = false;
						}
					} while (found19 != true);
					List<ProductBean> list2 = services.searchProduct(productId2);
					if (list2.isEmpty()) {
						throw new ProductException("Product not found ");
					}

					else {
						for (ProductBean productList : list2) {
							System.out.println(productList);
						}
					}
					break;
				case 6:
					try {
						Client.contract();
					} catch (ContractException e) {
						System.err.println(e.getMessage());
					}
					break;
				default:
					System.err.println("enter valid option");
					break;
				}
			} catch (ProductException e) {
				System.err.println(e.getMessage());
			}
		}
	}

}
