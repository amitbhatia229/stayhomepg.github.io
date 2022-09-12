package com.pgproject;
import java.io.*;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class user_password
 */
public class user_password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_password() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		
		
		String old_password=request.getParameter("password");
		String new_password=request.getParameter("new_password");
		String confirm_password=request.getParameter("cpassword");
		
		HttpSession session2=request.getSession(false);
		
		String email=String.valueOf(session2.getAttribute("username"));
		
		if(old_password.equals("") || new_password.equals("")|| confirm_password.equals("") ) 
		{
			
			out.println("Password fields are empty");
			
		}
		
		try 
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con= DriverManager.getConnection("jdbc:mysql://localhost:3306/pg","root","");
			
			PreparedStatement pst=con.prepareStatement("Select user_password from user_table where email=?");
			
			pst.setString(1,email);
			
			ResultSet rs=pst.executeQuery();
			
			rs.next();
			
			if(old_password!=null)
			{
				
				if(new_password.equals(confirm_password) && rs.getString(1).equals(old_password)) {
					
					
					PreparedStatement pst2=con.prepareStatement("update user_table set user_password=? where email=?");
					
					pst2.setString(1,new_password);
					pst2.setString(2, email);
					
					int a=pst2.executeUpdate();
					
					if(a>0) 
					{
						
						response.sendRedirect("user_page");
					}
					else 
					{
						out.println("error on updating");
					}
				}
				else
				{
					
					out.println("old password is null");
				}
			}
			
		}catch(ClassNotFoundException e) 
		{
			System.err.println("Class Not Found exception"+e);
			
		}catch(SQLException e) 
		{
			System.err.println("SQL Exception"+e);
			
		}
		
		
		
	}

	private void PrintWriter() {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
