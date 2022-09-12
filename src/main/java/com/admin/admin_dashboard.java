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
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class admin_dashboard
 */
public class admin_dashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public admin_dashboard() {
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
	
		try 
		{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pg","root","");
		
		PreparedStatement pst= con.prepareStatement("SELECT COUNT(user_id) from user_table WHERE usertype='PG_Owner';");
		
		PreparedStatement pst2= con.prepareStatement("SELECT COUNT(pg_id) from add_pg");

		PreparedStatement pst3=con.prepareStatement("SELECT COUNT(DISTINCT state) from add_pg");
		
		PreparedStatement pst4= con.prepareStatement("SELECT COUNT(DISTINCT city) from add_pg");
		
		PreparedStatement pst5= con.prepareStatement("SELECT COUNT(user_id) from user_table where usertype='User'");
		
		ResultSet rs=pst.executeQuery();
		ResultSet rs2=pst2.executeQuery();
		ResultSet rs3=pst3.executeQuery();
		ResultSet rs4=pst4.executeQuery();
		ResultSet rs5=pst5.executeQuery();
		
		rs.next();
		rs2.next();
		rs3.next();
		rs4.next();
		rs5.next();

		HttpSession session=request.getSession(false);     //creating of session and cookies
		
		if(session!=null)
		{
			String email=String.valueOf((session.getAttribute("adminname")));
		
			out.println("<!DOCTYPE html>      <!------@created and designed by AMIT BHATIA-------->\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "	<meta charset=\"utf-8\">\r\n"
				+ "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "	<title>Admin_Dashboard</title>\r\n"
				+ "	<link rel=\"icon\" href=\"PG home logo.jpg\">\r\n"
				+ "	<link rel=\"stylesheet\" href=\"bootstrap-4.6.1-dist\\css\\bootstrap.min.css\">\r\n"
				+ "	<link rel=\"stylesheet\" href=\"font-awesome-4.7.0\\css\\font-awesome.min.css\">\r\n"
				+ "	<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css\">\r\n"
				+ "	<script src=\"https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js\"></script>\r\n"
				+ "  	<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n"
				+ "  	<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
				+ "  	\r\n"
				+ "  	<style type=\"text/css\">\r\n"
				+ "      .clr\r\n"
				+ "      {\r\n"
				+ "        background-color: #f5f5f5;\r\n"
				+ "      }\r\n"
				+ "  	.vertical-nav \r\n"
				+ "    {\r\n"
				+ "      padding-top: 50px;\r\n"
				+ "      width: 100%;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .card \r\n"
				+ "    {\r\n"
				+ "    overflow:hidden;\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .card-body .icon i \r\n"
				+ "    {\r\n"
				+ "    color: rgba(20, 20, 20, 0.15);\r\n"
				+ "    position: absolute;\r\n"
				+ "    left: 0;\r\n"
				+ "    left: auto;\r\n"
				+ "    right: -10px;\r\n"
				+ "    bottom: 0;\r\n"
				+ "    display: block;\r\n"
				+ "    transform: rotate(-44deg);\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "    .card:hover{\r\n"
				+ "\r\n"
				+ "      transform: scale(1.01);\r\n"
				+ "      box-shadow: 0 10px 20px rgba(0,0,0,.12), 0 4px 8px rgba(0,0,0,.06);\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "</style>\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "  <!-------------------horizontal navbar--------------------->\r\n"
				+ "<nav class=\"navbar navbar-expand-lg bg-light navbar-light sticky-top py-0\">\r\n"
				+ "  <a class=\"navbar-brand\" href=\"Home_Tab.html\" style=\"margin-left:-9px;\"><img src=\"PG home logo.jpg\" alt=\"logo\" width=\"50px\"            height=\"40px\"> Stay Home</a>\r\n"
				+ "\r\n"
				+ "  <button type=\"button\" class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#abc\">\r\n"
				+ "    <span class=\"navbar-toggler-icon\"></span>\r\n"
				+ "  </button>\r\n"
				+ "  \r\n"
				+ "  <div class=\"collapse navbar-collapse\" id=\"abc\">\r\n"
				+ "    <ul class=\"navbar nav ml-auto\">\r\n"
				+"			<span class='bi bi-person-circle'> " +email+"</span>"
				+ "        <a class=\"nav-link text-dark\" href=\"admin_logout\" onclick=\"logout()\">Log Out</a>"
				+ "    </ul>\r\n"
				+ "  </div>\r\n"
				+ "</nav>\r\n"
				+ "<!-------------------horizonatal navbar--------------------->\r\n"
				+ "\r\n"
				+ "<!------------------Vertical navbar--------------------->\r\n"
				+ "<div class=\"container-fluid\">\r\n"
				+ "  <div class=\"row\">\r\n"
				+ "    <div class=\"col-lg-2 col-md-3 col-sm-2 bg-light vertical-nav\">\r\n"
				+ "      <h4 class=\"text-info text-center\" style=\"text-decoration:none;\">ADMIN DASHBOARD</h5>\r\n"
				+ "      <div class=\"text-center mt-sm-4\">\r\n"
				+ "        <p><a class=\"text-warning active\" href=\"admin_dashboard\" style=\"text-decoration:none;\">Dashboard</a></p>\r\n"
				+ "        <p><a class=\"text-warning  \" href=\"notfications_admin\" style=\"text-decoration:none;\">Notifications</a></p>\r\n"
				+ "   		<p><a class=\"text-warning  \" href=\"pg_manage\" style=\"text-decoration:none;\">Manage PG</a></p>"
				+ "      </div>\r\n"
				+ "    </div>\r\n"
				+ "    <!------------------Vertical navbar--------------------->\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "    <!------------------Cards--------------------->\r\n"
				+ "    <div class=\"col-lg-10 col-sm-10 col-md-10 clr\">\r\n"
				+ "      <div class=\"my-sm-5\">\r\n"
				+ "        <h1 class=\"display-4 text-info\">ADMIN Dashboard</h1>\r\n"
				+ "        <p class=\"text-warning\">Here you can manage the things...!</p>\r\n"
				+ "      </div>\r\n"
				+ "      <div class=\"row mb-3\">\r\n"
				+ "        <div class=\"col-lg-3 col-sm-6 col-md-3 mb-3\">\r\n"
				+ "          <div class=\"card bg-success text-white\">\r\n"
				+ "            <div class=\"card-body text-white\">\r\n"
				+ "              <div class=\"icon\">\r\n"
				+ "                <i class=\"fa fa-user fa-4x\" style=\"float:right\"></i>\r\n"
				+ "                <span class=\"bi bi-person-fill fa-2x mt-0\"></span>\r\n"
				+ "                <a href='total_owners' style=\"text-decoration:none; color:white\"><h5>Total PG Owners</h5></a>\r\n"
				+ "                <div class=\"\">\r\n"
				+ "                  <h5 class=\"display-4\">"+rs.getString(1)+"</h5>\r\n"
				+ "                </div>\r\n"
				+ "              </div>\r\n"
				+ "            </div>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				
				+ "        <div class=\"col-lg-3 col-sm-6 col-md-3 mb-3\">\r\n"
				+ "          <div class=\"card bg-danger text-white\">\r\n"
				+ "            <div class=\"card-body text-white\">\r\n"
				+ "              <div class=\"icon\">\r\n"
				+ "                <i class=\" fa fa-address-card-o fa-4x\" style=\"float:right\"></i>\r\n"
				+ "                <span class=\"fa fa-address-card-o fa-2x mt-2\"></span>\r\n"
				+ "                <a href='pg_manage' style=\"text-decoration:none; color:white\"><h5 class=\"mt-2\">Total Listed PG</h5></a>\r\n"
				+ "                <div class=\"\">\r\n"
				+ "                  <h5 class=\"display-4\">"+rs2.getString(1)+"</h5>\r\n"
				+ "                </div>\r\n"
				+ "              </div>\r\n"
				+ "            </div>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				
				+ "        <div class=\"col-lg-3 col-sm-6 col-md-3 mb-3\">\r\n"
				+ "          <div class=\"card bg-warning text-white\">\r\n"
				+ "            <div class=\"card-body text-white\">\r\n"
				+ "              <div class=\"icon\">\r\n"
				+ "                <i class=\"bi bi-card-checklist fa-4x\" style=\"float:right\"></i>\r\n"
				+ "                <span class=\"bi bi-card-checklist fa-2x mt-0\"></span>\r\n"
				+ "                <a href='total_states' style=\"text-decoration:none; color:white\"><h5 >Total States</h5></a>\r\n"
				+ "                <div class=\"\">\r\n"
				+ "                  <h5 class=\"display-4\">"+rs3.getString(1)+"</h5>\r\n"
				+ "                </div>\r\n"
				+ "              </div>\r\n"
				+ "            </div>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "        <div class=\"col-lg-3 col-sm-6 col-md-3 mb-3\">\r\n"
				+ "          <div class=\"card bg-info text-white\">\r\n"
				+ "            <div class=\"card-body text-white\">\r\n"
				+ "              <div class=\"icon\">\r\n"
				+ "                <i class=\"bi bi-list fa-4x\" style=\"float:right\"></i>\r\n"
				+ "                <span class=\"bi bi-list fa-2x mt-0\"></span>\r\n"
				+ "                <a href='total_cities' style=\"text-decoration:none; color:white\"><h5>Total Cities</h5></a>\r\n"
				+ "                <div class=\"\">\r\n"
				+ "                  <h5 class=\"display-4\">"+rs4.getString(1)+"</h5>\r\n"
				+ "                </div>\r\n"
				+ "              </div>\r\n"
				+ "            </div>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "        <div class=\"col-lg-3 col-sm-6 col-md-3 mb-3\">\r\n"
				+ "          <div class=\"card bg-secondary text-white\">\r\n"
				+ "            <div class=\"card-body text-white\">\r\n"
				+ "              <div class=\"icon\">\r\n"
				+ "                <i class=\"bi bi-list-task fa-4x\" style=\"float:right\"></i>\r\n"
				+ "                <span class=\"bi bi-list-task fa-2x mt-0\"></span>\r\n"
				+ "                <a href='total_users'  style=\"text-decoration:none; color:white\"><h5>Total Users</h5></a>\r\n"
				+ "                <div class=\"\">\r\n"
				+ "                  <h5 class=\"display-4\">"+rs5.getString(1)+"</h5>\r\n"
				+ "                </div>\r\n"
				+ "              </div>\r\n"
				+ "            </div>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </div><hr class=\"mx-sm-4\">\r\n"
				+ "      <footer class=\"text-center my-0 py-0\">\r\n"
				+ "        <p><small>All Rights Are Reserved</small></p>\r\n"
				+ "        <p><small>Designed & Created By <strong>AMIT BHATIA</strong></small></p>\r\n"
				+ "      </footer> \r\n"
				+ "    </div>\r\n"
				+ "  </div>\r\n"
				+ "</div>\r\n"
				+ "<!--------------Cards------------------------->\r\n"
				+ "\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ " ");
		}
		
		else 
		{
			
			out.println("<h1 style=color:Red;><em>Session Expired...!</em></h1>");
			out.println("<h3>Please Login Again</h3>");
			out.println("<h3>Back to <a href='index.html'>Login Page</a></h3>");
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


//String status = String.valueOf(session.getAttribute("loginstatus"));
//if(status.equals("true")) 
//{
//	out.println("<!DOCTYPE html>\r\n"
//			+ "  <html>\r\n"
//			+ "  <head>\r\n"
//			+ "  	<meta charset=\"utf-8\">\r\n"
//			+ "  	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
//			+ "  	<title></title>\r\n"
//			+ "  	<script src=\"sign_admin.js\"></script>\r\n"
//			+ "  </head>\r\n"
//			+ "  <body>\r\n"
//			+ "  </body>\r\n"
//			+ "  </html>\r\n"
//			+ "");
//	
//}session.setAttribute("loginstatus", false);