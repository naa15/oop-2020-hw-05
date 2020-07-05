<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Create Account</title>
	</head>
	
	<body>
		<h1>The name <%=request.getAttribute("name") %> is <br> Already in use.</h1>
		<p>Please enter another name and password.</p>
		<form action="NewAccServlet" method="post">
			User Name:
			<input type="text" name="username">
			<br>
			Password:
			<input type="password" name="password">
			<input type="submit" value="Login">
		</form>
	</body>
</html>