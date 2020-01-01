package com.capgemini.forestrymanagementsystem.controller;

import java.util.List;

import java.util.Scanner;

import com.capgemini.forestrymanagementsystem.bean.ContractorBean;
import com.capgemini.forestrymanagementsystem.factory.Factory;
import com.capgemini.forestrymanagementsystem.service.ContractorServices;



public class Contractor {
	public void contractor() {
		Scanner sc=new Scanner(System.in);

		while (true) {
			System.out.println("-----WELCOME TO CONTRACTOR MODULE-----");
			System.out.println("Press 1 to add contractor");
			System.out.println("Press 2 to search contractor");
			System.out.println("Press 3 to update contractor");
			System.out.println("Press 4 to remove contractor");
			System.out.println("Press 5 to get all contractor");
			System.out.println("Press 6 to return HOME");

			int choice=sc.nextInt();	



			switch (choice) {
			
			case 1:
				ContractorServices services=Factory.instanceOfContractorServices();
				ContractorBean user=new ContractorBean();
				Scanner sc1= new Scanner(System.in);
				System.out.println("enter contract id....");
				user.setContractId(sc1.nextInt());
				System.out.println("enter customer id....");
				user.setCustomerId(sc1.nextInt());
				System.out.println("enter product id....");
				user.setProductId(sc1.nextInt());
				System.out.println("enter haulier id....");
				user.setHaulierId(sc1.nextInt());
				System.out.println("enter delivery date....");
				user.setDeliveryDate(sc1.next());
				System.out.println("enter delivery day....");
				user.setDeliveryDay(sc1.next());
				System.out.println("enter  quantity....");
				user.setQuantity(sc1.nextInt());
				
			
				if(services.addContractor(user)) {
					System.out.println("contract inserted....");
				}
				else {
					System.err.println("something went wrong");
				}
				
			
			break;
			case 2:
				break;
			case 3:
				ContractorServices services4=Factory.instanceOfContractorServices();
				
				Scanner sc4= new Scanner(System.in);
				System.out.println("Enter the contract ID:");
				int ctid=sc.nextInt();
				ContractorBean user4=new ContractorBean();
				user4.setCustomerId(ctid);
				System.out.println("Enter the customer ID:");
				int cusid=sc4.nextInt();
				user4.setCustomerId(cusid);
				System.out.println("Enter the product ID:");
				int prodid=sc4.nextInt();
				user4.setProductId(prodid);
				System.out.println("Enter the haulier ID:");
				int hrid=sc4.nextInt();
				user4.setHaulierId(hrid);
				System.out.println("Enter the delivery date in (dd/mm/yyyy) format:");
				String dd=sc4.next();
				user4.setDeliveryDate(dd);
				System.out.println("Enter the delivery day: ");
				String ddy=sc4.next();
				user4.setDeliveryDay(ddy);
				System.out.println("Enter the quantity required:");
				int qty=sc4.nextInt();
				user4.setQuantity(qty);
			
				boolean result4 =services4.updateContractor(ctid,user4);
				
						if(result4){
					System.out.println("contract updated....");
				}
				else {
					System.err.println("something went wrong");
				}
				break;
			case 4:ContractorServices services2=Factory.instanceOfContractorServices();
			ContractorBean user3=new ContractorBean();
			Scanner sc2= new Scanner(System.in);
			System.out.println("enter contract id....");
			user3.setContractId(Integer.parseInt(sc2.nextLine()));
			boolean result1 =services2.deleteContractor(user3.getContractId());
			if(result1) {
			
				System.out.println("contract deleted....");
			}
			else {
				System.err.println("something went wrong");
			}
				break;
			case 5:ContractorServices services1 =  Factory.instanceOfContractorServices();
			List<ContractorBean> list=services1.getAllContractor();//return type is list so i'll be creating a list of generic type 
			if(list !=null) {
				for(ContractorBean user1 : list) {
					System.out.println(user1);
				}
			}


				break;
				
		default:System.out.println("Invalid option! please choose correct one...");

			}

	}
	

	}
}
