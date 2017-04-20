package edu.ycp.cs320.ms1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserHomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		if(req.getSession().getAttribute("username") != null){
			username = (String) req.getSession().getAttribute("username");
		}
		else{
			req.getSession().setAttribute("username", "guest");
		}
				
		req.getRequestDispatcher("/_view/UserHome.jsp").forward(req, resp);
		
		
	}
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			if(req.getParameter("Post") != null){
				resp.sendRedirect(req.getContextPath() + "/Post");
			}
			
			if(req.getParameter("New Post") != null){
				resp.sendRedirect(req.getContextPath() + "/NewPost");
			}

		}
}
