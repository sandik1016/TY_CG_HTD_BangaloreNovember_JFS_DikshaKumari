package com.capgmn.jdbc.dataacessobject;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.capgmn.jdbc.bean.UserBean;

public class UserDAOImpl implements UserDAO {
	FileReader reader;
	Properties prop;
	UserBean user;
	ResultSet rs;

	public UserDAOImpl() {
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
	public List<UserBean> getAllUsers() {
		List<UserBean> list = new ArrayList<UserBean>();
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(prop.getProperty("query1"))
				){
			while(rs.next()) {//more than one record present
				UserBean user = new UserBean();//create object of userbean 
				user.setUserid(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setEmail(rs.getString(3));//in order to return list of users we are setting first
				list.add(user);//add users in the list


			}
			return list;//it will return list of users ie userbean

		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public UserBean userLogin(String username, String password) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("userQuery"))){
			pstmt.setString(1,username);//user is local variable 
			pstmt.setString(2,password);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()){
				UserBean user=new UserBean();
				user.setUserid(rs.getInt(1));
				user.setUsername(rs.getString(2));
				user.setEmail(rs.getString(3));


			}


		}catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public boolean updateUser(int userid, String password, String email) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("updateQuery"))){

			//set the unknowns
			pstmt.setInt(2, userid);//user is local variable 
			pstmt.setString(1,email);
			pstmt.setString(3,password);
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
	public boolean insertUser(UserBean user) {
		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("insertQuery"))){

			//set the unknowns
			pstmt.setInt(1, user.getUserid());//user is local variable 
			pstmt.setString(2, user.getUsername());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
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
	public boolean deleteUser(int userid, String password) {


		try(Connection conn = DriverManager.getConnection(prop.getProperty("dbUrl"),
				prop.getProperty("dbUser"),prop.getProperty("dbPassword"));
				PreparedStatement pstmt = conn.prepareStatement(prop.getProperty("deleteQuery"))){

			//set the unknowns
			pstmt.setInt(1, userid);//user is local variable 
			pstmt.setString(2, password);
			int count = pstmt.executeUpdate();

			if(count>0) {
				return true;
			}

		}catch(Exception e) {
			e.printStackTrace();
		}
		return false;
	}//userdao help us to interact with db

	private String password() {
		// TODO Auto-generated method stub
		return null;
	}

	private int userid() {
		// TODO Auto-generated method stub
		return 0;
	}














	//     public UserDAOImpl() {
	//    	 try {
	//			Class.forName("com.mysql.jdbc.driver");
	//		} catch (ClassNotFoundException e) {
	//			// TODO Auto-generated catch block
	//			e.printStackTrace();
	//		}
	//     }//every time u will create object constructor will be loading driver of its own
	//	public List<UserBean> getAllUsers() {
	//
	//		return null;
	//	}
	//
	//	public UserBean userLogin(String username, String password) {
	//		
	//		return null;
	//	}



}
