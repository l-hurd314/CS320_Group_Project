<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
	<head>
		<title>Post</title>
		
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
					<p><c:forEach items="${myPosts}" var="item" varStatus="i">
						${item.title }
				</c:forEach></p>	
		    </div> 
			
			<div class="postList">
				<p><c:forEach items="${myPosts}" var="item" varStatus="i">
					${item.contents }
				</c:forEach></p>	
			</div>
		</div>
	</body>
</html>
