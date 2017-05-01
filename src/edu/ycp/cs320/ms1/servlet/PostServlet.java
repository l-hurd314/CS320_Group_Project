package edu.ycp.cs320.ms1.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.ms1.controller.UserHomeController;

public class PostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
	private int postId;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		UserHomeController c = new UserHomeController();
		
		if(req.getSession().getAttribute("username") != null){
			List posts = c.findAllTextPosts();
			System.out.println(posts.size());
			req.setAttribute("allPosts", posts);
			username = (String) req.getSession().getAttribute("username");
		}
		else{
			List posts = c.findAllTextPosts();
			System.out.println(posts.size());
			//System.out.println(posts.get(0));
			req.setAttribute("allPosts", posts);
			req.getSession().setAttribute("username", "guest");
		}
		
		req.getRequestDispatcher("/_view/Post.jsp").forward(req, resp);
		
		
	}
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			UserHomeController c = new UserHomeController();
			String post = null;
			String byButton = req.getParameter("bybutton");
			
			if(req.getSession().getAttribute("username") != null){
				List posts = c.findAllTextPosts();
				System.out.println(posts.size());
				req.setAttribute("myPosts", posts);
				username = (String) req.getSession().getAttribute("username");
			}
			else{
				String posts = c.findPostContents(postId);
				System.out.println(posts.length());
				req.setAttribute("myPosts", posts);
				req.getSession().setAttribute("username", "guest");
				postId = (int) req.getSession().getAttribute("postId");
			}
							
//			if (byButton.equals(c.findPostTitle(postId))) {
//				post = c.findPostContents(postId);
//			}
			
		}
}
