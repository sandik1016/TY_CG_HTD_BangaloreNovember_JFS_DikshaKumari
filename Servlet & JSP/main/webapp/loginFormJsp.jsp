<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page session ="false" %><!-- we have to do it in all jsp ......we will restrict jsp from creating new session object as jsp creates its own session object everytime even after logout option -->
     <!-- we have to get attribute using request-- -->
     <%String msg = (String)request.getAttribute("msg"); %><!-- msg is key and it is string type and return type is object so it is downcasted from object to string -->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%if(msg!=null && !msg.isEmpty()) { %>
<%=msg  %><!-- no semicolon in expression tag -->
<%} %>
<fieldset>
		<legend>Employee Login</legend>
		<form action="./login2" method="post">
			<table>  
				<tr>
					<td>Id</td> 
					<td>:</td>
					<td><input type="number" name="empId" required></td>
				</tr>
				<tr>
					<td>Password</td>
					<td>:</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
					<td colspan="3" align="center"><br>
					 <input type="submit" value="Login"></td>
				</tr>
			</table>
		</form>
	</fieldset>
</body>
</html>