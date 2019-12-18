<%@page import="com.capgemini.mywebapp.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session ="false" %><!-- bydefault sessionis true --> 
 <%HttpSession session = request.getSession(false); 
 EmployeeInfoBean employeeInfoBean =(EmployeeInfoBean) session.getAttribute("employeeInfoBean");%>
 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3 style ="color:navy;">Welcome <%=employeeInfoBean.getName() %></h3><!-- -in servlet this options was not coming we have to write explicilt -->
<a href ="./addEmpJspForm" > Add Employee</a><br>
<a href ="#" > Update Employee</a><br>
<a href ="./deleteEmpJspForm" > Delete Employee</a><br>
<a href ="./searchEmpJspForm" > Search Employee</a><br>
<a href ="#" > See All Employee</a><br>
<br>
<a href="./logout2">Logout</a><!--  -->
</body>
</html>