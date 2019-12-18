package com.capgemini.mywebapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.services.EmployeeService;
import com.capgemini.mywebapp.services.EmployeeServiceImp;

@WebServlet("/deleteEmployee1")
public class DeleteEmployeeServletWithJsp extends HttpServlet {
	private EmployeeService service = new EmployeeServiceImp();
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	HttpSession session = req.getSession(false);
	if(session !=null) {
		//valid session
		//get the form data
		int empId =  Integer.parseInt(req.getParameter("empId"));
		//create object of service
		EmployeeInfoBean employeeInfoBean =new EmployeeInfoBean();
		boolean isDeleted = service.deleteEmployee(empId);
		
		req.setAttribute("employeeInfoBean", employeeInfoBean);//we will set attribute because we want to display the msg via jsp page on the same jsp page
		req.getRequestDispatcher("./DeleteEmpJspForm.jsp").forward(req, resp);
		
	}else {
		//invalid session
		req.setAttribute("msg", "please login first");
		req.getRequestDispatcher("./loginForm").forward(req, resp);
	}
}
}
