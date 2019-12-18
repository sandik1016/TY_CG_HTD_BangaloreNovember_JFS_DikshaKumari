package com.capgemini.mywebapp.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/redirect")//configure the url
public class RedirectServlet extends HttpServlet{
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	 String url = "http://www.youtube.com"; // external resource   
	 //String url  = "./currentDate" ; internal resource//relative path
	 //String url1 = "http://localhost:8080/mywebapp/currentDate";//absolute path 
	 resp.sendRedirect(url);
}
	

}

