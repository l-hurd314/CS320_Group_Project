<!DOCTYPE html>

<html>
	<head>
		<title>User Home</title>
		
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
				Welcome Home! 
		    </div> 
			
			<div class="postList">
				<ul style="list-style-type:none">
		  			<li>A Day in the Life</li>
		 			<li>Don't You Worry Your Pretty Little Mind</li>
		  				<a href="${pageContext.servletContext.contextPath}/Post" target="_blank" class="postList">
							"It is a mistake to think you can solve any major problems just with potatoes."</a>
				</ul>
			</div>
			
			 <form action="${pageContext.servletContext.contextPath}/NewPost" method="get">
				<input name="NewPost" type="Submit" value="New Post" class="NewPost" class="NewPost:hover">
			</form>
						
		</div>
	</body>
</html>
