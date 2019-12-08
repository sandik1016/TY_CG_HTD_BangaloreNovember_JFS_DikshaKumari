package com.capg.jdbc;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUser {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		Connection conn = null;
		ResultSet rs=null;
		PreparedStatement pstmt =null;//it will be used in finally block thats why outside of try block
		try {
			Driver d = new com.mysql.jdbc.Driver(); 
			//registering driver
			DriverManager.registerDriver(d);//return type is void
			System.out.println("Driver Loaded");

			String dbUrl = "jdbc:mysql://127.0.0.1:3306/ty_cg_nov12";
			System.out.println("enter username and passwrd");
			String dbUser=sc.nextLine();
			String dbPass=sc.nextLine();


			conn=DriverManager. getConnection(dbUrl,dbUser,dbPass); //java.sql is the package name where getconnection is present.connection is interface and it has fully qualified name as java.sql.connection 
			System.out.println("connection estd");

			//issue sql 
			String query = "insert into users_info values ( ?,?,?,? )";
			pstmt = conn.prepareStatement(query); 
			System.out.println("Enter userid...");
			pstmt.setInt(1, Integer.parseInt(sc.nextLine()));
			System.out.println("enter username..");
			pstmt.setString(2,sc.nextLine());
			System.out.println("enter email..");
			pstmt.setString(3,sc.nextLine());
			System.out.println("enter password..");
			pstmt.setString(4,sc.nextLine());



			int count = pstmt.executeUpdate();//1 rows affected when a record gets deleted//return type is int
			if(count>0)//0 rows affected wrong password
			{
				System.out.println("New User Created");
			}
			else {
				System.out.println("Something went wrong");
			}



		}catch(SQLException e) {
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
			try {
				if(rs!=null) 
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
