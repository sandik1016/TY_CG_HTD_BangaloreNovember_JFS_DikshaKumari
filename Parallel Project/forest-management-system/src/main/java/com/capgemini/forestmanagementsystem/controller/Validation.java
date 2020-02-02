package com.capgemini.forestmanagementsystem.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;

import java.util.regex.Pattern;

import com.capgemini.forestmanagementsystem.bean.ContractBean;
import com.capgemini.forestmanagementsystem.bean.CustomerBean;
import com.capgemini.forestmanagementsystem.bean.ProductBean;
import com.capgemini.forestmanagementsystem.bean.SchedulerBean;
import com.capgemini.forestmanagementsystem.bean.UserBean;


public class Validation {
	CustomerBean customerBean=new CustomerBean();
	UserBean user=new UserBean();
	ContractBean contractBean = new ContractBean();
	ProductBean productBean = new ProductBean();
	SchedulerBean schedulerBean = new SchedulerBean();
	private static Pattern EMAIL_PATTERN = 
			Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
	public static boolean userEmailValidation(String email) {
		Matcher mtch = EMAIL_PATTERN.matcher(email);
        if(mtch.matches()){
            return true;
        }
        return false;
	}
	
	private static Pattern pswNamePtrn = 
	        Pattern.compile("((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,15})");
	     
	    public static boolean passwordValidation(String password){
	        Matcher mtch = pswNamePtrn.matcher(password);
	        if(mtch.matches()){
	            return true;
	        }
	        return false;
	    }
	public boolean nameValidation(String name) {
		boolean found;
		
		String regex = "^[A-Za-z]{3,15}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher  matcher = pattern.matcher(name);
		if( !matcher.matches()) {

			found=false;

		}else {
			
			found=true;
			
		}
     return found;
	}
	
	
	public boolean townValidation(String town) {
		boolean found;
		
	String regex0 = "^[A-Za-z]{3,15}$";
	Pattern pattern0 = Pattern.compile(regex0);
	Matcher matcher0 = pattern0.matcher(town);
	if( !matcher0.matches()) {
		
		found=false;

	}else {

	
		found=true;
	}
	return found;
	}
	
	public boolean postalValidation(String code) {
		boolean found;
		
	String regex4 = "[0-9]{6}";
	Pattern pattern4 = Pattern.compile(regex4);
	Matcher matcher4 = pattern4.matcher(code);
	if( !matcher4.matches()) {
		
		found=false;
	}else {

	
		found=true;
	}
	return found;
	}

	public boolean statusValidation(String status) {
		boolean found;
		System.out.println("Enter status from the following options :propose\n active\n pending\n completed\n cancell"
				+ "ed");
		String regex = "^(Proposed)|(Active)|(Pending)|(Completed)|(Cancelled)|(proposed)|"
				+ "(active)|(pending)|(completed)|(cancelled)|"
				+ "(PROPOSED)|(ACTIVE)|(PENDING)|(COMPLETED)|(CANCELLED)$";
		Pattern pattern1 = Pattern.compile(regex);
		Matcher matcher = pattern1.matcher(status);
		if (!matcher.matches()) {

	
			found = false;

		} else {
			
			found = true;

		}
		return found;
	}
	public boolean addressValidation(String address) {
		boolean found;
	

	String regex6 = "^[A-Za-z]{3,15}$";
	Pattern pattern6 = Pattern.compile(regex6);
	Matcher matcher6 = pattern6.matcher(address);
	if( !matcher6.matches()) {

		found=false;
	}else {
		
		found=true;
	}
	return found;
	}
	public boolean phoneValidation(String phone) {
		boolean found;
	
	String regex1 = "[6789]{1}[0-9]{9}";
	Pattern pattern1 = Pattern.compile(regex1);
	Matcher matcher1 = pattern1.matcher(phone);
	if(! matcher1.matches()) {
		
		found=false;
	}else {
		
		found=true;
	}
	return found;
	}
	
	public boolean dateValidation(String user_InputDate) throws ParseException {
		
        String[] str=user_InputDate.split("-");
        int day=Integer.parseInt(str[0]);
        int month=Integer.parseInt(str[1]);
        int year=Integer.parseInt(str[2]);
        //System.out.println(day+" "+month+" "+year);

        if(month<1||month>12||day<1||day>31)
        {
            System.out.println("Invalid Date:");
           // return false;
        }
        else if(month ==2)
        {
            if(((year % 4 == 0) &&  (year % 100 != 0)) ||  (year % 400 == 0))
            {
                if(day>29)
                {
                    System.out.println("Invalid Date:"); 
                   // return false;
                }
            }
            else
            {
                if(day>28)
                {
                    System.out.println("Invalid Date:"); 
                 //   return false;
                }
            }
        }
        else if(month==4||month==6||month==9||month==11)
        {
            if(day==31)
            {
               System.out.println("Invalid Date:"); 
               //return false;
            }
        }
        else        
        {
               //return true;
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date currDate=new Date();
        
        currDate=dateFormat.parse(dateFormat.format(currDate));
        Date user_Date=dateFormat.parse(user_InputDate);
        //System.out.println(user_Date);
        //System.out.println(currDate);
        
        
        if(user_Date.compareTo(currDate)<0)
        {
           // System.out.println("Invalid Date:");
                return false;
        }
        else
        {
            //System.out.println("Go Ahead");    
        	return true;
	    }
		//return false;
	}

	
	
	public boolean productNameValidation(String name) {
		boolean found;
		productBean.setProductName(name);
		String regex = "^[A-Za-z]{3,15}$";
		Pattern pattern = Pattern.compile(regex);
		Matcher  matcher = pattern.matcher(name);
		if( !matcher.matches()) {
			found=false;

		}else {
			
			found=true;
		}
     return found;
	}
	
	public boolean roleValidation(String role) {
		boolean found;
		String regex = "^((admin)|(ADMIN)|(CLIENT)|(client)|(scheduler)|(Scheduler)|(SCHEDULER)|(Client)|(Admin))$";
		
		Pattern pattern = Pattern.compile(regex);
		Matcher  matcher = pattern.matcher(role);
		if( !matcher.matches()) {
		
			found=false;

		}else {
			
			found=true;
			
		}
     return found;
	}	
	
}
