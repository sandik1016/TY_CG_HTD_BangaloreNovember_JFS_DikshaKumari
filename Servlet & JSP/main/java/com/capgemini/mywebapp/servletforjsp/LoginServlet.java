package com.capgemini.mywebapp.servletforjsp;

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

@WebServlet("/login2")//we have created for jsp
public class LoginServlet extends HttpServlet{
	private EmployeeService service = new EmployeeServiceImp();
@Override
protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	//get the form data
	int empId = Integer.parseInt(req.getParameter("empId"));
	String password =  req.getParameter("password");
	
	//validate using service
	
	EmployeeInfoBean employeeInfoBean = service.authenticate(empId, password);//if id and password doesnt match we return null
	
	
	if(employeeInfoBean!=null) {
		//valid credentials
		HttpSession session = req.getSession(true);
		session.setAttribute("employeeInfoBean", employeeInfoBean);//create session
		//forward the request to homepage.jsp
		req.getRequestDispatcher("./homePageJsp.jsp").forward(req, resp);
		
	}else {
		//invalid credentials
		req.setAttribute("msg", "invalid credentials!");//when request will go then attribute will also go
		req.getRequestDispatcher("./loginForm").forward(req, resp);//it is url we can also use filename
	}
}//attributes - context,request and session//we have set attribute in request req
}
