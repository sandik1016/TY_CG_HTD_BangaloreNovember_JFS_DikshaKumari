<%@page import="com.capgemini.empspringmvc.manytoone.EmployeeBean"%>
<%@page import="java.util.List"%>
<jsp:useBean id="bean"
	class="com.capgemini.empspringmvc.manytoone.EmployeeBean"
	scope="session" />
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<a href="./changepassword">Change Password</a>
	<a href="./logout" style="float: right;">Logout</a>


	<h1>
		Welcome
		<%=bean.getName()%></h1>
	<form action="./search">
		<table>
			<tr>
				<td>Enter Key:</td>
				<td><input type="text" name="key"></td>
				<td><input type="submit" value="Search"></td>
			</tr>
		</table>
	</form>
	
	<%List<EmployeeBean> list =(List<EmployeeBean>) request.getAttribute("list"); %>

	<%  if(list!=null){ %>
	
	<%if(list.isEmpty()){ %>
	<h3>No data found</h3>
	
	<%}else{ %>
	
	
	<table>
	<tr>
	<th>Id</th>
	<th>Name</th>
	<th>Email</th>
	</tr>
	<%for(EmployeeBean employee :list){ %>
	<tr>
	<td><%=employee.getId() %></td>
	<td><%=employee.getName() %></td>
	<td><%=employee.getEmail() %></td>
	</tr>
	
	
	<%} %>
	
	</table>
	
	<%} %>
	
	
	<%} %>
	
</body>
</html>