<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>
		
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
		    	    
		    
		    <form action="${pageContext.servletContext.contextPath}/index" method="post">
				<input name="signup" type="Submit" value="Sign Up" class="signup" class="signup:hover">
			</form>
			
							
			<form action="${pageContext.servletContext.contextPath}/index" method="post">
				<input name="login" type="Submit" value="Login" class="login" class="login:hover">
			</form>
			
			 <div class="main_bar"> 
				Welcome! 
		    </div> 
		    
		    <div class="img">
		    	<img src="https://68.media.tumblr.com/eef642c1e3777674f4343757b991a208/tumblr_om7oe5g4CA1u3233wo2_1280.jpg" alt=""/>
		    </div>
	    
	    </div>
	</body>
</html>
