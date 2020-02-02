package com.capgemini.forestmanagementsystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.Factory.Factory;
import com.capgemini.forestmanagementsystem.bean.CustomerBean;
import com.capgemini.forestmanagementsystem.exception.CustomerException;
import com.capgemini.forestmanagementsystem.service.CustomerServices;

public class Customer {
	public static void customer() throws Exception {
		CustomerServices services = Factory.customerServicesInstance();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		Validation validation = new Validation();
		while (true) {
			try {
				System.out.println("Enter the option to perform operations");
				System.out.println(
						" 1.enter customer details\n 2.delete customer details\n " + "3.show all customer details\n"
								+ " 4.update customer details\n 5.search customer details\n 6.Home");
				int choice = 0;
				boolean found7 = true;
				do {
					System.out.println("Enter the valid option:");
					try {
						choice = Integer.parseInt(scanner.next());
						if (choice > 0) {
							found7 = true;
						} else {
							System.err.println("enter only positive number");
							found7 = false;
						}
					} catch (Exception e) {

						System.err.println("Please enter valid option!");
						found7 = false;
					}
				} while (found7 != true);
				switch (choice) {
				case 1:
					CustomerBean customer = new CustomerBean();
					System.out.println("enter the customer details");
					int customerId = 0;
					boolean found4 = true;
					do {
						System.out.println("Enter the customer ID:");
						try {
							customerId = Integer.parseInt(scanner.next());
							if (customerId > 0) {
								customer.setCustomerId(customerId);
								found4 = true;
							} else {
								System.out.println("Enter positive number only");
								found4 = false;
							}
						} catch (Exception e) {

							System.err.println("Please enter valid id!");
							found4 = false;
						}
					} while (found4 != true);

					boolean found = true;
					do {
						System.out.println("Enter customer name: ");
						String name = scanner.next();
						found = validation.nameValidation(name);
						if (found == true) {
							customer.setCustomerName(name);
						} else {
							System.err.println("Enter valid name");
							found = false;
						}
					} while (found != true);
					boolean found1 = true;
					do {
						System.out.println("Enter customer town: ");
						String town = scanner.next();
						found1 = validation.townValidation(town);
						if (found1 == true) {
							customer.setCustomerTown(town);
						} else {
							System.err.println("Enter valid town");
							found1 = false;
						}
					} while (found1 != true);

					boolean found2 = true;
					do {
						System.out.println("Enter customer postal code: ");
						String code = scanner.next();
						found2 = validation.postalValidation(code);
						if (found2 == true) {
							customer.setCustomerPostal(code);
						} else {
							System.err.println("Enter valid postal code");
							found2 = false;
						}
					} while (found2 != true);

					boolean found3 = true;
					do {
						System.out.println("Enter customer email: ");
						String email = scanner.next();
						found3 = Validation.userEmailValidation(email);
						if (found3 == true) {
							customer.setCustomerEmail(email);
						} else {
							System.err.println("Enter valid email");
							found3 = false;
						}

					} while (found3 != true);

					boolean found11 = true;
					do {
						System.out.println("Enter customer's address: ");
						String address = scanner.next();
						found11 = validation.addressValidation(address);
						if (found11 == true) {
							customer.setCustomerAddress(address);
						} else {
							System.err.println("Enter valid address");
							found11 = false;
						}
					} while (found11 != true);

					boolean found5 = true;
					do {
						System.out.println("Enter customer contact number: ");
						String phone = scanner.next();
						found5 = validation.phoneValidation(phone);
						if (found5 == true) {
							customer.setCustomerPhone(phone);
						} else {
							System.err.println("Enter valid contact number");
							found5 = false;
						}
					} while (found5 != true);

					if (services.addCustomer(customer)) {
						System.out.println("customer details added");
					} else {
						System.err.println("customer details not added");
					}
					break;
				case 2:
					CustomerBean customer1 = new CustomerBean();
					int customerId1 = 0;
					boolean found6 = true;
					do {
						System.out.println("enter customer id to delete");
						try {
							customerId1 = Integer.parseInt(scanner.next());
							if (customerId1 > 0) {
								customer1.setCustomerId(customerId1);
								found6 = true;
							} else {
								System.out.println("Enter positive number only");
								found6 = false;
							}
						} catch (Exception e) {

							System.err.println("Please enter valid id!");
							found6 = false;
						}
					} while (found6 != true);
					if (services.deleteCustomer(customerId1)) {
						System.out.println("customer details deleted");
					} else {
						System.err.println("customer details does not exist");
					}
					break;
				case 3:
					List<CustomerBean> list3 = services.getAllCustomer();
					if (list3.size() != 0) {
						for (CustomerBean customerList : list3) {
							System.out.println(customerList);
						}
					} else {
						System.err.println("no record found here");
					}

					break;
				case 4:
					System.out.println("Enter detail to modify");
					System.out.println(" 1.Address \n 2.Contact details");
					int choice1 = 0;
					boolean found9 = true;
					do {
						System.out.println("Enter the valid option:");
						try {
							choice = Integer.parseInt(scanner.next());
							if (choice > 0) {
								found9 = true;
							} else {
								System.out.println("Enter only positive number");
								found9 = false;
							}
						} catch (Exception e) {

							System.err.println("Please enter valid option!");
							found9 = false;
						}
					} while (found9 != true);

					switch (choice1) {
					case 1:
						CustomerBean customer2 = new CustomerBean();
						int customerId3 = 0;
						boolean found12 = true;
						do {
							System.out.println("enter customer id to update");
							try {
								customerId3 = Integer.parseInt(scanner.next());
								if (customerId3 > 0) {
									customer2.setCustomerId(customerId3);
									found12 = true;
								} else {
									System.out.println("Enter positive number only");
									found12 = false;
								}
							} catch (Exception e) {

								System.err.println("Please enter valid id!");
								found12 = false;
							}
						} while (found12 != true);

						boolean found13 = true;
						do {
							System.out.println("Enter customer's address: ");
							String address = scanner.next();
							found13 = validation.addressValidation(address);
							if (found13 == true) {
								customer2.setCustomerAddress(address);
							} else {
								System.err.println("Enter valid address");
								found13 = false;
							}
						} while (found13 != true);

						boolean found14 = true;
						do {
							System.out.println("Enter customer town: ");
							String town = scanner.next();
							found14 = validation.townValidation(town);
							if (found14 == true) {
								customer2.setCustomerTown(town);
							} else {
								System.err.println("Enter valid town");
								found14 = false;
							}
						} while (found14 != true);

						boolean found15 = true;
						do {
							System.out.println("Enter customer postal code: ");
							String code = scanner.next();
							found15 = validation.postalValidation(code);
							if (found15 == true) {
								customer2.setCustomerPostal(code);
							} else {
								System.err.println("Enter valid postal code");
								found15 = false;
							}
						} while (found15 != true);

						if (services.updateAddress(customer2)) {
							System.out.println("Address updated");
						} else {
							System.err.println("Address not updated...");
						}
						break;
					case 2:
						CustomerBean customer4 = new CustomerBean();
						int customerId4 = 0;
						boolean found16 = true;
						do {
							System.out.println("enter customer id to modify");
							try {
								customerId4 = Integer.parseInt(scanner.next());
								if (customerId4 > 0) {
									customer4.setCustomerId(customerId4);
									found16 = true;
								} else {
									System.out.println("Enter positive number only");
									found16 = false;
								}
							} catch (Exception e) {

								System.err.println("Please enter valid id!");
								found16 = false;
							}
						} while (found16 != true);

						boolean found17 = true;
						do {
							System.out.println("Enter customer email: ");
							String email = scanner.next();
							found17 = Validation.userEmailValidation(email);
							if (found17 == true) {
								customer4.setCustomerEmail(email);
							} else {
								System.err.println("Enter valid email");
								found17 = false;
							}

						} while (found17 != true);
						boolean found18 = true;
						do {
							System.out.println("Enter customer contact number: ");
							String phone = scanner.next();
							found18 = validation.phoneValidation(phone);
							if (found18 == true) {
								customer4.setCustomerPhone(phone);
							} else {
								System.err.println("Enter valid contact number");
								found18 = false;
							}
						} while (found18 != true);

						if (services.updateContact(customer4)) {
							System.out.println("contact details updated...");
						} else {
							System.err.println("contact details not updated...");
						}
					default:
						System.err.println("Enter option");
						break;
					}
					break;

				case 5:
					List<CustomerBean> list1 = new ArrayList<CustomerBean>();
					CustomerBean customer5 = new CustomerBean();
					int customerId4 = 0;
					boolean found16 = true;
					do {
						System.out.println("Enter customer id to display details");
						try {
							customerId4 = Integer.parseInt(scanner.next());
							if (customerId4 > 0) {
								customer5.setCustomerId(customerId4);
								found16 = true;
							} else {
								System.out.println("Enter positive number only");
								found16 = false;
							}
						} catch (Exception e) {

							System.err.println("Please enter valid id!");
							found16 = false;
						}
					} while (found16 != true);
					list1 = services.searchCustomer(customerId4);
					if (list1.size() != 0) {
						for (CustomerBean customer2 : list1) {
							System.out.println(customer2);
						}
					} else {
						System.err.println("Customer not found");
					}
					break;
				case 6:
					ForestApp.main(null);
					break;
				default:
					System.err.println("Enter valid Option");
					break;

				}
			} catch (CustomerException e) {
				System.err.println(e.getMessage());
			}

		}
	}
}
