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

@WebServlet("/addEmployee")
public class AddEmployeeServlet extends HttpServlet {
	private EmployeeService service = new EmployeeServiceImp();
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session!=null)
		{
			//get the form data it shuld match wd the input form field
			int empId = Integer.parseInt(req.getParameter("empId"));
			String name = req.getParameter("name");
			int age = Integer.parseInt(req.getParameter("age"));
			double salary = Double.parseDouble(req.getParameter("salary"));
			String designation = req.getParameter("designation");
			String password =req.getParameter("password");
			EmployeeInfoBean employeeInfoBean =new EmployeeInfoBean();
			employeeInfoBean.setEmp_id(empId);

			employeeInfoBean.setName(name);
			employeeInfoBean.setAge(age);
			employeeInfoBean.setSalary(salary);
			employeeInfoBean.setDesignation(designation);
			employeeInfoBean.setPassword(password);

			boolean isAdded = service.addEmployee(employeeInfoBean);
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<body>");

			if(isAdded) {
				out.println("<h3 style='color:green'>Employee added successfully...........</h3>");
			}else {
				out.println("<h3 style='color:red'>Unable to ADD Employe....</h3>");

			}
			out.println("</body>");
			out.println("</html>");
			req.getRequestDispatcher("./addEmpForm.html").include(req, resp);
		}else {
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			out.println("<h3 style ='color:red'>Please login first!<h3>");
			out.println("</body>");
			out.println("</html>");
			req.getRequestDispatcher("./loginPage.html").include(req, resp);
		}
	}
}
