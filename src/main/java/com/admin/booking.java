package com.admin;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class booking
 */
public class booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public booking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		HttpSession session2=request.getSession(false);
		String pg_id=request.getParameter("pg_id");
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pg","root","");
			
			PreparedStatement pst= con.prepareStatement("select*from add_pg where pg_id=?");
			
			pst.setString(1,pg_id);
			
			ResultSet rs= pst.executeQuery();
			rs.next();
			
			if(session2!=null) 
			{
			String email=String.valueOf(session2.getAttribute("username"));
			String user_id=String.valueOf(session2.getAttribute("user_id"));
			
			
			out.println("<!DOCTYPE html>\r\n"
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
					+ "\r\n"
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
					+ " <div class=\"table-responsive-sm clr\"><br>\r\n"
					+ "  <table class=\"table table-striped\">\r\n"
					+ "  	<h5  class=\"text-info\" align=\"center\">PG Details</h5><br>\r\n"
					+ "  <thead>\r\n"
					+ "    <tr>\r\n"
					+ "		<th class=\"text-warning\">PG Name</th>\r\n"
					+ "		<th class=\"text-warning\">PG Type</th>\r\n"
					+ "		<th class=\"text-warning\">State</th>\r\n"
					+ "		<th class=\"text-warning\">City</th>\r\n"
					+ "		<th class=\"text-warning\">Rooms</th>\r\n"
					+ "		<th class=\"text-warning\">Address</th>\r\n"
					+ "		<th class=\"text-warning\">Rent</th>	\r\n"
					+ "    </tr>\r\n"
					+ "  </thead>\r\n"
					+ "  <tbody>\r\n"
					+ "    <tr>\r\n"
					+ "     <th class=\"text-danger\">"+rs.getString(2)+"</th>\r\n"
					+ "		<td>"+rs.getString(3)+"</td>\r\n"
					+ "		<td>"+rs.getString(4)+"</td>\r\n"
					+ "		<td>"+rs.getString(5)+"</td>\r\n"
					+ "		<td>"+rs.getString(6)+"</td>\r\n"
					+ "		<td>"+rs.getString(7)+"</td>\r\n"
					+ "		<td>"+rs.getString(8)+"</td>\r\n"
					+ "    </tr>\r\n"
					+ "  </tbody>\r\n"
					+ "</table>\r\n"
					+ "<br>\r\n"
					+ "<h5 class=\"text-info\" align=\"center\">Amenities Offered</h5><br>\r\n"
					+ "	<table class=\"table table-striped\">\r\n"
					+ "	  	<thead>\r\n"
					+ "		    <tr>\r\n"
					+ "				<th class=\"text-warning\">Electricity</th>\r\n"
					+ "				<th class=\"text-warning\">Wifi</th>\r\n"
					+ "				<th class=\"text-warning\">Television</th>\r\n"
					+ "				<th class=\"text-warning\">Power Backup</th>\r\n"
					+ "				<th class=\"text-warning\">Security</th>\r\n"
					+ "				<th class=\"text-warning\">Parking</th>\r\n"
					+ "				<th class=\"text-warning\">CCTV</th>\r\n"
					+ "				<th class=\"text-warning\">Breakfast</th>\r\n"
					+ "				<th class=\"text-warning\">Lunch</th>\r\n"
					+ "				<th class=\"text-warning\">Dinner</th>\r\n"
					+ "		    </tr>\r\n"
					+ "	  	</thead>\r\n"
					+ "	  	<tbody>\r\n"
					+ "		    <tr>\r\n"
					+ "		     	<td>"+rs.getString(9)+"</td>\r\n"
					+ "				<td>"+rs.getString(10)+"</td>\r\n"
					+ "				<td>"+rs.getString(11)+"</td>\r\n"
					+ "				<td>"+rs.getString(12)+"</td>\r\n"
					+ "				<td>"+rs.getString(13)+"</td>\r\n"
					+ "				<td>"+rs.getString(14)+"</td>\r\n"
					+ "				<td>"+rs.getString(15)+"</td>\r\n"
					+ "				<td>"+rs.getString(16)+"</td>\r\n"
					+ "				<td>"+rs.getString(17)+"</td>\r\n"
					+ "				<td>"+rs.getString(18)+"</td>\r\n"
					+ "		    </tr>\r\n"
					+ "	    </tbody>\r\n"
					+ "	</table>\r\n"
					+ "</div>\r\n"
					+ "	<div align=\"center\">\r\n"
					+ "		<a href=\"user_page\" class=\"btn btn-primary\" style=\"text-decoration:none; font-size: 18px;\">Back</a>&nbsp;&nbsp;&nbsp;\r\n"
					+ "		<a href=\"confirm_booking?pg_id="+rs.getString(1)+"\" class=\"btn btn-success\" style=\"text-decoration:none; font-size: 18px;\" onclick=\"submit()\"> <strong>Book Now</strong></a>\r\n"
					+ "	</div>\r\n"
					+ "  \r\n"
					+ "  </body>\r\n"
					+ "  </html>");
			

//			RequestDispatcher rd= request.getRequestDispatcher("user_page");			
//			rd.include(request, response);
		
		}
			else 
			{
		
				out.println("<h1 style=color:Red;><em>Session Expired...!</em></h1>");
				out.println("<h3>Please Login Again</h3>");
				out.println("<h3>Back to <a href='index.html'>Login Page</a></h3>");
			}
}
		
		catch(ClassNotFoundException e)
		{
			System.err.println("class not found exception"+e);
			
		}
		catch(SQLException e)
		{
			System.err.println("class not found exception"+e);
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