package com.capg.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class EvolvedJDBC { 

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String dbUrl = "jdbc:mysql://127.0.0.1:3306/ty_cg_nov12";
		System.out.println("enter username and passwrd");
		String dbUser=sc.nextLine();
		String dbPass=sc.nextLine();
		String query="select * from users_info";//username-root and password-root


		try(Connection conn= DriverManager.getConnection(dbUrl,dbUser,dbPass);
				Statement stmt=conn.createStatement();
				ResultSet rs=stmt.executeQuery(query)){
			while (rs.next()) {
				System.out.println("userid:"+rs.getInt("userid"));
				System.out.println("username:"+rs.getString("username"));
				System.out.println("email:"+rs.getString("email"));
				System.out.println("******************************************");
			}

			sc.close();
		}catch(Exception e) {
			e.printStackTrace();

		}
	}//3 ways to handle exception   try with catch,try with resource,try with finally

}
