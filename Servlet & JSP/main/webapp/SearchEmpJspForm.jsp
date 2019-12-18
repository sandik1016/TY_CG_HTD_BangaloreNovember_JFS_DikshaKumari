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
		<legend> Search Employee</legend>
		<form action="./getEmployee1" method="get">//it must go first to validate servlet class then display result
			Employee ID: <input type="number" name="empId" required><br>
			<input type="submit" value="Search">//bydefault get method
		</form>
	</fieldset>
	<br><br>
	<% if(employeeInfoBean==null){ %>
	<h3 style ="color:red;">EmployeeId not found</h3>
	<%} else{%>
	<h3 style ="color:green;">Details for EmployeeId <%=employeeInfoBean.getEmp_id() %></h3><br>
	Employee Name =<%=employeeInfoBean.getName() %><br>
	Age = <%=employeeInfoBean.getAge() %><br>
	Salary = <%=employeeInfoBean.getSalary() %><br>
	Designation = <%=employeeInfoBean.getDesignation() %>
	<%} %>
</body>
</html>