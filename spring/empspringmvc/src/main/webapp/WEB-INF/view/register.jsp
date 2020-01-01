<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="./register" method="post">
		<fieldset>
			<legend> Employee Details</legend>
			<table>
				<tr>
					<td>Name :</td>
					<td><input type="text" name="name" required></td>
				</tr>
				<tr>
					<td>Email :</td>
					<td><input type="email" name="email" required></td>
				</tr>
				<tr>
					<td>Password :</td>
					<td><input type="password" name="password" required></td>
				</tr>
			</table>
		</fieldset>
		<fieldset>
			<legend> Employee Permanent Address</legend>
			<table>
				<tr>
				<td>Address Type:</td>
					<td><select name="other[0].add_type">
						<option value="permanent">Permanent</option>
						<option value="temporary">Temporary</option>
				
				</select>
				</td>
				</tr>
				<tr>
					<td>Address 1 :</td>
					<td><input type="text" name="other[0].add1"></td>
				</tr>
				<tr>
					<td>Address 2 :</td>
					<td><input type="text" name="other[0].add2"></td>
				</tr>
			</table>
		</fieldset>
		<fieldset>
			<legend> Employee Temporary Address</legend>
			<table>
				<tr>
				<td>Address Type:</td>
				<td>
					<select name="other[1].add_type">
						<option value="permanent">Permanent</option>
						<option value="temporary">Temporary</option>
				
				</select>
				</td>
				</tr>
				<tr>
					<td>Address 1 :</td>
					<td><input type="text" name="other[1].add1"></td>
				</tr>
				<tr>
					<td>Address 2 :</td>
					<td><input type="text" name="other[1].add2"></td>
				</tr>
				
				
				<tr>
				
					<td><input type="submit" name="register" value="register"></td>
				</tr>
				
			</table>
		</fieldset>

	</form>
</body>
</html>