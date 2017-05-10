
<!DOCTYPE html>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

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
				CS320 Public Forum 
		    </div>   
		    
		    <div class="main_bar"> 
				Welcome Home! 
		    </div>
		    
		    <div class="postList">
		    	<c:forEach items="${allPosts}" var="item" varStatus="i">
			    	<tr>
				    	<td>
							${item.title } 	
						</td>
							
						<td>
							<ul style="list-style-type:circle">
								<li>${item.contents }</li>
							</ul>
						</td>
						
						<td>
							<form action="${pageContext.servletContext.contextPath}/delete" method="get">
								<input name="delete" type="Submit" value=${i.index } class="login_page_button" class="login_page_button:hover"><br><br><br>
							</form>
						</td>
					</tr>
				</c:forEach>
		    </div> 
		    
		    <!--
		    <div class="postList">	

		    	<c:forEach items="${fi}" var="item" varStatus="i">
		    	<tr>
		    		<p><${pageContext.request.contextPath}/war/exploitAllTheCores.jpg/></p>
					<h>${item.fileName } </h>
					<br>${item.contents }</br>
						<form action="${pageContext.servletContext.contextPath}/delete" method="get">
							<input name="delete" type="Submit" value="Delete" class="login_page_button" class="login_page_button:hover"><br><br><br>
						</form>
					</tr>
				</c:forEach>
		    </div> 
		    -->
			
			<br><br>
			
			 <form action="${pageContext.servletContext.contextPath}/NewPost" method="get">
				<input name="NewPost" type="Submit" value="New Comment" class="NewPost" class="NewPost:hover">
			</form>			
		</div>
	</body>
</html>
