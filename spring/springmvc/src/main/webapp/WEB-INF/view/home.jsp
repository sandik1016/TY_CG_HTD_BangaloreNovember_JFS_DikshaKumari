<jsp:useBean id="user" class="com.capgemini.springmvc.beans.User" scope="session"/><!--  if it is context then scope is application-->
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Welcome <%=user.getName() %></h1>
<h1><%=user.getEmail() %></h1>
<h1><%=user.getGender() %></h1>
</body>
</html>