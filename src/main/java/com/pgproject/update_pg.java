package com.pgproject;

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
 * Servlet implementation class update_pg
 */
public class update_pg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_pg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		//creating the session and cookies
		HttpSession owner=request.getSession();
		String email=String.valueOf(owner.getAttribute("ownername"));
		
		
		String name=request.getParameter("pg_name");
		String type=request.getParameter("type");
		String state=request.getParameter("state");
		String city=request.getParameter("city");
		String rooms=request.getParameter("rooms");
		String address=request.getParameter("address");
		String rent=request.getParameter("rent");
		
		String electricity= request.getParameter("electricity");
		String wifi= request.getParameter("wi_fi");
		String power= request.getParameter("power");
		String tv= request.getParameter("tv");
		String security= request.getParameter("security");
		String parking= request.getParameter("parking");
		String cctv= request.getParameter("cctv");
		String breakfast= request.getParameter("breakfast");
		String lunch= request.getParameter("lunch");
		String dinner= request.getParameter("dinner");
		
		
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/pg","root","");
			
			PreparedStatement pst=con.prepareStatement("select user_id from user_table where email=?");
			
			pst.setString(1, email);
			
			ResultSet rs= pst.executeQuery();
			rs.next();
			
			
			
		if(rs.getString(1)!=null)
		{
			String user_id=rs.getString(1);
			
			
			PreparedStatement pst2= con.prepareStatement("update add_pg set pg_name=?,pg_type=?,state=?,city=?,rooms=?,address=?,rent=?,electricity=?,wifi=?,television=?,power_backup=?,pg_security=?,parking=?,cctv=?,breakfast=?,lunch=?,dinner=? where user_id="+user_id+";");			
			pst2.setString(1,name);
			pst2.setString(2,type);
			pst2.setString(3,state);
			pst2.setString(4,city);
			pst2.setString(5,rooms);
			pst2.setString(6,address);
			pst2.setString(7,rent);
			pst2.setString(8, electricity);
			pst2.setString(9, wifi);
			pst2.setString(10, tv);
			pst2.setString(11,power);
			pst2.setString(12, security);
			pst2.setString(13, parking);
			pst2.setString(14, cctv);
			pst2.setString(15, breakfast);
			pst2.setString(16, lunch);
			pst2.setString(17, dinner);
        	pst2.setString(18, user_id);
//			pst2.setString(19, email);
			
			
			int a=pst2.executeUpdate();
			
			if(a>0) 
			{
				
				RequestDispatcher rd= request.getRequestDispatcher("PG_OwnerDashboard");
				rd.forward(request, response);
			}
			else 
			{
				out.println("Data Not Inserted");
			}
			
		}
		else
		{
			out.println("User is not Found");
			
		}
		}
		catch(ClassNotFoundException e) 
		{
			System.err.println("Class not found"+e);	
		}
		catch(SQLException e) 
		{
			System.err.println("SQL Exception"+e);
			
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
