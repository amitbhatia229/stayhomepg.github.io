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
 * Servlet implementation class sign_up
 */
public class sign_up extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public sign_up() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();
		
		String first_name= request.getParameter("First_Name");
		String mobile_number= request.getParameter("Mobile_Number");
		String email= request.getParameter("Email");
		String password= request.getParameter("passwordname");
		String last_name= request.getParameter("last_name");
		String dob= request.getParameter("dob");
		String type= request.getParameter("user_type");
		String confirm_password= request.getParameter("cpassword");

		
		out.println("password is "+password + " confirm password is "+confirm_password);
		

		if(password == null || confirm_password == null  || confirm_password.equals("")|| password.equals("") || !password.equals(confirm_password)) 
		{
			RequestDispatcher rd= request.getRequestDispatcher("index.html");
			rd.forward(request, response);
			out.println("inside here ");	
		}
		
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pg","root","");
			
			PreparedStatement pst= con.prepareStatement("insert into user_table(first_name,last_name,Mobile_number,date_of_birth,email,user_password,usertype,confirm_password)values(?,?,?,?,?,?,?,?)");
			
			
			pst.setString(1, first_name);
			pst.setString(2, last_name);
			pst.setString(3, mobile_number);
			pst.setString(4, dob);
			pst.setString(5, email);
			pst.setString(6, password);
			pst.setString(7, type);
			pst.setString(8, confirm_password);
		
			int a=pst.executeUpdate();
			
				if(a>0)
				{
					
					RequestDispatcher rd= request.getRequestDispatcher("index.html");
					rd.include(request, response);
					out.println(" <!DOCTYPE html>\r\n"
							+ "  <html>\r\n"
							+ "  <head>\r\n"
							+ "  	<meta charset=\"utf-8\">\r\n"
							+ "  	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
							+ "  	<title></title>\r\n"
							+ "  </head>\r\n"
							+ "  <body>\r\n"
							+ "  	<script src=\"signup.js\"></script>\r\n"
							+ "  </body>\r\n"
							+ "  </html>");
					
					
				}
			
			else 
			{
				out.println("<h3 style=\"color:Red;\">Sorry We are unable to process your request...</h3>");
				out.println("<h3 style=\"color:Red;\">Try again after some time</h3>");

			}
		}
		catch(ClassNotFoundException e)
		{
			System.err.println("Class not found exception"+e);
		}
		catch(SQLException e) 
		{
			System.err.println("SQL Exception"+e);
			out.println("<h3 align='center' style=\"color:Red;\">Sorry,database is not responding.</h3>");
			out.println("<h3 align='center'style=\"color:Red;\">Please try again after some time</h3");
			out.println("<h3 align='center'>If you are facing this issue again after some time then please write to us in the Contact Page.</h3>");
		
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
