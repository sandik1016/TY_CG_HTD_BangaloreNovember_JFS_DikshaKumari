package com.capgemini.forestrymanagementsystem.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.capgemini.forestrymanagementsystem.bean.ContractBean;
import com.capgemini.forestrymanagementsystem.dao.ContractDAO;
import com.capgemini.forestrymanagementsystem.exception.ContractIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.CustomerIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.HaulierIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.LandIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.ProductIdNotFoundException;
import com.capgemini.forestrymanagementsystem.exception.SchedulerIdNotFoundException;
import com.capgemini.forestrymanagementsystem.factory.ForestryManager;


public class Contractor {

	static ContractDAO cdao=ForestryManager.getContractDAOImpl();
	static Set<ContractBean>  s;
	static Map<Integer,Set<ContractBean>> h=new HashMap<Integer,Set<ContractBean>>();
	void contract() throws Exception{

		Scanner sc=new Scanner(System.in);

		while (true) {
			try {
			System.out.println("-----WELCOME TO CONTRACT MODULE-----");
			System.out.println("Press 1 to add Contract");
			System.out.println("Press 2 to search Contract");
			System.out.println("Press 3 to update Contract");
			System.out.println("Press 4 to remove  Contract");
			System.out.println("Press 5 to get all Contract");
			System.out.println("Press 6 to return HOME");
			int choice=sc.nextInt();


			switch (choice) {
			case 1:
				ContractBean cb=new ContractBean();
				int contractId=0;
				boolean found6 = true;
				do {
					System.out.println("Enter the contract ID:");
					try {
						contractId=Integer.parseInt(sc.next());
						cb.setContractorId(contractId);
						found6=true;

					}catch(Exception e) {

						System.err.println("Please enter valid id!");
						found6=false;
					}
				}while (found6!=true);

                int customerId=0;
				boolean found5 = true;
				do {
					System.out.println("Enter the customer ID:");
					try {
						customerId=Integer.parseInt(sc.next());
						cb.setCustomerId(customerId);
						found5=true;

					}catch(Exception e) {

						System.err.println("Please enter valid id!");
						found5=false;
					}
				}while (found5!=true);

				int productId=0;
				boolean found4 = true;
				do {
					System.out.println("Enter the product ID:");
					try {
						productId=Integer.parseInt(sc.next());
						cb.setProductId(productId);
						found4=true;

					}catch(Exception e) {

						System.err.println("Please enter valid id!");
						found4=false;
					}
				}while (found4!=true);

				int haulierId=0;
				boolean found3 = true;
				do {
					System.out.println("Enter the haulier ID:");
					try {
						haulierId=Integer.parseInt(sc.next());
						cb.setHaulierId(haulierId);
						found3=true;

					}catch(Exception e) {

						System.err.println("Please enter valid id!");
						found3=false;
					}
				}while (found3!=true);
			

				boolean found = true;
				do {
					try {
		        System.out.println("Please Enter Date in this Format: \"dd-mm-yyyy\"");
		        String user_InputDate=sc.next();

		        String[] str=user_InputDate.split("-");
		        int day=Integer.parseInt(str[0]);
		        int month=Integer.parseInt(str[1]);
		        int year=Integer.parseInt(str[2]);
		        //System.out.println(day+" "+month+" "+year);

		        if(month<1||month>12||day<1||day>31)
		        {
		            System.out.println("Invalid Date:");
		            return;
		        }
		        else if(month ==2)
		        {
		            if(!((year % 4 == 0) &&  (year % 100 != 0)) ||  (year % 400 == 0))
		            {
		                if(day>28)
		                {
		                    System.out.println("Invalid Date:"); 
		                    return;
		                }
		            }
		        }
		        else if(month==4||month==6||month==9||month==11)
		        {
		            if(day==31)
		            {
		               System.out.println("Invalid Date:"); 
		               return;
		            }
		        }
		        else        
		        {

		        }

		        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		        Date currDate=new Date();
		        
		        currDate=dateFormat.parse(dateFormat.format(currDate));
		        Date user_Date=dateFormat.parse(user_InputDate);
		       
		        
		        
		        if(user_Date.compareTo(currDate)<0)
		        {
		            System.out.println("Invalid Date:");
		            found=false;
		            
		        }
		        else
		        {
		            System.out.println("Go Ahead");
		            cb.setDeliveryDate(user_InputDate);
					found=true;
		            
		        }
					}catch(Exception e) {
						
					}
		        
		    }while (found!=true);	

				boolean found2 = true;
				do {
					System.out.println("Enter the delivery day: ");
					String day = sc.next();
					cb.setDeliveryDay(day);

					String regex = "^((Monday)|(Tuesday)|(Wednesday)|(Thursday)|(Friday)|(Saturday)|(Sunday)|"
							+ "(MONDAY)|(TUESDAY)|(WEDNESDAY)|(THURSDAY)|(FRIDAY)|(SATURDAY)|(SUNDAY)|"
							+ "(MON)|(TUES)|(WED)|(THRU)|(FRI)|(SAT)|(SUN)|"
							+ "(monday)|(tuesday)|(wednesday)|(thursday)|(friday)|(saturday)|(sunday))$";
					Pattern pattern = Pattern.compile(regex);
					Matcher  matcher = pattern.matcher(day);
					if( !matcher.matches()) {

						System.err.println("Please enter valid day!");
						found2=false;

					}else {
						cb.getDeliveryDay();
						found2=true;

					}
				}while (found2!=true);
				int quantity=0;
				boolean found7 = true;
				do {
					System.out.println("Enter the quantity required:");
					try {
						productId=Integer.parseInt(sc.next());
						cb.setQuantity(quantity);
						found7=true;

					}catch(Exception e) {

						System.err.println("Please enter valid quantity!");
						found7=false;
					}
				}while (found7!=true);
				
				
				
				boolean add=cdao.addContract(cb);
				s=cdao.getAllContract();
				if(add) {
					System.out.println("Contractor added successfully!");
				}else System.err.println("Something went wrong!");
				h.put(cb.getContractId(),s);

				break;
			case 2:
				System.out.println("Enter the contractID to search contractor: ");
				int ctid1=sc.nextInt();
				if(cdao.searchContract(ctid1, h))

					System.out.println(h.get(ctid1));
				else
					System.err.println("Contract details not found");
				break;
			case 3:
				System.out.println("enter the contractid to update:");
				int cidToUpdate =sc.nextInt();
				if(cdao.searchContract(cidToUpdate, h)) {

					System.out.println(h.get(cidToUpdate));
					h.remove(cidToUpdate);
					ContractBean cb2=new ContractBean();
					cb2.setContractorId(cidToUpdate);
					System.out.println("Enter Customer ID to update:");
					cb2.setCustomerId(sc.nextInt());
					System.out.println("enter product ID to update: ");
					cb2.setProductId(sc.nextInt());
					System.out.println("enter haulier ID to update: ");
					cb2.setHaulierId(sc.nextInt());
					System.out.println("enter delivery date to update: ");
					cb2.setDeliveryDate(sc.next());
					System.out.println("enter delivery day to update: ");
					cb2.setDeliveryDay(sc.next());
					System.out.println("enter quantity to update: ");
					cb2.setQuantity(sc.nextInt());
					cdao.addContract(cb2);
					s=cdao.getAllContract();
					h.put(cb2.getContractId(), s);
					System.out.println(h.get(cidToUpdate));
				}
				else System.err.println("Something went wrong!");
				break;
			case 4:
				System.out.println("Enter the Contractor ID to delete the account:");
				int cidToDelete=sc.nextInt();
				if(cdao.deleteContract(cidToDelete,h)) {
					h.remove(cidToDelete);
					System.out.println("Contract details deleted successfully");
				}
				else {
					System.err.println("Something went wrong...");
				}
				break;
			case 5:
				Set<Map.Entry<Integer,Set<ContractBean>>> s1=h.entrySet();
				for(Map.Entry<Integer,Set<ContractBean>> e1:s1) {
					System.out.println(e1.getKey());
					System.out.println(e1.getValue());
					System.out.println("-----------------");
				}
				break;
			case 6:
				HomeForestApp m=new HomeForestApp();
				m.main(null);

			}
		}catch(ContractIdNotFoundException con)
			{
			     con.printStackTrace();
			}
	}
}
}
