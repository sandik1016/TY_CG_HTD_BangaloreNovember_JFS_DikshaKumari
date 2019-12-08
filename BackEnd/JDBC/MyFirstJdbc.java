package com.capg.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//here we are using sql driver not mysql 

public class MyFirstJdbc {

	public static void main(String[] args) {
		Connection conn = null;
		Statement   stmt = null;
		ResultSet rs= null;

		try {
			//load driver
			Driver d = new com.mysql.jdbc.Driver(); //interface of that of sql type
			//registering driver
			DriverManager.registerDriver(d);//return type is void
			System.out.println("Driver Loaded");
			//call someone after registering on a network
			//same company will provide database ,jdbc (mobile)is db  independent,drivers(sim card) are db dependent
			//get address ,make connection with db give db address
			//db urls
			//establish connection//get db  connection via driver
			String dbUrl = "jdbc:mysql://localhost:3306/ty_cg_nov12"+"?user=root&password=root";//db url localhost because it is prsnt in our desktop othrwise ip address 127.0.0.1
			//getconnection is present in drivermanager
			conn=DriverManager.getConnection(dbUrl);//return is connection
			System.out.println("connection established");
			//issue sql query via connection
			String query="select * from users_info";
			//createStatement is used to change string into query/statement so that db can understand
			//statement is return type and it is interface 

			stmt = conn.createStatement();//it is present in connection

			//executequer executes given sql statement (nonstatic) present  inside statement
			//stmt contains statement


			rs=stmt.executeQuery(query);
			//query will be converted to statemnt and it will executed
			//resultset is interface

			System.out.println(" query issued");
			System.out.println("******************");

			//process the result
			//resultset is an object representn of result table

			while(rs.next()) {//return type is boolea
				//all field will be stored in rs
				/*column index*/ System.out.println("userid:"+rs.getInt("userid"));
				System.out.println("username:"+rs.getString("username"));
				System.out.println("email:"+rs.getString("email"));
				System.out.println("******************************");

			}


		} catch (SQLException e) {  
			//checked exception
			e.printStackTrace();
		}

		//close all jdbc objects
		finally {

			try {
				if(conn!=null) 
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(stmt!=null) 
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(rs!=null) 
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}


