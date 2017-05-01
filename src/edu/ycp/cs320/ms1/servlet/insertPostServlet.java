package edu.ycp.cs320.ms1.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.ms1.controller.InsertPostController;
import edu.ycp.cs320.ms1.model.TextPost;
import edu.ycp.cs320.ms1.model.User;

public class insertPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private InsertPostController controller = null;	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		System.out.println("\ninsertPostServlet: doGet");

		String user = (String) req.getSession().getAttribute("user");
		if (user == null) {
			System.out.println("   User: <" + user + "> not logged in or session timed out");
			
			// user is not logged in, or the session expired
			resp.sendRedirect(req.getContextPath() + "/login");
			return;
		}

		// now we have the user's User object,
		// proceed to handle request...
		
		System.out.println("   User: <" + user + "> logged in");

		req.getRequestDispatcher("/_view/UserHome.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		System.out.println("\ninsertPostServlet: doPost");		
		
		String errorMessage   = null;
		String successMessage = null;
		String firstName      = null;
		String lastName       = null;
		String title		  = null;
		String strPublished   = null;
		
		String username = null;
		String content = null;
		
		int    published	  = 0;
		
		// Decode form parameters and dispatch to controller
		firstName    = req.getParameter("author_firstname");
		lastName     = req.getParameter("author_lastname");
		title        = req.getParameter("post_title");
		
//I don't know what this does, Work on it later
		username        = req.getParameter("username");
		content         = req.getParameter("post_content");
		
		strPublished = req.getParameter("book_published");
		
		if (firstName    == null || firstName.equals("") ||
			lastName     == null || lastName.equals("")  ||
			title        == null || title.equals("")     ||
			strPublished == null) {
			
			errorMessage = "Please fill in all of the required fields";
		} else {
			controller = new InsertPostController();

			// convert published to integer now that it is valid
			published = Integer.parseInt(strPublished);
			
			// get list of post returned from query			
			if (controller.insertPostIntoPostsTable(title, username, content)) {
				successMessage = title;
			}
			else {
				errorMessage = "Failed to insert Post: " + title;					
			}
		}
		
		// Add parameters as request attributes
		req.setAttribute("author_firstname", firstName);
		req.setAttribute("author_lastname",  lastName);
		req.setAttribute("post_title",       title);
		req.setAttribute("book_published",   published);
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage",   errorMessage);
		req.setAttribute("successMessage", successMessage);
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/UserHome.jsp").forward(req, resp);
	}	
}
