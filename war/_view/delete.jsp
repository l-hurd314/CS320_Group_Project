<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Delete</title>
		
		<link rel="stylesheet" type="text/css" href="_view/style.css">
	</head>

	<body>
		<div class="cursor">
			<div id="background">
	    		<img src="https://images.freecreatives.com/wp-content/uploads/2016/05/Awesome-Gradient-Background-.jpg" class="stretch" alt="" />
			</div>
			
			<div class="header"> 
				Photo/File Forum 
		    </div>   
		    
		   <div class="main_bar"> 
				Delete Post? 
		    </div> 
		
			<div>
				<form action="${pageContext.servletContext.contextPath}/UserHome" method="get">
					<input name="yes" type="Submit" value="Yes" class="login_page_button" class="login_page_button:hover">
				</form>
				
				<br>
				<br>
				<br>
				
				<form action="${pageContext.servletContext.contextPath}/UserHome" method="get">
					<input name="no" type="Submit" value="No" class="login_page_button" class="login_page_button:hover">
				</form>
			</div>
		</div>
	</body>
</html>
