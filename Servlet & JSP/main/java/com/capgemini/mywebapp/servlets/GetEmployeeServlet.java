package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GetEmployeeServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Get the Query String
		String idVal = req.getParameter("id");
		
		//context param - applicable to all the servlet and if any changes occur reflectd to all servlet
		ServletContext context = getServletContext();//servletcontext obj//present in genericservlet so we are invoking directly and with help of this we are creating object of context 
    	String contextParamVal = context.getInitParameter("myContextParam");
    	
		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("Employee id : "+idVal);
		out.println("<br>Name = Diksha");
		out.println("<br>Salary = 85000");
		
		
		out.println("<br><br>Context Param value = "+contextParamVal);
		out.println("</body>");
		out.println("</html>");
		}//end of doGet
}
