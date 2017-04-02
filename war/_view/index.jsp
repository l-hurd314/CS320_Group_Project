<!DOCTYPE html>

<html>
	<head>
		<title>Index view</title>
		
		<link rel="stylesheet" type="text/css" href="_view/style.css">
		
	</head>

	<body>
		<div class="cursor">
			
			<div id="background">
	    		<img src="http://www.wallcoo.net/flower/SZ_186_CG_Digital_Flowers/images/HS066_350AA.jpg" class="stretch" alt="" />
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
	    
	    </div>
	</body>
</html>
