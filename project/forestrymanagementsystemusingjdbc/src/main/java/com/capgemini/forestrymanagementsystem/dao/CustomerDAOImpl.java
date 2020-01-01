package com.capgemini.forestrymanagementsystem.dao;
import java.io.FileReader;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import com.capgemini.forestrymanagementsystem.bean.CustomerBean;

public class CustomerDAOImpl implements CustomerDAO{
   FileReader reader;
	Properties prop;
	CustomerBean user;
	ResultSet rs;

	public CustomerDAOImpl() {
		try {
            reader =  new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}
	@Override
	
 public List<CustomerBean> getAllCustomer() {
		List<CustomerBean> list = new ArrayList<CustomerBean>();
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("query1"))
				){
			while(rs.next()) {//more than one record present
				CustomerBean user = new CustomerBean();//create object of userbean 
				user.setCustomerId(rs.getInt(1));
				user.setCustomerName(rs.getString(2));
				user.setTown(rs.getString(3));
				user.setStreetAddress1(rs.getString(4));
				user.setStreetAddress2(rs.getString(5));
				user.setPostalCode(rs.getInt(6));
				user.setEmail(rs.getString(7));
				user.setPhoneNumber(rs.getString(8));//in order to return list of users we are setting first
				list.add(user);//add users in the list


			}
			return list;//it will return list of users ie userbean

		}catch(Exception e) {
			e.printStackTrace();
		}
 		return null;
	}



	@Override
	public CustomerBean customerLogin(int cid, String name) {
	  	  
		return null;
	}

	@Override
	public boolean updateCustomer(int cid, CustomerBean customerUpdate) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("updateQuery"))){
		//user is local variable 
			pstmt.setInt(8, customerUpdate.getCustomerId());
			pstmt.setString(1, customerUpdate.getCustomerName());
			pstmt.setString(2, customerUpdate.getTown());
			pstmt.setString(3, customerUpdate.getStreetAddress1());
 			pstmt.setString(4, customerUpdate.getStreetAddress2());
			pstmt.setInt(5, customerUpdate.getPostalCode());
			pstmt.setString(6, customerUpdate.getEmail());
			pstmt.setString(7, customerUpdate.getPhoneNumber());
			int count1 = pstmt.executeUpdate();
			if(count1>0) {
				return true;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
			
		}
	 

	@Override
	public boolean deleteCustomer(int cid) {

		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deleteQuery"))){

			//set the unknowns
			pstmt.setInt(1, cid);
			
			int count = pstmt.executeUpdate();

			if(count>0) {
				return true;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addCustomer(CustomerBean customer) {
		
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertQuery"));
	 			){

			//set the unknowns
			pstmt.setInt(1,customer.getCustomerId());
			pstmt.setString(2, customer.getCustomerName());
			pstmt.setString(3, customer.getTown());
			pstmt.setString(4, customer.getStreetAddress1());
			pstmt.setString(5, customer.getStreetAddress2());
			pstmt.setInt(6, customer.getPostalCode());
			pstmt.setString(7, customer.getEmail());
			pstmt.setString(8, customer.getPhoneNumber());
			
			int count = pstmt.executeUpdate();

			if(count>0) {
				return true;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	

	@Override
	public CustomerBean searchCustomer(int cid) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
