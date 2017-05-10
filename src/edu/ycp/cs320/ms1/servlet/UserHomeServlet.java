package edu.ycp.cs320.ms1.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.ms1.controller.InsertPostController;
import edu.ycp.cs320.ms1.controller.UserHomeController;

public class UserHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if(req.getAttribute("text") != null && req.getAttribute("title") != null){
			InsertPostController controller = new InsertPostController();
			controller.insertPostIntoPostsTable(req.getAttribute("title").toString(), "testuser", req.getAttribute("content").toString());
		}
		
		UserHomeController c = new UserHomeController();
		if(req.getSession().getAttribute("username") != null){
			username = (String) req.getSession().getAttribute("username");
			List posts = c.findAllTextPosts();
			//System.out.println(posts.size());
			req.setAttribute("allPosts", posts);
			username = (String) req.getSession().getAttribute("username");
		}
		else{
			List posts = c.findAllTextPosts();
			System.out.println(posts.size());
			req.setAttribute("allPosts", posts);
			req.getSession().setAttribute("username", "guest");
		}
				
		req.getRequestDispatcher("/_view/UserHome.jsp").forward(req, resp);
		
		
	}
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			if(req.getAttribute("text") != null && req.getAttribute("title") != null){
				InsertPostController controller = new InsertPostController();
				controller.insertPostIntoPostsTable(req.getAttribute("title").toString(), "testuser", req.getAttribute("content").toString());
			}
			
			UserHomeController c = new UserHomeController();
			
			if(req.getSession().getAttribute("username") != null){
				username = (String) req.getSession().getAttribute("username");
				List posts = c.findAllTextPosts();
				System.out.println(posts.size());
				req.setAttribute("allPosts", posts);				
			}
			else{
				/*List posts = c.findAllTextPosts();
				System.out.println(posts.size());
				req.setAttribute("allPosts", posts);
				req.getSession().setAttribute("username", "guest");*/
			}
			
			
			if(req.getParameter("Post") != null){
				List posts = c.findAllTextPosts();
				System.out.println(posts.size());
				req.setAttribute("allPosts", posts);
				resp.sendRedirect(req.getContextPath() + "/Post");
			}
			
			if(req.getParameter("New Post") != null){
				List posts = c.findAllTextPosts();
				System.out.println(posts.size());
				req.setAttribute("allPosts", posts);
				resp.sendRedirect(req.getContextPath() + "/NewPost");
			}

		}
}
