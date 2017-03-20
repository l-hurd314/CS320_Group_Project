<!DOCTYPE html>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>

<html>
	<head>
		<title>Sign Up</title>
		<style type="text/css">
		.error {
			color: red;
		}
		
		td.label {
			text-align: right;
		}
		</style>
	</head>

	<body>
		<c:if test="${! empty errorMessage}">
			<div class="error">${errorMessage}</div>
		</c:if>
	
		<form action="${pageContext.servletContext.contextPath}/signUp" method="post">
			<table>
				<tr>
					<td class="label">Create Username:</td>
					<td><input type="text" name="first" size="12" value="${game.value1}" /></td>
				</tr>
				<tr>
					<td class="label">Create Password:</td>
					<td><input type="text" name="second" size="12" value="${game.value2}" /></td>
				</tr>
			</table>
		</form>
		
		<form action="${pageContext.servletContext.contextPath}/signUp" method="post">
			<input name="login" type="Submit" value="Sign Up">
		</form>
	</body>
</html>