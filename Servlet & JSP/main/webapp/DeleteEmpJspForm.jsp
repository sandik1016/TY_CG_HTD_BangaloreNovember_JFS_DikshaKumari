<%@page import="com.capgemini.mywebapp.bean.EmployeeInfoBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session ="false" %>
     <%EmployeeInfoBean employeeInfoBean = (EmployeeInfoBean)request.getAttribute("employeeInfoBean"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<fieldset>
		<legend> Delete Employee</legend>
		<form action="./deleteEmployee1" method="get">
			EmployeeId: <input type="number" name="empId" required><br>
			<input type="submit" value="delete">
		</form>
	</fieldset> 
	
	<% if(employeeInfoBean==null){ %>
	<h3 style ="color:red;">EmployeeId <%=employeeInfoBean.getEmp_id() %> not found</h3>
	<%} else{%>
	<h3 style ="color:green;"> EmployeeId record <%=employeeInfoBean.getEmp_id() %> deleted </h3><br>
	
	<%} %>
</body>
</html>