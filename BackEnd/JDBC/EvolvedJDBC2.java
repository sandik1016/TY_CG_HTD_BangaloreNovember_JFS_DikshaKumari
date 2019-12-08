package com.capg.jdbc;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.Statement;


public class EvolvedJDBC2 {

	public static void main(String[] args) {
		FileReader reader=null;
		Properties prop =null; 
  try {
	 reader=new FileReader("db.properties");
	 prop = new Properties(); 
	//load properties
	 prop.load(reader);
	
	Class.forName(prop.getProperty("driverClass"));//key is driverclas
	System.out.println("Driver loaded..");
	
	
	
} catch (Exception e) {
	
	e.printStackTrace();
}//checked exception file not found
  
  
  try(Connection conn=DriverManager.getConnection(prop.getProperty("dbUrl"),prop.getProperty("dbUser"),prop.getProperty("dbPassword"));//or  DriverManager.getConnection(url,prop)
		  Statement stmt =conn.createStatement();
		  ResultSet rs=stmt.executeQuery(prop.getProperty("query1"))){
	  
	  while (rs.next()) {
			System.out.println("userid:"+rs.getInt("userid"));
			System.out.println("username:"+rs.getString("username"));
			System.out.println("email:"+rs.getString("email"));
			System.out.println("******************************************");
		}
	  
  }catch(Exception e) {
	  e.printStackTrace();
  }
	}

}
