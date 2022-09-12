package com.pgproject;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class confirmed_screen
 */
public class confirmed_screen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public confirmed_screen() {
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
		if (session2!=null)
{
		String email=String.valueOf(session2.getAttribute("username"));
		
		out.println("<!DOCTYPE html>\r\n"
		+ "<html>\r\n"
		+ "<head>\r\n"
		+ "	<meta charset=\"utf-8\">\r\n"
		+ "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
		+ "	<title></title>\r\n"
		+ "</head>\r\n"
		+ "<body>\r\n"
		+ "<img src=\"tick.png\" height=\"350px\" style=\"margin:auto; display: block;\">\r\n"
		+ "<p><h2 align='center' style=color:Green;><em> Hey "+email+" you have successfully booked your PG.</em></h2>	</p>\r\n"
		+ "<p><h3 align='center' style=color:Red;>In order to cancel your booking, please click on <a href='user_booking_manage' style=text-decoration:none;>Manage Booking</a></h3></p>\r\n"
		+ "<p><h3 align='center' style=color:Red;>If you have any booking related query then please reach out to our <a href='contact_tab.html' style=text-decoration:none;>Contact Page</a></h3></p>\r\n"
		+ "<p><h3 align='center'>Thanks....</h3></p>\r\n"
		+ "\r\n"
		+ "</body>\r\n"
		+ "</html>");
		
		out.println("<h3 align='center' style=\"color:Red\"><a href='user_page' style=text-decoration:none;>Back to Dashboard</a></h3>");
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
