
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>${msg}</h2>
	<form action="./login" method="post">
		<fieldset>
			<legend> Employee Login</legend>
			<table>
				<tr>
					<td>Email :</td>
					<td><input type="email" name="email" required></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password" required></td>
				</tr>
				<tr>
                  <td><input type="submit" name="login" value="login"></td>
				</tr>
             </table>
		</fieldset>

	 </form>
	<a href="./register">Register here</a>
</body>
</html>