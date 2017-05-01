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
				<form action="${pageContext.servletContext.contextPath}/delete" method="post">
					<input name="delete" type="Submit" value="Yes" class="delete_page_button" class="delete_page_button:hover">
				</form>
				
				<form action="${pageContext.servletContext.contextPath}/delete" method="post">
					<input name="delete" type="Submit" value="No" class="delete_page_button" class="delete_page_button:hover">
				</form>
			</div>
		</div>
	</body>
</html>
