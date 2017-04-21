package edu.ycp.cs320.ms1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ycp.cs320.ms1.controller.InsertPostController;

public class NewPostServlet extends HttpServlet {
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
		
		req.getRequestDispatcher("/_view/NewPost.jsp").forward(req, resp);
		
		
	}
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			if(req.getParameter("text") != null && req.getParameter("title") != null){
				InsertPostController ipc = new InsertPostController();
				ipc.insertPostIntoPostsTable(req.getParameter("title"), username, req.getParameter("text"));
				resp.sendRedirect(req.getContextPath() + "/UserHome");
				
			}
			
			
		}
}
