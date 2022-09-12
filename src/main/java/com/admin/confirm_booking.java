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
import java.sql.*;

import org.apache.catalina.SessionEvent;
;/**
 * Servlet implementation class confirm_booking
 */
public class confirm_booking extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public confirm_booking() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			
			HttpSession session2=request.getSession(false);
			
			String pg_id=request.getParameter("pg_id");
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pg","root","");
				
				PreparedStatement pst= con.prepareStatement("select * from add_pg where pg_id=?");				
				
//				PreparedStatement pst2= con.prepareStatement("INSERT INTO book_pg(pg_name,type,state,City,rooms,Rent,pg_id,address)SELECT pg_name,pg_type,state,city,rooms,rent,pg_id,address FROM add_pg WHERE user_id=? and email=?");				
				
				
//				pst.setString(1,user_id);
//				pst.setString(2, email);
				pst.setString(1, pg_id);
				ResultSet rs=pst.executeQuery();
				rs.next();
				String pg_=rs.getString(1);
				String pg_name=rs.getString(2);
				String type=rs.getString(3);
				String state=rs.getString(4);
				String city=rs.getString(5);
				String rooms=rs.getString(6);
				String address=rs.getString(7);
				String rent=rs.getString(8);
				
				String user_id=String.valueOf(session2.getAttribute("user_id"));
				String email=String.valueOf(session2.getAttribute("username"));
				
				
//				out.println("insert into book_pg(pg_name,type,state,City,rooms,Rent,pg_id,address,user_id,email)values("+pg_name+","+type+","+state+","+city+","+rooms+","+rent+","+address+","+user_id+","+email+")");
				
				
				PreparedStatement pst2=con.prepareStatement("INSERT into book_pg(pg_name,type,state,City,rooms,Rent,pg_id,address,user_id,email)VALUES(?,?,?,?,?,?,?,?,?,?)");
				
			
				pst2.setString(1,pg_name);
				pst2.setString(2,type);
				pst2.setString(3,state);
				pst2.setString(4,city);
				pst2.setString(5,rooms);
				pst2.setString(6,rent);
				pst2.setString(7,pg_);
				pst2.setString(8,address);
				pst2.setString(9,user_id);
				pst2.setString(10, email);
				
				boolean a=pst2.execute();
				
				if(a=true) {
					
					
					RequestDispatcher rd = request.getRequestDispatcher("confirmed_screen");
					rd.forward(request, response);
					
					
				
					
				}
				else
				{
					RequestDispatcher rd = request.getRequestDispatcher("booking");
					rd.include(request, response);
					out.println("Sorry Booking is not Successfull, Please Try Again later....");
				}
				
	
			}
			
			catch(ClassNotFoundException e)
			{
				System.err.println("class not found exception"+e);
				
			}
			catch(SQLException e)
			{
				System.err.println("class not found exception"+e);
				out.println("<h2 align='center'><em>Database Error<em></h2>");
			}
		}
	}
		
		
		

	/**+
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
