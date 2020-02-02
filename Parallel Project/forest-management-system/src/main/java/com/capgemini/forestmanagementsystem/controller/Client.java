package com.capgemini.forestmanagementsystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.Factory.Factory;
import com.capgemini.forestmanagementsystem.bean.ContractBean;
import com.capgemini.forestmanagementsystem.bean.UserBean;
import com.capgemini.forestmanagementsystem.exception.ContractException;
import com.capgemini.forestmanagementsystem.exception.CustomerException;
import com.capgemini.forestmanagementsystem.exception.ProductException;
import com.capgemini.forestmanagementsystem.service.ContractServices;
import com.capgemini.forestmanagementsystem.service.UserServices;

public class Client {
	public static void contract() throws Exception {

		UserServices userServices = Factory.userServicesInstance();
		ContractServices contractServices = Factory.contractServicesInstance();
		ContractBean client;
		Validation validation = new Validation();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		UserBean user = new UserBean();
		System.out.println("*****WELCOME TO CLIENT MODULE*****");
		boolean found = true;
		String clientEmail;
		do {
			System.out.println("Client...enter your email");
			clientEmail = scanner.next();
			found = Validation.userEmailValidation(clientEmail);
			if (found == true) {
				user.setEmail(clientEmail);
			} else {
				System.err.println("Please enter valid email");
				found = false;
			}
		} while (found != true);

		boolean found8 = true;
		String clientPassword;
		do {
			System.out.println("Enter client password: ");
			clientPassword = scanner.next();
			found8 = Validation.passwordValidation(clientPassword);
			if (found8 == true) {
				user.setPassword(clientPassword);
			} else {
				System.out.println("Please enter valid password");
				found8 = false;
			}

		} while (found8 != true);

		if (userServices.authenticateClient(clientEmail, clientPassword)) {
			System.out.println("Client you are successfully logged in");
			while (true) {
				try {
					System.out.println("Enter the option to perform operations");
					System.out.println(" 1.Enter contract details\n 2.Delete contract\n 3.Show all contracts\n"
							+ " 4.Update contract\n 5.Inventory/product\n 6.View contract \n 7.Customer Details\n 8.Home");
					int choice = 0;
					boolean found5 = true;
					do {
						System.out.println("Enter the valid option:");
						try {
							choice = Integer.parseInt(scanner.next());
							if (choice > 0) {
								found5 = true;
							} else {
								System.err.println("Enter only positive number");
								found5 = false;
							}

						} catch (Exception e) {

							System.err.println("Please enter valid option!");
							found5 = false;
						}
					} while (found5 != true);
					switch (choice) {
					case 1:
						client = new ContractBean();
						System.out.println("enter the contract details");
						int contractId1 = 0;
						boolean found2 = true;
						do {
							System.out.println("Enter the contract ID:");
							try {
								contractId1 = Integer.parseInt(scanner.next());
								if (contractId1 > 0) {
									client.setContractId(contractId1);
									found2 = true;
								} else {
									System.err.println("Enter only positive number");
									found2 = false;
								}
							} catch (Exception e) {

								System.err.println("Please enter valid id!");
								found2 = false;
							}
						} while (found2 != true);
						int customerId = 0;
						boolean found1 = true;
						do {
							System.out.println("Enter the customer ID:");
							try {
								customerId = Integer.parseInt(scanner.next());
								if (customerId > 0) {
									if (contractServices.searchCustomerId(customerId)) {

										client.setCustomerId(customerId);
										found1 = true;
									} else {
										System.err.println("CustomerId doesn't exists");
										found1 = false;
									}
								} else {
									System.err.println("Enter only positive number");
									found1 = false;
								}
							} catch (Exception e) {

								System.err.println("Please enter valid id!");
								found1 = false;
							}
						} while (found1 != true);
						int productId = 0;
						boolean found12 = true;
						do {
							System.out.println("Enter the product ID:");
							try {
								productId = Integer.parseInt(scanner.next());
								if (productId > 0) {
									if (contractServices.searchProductId(productId)) {
										client.setProductId(productId);
										found12 = true;
									} else {
										System.err.println("Product id doesn't exists");
										found12 = false;
									}
								} else {
									System.err.println("Enter only positive number");
									found12 = false;
								}
							} catch (Exception e) {

								System.err.println("Please enter valid id!");
								found12 = false;
							}
						} while (found12 != true);

						int quantity = 0;
						boolean found3 = true;
						do {
							System.out.println("Enter the quantity:");
							try {
								quantity = Integer.parseInt(scanner.next());
								if (quantity > 0) {
									client.setQuantity(quantity);
									found3 = true;
								} else {
									System.err.println("Enter only positive number");
									found3 = false;
								}
							} catch (Exception e) {

								System.err.println("Please enter valid quantity!");
								found3 = false;
							}
						} while (found3 != true);

						boolean found4 = true;
						do {
							System.out.println("Please Enter Date in this Format: \"dd-mm-yyyy\"");
							String user_InputDate = scanner.next().toString();
							try {
								found4 = validation.dateValidation(user_InputDate);
								if (found4 == true) {
									client.setDeliveryDate(user_InputDate);
								} else {
									System.err.println("Enter valid date");
									found4 = false;
								}
							} catch (Exception e) {
								System.err.println("Please enter correct format");
								return;
							}
						} while (found4 != true);

						try {
							if (contractServices.addContract(client)) {
								System.out.println("contract inserted successfully");
							} else {
								System.err.println("Failed!contract not added");
							}
						} catch (ContractException e) {
							System.out.println(e.getMessage());
						}
						break;
					case 2:
						ContractBean client1 = new ContractBean();
						int contractId = 0;
						boolean found6 = true;
						do {
							System.out.println("enter contract id to delete");
							try {
								contractId = Integer.parseInt(scanner.next());
								if (contractId > 0) {
									client1.setContractId(contractId);
									found6 = true;
								} else {
									System.err.println("Enter only positive number");
									found6 = false;
								}
							} catch (Exception e) {
								System.err.println("Please enter valid id!");
								found6 = false;
							}
						} while (found6 != true);
						if (contractServices.deleteContract(contractId)) {
							System.out.println("contract deleted successfully");
						} else {
							System.err.println("Sorry!contract does not exist");
						}
						break;
					case 3:
						List<ContractBean> l1 = new ArrayList<ContractBean>();
						l1 = contractServices.getAllContract();
						if (l1.size() != 0) {
							for (ContractBean clientBean : l1) {
								System.out.println(clientBean);
							}
						} else {
							System.err.println("No records found");
						}
						break;
					case 4:
						ContractBean client2 = new ContractBean();
						int contractId2 = 0;
						boolean found9 = true;
						do {
							System.out.println("Enter contract id to modify");
							try {
								contractId2 = Integer.parseInt(scanner.next());
								if (contractId2 > 0) {
									client2.setContractId(contractId2);
									found9 = true;
								} else {
									System.err.println("Enter only positive number");
								}
							} catch (Exception e) {
								System.err.println("Please enter valid id!");
								found9 = false;
							}
						} while (found9 != true);
						System.out.println("Enter detail to modify");
						System.out.println(" 1.product id\n  2.delivery date\n ");
						int choice1 = 0;
						boolean found7 = true;
						do {
							System.out.println("Enter the valid option:");
							try {
								choice = Integer.parseInt(scanner.next());
								if (choice > 0) {
									found7 = true;
								} else {
									System.err.println("Enter only positive number");
								}
							} catch (Exception e) {

								System.err.println("Please enter valid option!");
								found7 = false;
							}
						} while (found7 != true);

						switch (choice1) {
						case 1:
							int productId1 = 0;
							boolean found13 = true;
							do {
								System.out.println("Enter the product ID:");
								try {
									productId1 = Integer.parseInt(scanner.next());
									if (productId1 > 0) {
										if (contractServices.searchProductId(productId1)) {
											client2.setProductId(productId1);
											found13 = true;
										} else {
											System.err.println("Product id doesn't exists");
											found13 = false;
										}
									} else {
										System.err.println("Enter only positive number");
										found13 = false;
									}
								} catch (Exception e) {
									System.err.println("Please enter valid id!");
									found13 = false;
								}
							} while (found13 != true);

							if (contractServices.updateProductId(contractId2, productId1)) {
								System.out.println("Congrats!ProductId updated");
							} else {
								System.err.println("Error occured while updation of product id");
							}
							break;

						case 2:
							String user_InputDate;
							boolean found11 = true;
							do {
								System.out.println("Please Enter Date in this Format: \"dd-mm-yyyy\"");
								user_InputDate = scanner.next().toString();
								try {
									found11 = validation.dateValidation(user_InputDate);
									if (found11 == true) {
										client2.setDeliveryDate(user_InputDate);
									} else {
										System.err.println("Enter valid date");
										found11 = false;
									}
								} catch (Exception e) {
									System.err.println("Please enter correct format");
									return;
								}
							} while (found11 != true);
							if (contractServices.updateDeliveryDate(contractId2, user_InputDate)) {
								System.out.println("delivery date updated");
							} else {
								System.err.println("OOPS!delivery date not updated");
							}
							break;

						default:
							System.err.println("enter option");
							break;
						}
						break;
					case 5:
						try {
							Product.product();
						} catch (ProductException e) {
							System.err.println(e.getMessage());
						}
						break;

					case 6:
						ContractBean client3 = new ContractBean();
						List<ContractBean> list3 = new ArrayList<ContractBean>();
						int contractId4 = 0;
						boolean found14 = true;
						do {
							System.out.println("Enter the contract ID:");
							try {
								contractId4 = Integer.parseInt(scanner.next());
								if (contractId4 > 0) {
									client3.setContractId(contractId4);
									found14 = true;
								} else {
									System.err.println("Enter only positive number");
									found14 = false;
								}
							} catch (Exception e) {

								System.err.println("Please enter valid id!");
								found14 = false;
							}
						} while (found14 != true);

						list3 = contractServices.searchContract(contractId4);
						if (list3.size() != 0) {
							for (ContractBean cust2 : list3) {
								System.out.println(cust2);
							}
						} else {
							System.err.println("contract not found");
						}
						break;
					case 7:
						try {
							Customer.customer();
						} catch (CustomerException e) {
							System.err.println(e.getMessage());
						}
						break;
					case 8:
						ForestApp.main(null);
						break;
					default:
						System.err.println("enter valid option");
						break;
					}

				} catch (ContractException e) {
					System.err.println(e.getMessage());
				}

			}
		} else {
			System.err.println("Enter correct login details");
		}
	}
}
