package com.capgemini.mywebapp.services;

import java.util.List;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;

public interface EmployeeService {
         public EmployeeInfoBean searchEmployee(int emp_id);
         public EmployeeInfoBean authenticate(int empId,String password);//return whole emp details as object
         
         public boolean addEmployee(EmployeeInfoBean employeeInfoBean);
         public boolean deleteEmployee(int emp_id);
         public boolean updateEmployee(EmployeeInfoBean employeeInfoBean);
         public List<EmployeeInfoBean> getAllEmployee();
         
}
