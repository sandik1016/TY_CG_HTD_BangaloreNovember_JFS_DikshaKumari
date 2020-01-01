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

import com.capgemini.forestrymanagementsystem.bean.ProductBean;

public class ProductDAOImpl implements ProductDAO{
	
	FileReader reader;
	Properties prop;
	ProductBean user;
	ResultSet rs;

	public ProductDAOImpl() {
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
	public List<ProductBean> getAllProduct() {
		List<ProductBean> list = new ArrayList<ProductBean>();
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("query3"))
				){
			while(rs.next()) {//more than one record present
				ProductBean user = new ProductBean();//create object of userbean 
				user.setProductId(rs.getInt(1));
				user.setProductName(rs.getString(2));
				list.add(user);//add users in the list
                }
			return list;//it will return list of users ie userbean

		}catch(Exception e) {
			e.printStackTrace();
		} 
		return null;
	}
	

	@Override
	public boolean updateProduct(int pid, ProductBean productUpdate) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("updateQuery2"))){
		//user is local variable 
			pstmt.setInt(2, productUpdate.getProductId());
			pstmt.setString(1,productUpdate.getProductName());
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
	public boolean deleteProduct(int productDelete) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deleteQuery2"))){

			//set the unknowns
			pstmt.setInt(1, productDelete);//user is local variable 
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
	public boolean addProduct(ProductBean product) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertQuery2"))){

			//set the unknowns
			pstmt.setInt(1, product.getProductId());//user is local variable 
			pstmt.setString(2, product.getProductName());
			
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
	public ProductBean searchProduct(int pid) {
		// TODO Auto-generated method stub
		return null;
	}

}
