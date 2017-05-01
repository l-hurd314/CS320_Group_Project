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
	private int postID;
	
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
			req.setAttribute("allPosts", posts);
			req.getSession().setAttribute("username", "guest");
		}
		
		if(req.getSession().getAttribute("Post") != null){
			List posts = c.findPostContents();
			System.out.println(posts.size());
			req.setAttribute("postID", posts);
			postID = (int)req.getSession().getAttribute("postID");
		}
		
		req.getRequestDispatcher("/_view/Post.jsp").forward(req, resp);
		
		
	}
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
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
				req.setAttribute("allPosts", posts);
				req.getSession().setAttribute("username", "guest");
			}
					
		
			if(req.getParameter("postID") != null){
				List posts = c.findAllTextPosts();
				System.out.println(posts.get((int)postID));
				req.setAttribute("postID", posts);
				//resp.sendRedirect(req.getContextPath() + "/Post");
			}
			
		}
}
