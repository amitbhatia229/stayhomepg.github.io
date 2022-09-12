package com.admin;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class change_password
 */
public class change_password extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public change_password() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String old_password= request.getParameter("password");
		String new_password=request.getParameter("new_password");
		String confirm_password =request.getParameter("cpassword");
			
		HttpSession owner =request.getSession(false);
	
		String email=String.valueOf(owner.getAttribute("ownername"));
		
		if(old_password.equals("") || new_password.equals("")|| confirm_password.equals("") ) 
		{
			
			out.println("<h2><em>Password fields are empty<em></h2>");
			
		}
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pg","root","");
			
			PreparedStatement pst=con.prepareStatement("select user_password from user_table where email=?");
			
			pst.setString(1, email);
			
			ResultSet rs= pst.executeQuery();
			
			rs.next();
			
			if(old_password!=null)
			{
			 if(rs.getString(1).equals(old_password) && new_password.equals(confirm_password))
				{
					
						PreparedStatement pst2=con.prepareStatement("update user_table set user_password=? where email=?");
					
						pst2.setString(1,new_password);
						pst2.setString(2,email);
					
						int a=pst2.executeUpdate();
					
						if(a>0) 
						{
							RequestDispatcher rd= request.getRequestDispatcher("PG_OwnerDashboard");
							rd.forward(request, response);	
						}
											
				}
			 else 
			 	{
				out.println("<h2><em>Password Should Be Match<em></h2>"); 
			 	}
			}
		
		
		}
		catch(ClassNotFoundException e)
		{
		System.err.println("class not found exception"+e);
		
		}
		catch(SQLException e)
		{
		System.err.println("class not found exception"+e);
		out.println("Database error");
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
