package com.capgemini.mywebapp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/readCookie")
public class ReadCookieServlet extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Cookie cookies[] =  req.getCookies();//get the cookies

		resp.setContentType("text/html");
		PrintWriter out =  resp.getWriter();

		RequestDispatcher dispatcher = req.getRequestDispatcher("./cookiePage.html");
		dispatcher.include(req, resp);


		out.println("<html>");
		out.println("<body>");
		out.println("<h2>read cookie here...</h2>");
		if(cookies!=null) {
         for(Cookie cook :cookies)
         {
        	 out.println("cookie name = "+cook.getName());
        	 out.println("<br>cookie value = "+cook.getValue());
         }
         }else {
			out.println("<br>cookies not found!");
		}
		out.println("</body>");
		out.println("</html>");
	}
}
