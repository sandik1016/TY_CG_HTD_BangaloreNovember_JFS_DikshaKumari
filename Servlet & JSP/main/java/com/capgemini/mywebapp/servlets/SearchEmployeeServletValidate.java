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

@WebServlet("/searchEmployee2")
public class SearchEmployeeServletValidate  extends HttpServlet{

	private EmployeeService service = new EmployeeServiceImp();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//check user is login or not i.e session validation otherwise simply forward the request to login page
		//in order to validate get the same session object so pass false value
		//if user is not logged in it will return null
		HttpSession session = req.getSession(false);//get the session object
		PrintWriter out = resp.getWriter();
		out.println("<html>");
		out.println("<body>");
		if(session!= null) {//check user is logged in or not
			//valid session
			String empIdVal = req.getParameter("emp_id");
			int empId = Integer.parseInt(empIdVal);
			
			EmployeeInfoBean employeeInfoBean = service.searchEmployee(empId);//from service dao will be called
			if(employeeInfoBean!=null) {//if emp id is presesnt in db or not
				   out.println("<h3 style ='color:green'>EmployeeId "+ empId +"Found-</h3>");
				   out.println("Name = "+employeeInfoBean.getName());
				   out.println("<br>Age = "+employeeInfoBean.getAge());
				   out.println("<br>Salary = "+employeeInfoBean.getSalary());
				   out.println("<br>Designation = "+employeeInfoBean.getDesignation());
				   
			}else {
				 out.println("<h3 style = 'color:red' >Employee id:"+empId+"not found!</h3>");
				
			}
		}else {
			//invalid session
			out.println("Please Login First!");
			req.getRequestDispatcher("./loginPage.html").include(req, resp);

		}
		
		out.println("</body>");
		out.println("</html>");
	}//end of doGet()
}
