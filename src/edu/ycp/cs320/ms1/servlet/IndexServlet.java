package edu.ycp.cs320.ms1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class IndexServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		
		req.getRequestDispatcher("/_view/index.jsp").forward(req, resp);
		
		
	}
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			if(req.getParameter("add") != null){
				resp.sendRedirect(req.getContextPath() + "/addNumbers");
			}
			else if(req.getParameter("mult") != null){
				resp.sendRedirect(req.getContextPath() + "/multNumbers");
			}
			else if(req.getParameter("guess") != null){
				resp.sendRedirect(req.getContextPath() + "/guessingGame");
			}
			
			else if(req.getParameter("login") != null){
				resp.sendRedirect(req.getContextPath() + "/Login");
			}
			
			else if(req.getParameter("signup") != null){
				resp.sendRedirect(req.getContextPath() + "/signUp");
			}
			
			else if(req.getParameter("guest") != null){
				resp.sendRedirect(req.getContextPath() + "/UserHome");
			}
		
		}
}
