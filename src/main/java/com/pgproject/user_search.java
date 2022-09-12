package com.pgproject;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class user_search
 */
public class user_search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_search() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		
		String Search=request.getParameter("search");
		
		if(Search.equals("")) 
			
			
		{
		
			
			RequestDispatcher rd= request.getRequestDispatcher("user_page");			
			rd.include(request, response);
			out.println("<!DOCTYPE html>\r\n"
					+ "  <html>\r\n"
					+ "  <head>\r\n"
					+ "  	<meta charset=\"utf-8\">\r\n"
					+ "  	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
					+ "  	<title></title>\r\n"
					+ "     <link rel='stylesheet' href='https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.min.css'>"
					+ "     <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js\"></script>\r\n"
					+ "	    <script src=\"https://cdn.jsdelivr.net/npm/sweetalert2@10.10.1/dist/sweetalert2.all.min.js\"></script>\r\n"
					+ "  	<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n"
					+ "  	<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>"
					+ "  </head>\r\n"
					+ "  <body>\r\n"
					+ "  	<script src=\"searching.js\"></script>\r\n"
					+ "  </body>\r\n"
					+ "  </html>");
			
		}
		else {
		
		try 
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pg","root","");
			
			PreparedStatement pst= con.prepareStatement("select * from add_pg WHERE pg_name=?");
						
			pst.setString(1, Search);
			
			ResultSet rs=pst.executeQuery();
				
			{
			out.println(" <!DOCTYPE html>\r\n"
					+ "  <html>\r\n"
					+ "  <head>\r\n"
					+ "  	<meta charset=\"utf-8\">\r\n"
					+ "  	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
					+ "  	<title></title>\r\n"
					+ "  	<link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap-4.6.1-dist\\css\\bootstrap.min.css\">\r\n"
					+ "	<link rel=\"stylesheet\" href=\"font-awesome-4.7.0\\css\\font-awesome.min.css\">\r\n"
					+ "	<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css\"> <!----bootstrap icons---->\r\n"
					+ "	<script src=\"https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js\"></script>\r\n"
					+ "  	<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n"
					+ "  	<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
					+ "  	<script src=\"function.js\"></script>\r\n"
					+ "  	<style type=\"text/css\">\r\n"
					+ "  		\r\n"
					+ "  		.clr\r\n"
					+ "  		{\r\n"
					+ "  			\r\n"
					+ "  		background-color: #f5f5f5;\r\n"
					+ "  		}\r\n"
					+ "\r\n"
					+ "  		a:hover\r\n"
					+ "  		{\r\n"
					+ " 			color: red;\r\n"
					+ "  		}\r\n"
					+ "\r\n"
					+ "  			\r\n"
					+ "  	</style>\r\n"
					+ "  </head>\r\n"
					+ "  <body>\r\n"
					+ " \r\n"
					+ "<div class=\"table-responsive-sm clr\"><br>\r\n"
					+ "  	<table class=\"table table-striped\">\r\n"
					+ "  		<h5  class=\"text-info\" align=\"center\">Search Details</h5><br>\r\n"
					+ "	  	<thead>\r\n"
					+ "		    <tr>\r\n"
					+ "				<th class=\"text-warning\">PG Name</th>\r\n"
					+ "				<th class=\"text-warning\">PG Type</th>\r\n"
					+ "              <th class=\"text-warning\">State</th>\r\n"
					+ "				<th class=\"text-warning\">City</th>\r\n"
					+ "		    </tr>\r\n"
					+ "	  	</thead>");
			
			while (rs.next())
			{
				out.println("<tbody>\r\n"
						+ "		    <tr>\r\n"
						+ "				<td>"+rs.getString(2)+"</td>\r\n"
						+ "				<td>"+rs.getString(3)+"</td>\r\n"
						+ "				<td>"+rs.getString(4)+"</td>\r\n"
						+ "				<td>"+rs.getString(5)+"</td>\r\n"
						+ "		    </tr>\r\n"
						+ "	    </tbody>");
			}
		
			out.println("</table>\r\n"
					+ "</div>\r\n"
					+ "<div align=\"center\">\r\n"
					+ "<p align='center' class=\"text-danger\" >**If the Search Details are empty, It means PG are not available in your City or State</p>\r\n"
					+ "<p align='center' class=\"text-danger\"> To request PG in your location, Please write to the Owner in the <a href='contact_tab.html'>Contact Tab</a>.Thanks!</p>\r\n"
					+ "</div>\r\n"
					+ "</body>\r\n"
					+ "</html>");
				
		
		
			}
			
		
		}
			catch(ClassNotFoundException e)
			{
				System.err.println("ClassNotFound Exception" +e);
				
			}
			catch(SQLException e)
			{
				System.err.println("SQL Exception" +e);
				out.println("No data found in the database...");
				out.println("or you have typed the wrong information");
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
