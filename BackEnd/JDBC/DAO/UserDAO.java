package com.capgmn.jdbc.dataacessobject;

import java.util.List;

import com.capgmn.jdbc.bean.UserBean;

public interface UserDAO {
	public List<UserBean> getAllUsers();//return all details of user
    public UserBean userLogin(String username,String password);//return details of single user
    public boolean updateUser(int userid,String password,String email);
    public boolean insertUser(UserBean user);
    public boolean deleteUser(int userid,String password);//method signature
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public List<UserBean> getAllUsers();//we will store only userbean type of arraylist 
//   public UserBean userLogin(String username,String password);
}
/*Data Access Object or DAO design pattern is a popular design pattern to implement persistence layer of Java application.
 *  DAO pattern is based on abstraction and encapsulation design principles and shields rest of application from any change 
 *  in the persistence layer e.g. change of database from Oracle to MySQL, change of persistence technology
 *   e.g. from File System to Database. For example, if you are authenticating the user 
 *   using a relational database and later your company wants to use LDAP to perform authentication. 
 *   If you are using DAO design pattern to access database, it would be relatively safe as you only need to
 *    make a change on Data Access Layer. DAO design pattern also keeps coupling low between
 *     different parts of an application. By using DAO design pattern your View Layer is completely independent 
 * of DAO layer and only Service layer has the dependency on it which is also abstracted by using DAO interface.
 * The persistence layer of enterprise applications serves as an intermediary between the business functions of the application
 *  and the data it stores in a relational database. 
 * This function of the persistence layer is also known as object-relational mapping because 
 * it maps Java objects to relational data.*/
 