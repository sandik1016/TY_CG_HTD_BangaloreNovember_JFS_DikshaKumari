package com.capgemini.forestmanagementsystem.controller;

import java.util.List;
import java.util.Scanner;

import com.capgemini.forestmanagementsystem.Factory.Factory;
import com.capgemini.forestmanagementsystem.bean.LandBean;
import com.capgemini.forestmanagementsystem.exception.LandException;
import com.capgemini.forestmanagementsystem.service.LandServices;

public class Land {
	public static void land() throws Exception {
		LandServices services = Factory.landServicesInstance();
		Validation validation = new Validation();
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		LandBean land = new LandBean();
		
		while (true) {
			try {
				System.out.println("Enter option to perform operation");
				System.out.println(" 1.Insert land details\n 2.Delete land details\n 3.Update land details\n "
						+ "4.View all land details\n 5.view land details\n 6.Home");
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
					int landId1 = 0;
					boolean found = true;
					do {
						System.out.println("Enter the land ID:");
						try {
							landId1 = Integer.parseInt(scanner.next());
							if (landId1>0) {
							land.setLandId(landId1);
							found = true;
							}else {
								System.err.println("Enter only positive number");
								found = true;
							}
						} catch (Exception e) {
							System.err.println("Please enter valid id!");
							found = false;
						}
					} while (found != true);

					boolean found4 = true;
					do {
						System.out.println("Enter land location");
						String land1 = scanner.next();
						found4 = validation.addressValidation(land1);
						if(found4==true) {
							land.setLandLocation(land1);
						}else {
							System.err.println("Enter valid location");
							found4= false;
						}

					} while (found4 != true);

					double landCost = 0.0;
					boolean found6 = true;
					do {
						System.out.println("Enter land cost:");
						try {
							landCost = Double.parseDouble(scanner.next());
							if(landCost>0) {
								land.setLandCost(landCost);
								found6 = true;
							}else {
								System.err.println("Enter valid cost");
								found6= false;
							}
						} catch (Exception e) {

							System.err.println("Please enter valid id!");
							found6 = false;
						}
					} while (found6 != true);
					String user_InputDate;
					boolean found11 = true;
					do {
						System.out.println("Enter the acquiring date of land");
						System.out.println("Please Enter Date in this Format: \"dd-mm-yyyy\"");
						user_InputDate = scanner.next().toString();
						try {
						found11 = validation.dateValidation(user_InputDate);
						if (found11 == true) {
							land.setAcquiredDate(user_InputDate);
						} else {
							System.err.println("Enter valid date");
							found11 = false;
						}
						} catch (Exception e) {
							System.err.println("Please enter correct format");
							return;
						}
					} while (found11 != true);
					
					if (services.addLandDetails(land)) {
						System.out.println("land details inserted");
					} else {
						System.err.println("land details not inserted");
					}
					break;
				case 2:
					int landId2 = 0;
					boolean found9 = true;
					do {
						System.out.println("enter land id to delete");
						try {
							landId2 = Integer.parseInt(scanner.next());
							if (landId2>0) {
							land.setLandId(landId2);
							found9 = true;
							}else {
								System.err.println("Enter only positive number");
								found9 = true;
							}
						} catch (Exception e) {
							System.err.println("Please enter valid id!");
							found9 = false;
						}
					} while (found9 != true);

					if (services.deleteLandDetails(landId2)) {
						System.out.println("land details deleted");
					} else {
						System.err.println("land details not found");
					}
					break;
				case 3:
					int landId3 = 0;
					boolean found10 = true;
					do {
						System.out.println("enter land id to update");
						try {
							landId3 = Integer.parseInt(scanner.next());
							if (landId3>0) {
							land.setLandId(landId3);
							found10 = true;
							}else {
								System.err.println("Enter only positive number");
								found10 = true;
							}
						} catch (Exception e) {
							System.err.println("Please enter valid id!");
							found10 = false;
						}
					} while (found10 != true);
					
					int landCost1 = 0;
					boolean found16 = true;
					do {
						System.out.println("enter land cost to update");
						try {
							landCost1 = Integer.parseInt(scanner.next());
							if(landCost1>0) {
								land.setLandCost(landCost1);
								found16 = true;
							}else {
								System.err.println("Enter valid cost");
								found16= false;
							}
						} catch (Exception e) {

							System.err.println("Please enter valid id!");
							found16 = false;
						}
					} while (found16 != true);
					
					if (services.updateLandDetails(landId3, landCost1)) {
						System.out.println("land value updated");
					} else {
						System.err.println("land details not found");
					}
					break;
				case 4:
					List<LandBean> list = services.getAllLandDetails();
					if (list.size() != 0) {
						for (LandBean land1 : list) {
							System.out.println(land1);
						}
					} else {
						System.err.println("no data");
					}
					break;
				case 5:
					
					int landId4 = 0;
					boolean found12 = true;
					do {
						System.out.println("enter land id to display details");
						try {
							landId4 = Integer.parseInt(scanner.next());
							if (landId4>0) {
							land.setLandId(landId4);
							found12 = true;
							}else {
								System.err.println("Enter only positive number");
								found12 = true;
							}
						} catch (Exception e) {
							System.err.println("Please enter valid id!");
							found12 = false;
						}
					} while (found12 != true);
					List<LandBean> list1 = services.searchLandDetails(landId4);
					if (list1.size() != 0) {
						for (LandBean land1 : list1) {
							System.out.println(land1);
						}
					} else {
						System.err.println("no data");
					}

					break;
				case 6:
					Admin.admin();
					break;
				default:
					System.err.println("enter an option");
					break;
				}
			} catch (LandException e) {
				
			}
		}
	}

}