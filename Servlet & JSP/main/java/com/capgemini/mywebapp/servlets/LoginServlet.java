 package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.services.EmployeeService;
import com.capgemini.mywebapp.services.EmployeeServiceImp;

@WebServlet("/login")
public class LoginServlet extends HttpServlet{
	//create service obje
	private EmployeeService service = new EmployeeServiceImp();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get the form data
		String empIdVal = req.getParameter("empId");//pass the same as in html 
		String password = req.getParameter("password");
		int empId = Integer.parseInt(empIdVal);

		//check the db 
		EmployeeInfoBean employeeInfoBean =  service.authenticate(empId, password);
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
        //logic of generation of dynamic data is business logic(servlet,hibernate,design pattern ie layered architecture)
		//presentation logic displaying dynamic data(jsp,html,css)
		if(employeeInfoBean !=null) {
			//valid credentials
			//create a new session
			HttpSession session = req.getSession(true);//for login and logout we need to pass true value..... to create a new session with true value
			session.setAttribute("employeeInfoBean",employeeInfoBean);//key is string and value is object
			
			out.println("<h2 style ='color:blue'>Welcome "+employeeInfoBean.getName()+"!</h2>");
			out.println("<br><a href='./addEmpForm.html'>Add Employee</a>");
			out.println("<br><a href='#'>Update Employee</a>");
			out.println("<br><a href='./searchEmpForm.html'>Search Employee</a>");
			out.println("<br><a href='./deleteEmpForm.html'>Delete Employee</a>");
			out.println("<br><a href='#'>See All Employee</a>");
			out.println("<br><br><a href='./logout'>Logout Employee</a>");
			
		}else {
			//invalid credentials
			out.println("<h3 style='color:red'>Invalid credentials </h3>");
			req.getRequestDispatcher("./loginPage.html").include(req, resp);
		}

	}
}
