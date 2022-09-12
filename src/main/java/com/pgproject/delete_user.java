package com.pgproject;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class delete_user
 */
public class delete_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete_user() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		HttpSession session2=request.getSession(false);	
		
		
		if(session2!=null)
		{
			String email=String.valueOf(session2.getAttribute("username"));
			try 
			{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/pg","root","");
			
			PreparedStatement pst=con.prepareStatement("delete from user_table where email=?");
			
			pst.setString(1,email);
			
			int a=pst.executeUpdate();
			
			
			if (a>0) 
			{
			response.sendRedirect("index.html");	
				
			}
			else {
				
				response.sendRedirect("user_page");
			}
			
			
			}
		
		
		catch(ClassNotFoundException e) 
			{
			
			System.err.println("class not found exception"+e);
			}
			
		catch(SQLException e)
			{
			System.err.println("SQL exception"+e);
			}
		}
		else 
		{
			out.println("<h1>session expired</h1>");
			out.println("please login again");
			out.println("<a href='index.html'>Back to login page</a>");
			
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
