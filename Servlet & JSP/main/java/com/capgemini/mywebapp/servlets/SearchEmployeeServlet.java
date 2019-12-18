package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.capgemini.mywebapp.bean.EmployeeInfoBean;
import com.capgemini.mywebapp.services.EmployeeService;
import com.capgemini.mywebapp.services.EmployeeServiceImp;
@WebServlet("/searchEmployee")
public class SearchEmployeeServlet extends HttpServlet{
private EmployeeService employeeService = new EmployeeServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get the form data
		//case sensitive  name of html input field shud be given here
		String empIdVal = req.getParameter("emp_id");
		int empId = Integer.parseInt(empIdVal);
		EmployeeInfoBean employeeInfoBean = employeeService.searchEmployee(empId);
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(employeeInfoBean!=null) {
			   out.println("<h3>EmployeeId "+empId +"Found-</h3>");
			   out.println("Name = "+employeeInfoBean.getName());
			   out.println("<br>Age = "+employeeInfoBean.getAge());
			   out.println("<br>Salary = "+employeeInfoBean.getSalary());
			   out.println("<br>Designation = "+employeeInfoBean.getDesignation());
			   
		}else {
			 out.println("<h3 style = 'color:red' >Employee id:"+empId+"not found!</h3>");
			
		}
		
		out.println("</body>");
		out.println("</html>");
		
	}
}
