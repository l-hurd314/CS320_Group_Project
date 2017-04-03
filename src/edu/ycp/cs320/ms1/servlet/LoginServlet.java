package edu.ycp.cs320.ms1.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.ycp.cs320.ms1.controller.NumbersController;
import edu.ycp.cs320.ms1.model.Numbers;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		//Numbers model = new Numbers();
		
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		String errorMessage = null;
		
		if(username.equals("Test") && password.equals("test1")){
			req.getSession().setAttribute("username", username);
			resp.sendRedirect(req.getContextPath() + "/UserHome");
		}
		resp.sendRedirect(req.getContextPath() + "/UserHome");
		/*else{
			errorMessage = "Invalid Login.";
			req.setAttribute("errorMessage", errorMessage);
			req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		}*/
		
		
		/*
		// Decode form parameters and dispatch to controller
		String errorMessage = null;
		//Double result = null;
		try {
			Double first = getDoubleFromParameter(req.getParameter("first"));
			Double second = getDoubleFromParameter(req.getParameter("second"));
			
			model.setValue1(first);
			model.setValue2(second);
			
			//Double first = model.getValue1();
			//Double second = model.getValue2();

			if (first == null || second == null) {
				errorMessage = "Invalid";
			} else {
				NumbersController controller = new NumbersController();
				model.setResult(controller.mult(first, second));
			}
		} catch (NumberFormatException e) {
			errorMessage = "Invalid double";
		}
		
		// Add parameters as request attributes
		//req.setAttribute("first", req.getParameter("first"));
		//req.setAttribute("second", req.getParameter("second"));
		
		// Add result objects as request attributes
		req.setAttribute("errorMessage", errorMessage);
		//req.setAttribute("result", result);
		req.setAttribute("game", model);
		
		// Forward to view to render the result HTML document
		req.getRequestDispatcher("/_view/login.jsp").forward(req, resp);
		
	*/
	}

		
	private Double getDouble(HttpServletRequest req, String name) {
		return Double.parseDouble(req.getParameter(name));
		
	}
	private Double getDoubleFromParameter(String s) {
		if (s == null || s.equals("")) {
			return null;
		} else {
			return Double.parseDouble(s);
		}
	}
}
