package com.admin;
import java.sql.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class pg_manage
 */
public class pg_manage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pg_manage() {
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
				
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pg","root","");
			
			PreparedStatement pst= con.prepareStatement("select * from add_pg");				
		
		
			ResultSet rs= pst.executeQuery();
			
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
					+ "  		<h5  class=\"text-info\" align=\"center\">Manage Your PG Here</h5><br>\r\n"
					+ "	  	<thead>\r\n"
					+ "		    <tr>\r\n"
					+ "				<th class=\"text-warning\">PG Id</th>\r\n"
					+ "				<th class=\"text-warning\">PG Name</th>\r\n"
					+ "				<th class=\"text-warning\">PG Type</th>\r\n"
					+ "				<th class=\"text-warning\">State</th>\r\n"
					+ "				<th class=\"text-warning\">City</th>\r\n"
					+ "				<th class=\"text-warning\">Rooms</th>\r\n"
					+ "				<th class=\"text-warning\">Address</th>\r\n"
					+ "				<th class=\"text-warning\">Rent</th>\r\n"
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
					+ "				<th class=\"text-danger\">Action</th>\r\n"
					+ "		    </tr>\r\n"
					+ "	  	</thead>");
			
			while (rs.next())
			{
				out.println("<tbody>\r\n"
						+ "		    <tr>\r\n"
						+ "		     	<th class=\"text-danger\">"+rs.getString(1)+"</th>\r\n"
						+ "				<th class=\"text-danger\">"+rs.getString(2)+"</th>\r\n"
						+ "				<td>"+rs.getString(3)+"</td>\r\n"
						+ "				<td>"+rs.getString(4)+"</td>\r\n"
						+ "				<td>"+rs.getString(5)+"</td>\r\n"
						+ "				<td>"+rs.getString(6)+"</td>\r\n"
						+ "				<td>"+rs.getString(7)+"</td>\r\n"
						+ "				<td>"+rs.getString(8)+"</td>\r\n"
						+ "				<td>"+rs.getString(9)+"</td>\r\n"
						+ "				<td>"+rs.getString(10)+"</td>\r\n"
						+ "				<td>"+rs.getString(11)+"</td>\r\n"
						+ "				<td>"+rs.getString(12)+"</td>\r\n"
						+ "				<td>"+rs.getString(13)+"</td>\r\n"
						+ "				<td>"+rs.getString(14)+"</td>\r\n"
						+ "				<td>"+rs.getString(15)+"</td>\r\n"
						+ "				<td>"+rs.getString(16)+"</td>\r\n"
						+ "				<td>"+rs.getString(17)+"</td>\r\n"
						+ "				<td>"+rs.getString(18)+"</td>\r\n"
						+ "				<th class=\"text-danger\"><a href=\"delete_command_user?pgId="+rs.getString(1)+" style=\"text-decoration:none;\"><i class=\"bi bi-trash\"></i> </a></th>\r\n"
						+ "		    </tr>\r\n"
						+ "	    </tbody>");
			}
		
			out.println("</table>\r\n"
					+ "</div>\r\n"
					+ "<div align=\"center\">\r\n"
					+ "	<a href=\"admin_dashboard\" style=\"text-decoration:none; font-size: 18px;\">Back to Dashboard</a>&nbsp;&nbsp;&nbsp;\r\n"
					+ "</div>\r\n"
					+ "</body>\r\n"
					+ "</html>");
		
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
