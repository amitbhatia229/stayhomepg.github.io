package com.pgproject;
import java.sql.*;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class contact_tab
 */
public class contact_tab extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public contact_tab() {
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
		
		
		String name=request.getParameter("name");
		String mobile_number=request.getParameter("mobile");
		String email_id=request.getParameter("email");
		String subject=request.getParameter("subject");
		String message=request.getParameter("message");
		
		
		try 
		{
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pg","root","");
			
			PreparedStatement pst= con.prepareStatement("insert into feedback(full_name,contact_no,email,Subject,message) values(?,?,?,?,?)");
			
			pst.setString(1, name);
			pst.setString(2,(mobile_number));
			pst.setString(3, email_id);
			pst.setString(4, subject);
			pst.setString(5, message);
			
			int a=pst.executeUpdate();
			
			if(a>0) 
			{
				RequestDispatcher rd=request.getRequestDispatcher("contact_tab.html");
				rd.forward(request, response);
			}
			
			else 
			{
				out.println("Data not Found");
			}
		}
		catch(ClassNotFoundException e)
		{
			System.err.println("ClassNotFound Exception" +e);
			
		}
		catch(SQLException e)
		{
			System.err.println("SQL Exception" +e);
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
