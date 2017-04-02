package edu.ycp.cs320.ms1.servlet;

import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

import org.junit.Before;
import org.junit.Test;

import edu.ycp.cs320.ms1.model.GuessingGame;

public class LoginServletTest {
	private LoginServlet loginServ = new LoginServlet();
	HttpServletRequestWrapper req1;
	HttpServletResponseWrapper resp1;
	
	@Before
	public void setUp() {
		req1 = new HttpServletRequestWrapper(req1);
		resp1 = new HttpServletResponseWrapper(resp1);
	}
	
	@Test
	public void testLoginGoodCreds() {
		//String currentURL = req.getRequestURI();
		//String currentURL = req1.getContextPath();
		req1.getSession().setAttribute("username", "Test");
		req1.getSession().setAttribute("password", "test1");
		try {
			loginServ.doPost(req1, resp1);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		assertEquals(req1.getContextPath() + "/UserHome", "https://localhost:8081/ms1/UserHome");
	}
	
	public void testLoginBadCreds1() {
		
	}
}
