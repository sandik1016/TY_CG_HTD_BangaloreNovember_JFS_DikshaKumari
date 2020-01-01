package com.capgemini.forestrymanagementsystem.dao;

import java.io.FileReader;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import com.capgemini.forestrymanagementsystem.bean.ContractorBean;



public class ContractorDAOImpl implements ContractorDAO{
	FileReader reader;
	Properties prop;
	ContractorBean user;
	ResultSet rs;

	public ContractorDAOImpl() {
		try {

			reader =  new FileReader("db.properties");
			prop = new Properties();
			prop.load(reader);
			Class.forName(prop.getProperty("driverClass"));

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}//properties should be available for each and every method


	@Override
	public List<ContractorBean> getAllContractor() {
		List<ContractorBean> list = new ArrayList<ContractorBean>();
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("query2"))
				){
			while(rs.next()) {//more than one record present
				ContractorBean user = new ContractorBean();//create object of userbean 
				user.setContractId(rs.getInt(1));
				user.setCustomerId(rs.getInt(2));
				user.setProductId(rs.getInt(3));
				user.setHaulierId(rs.getInt(4));
				user.setDeliveryDate(rs.getString(5));
				user.setDeliveryDay(rs.getString(6));
				user.setQuantity(rs.getInt(7));
				list.add(user);//add users in the list
           }
			return list;//it will return list of users ie userbean

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
		
@Override
	public boolean updateContractor(int cid, ContractorBean contractorUpdate) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("updateQuery1"))){
		//user is local variable 
			pstmt.setInt(7, contractorUpdate.getContractId());
			pstmt.setInt(1, contractorUpdate.getCustomerId());
			pstmt.setInt(2, contractorUpdate.getProductId());
			pstmt.setInt(3, contractorUpdate.getHaulierId());
			pstmt.setString(4, contractorUpdate.getDeliveryDate());
			pstmt.setString(5, contractorUpdate.getDeliveryDay());
			pstmt.setInt(6, contractorUpdate.getQuantity());
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
	public boolean deleteContractor(int contractorDelete) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deleteQuery1"))){

			//set the unknowns
			pstmt.setInt(1, contractorDelete);//user is local variable 
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
	public boolean addContractor(ContractorBean contractor) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertQuery1"))){

			//set the unknowns
			pstmt.setInt(1, contractor.getContractId());//user is local variable 
			pstmt.setInt(2, contractor.getCustomerId());
			pstmt.setInt(3, contractor.getProductId());
			pstmt.setInt(4, contractor.getHaulierId());
			pstmt.setString(5, contractor.getDeliveryDate());
			pstmt.setString(6, contractor.getDeliveryDay());
			pstmt.setInt(7, contractor.getQuantity());
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
	public ContractorBean searchContractor(int cid) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
