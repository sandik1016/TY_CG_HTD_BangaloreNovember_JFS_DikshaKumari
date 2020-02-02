package com.capgemini.forestmanagementsystem.controller;

import java.util.ArrayList;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.Factory.Factory;
import com.capgemini.forestmanagementsystem.bean.ContractBean;
import com.capgemini.forestmanagementsystem.bean.UserBean;
import com.capgemini.forestmanagementsystem.exception.LandException;
import com.capgemini.forestmanagementsystem.exception.ProductException;
import com.capgemini.forestmanagementsystem.service.ContractServices;
import com.capgemini.forestmanagementsystem.service.UserServices;

public class Admin {
	public static void admin() throws Exception {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		UserServices userServices = Factory.userServicesInstance();
		ContractServices contractServices = Factory.contractServicesInstance();
		UserBean user = new UserBean();
		Validation validation = new Validation();
		while (true) {
			System.out.println("Sign up first....if you doesn't hold any account");
			System.out.println("Enter option to perform operation");
			System.out.println(" 1.Login admin\n 2.Show all admin accounts\n 3.go back");
			int choice = 0;
			boolean found = true;
			do {
				System.out.println("Enter the valid option:");
				try {
					choice = Integer.parseInt(scanner.next());
					if (choice > 0) {
						found = true;
					} else {
						System.err.println("Enter only positive number");
						found = false;
					}
				} catch (Exception e) {

					System.err.println("Please enter valid option!");
					found = false;
				}
			} while (found != true);
			switch (choice) {
			case 3:  admin();
		             break;
			case 2:
				List<UserBean> list = userServices.showUser();
				for (UserBean admin1 : list) {
					System.out.println(admin1);
				}
				break;
			case 1:
				System.out.println("Please enter valid credentials to proceed further");	
				boolean found6 = true;
				String adminEmail;
				do {
					System.out.println("Admin...enter your email");
					adminEmail = scanner.next();
					found6 = Validation.userEmailValidation(adminEmail);
					if (found6 == true) {
						user.setEmail(adminEmail);
					} else {
						System.err.println("Please enter valid email");
						found6 = false;
					}
				} while (found6 != true);
				
				boolean found8 = true;
				String adminPassword;
				do {
					System.out.println("Enter admin password: ");
					adminPassword = scanner.next();
					found8 = Validation.passwordValidation(adminPassword);
					if (found8 == true) {
						user.setPassword(adminPassword);
					} else {
						System.out.println("Please enter valid password");
						found8 = false;
					}

				} while (found8 != true);
				
				if (userServices.authenticate(adminEmail, adminPassword))

				{
					while (true) {
						System.out.println("Admin you are successfully logged in");
						System.out.println("----------*Welcome to admin section*------------");
						System.out.println("Enter option to perform operation");
						System.out.println(" 1.Add Client\n 2.Remove Client\n 3.Show Client\n 4.View Contract\n "
								+ "5.Land details\n 6.Product Details \n 7.Add Scheduler\n 8.Remove Scheduler\n 9.Home");
						int options = scanner.nextInt();
						switch (options) {
						case 1:
							int clientId = 0;
							boolean found16 = true;
							do {
								System.out.println("Enter the client ID:");
								try {
									clientId = Integer.parseInt(scanner.next());
									if(clientId>0) {
									user.setId(clientId);
									found16 = true;
									}
									else {
										System.err.println("Enter only positive number");
									}
								} catch (Exception e) {

									System.err.println("Please enter valid id!");
									found16 = false;
								}
							} while (found16 != true);

							boolean found1 = true;
							do {
								System.out.println("Enter client email: ");
								String clientEmail = scanner.next();
								found1 = Validation.userEmailValidation(clientEmail);
								if(found1==true) {
									user.setEmail(clientEmail);
								}else {
									System.out.println("Enter valid email");
									found1=false;
								}
							} while (found1 != true);

							boolean found2 = true;
							do {
								System.out.println("Enter client password: ");
								String clientPassword = scanner.next();
								found2 = Validation.passwordValidation(clientPassword);
								if(found2 == true) {
									user.setEmail(clientPassword);
								}else {
									System.out.println("Enter valid password");
									found2=false;
								}

							} while (found2 != true);
							boolean found08 = true;
							do {
							System.out.println("enter your role");
							String role1 = scanner.next().toLowerCase();
							found08 = validation.roleValidation(role1);
							if(found08==true) {
								user.setUser_type(role1);	
							}
							else {
								System.out.println("Enter valid user type");
								found08=false;
							}
							} while (found08 != true);
							if (userServices.addUser(user)) {
								System.out.println("client account created");
							} else {
								System.err.println("Sorry! account not created");
							}
							break;
						case 2:
							boolean found11 = true;
							String clientEmail;
							do {
								System.out.println("Enter client email: ");
								clientEmail = scanner.next();
								found11 = Validation.userEmailValidation(clientEmail);
								if(found11==true) {
									user.setEmail(clientEmail);
								}else {
									System.out.println("Enter valid email");
									found11=false;
								}
							} while (found11 != true);
							if (userServices.removeUser(clientEmail)) {
								System.out.println("client account deleted");
							} else {
								System.out.println("client not found");
							}
							break;
						case 3:
							List<UserBean> list1 = userServices.showUser();
							for (UserBean user1 : list1) {
								System.out.println(user1);
							}
							break;

						case 4:
							List<ContractBean> l2 = new ArrayList<ContractBean>();
							l2 = contractServices.getAllContract();
							if (l2.size() != 0) {
								for (ContractBean clientBean : l2) {
									System.out.println(clientBean);
								}
							} else {
								System.err.println("no data");
							}
							break;
						case 5:
							try {
								Land.land();
							} catch (LandException e) {
								System.err.println(e.getMessage());
							}
							break;
						case 6:
							try {
								Product.product();
							} catch (ProductException e) {
								System.err.println(e.getMessage());
							}
							break;

						case 7:
							int scheduleId = 0;
							boolean found18 = true;
							do {
								System.out.println("Enter the schedule ID:");
								try {
									scheduleId = Integer.parseInt(scanner.next());
									if(scheduleId>0) {
									user.setId(scheduleId);
									found18 = true;
									}else {
									System.err.println("Enter only positive number");
									}
								} catch (Exception e) {

									System.err.println("Please enter valid id!");
									found18 = false;
								}
							} while (found18 != true);

							boolean found9 = true;
							do {
								System.out.println("Enter scheduler email: ");
								String scheduleEmail = scanner.next();
								found9 = Validation.userEmailValidation(scheduleEmail);
								if(found9==true) {
									user.setEmail(scheduleEmail);
								}else {
									System.err.println("Enter valid email");
									found9=false;
								}

							} while (found9 != true);

							boolean found10 = true;
							do {
								System.out.println("Enter scheduler password: ");
								String schedulerPassword = scanner.next();
								found10 = Validation.passwordValidation(schedulerPassword);
								if(found10==true) {
									user.setPassword(schedulerPassword);
								}else {
									System.err.println("Enter valid password");
									System.out.println("Rules for creating password");
									System.out.println("must contains one digit from 0-9\r\n" + 
											"  must contains one lowercase characters\r\n" + 
											"  must contains one uppercase characters\r\n" + 
											"  must contains one special symbols in the list \"@#$%\"\r\n" + 
											"  match anything with previous condition checking\r\n" + 
											"  length at least 6 characters and maximum of 20");
									found10=false;
								}
							} while (found10 != true);

							boolean found19 = true;
							do {
								System.out.println("enter your role");
								String role2 = scanner.next().toLowerCase();
								found19 = validation.roleValidation(role2);
								if(found19==true) {
									user.setUser_type(role2);
								}else {
									System.err.println("Enter valid role : admin\n client\n scheduler\n");
									found19=false;
								}
							} while (found19 != true);
						
							if (userServices.addUser(user)) {
								System.out.println("scheduler account created");
							} else {
								System.err.println("Sorry! scheduler account not created");
							}
							break;

						case 8:
							String schedulerEmail;
							boolean found17 = true;
							do {
								System.out.println("Scheduler...enter email to delete");
								schedulerEmail = scanner.next();
								found17 = Validation.userEmailValidation(schedulerEmail);
								if(found17==true) {
									user.setEmail(schedulerEmail);
								}else {
									System.err.println("Enter valid email");
									found17=false;
								}
							} while (found17 != true);
						
							if (userServices.removeUser(schedulerEmail)) {
								System.out.println("scheduler account deleted");
							} else {
								System.out.println("scheduler not found");
							}
							break;
						case 9:
							ForestApp.main(null);
							break;
						default:
							System.err.println("enter valid option");
							break;
						}
					}
				} else {
					System.err.println("please enter valid credentials");
				}

			case 5:
				ForestApp.main(null);
				break;
			default:
				System.out.println("enter valid options");
			}
		}

	}
}
