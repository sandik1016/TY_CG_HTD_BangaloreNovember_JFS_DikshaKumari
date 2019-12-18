package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.capgemini.mywebapp.dao.EmployeeDaoImp;
import com.capgemini.mywebapp.services.EmployeeService;
import com.capgemini.mywebapp.services.EmployeeServiceImp;

@WebServlet("/deleteEmployee")
public class DeleteServlet extends HttpServlet{
	EmployeeService service = new EmployeeServiceImp();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//get can be passed only to get not to post 
		HttpSession session = req.getSession(false);
		if(session!=null) {
			int empId = Integer.parseInt(req.getParameter("empId"));//pass table input not bean var we will apss in jpql the bean var
			PrintWriter out = resp.getWriter();
			out.println("<html>");
			out.println("<body>");
			if(service.deleteEmployee(empId)) {
				out.println("<h3 style ='color:red'>Employee record "+empId+"deleted</h3>");

			}else {
				out.println("<h3 style ='color:red'>Employee id"+empId+"not found</h3>");
			}
			out.println("</body>");
			out.println("</html>");

			req.getRequestDispatcher("./deleteEmpForm.html").include(req, resp);
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
