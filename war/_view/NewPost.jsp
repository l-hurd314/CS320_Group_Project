<!DOCTYPE html>

<html>
	<head>
		<title>New Post</title>
		
		<link rel="stylesheet" type="text/css" href="_view/style.css">
	</head>

	<body>
		<div class="cursor">
			<div id="background">
	    		<img src="https://lh3.ggpht.com/F8Ykdb1B_NtMaVmyI4np36FzXvxf9yFLgkJWGIgBA-H4RQ2IDSVz8NXtEmRi_GIgkA=h900" class="stretch" alt="" />
			</div>
			
			<div class="header"> 
				Photo/File Forum 
		    </div>   
		    
		    <div class="main_bar"> 
				New Post
		    </div> 
		    
			<select class="dropbtn">
				      <option value="select" selected>Select File Type</option>
				      <option value="text">Text File</option>
				      <option value="image">Image</option>
				      <option value="video">Video</option>
			</select>
			
			<c:if test="${! empty errorMessage}">
				<div class="error">${errorMessage}</div>
			</c:if>
			
			<c:if test="${! empty successMessage}">
				<div class="success">Successfully added ${successMessage} to Library</div>
			</c:if>
			
			<form action="${pageContext.servletContext.contextPath}/insertPost" method="post">
				<table>
					<tr>
						<td class="label">Title:</td>
						<td><input type="text" name="title" size="20" value="${title}" class="NewPost" class="NewPost:hover"></td>
					</tr>
					<tr>
						<td class="label">Text:</td>
						<td><input type="text" name="textt" size="20" value="${title}" class="NewPost" class="NewPost:hover"></td>
					</tr>
				</table>
			</form>

		</div>
	</body>
</html>
