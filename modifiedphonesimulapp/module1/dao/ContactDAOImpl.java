package com.capgemini.module1.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgemini.module1.bean.ContactBean;

public class ContactDAOImpl implements ContactDAO{
	FileReader reader;
	Properties prop;
	ResultSet rs;
	ContactBean contact;

	public ContactDAOImpl() {

		try {
			reader = new FileReader("db.properties");
			prop =  new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));

		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<ContactBean> getAllContact() {
		List<ContactBean> list = new ArrayList<ContactBean>();
		
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				Statement stmt = conn.createStatement();
				ResultSet rs =  stmt.executeQuery(prop.getProperty("query1"))){
			while(rs.next()){
				ContactBean contact = new ContactBean();
				contact.setName(rs.getString(1));
				contact.setNumber(rs.getString(2));
				contact.setGroup(rs.getString(3));
				list.add(contact);
			}
			return list;
		}catch(Exception e1)
		{
			e1.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean addContact(ContactBean contact) {

		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("addQuery1"))){
			ContactBean user =  new ContactBean();
			pstmt.setString(1,contact.getName());
			pstmt.setString(2,contact.getNumber());
			pstmt.setString(3,contact.getGroup());
			int count = pstmt.executeUpdate();

			if (count>0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean deleteContact(String contactName) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt2 = conn.prepareStatement(prop.getProperty("deleteQuery1"))){
			pstmt2.setString(1,contactName);

			int count = pstmt2.executeUpdate();
			if(count>0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean editContact(String contactName, ContactBean contactUpdate) {

		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt2 = conn.prepareStatement(prop.getProperty("updateQuery1"))){
			ContactBean user =  new ContactBean();
			pstmt2.setString(2,contactUpdate.getName());
			pstmt2.setString(1,contactUpdate.getNumber());

			int count = pstmt2.executeUpdate();

			if (count>0) {
				return true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public ContactBean searchContact(String contactName) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),prop.getProperty("dbUser"),
				prop.getProperty("dbPassword"));
				PreparedStatement pstmt2 = conn.prepareStatement(prop.getProperty("searchQuery1"))){
		pstmt2.setString(1, contactName);
		
		ResultSet rs=pstmt2.executeQuery();
		ContactBean c1 = new ContactBean();
			while(rs.next())
			{
				 
				 c1.setName(rs.getString(1));
				 c1.setNumber(rs.getString(2));
				 c1.setGroup(rs.getString(3));
				 
}
			
			}catch(Exception e) {
				e.printStackTrace();
			}
  return contact;
	}

}