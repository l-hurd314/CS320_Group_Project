package edu.ycp.cs320.ms1.servlet;

import java.io.*;
import java.util.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ycp.cs320.ms1.controller.InsertPostController;

//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;


public class NewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
//	private String filePath;
//	private File file;
	
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
			
//			//Source code: https://www.tutorialspoint.com/jsp/jsp_file_uploading.htm
//
//		      DiskFileItemFactory factory = new DiskFileItemFactory();
//
//		      //Handles upload process
//		      ServletFileUpload upload = new ServletFileUpload(factory);
//
//		         try{ 
//			      //Gets file
//			         List fileItem = upload.parseRequest(req);
//	
//			      // Processes file
//			         Iterator i = fileItem.iterator();
//			         
//			         while ( i.hasNext () ) 
//			         {
//			        	 FileItem fi = (FileItem)i.next();
//			        	 
//			        	 if ( !fi.isFormField () )  
//			        	 {
//
//				            String fileName = fi.getName();
//
//				            //where file will go
//				            filePath = "war/";
//				            
//				            // Writes file
//				            if( fileName.lastIndexOf("\\") >= 0 ){
//				               file = new File( filePath + 
//				               fileName.substring( fileName.lastIndexOf("\\"))) ;
//				            }
//				            
//				            else{
//				               file = new File( filePath + 
//				               fileName.substring(fileName.lastIndexOf("\\")+1)) ;
//				            }
//				            
//			            fi.write( file ) ;
//			            resp.sendRedirect(req.getContextPath() + "/UserHome");
//			        	 }
//		          }
//		         }	
//		         
//		         catch(Exception ex) 
//		         {
//		        	 System.out.println(ex);
//		         }
		  }
}
