<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>
	</head>

	<body>
		<form action="${pageContext.servletContext.contextPath}/index" method="post">
			<input name="add" type="Submit" value="AddNumbers">
		</form>
		<form action="${pageContext.servletContext.contextPath}/index" method="post">
			<input name="mult" type="Submit" value="MultiplyNumbers">
		</form>
		<form action="${pageContext.servletContext.contextPath}/index" method="post">
			<input name="guess" type="Submit" value="GuessingGameNumbers">
		</form>
		
		<form action="${pageContext.servletContext.contextPath}/index" method="post">
			<input name="login" type="Submit" value="Login">
		</form>
		
		<form action="${pageContext.servletContext.contextPath}/index" method="post">
			<input name="signup" type="Submit" value="Sign Up">
		</form>
		
	</body>
</html>
