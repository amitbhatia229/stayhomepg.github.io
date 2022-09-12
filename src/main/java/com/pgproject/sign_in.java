package com.pgproject;
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
 * Servlet implementation class sign_in
 */
public class sign_in extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sign_in() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		String type=request.getParameter("user_type");
		
		
		if(email.equals("") || password.equals("")) 
			
		{
			RequestDispatcher rd= request.getRequestDispatcher("index.html");
			rd.forward(request, response);
			
		}
		String user_id=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pg","root","");
			
			PreparedStatement pst=con.prepareStatement("select user_password from user_table where email=? and usertype=?");
			
			pst.setString(1, email);			
			
			pst.setString(2, type);
			
			ResultSet rs= pst.executeQuery();
			
			rs.next(); 
			
			if(email.equals("admin@gmail.com") && password.equals("admin") && type.equals("Admin")) 
				{
					//using session and cookies
					
					HttpSession session=request.getSession();
					
					session.setAttribute("adminname",email);                       	//session.setAttribute("loginstatus",true);
				
					response.sendRedirect("admin_dashboard");					
					
				}
			
			
			else if (rs.getString(1).equals(password) && type.equals("PG_Owner")) 
			{
				
				HttpSession owner=request.getSession();
				
				
				
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con2=DriverManager.getConnection("jdbc:mysql://localhost:3306/pg","root","");
				
					PreparedStatement pst2=con2.prepareStatement("select user_id from add_pg where email=?");
					
					pst2.setString(1, email);
					
					ResultSet rs2= pst2.executeQuery();
					rs2.next();
				
					user_id=rs2.getString(1);
					
				}
				
					catch(ClassNotFoundException e)
					{
						System.err.println("Class Not Found Exception"+e);
					}
					
					catch(SQLException e)
					{
						
						System.err.println("SQL Exception"+e);
					}
				
				owner.setAttribute("ownername", email);	
				owner.setAttribute("user_id", user_id);
				
				response.sendRedirect("PG_OwnerDashboard");
			}
			
			
			else if(rs.getString(1).equals(password) && type.equals("User"))
			
			{
				HttpSession session2 =request.getSession();
				
				try 
				{
					Class.forName("com.mysql.jdbc.Driver");
					
					Connection con3=DriverManager.getConnection("jdbc:mysql://localhost:3306/pg","root","");
				
					PreparedStatement pst3=con3.prepareStatement("select user_id from user_table where email=?");
					
					pst3.setString(1, email);
					
					ResultSet rs3= pst3.executeQuery();
					
					rs3.next();
				
					user_id=rs3.getString(1);
					
				}
				
					catch(ClassNotFoundException e)
					{
						System.err.println("Class Not Found Exception"+e);
					}
					
					catch(SQLException e)
					{
						
						System.err.println("SQL Exception"+e);
					}
				
				session2.setAttribute("username", email );
				
				session2.setAttribute("user_id", user_id);
				
				response.sendRedirect("user_page");
				
			}
			
			
			else 
			{	
				
				out.println("<h3 align='center' style=\"color:Red;\"><em>Hi..! You have entered Wrong Login Credentials.</em></h3>");
				out.println("<h4 align='center'>Please Check Your Login Credentials...Thanks</h4>");
		
			}
		}
		
		catch(ClassNotFoundException e)
		{
			System.err.println("Class Not Found Exception"+e);
		}
		
		catch(SQLException e)
		{
			
			System.err.println("SQL Exception"+e);
			out.println("<h3 align='center'style=\"color:Red;\">Database Error...Not Found</h3>");
			out.println("<h3 align='center' style=\"color:Red;\">You have entered/selected wrong login credentials... </h3>");
			out.println("<h4 align='center'>Please Check Your Login Credentials...Thanks</h4>");
			
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
