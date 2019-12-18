 package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DateServlet extends HttpServlet{
         @Override   
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        	//current system date and tim
        	 Date date =  new Date();//util package
        	 
        	resp.setContentType("text/html");//in order to inform the browser that response will be in html form
        	resp.setHeader("refresh", "1");//refresh page in 1 sec
        	
        	//how to get context param
        	ServletContext context = getServletContext();//servletcontext obj or we can write 
        	//ServletContext context = req.getServletContext(); present in httpservletrequest
        	String contextParamVal = context.getInitParameter("myContextParam");
        	//we can also write String contextParamVal = getInitParameter("myContextParam"); 
        	//but we can get confused on which reference object it is invoked whether context or config
        	
        	//get config param
        	ServletConfig config = getServletConfig();
        	String configParamVa = config.getInitParameter("myConfigParam");  
        	
        	PrintWriter out = resp.getWriter();//browser understand html language
        	out.print("<html>");
        	out.print("<h2>Current System Date & Time -<br>"+date+"</h2>");
        	
        	//displaying contextparam & config-param valu
        	out.println("<br><br>Context Param value = "+contextParamVal);
        	out.println("<br><br>Config Param value = "+configParamVa);
        	
        	out.print("</html>");
        	
        } //end of doget  
}

  