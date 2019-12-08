package com.capgmn.jdbc.services;
import java.util.List;
import com.capgmn.jdbc.bean.UserBean;

public interface UserServices {
	      public List<UserBean> getAllUsers();//return all details of user, return type list of userbean
          public UserBean userLogin(String username,String password);//return details of single user
          public boolean updateUser(int userid,String password,String email);
          public boolean insertUser(UserBean user);
          public boolean deleteUser(int userid,String password);//method signature
}
