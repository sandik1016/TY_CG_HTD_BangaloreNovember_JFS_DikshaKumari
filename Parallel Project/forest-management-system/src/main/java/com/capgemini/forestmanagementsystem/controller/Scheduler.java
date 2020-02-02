package com.capgemini.forestmanagementsystem.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.Factory.Factory;
import com.capgemini.forestmanagementsystem.bean.ContractBean;
import com.capgemini.forestmanagementsystem.bean.ProductBean;
import com.capgemini.forestmanagementsystem.bean.SchedulerBean;
import com.capgemini.forestmanagementsystem.bean.UserBean;
import com.capgemini.forestmanagementsystem.exception.SchedulerException;
import com.capgemini.forestmanagementsystem.service.ContractServices;
import com.capgemini.forestmanagementsystem.service.ProductServices;
import com.capgemini.forestmanagementsystem.service.SchedulerServices;
import com.capgemini.forestmanagementsystem.service.UserServices;

public class Scheduler {
	public static void scheduler() throws Exception {
		SchedulerServices services = Factory.schedulerServicesInstance();
		ContractServices contractServices = Factory.contractServicesInstance();
		ProductServices productServices = Factory.productServicesInstance();
		UserServices userServices = Factory.userServicesInstance();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		SchedulerBean scheduler = new SchedulerBean();
		UserBean user = new UserBean();
		Validation validation = new Validation();
		while (true) {
			System.out.println("***Scheduler Related Operations***");
			System.out.println("Please enter valid credentials to proceed further");
			
			boolean found = true;
			String schedulerEmail;
			do {
				System.out.println("Scheduler...enter your email");
				schedulerEmail = scanner.next();
				found = Validation.userEmailValidation(schedulerEmail);
				if (found == true) {
					user.setEmail(schedulerEmail);
				} else {
					System.err.println("Please enter valid email");
					found = false;
				}
			} while (found != true);

			boolean found8 = true;
			String schedulerPassword;
			do {
				System.out.println("Enter scheduler password: ");
				schedulerPassword = scanner.next();
				found8 = Validation.passwordValidation(schedulerPassword);
				if (found8 == true) {
					user.setPassword(schedulerPassword);
				} else {
					System.out.println("Please enter valid password");
					found8 = false;
				}

			} while (found8 != true);
			if (userServices.authenticateScheduler(schedulerEmail, schedulerPassword)) {

				try {
					System.out.println("Enter option to perform operation");
					System.out.println(" 1.Insert schedule\n 2.Delete schedule\n 3.Update schedule details\n "
							+ "4.View all schedules\n 5.view schedule\n 6.view contracts\n 7.View inventory\n 8.Home");
					int choice = 0;
					boolean found7 = true;
					do {
						System.out.println("Enter the valid option:");
						try {
							choice = Integer.parseInt(scanner.next());
							if(choice>0) {
								found7 = true;
								}else {
									System.err.println("Enter positive number only");
									found7= false;
								}

						} catch (Exception e) {

							System.err.println("Please enter valid option!");
							found7 = false;
						}
					} while (found7 != true);
					switch (choice) {
					case 1:

						int scheduleId = 0;
						boolean found2 = true;
						do {
							System.out.println("Enter the schedule ID:");
							try {
								scheduleId = Integer.parseInt(scanner.next());
								if(scheduleId>0) {
								scheduler.setScheduleId(scheduleId);
								found2 = true;
								}else {
									System.err.println("Enter only positive number");
									found2=false;
								}
							} catch (Exception e) {

								System.err.println("Please enter valid id!");
								found2 = false;
							}
						} while (found2 != true);

						int contractId = 0;
						boolean found4 = true;
						do {
							System.out.println("Enter the contract ID:");
							try {
								contractId = Integer.parseInt(scanner.next());
								if(contractId>0) {
								if (services.searchContractId(contractId)) {
									scheduler.setContractId(contractId);
									found4 = true;
								} else {
									System.err.println("This contract id doesn't exists");
									found4 = false;
								}
							}else {
								System.err.println("Enter only positive number");
								found2=false;
							}}catch (Exception e) {

								System.err.println("Please enter valid id!");
								found4 = false;
							}
						} while (found4 != true);

						boolean found5 = true;
						do {
							System.out.println("Please Enter Date in this Format: \"dd-mm-yyyy\"");
							String user_InputDate = scanner.next().toString();
							try {
								found5 = validation.dateValidation(user_InputDate);
								if (found5 == true) {
									scheduler.setDeliveryDate(user_InputDate);
								} else {
									System.err.println("Enter valid date");
									found5 = false;
								}

							} catch (Exception e) {
								System.err.println("Please enter correct format");
								return;
							}
						} while (found5 != true);

						boolean found17 = true;
						do {
							System.out.println("Enter schedule status: ");
							String status = scanner.next();

							found = validation.statusValidation(status);
							if (found17 == true) {
								scheduler.setStatus(status);
							} else {
								System.err.println(" Please enter valid schedule status");
								found17 = false;
							}
						} while (found17 != true);

						if (services.addSchedule(scheduler)) {
							System.out.println("schedule details inserted");
						} else {
							System.err.println("schedule details not inserted");
						}
						break;
					case 2:
						
						int scheduleId5 = 0;
						boolean found29 = true;
						do {
							System.out.println("enter schedule id to delete");
							try {
								scheduleId5 = Integer.parseInt(scanner.next());
								if(scheduleId5>0) {
								scheduler.setScheduleId(scheduleId5);
								found29 = true;
								}else {
									System.err.println("Enter only positive number");
									found29=false;
								}
							} catch (Exception e) {

								System.err.println("Please enter valid id!");
								found29 = false;
							}
						} while (found29 != true);

						if (services.deleteSchedule(scheduleId5)) {
							System.out.println("schedule details deleted");
						} else {
							System.err.println("schedule details not found");
						}
						break;
					case 3:
						System.out.println("select detail to update\n 1.contractId \n 2.date");
						int choice2 = 0;
						boolean found26 = true;
						do {
							System.out.println("Enter the valid option:");
							try {
								choice2 = Integer.parseInt(scanner.next());
								if(choice2>0) {
									found26 = true;
								}else {
									System.err.println("Enter only positive number");
									found26 = false;
								}

							} catch (Exception e) {

								System.err.println("Please enter valid option!");
								found26 = false;
							}
						} while (found26 != true);
						switch (choice2) {
						case 1:
							int scheduleId1 = 0;
							boolean found21 = true;
							do {
								System.out.println("enter schedule id to update");
								try {
									scheduleId1 = Integer.parseInt(scanner.next());
									if(scheduleId1>0) {
									scheduler.setScheduleId(scheduleId1);
									found21 = true;
									}else {
										System.err.println("Enter only positive number");
										found21=false;
									}
								} catch (Exception e) {

									System.err.println("Please enter valid id!");
									found21 = false;
								}
							} while (found21 != true);
							int contractId1 = 0;
							boolean found23 = true;
							do {
								System.out.println("enter contractId to update");
								
								try {
									contractId1 = Integer.parseInt(scanner.next());
									if(contractId1>0) {
									scheduler.setContractId(contractId1);
									found23 = true;
									}else {
										System.err.println("Enter only positive number");
										found23=false;
									}
								} catch (Exception e) {

									System.err.println("Please enter valid id!");
									found23 = false;
								}
							} while (found23 != true);
							
							
							if (services.updateSchedule(scheduleId1, contractId1)) {
								System.out.println("schedule updated");
							} else {
								System.err.println("schedule details not found");
							}
							break;
						case 2:
							int scheduleId12 = 0;
							boolean found28 = true;
							do {
								System.out.println("enter schedule id to update");
								try {
									scheduleId12 = Integer.parseInt(scanner.next());
									if(scheduleId12>0) {
									scheduler.setScheduleId(scheduleId12);
									found28 = true;
									}else {
										System.err.println("Enter only positive number");
										found28=false;
									}
								} catch (Exception e) {

									System.err.println("Please enter valid id!");
									found28 = false;
								}
							} while (found28 != true);

							String user_InputDate;
							boolean found24 = true;
							do {
								System.out.println("Please Enter Date in this Format: \"dd-mm-yyyy\"");
							    user_InputDate = scanner.next().toString();
								try {
								found24 = validation.dateValidation(user_InputDate);
								if (found24 == true) {
									scheduler.setDeliveryDate(user_InputDate);
								} else {
									System.err.println("Enter valid date");
									found24 = false;
								}
								} catch (Exception e) {
									System.err.println("Please enter correct format");
									return;
								}
							} while (found24 != true);
							if (services.updateScheduleDate(scheduleId12, user_InputDate)) {
								System.out.println("schedule updated");
							} else {
								System.err.println("schedule details not found");
							}
							break;
						default:
							System.err.println("enter option");
							break;
						}
						break;
					case 4:
						List<SchedulerBean> l1 = services.getAllSchedules();
						if (l1.size() != 0) {
							for (SchedulerBean sch1 : l1) {
								System.out.println(sch1);
							}
						} else {
							System.err.println("no data");
						}
						break;
					case 5:
						int scheduleId2 = 0;
						boolean found22 = true;
						do {
							System.out.println("enter scheduler id to view");
							try {
								scheduleId2 = Integer.parseInt(scanner.next());
								if(scheduleId2>0) {
								scheduler.setScheduleId(scheduleId2);
								found22 = true;
								}else {
									System.err.println("Enter only positive number");
									found22=false;
								}
							} catch (Exception e) {

								System.err.println("Please enter valid id!");
								found22 = false;
							}
						} while (found22 != true);
						List<SchedulerBean> l3 = services.searchSchedule(scheduleId2 );
						if (l3.size() != 0) {
							for (SchedulerBean sch1 : l3) {
								System.out.println(sch1);
							}
						} else {
							System.err.println("schedule not found");
						}
						break;
					case 6:
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
					case 7:
						List<ProductBean> l4 = productServices.getAllProducts();
						for (ProductBean product1 : l4) {
							System.out.println(product1);
						}
						break;
					case 8:
						ForestApp.main(null);
						break;
					default:
						System.err.println("enter a valid option");
						break;
					}
				} catch (SchedulerException e) {
					System.err.println(e.getMessage());
				}
			}
		}
	}
}
