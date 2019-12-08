package com.capg.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class UserEmailUpdate {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		Connection conn=null;
		PreparedStatement pstmt =null;//it will be used in finally block thats why outside of try block
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Loaded");

			String dbUrl = "jdbc:mysql://127.0.0.1:3306/ty_cg_nov12";
			System.out.println("enter db username and password");
			conn=DriverManager. getConnection(dbUrl,sc.nextLine(),sc.nextLine()); //java.sql is the package name where getconnection is present.connection is interface and it has fully qualified name as java.sql.connection 
			System.out.println("connection established");

			//issue sql 
			String query = "update users_info set email = ? where userid =? and password=?";//because we want to update single record and password for security
			pstmt = conn.prepareStatement(query); 
			System.out.println("enter new email..");
			pstmt.setString(1,sc.nextLine());
			System.out.println("Enter userid...");
			pstmt.setInt(2, Integer.parseInt(sc.nextLine()));
			System.out.println("enter password to update..");
			pstmt.setString(3,sc.nextLine());
			int count = pstmt.executeUpdate();//for executing query other than select query
			if(count>0)
			{
				System.out.println("Query OK,"+count+"Rows effected");
			}
			else {
				System.out.println("Something went wrong!!");
			}

           sc.close();

		}catch(Exception e) {
			e.printStackTrace(); 
		}finally {
			try {
				if(conn!=null) 
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if(pstmt!=null) 
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}
}
