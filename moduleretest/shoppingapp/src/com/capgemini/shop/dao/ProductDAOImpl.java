package com.capgemini.shop.dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import com.capgemini.shop.beans.ProductBean;

public class ProductDAOImpl implements ProductDAO{
	      FileReader reader;
	      Properties prop;
	      ResultSet rs;
	      ProductBean bean;
	
         public ProductDAOImpl() {
    	   try {
    		   reader = new FileReader("db.properties");
    		   prop = new Properties();
    		   prop.load(reader);
    		   Class.forName(prop.getProperty("driverClass"));
    	   }catch(Exception e)
    	   {
    		   e.printStackTrace();
    	   }
       }
	@Override
	public boolean addProduct(ProductBean product) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("addProduct"))){
                          pstmt.setInt(1, product.getProductId());
                          pstmt.setString(2, product.getProductName());
                          pstmt.setDouble(3, product.getProductCost());
                          pstmt.setString(4, product.getProductCategory());
                          pstmt.setString(5, product.getDescription());
                          pstmt.setInt(6, product.getNo_product());
                          
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
	public ProductBean searchProduct(String productName) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("searchProduct"))){
			    pstmt.setString(1, productName);
			    ResultSet rs=pstmt.executeQuery();
			    ProductBean p1 = new ProductBean();
				while(rs.next())
				{
					 
					 p1.setProductId(rs.getInt("productId"));
     				 p1.setProductCost(rs.getDouble("productCost"));
					 p1.setProductCategory(rs.getString("productCategory"));
					 p1.setDescription(rs.getString("description"));
					 p1.setNo_product(rs.getInt("no_product"));
					
	           }
			
		}catch(Exception e) {
			
		}
		
		return bean;
	}

	@Override
	public List<ProductBean> getAllProduct() {
		
			List<ProductBean> list = new ArrayList<ProductBean>();
			
			try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),prop.getProperty("dbUser"),
					prop.getProperty("dbPassword"));
					Statement stmt = conn.createStatement();
					ResultSet rs =  stmt.executeQuery(prop.getProperty("query"))){
				while(rs.next()){
					ProductBean prod = new ProductBean();
					prod.setProductId(rs.getInt(1));
					prod.setProductName(rs.getString(2));
					prod.setProductCost(rs.getDouble(3));
					prod.setProductCategory(rs.getString(4));
					prod.setDescription(rs.getString(5));
					prod.setNo_product(rs.getInt(6));
					list.add(prod);
				}
				return list;
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return null;
	}

}
