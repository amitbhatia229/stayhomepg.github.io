package com.pgproject;

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
import java.sql.SQLException;

/**
 * Servlet implementation class delete_command_user
 */
public class delete_command_user extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete_command_user() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();	
		
		HttpSession session2=request.getSession(false);
		
		String user_id=String.valueOf(session2.getAttribute("user_id"));
		
		String booking_id=request.getParameter("booking_id");
		
		try 
		{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pg","root","");
			
			PreparedStatement pst= con.prepareStatement("delete from book_pg where booking_id=?");
			
			pst.setString(1,booking_id);
			
			int a= pst.executeUpdate();
		
				if(a>0) 
				{
					response.sendRedirect("user_booking_manage");
				}
				else {
					
					response.sendRedirect("user_booking_manage");
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
