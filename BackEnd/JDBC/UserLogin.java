package com.capg.jdbc;
import java.sql.Connection;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class UserLogin {
	public static void main(String args[]) {
		Scanner sc =new Scanner(System.in);
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		PreparedStatement pstmt =null;
		try {
			//load driver
			Driver d = new com.mysql.jdbc.Driver(); 
			//registering driver
			DriverManager.registerDriver(d);//return type is void
			System.out.println("Driver Loaded");

			//get the database connection 
			String dbUrl = "jdbc:mysql://127.0.0.1:3306/ty_cg_nov12";
			System.out.println("enter username and passwrd");
			String dbUser=sc.nextLine();
			String dbPass=sc.nextLine();
			conn=DriverManager. getConnection(dbUrl,dbUser,dbPass);//overloading to connect with db and abstraction and compile time  polymorphism
			System.out.println("connection estd");


			//issues SQL queries
			//			String query="SELECT * FROM users_info where userid=1501292166  and password='sidt12'";
			//
			//			stmt = conn.createStatement();
			//			rs=stmt.executeQuery(query);
			//			
			//			System.out.println(" query issued and executed");

			//using preparedstatement
			String query="select * from users_info where userid = ? and password= ? ";
			pstmt = conn.prepareStatement(query);
			System.out.println("Enter userid...");
			pstmt.setInt(1, Integer.parseInt(sc.nextLine()));
			System.out.println("enter password..");
			pstmt.setString(2,sc.nextLine());

			rs= pstmt.executeQuery();


			//process result
			if(rs.next()) {
				///gives one row as output or for zero row
				System.out.println("userid:"+rs.getInt(1));//index or label
				System.out.println("username:"+rs.getString(2));
				System.out.println("email:"+rs.getString(3));
				System.out.println("******************************");

			}else {
				System.out.println("something went wrong");
			}

		}catch(SQLException e) {
		} 
		//close all JDBC objects
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

