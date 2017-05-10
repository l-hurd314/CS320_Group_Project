package edu.ycp.cs320.ms1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.ms1.controller.deletePostController;


public class deletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String item;
@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/delete.jsp").forward(req, resp);
		//System.out.println(req.getQueryString());
		item = req.getQueryString();
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		//checks button
		if(req.getParameter("yes") != null){
			deletePostController dpc = new deletePostController();
			
			//Thank you Dan for walking us through how to fix this method
			int index = item.indexOf("=");
			item = item.substring(index + 1, item.length());
			dpc.deletePost(Integer.parseInt(item));
			resp.sendRedirect(req.getContextPath() + "/UserHome");
		}
		
		if(req.getParameter("no") != null){
			resp.sendRedirect(req.getContextPath() + "/UserHome");
		}
	}

}