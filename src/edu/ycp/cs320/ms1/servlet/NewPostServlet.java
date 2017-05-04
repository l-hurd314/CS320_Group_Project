package edu.ycp.cs320.ms1.servlet;

import java.io.*;
import java.util.*;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.ycp.cs320.ms1.controller.InsertPostController;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.output.*;


public class NewPostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private String username;
	 private boolean isMultipart;
	 private String filePath;
	 private int maxFileSize = 1000000 * 1024;
	 private int maxMemSize = 1000000 * 1024;
	 private File file;
	
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
		
//		 throw new ServletException("GET method used with " +
//		            getClass( ).getName( )+": POST method required.");
		           
		
	}
		protected void doPost(HttpServletRequest req, HttpServletResponse resp)
				throws ServletException, IOException {
			
			if(req.getParameter("text") != null && req.getParameter("title") != null){
				InsertPostController ipc = new InsertPostController();
				ipc.insertPostIntoPostsTable(req.getParameter("title"), username, req.getParameter("text"));
				resp.sendRedirect(req.getContextPath() + "/UserHome");
				
			}
			
			isMultipart = ServletFileUpload.isMultipartContent(req);
			resp.setContentType("text/html");
		     java.io.PrintWriter out = resp.getWriter( );
		     
		      if( !isMultipart ){
			     out.println("<html>");
			     out.println("<head>");
			     out.println("<title>Servlet upload</title>");  
			     out.println("</head>");
			     out.println("<body>");
			     out.println("<p>No file uploaded</p>"); 
			     out.println("</body>");
			     out.println("</html>");
			     return;
		     }
		      
		      DiskFileItemFactory factory = new DiskFileItemFactory();
		      // maximum size that will be stored in memory
		         factory.setSizeThreshold(maxMemSize);
		      // Location to save data that is larger than maxMemSize.
		         factory.setRepository(new File(" C:/Users/")); 

		      // Create a new file upload handler
		          ServletFileUpload upload = new ServletFileUpload(factory);
		      // maximum file size to be uploaded.
		         upload.setSizeMax( maxFileSize );

		         try{ 
			      // Parse the request to get file items.
			         List fileItems = upload.parseRequest(req);
	
			      // Process the uploaded file items
			         Iterator i = fileItems.iterator();
	
			         out.println("<html>");
			         out.println("<head>");
			         out.println("<title>Servlet upload</title>");  
			         out.println("</head>");
			         out.println("<body>");
			         
			         while ( i.hasNext () ) 
			         {
			        	 FileItem fi = (FileItem)i.next();
			        	 
			        	 if ( !fi.isFormField () )  
			        	 {
//				            // Get the uploaded file parameters
//				            String fieldName = fi.getFieldName();
				            String fileName = fi.getName();
//				            String contentType = fi.getContentType();
//				            boolean isInMemory = fi.isInMemory();
//				            long sizeInBytes = fi.getSize();
				            
				            // Write the file
				            if( fileName.lastIndexOf("\\") >= 0 ){
				               file = new File( filePath + 
				               fileName.substring( fileName.lastIndexOf("\\"))) ;
				            }
				            
				            else{
				               file = new File( filePath + 
				               fileName.substring(fileName.lastIndexOf("\\")+1)) ;
				            }
				            
			            fi.write( file ) ;
			            resp.sendRedirect(req.getContextPath() + "/UserHome");
			        	 }
		          }
			         
			         out.println("</body>");
			         out.println("</html>");
		         }	
		         
		         catch(Exception ex) 
		         {
		        	 System.out.println(ex);
		         }
		  }
}
