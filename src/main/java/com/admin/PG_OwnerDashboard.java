package com.admin;
import java.sql.*;
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
 * Servlet implementation class PG_OwnerDashboard
 */

//select * from add_pg where pg_id in (select pg_id from add_pg where user_id  = ?)
public class PG_OwnerDashboard extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PG_OwnerDashboard() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out= response.getWriter();	
				
		HttpSession owner= request.getSession(false);
		
		try 
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pg","root","");
		PreparedStatement pst= con.prepareStatement("select* from user_table");
	
		
		ResultSet rs= pst.executeQuery();
		
		rs.next();	
	
		
		if(owner!=null) 
		{
		
		String email=String.valueOf(owner.getAttribute("ownername"));
		
		String user_id=String.valueOf(owner.getAttribute("user_id"));
		
		PreparedStatement pst2= con.prepareStatement("select count(pg_id) from add_pg where user_id=?");
		PreparedStatement pst3= con.prepareStatement("select count(*) from book_pg where pg_id in (select pg_id from add_pg where user_id = ?)");
		
		pst2.setString(1, user_id);
		pst3.setString(1, user_id);
		ResultSet rs2= pst2.executeQuery();
		rs2.next();	
		
	    ResultSet rs3 = pst3.executeQuery();
	    int numberOfRows = 0;
	    if (rs3.next()) {
	        numberOfRows = rs3.getInt(1);
	        System.out.println("numberOfRows= " + numberOfRows);
	      } else {
	      }
		
	    System.out.println("number of rows are "+numberOfRows);
		out.println("<!DOCTYPE html>      <!------@created and designed by AMIT BHATIA-------->\r\n"
				+ "<html>\r\n"
				+ "<head>\r\n"
				+ "	<meta charset=\"utf-8\">\r\n"
				+ "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "	<title>PG Owner Dashboard</title>\r\n"
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
				+ "    .card:hover\r\n"
				+ "    {\r\n"
				+ "      transform: scale(1.01);\r\n"
				+ "      box-shadow: 0 10px 20px rgba(0,0,0,.12), 0 4px 8px rgba(0,0,0,.06);\r\n"
				+ "    }\r\n"
				+ "\r\n"
				+ "</style>\r\n"
				+"	<script type=\"text/javascript\">\r\n"
				+ "  	\r\n"
				+ "  	function reset()\r\n"
				+ "		{\r\n"
				+ "		\r\n"
				+ "			document.getElementById(\"form1\").reset();\r\n"
				+ "		}  		\r\n"
				+ "  	\r\n"
				+ "  </script>"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "  <!-------------------horizontal navbar--------------------->\r\n"
				+ "<nav class=\"navbar navbar-expand-lg bg-light navbar-light sticky-top py-0\">\r\n"
				+ "  <a class=\"navbar-brand\" href=\"index.html\" style=\"margin-left:-9px;\"><img src=\"PG home logo.jpg\" alt=\"logo\" width=\"50px\"            height=\"40px\"> Stay Home</a>\r\n"
				+ "\r\n"
				+ "  <button type=\"button\" class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#abc\">\r\n"
				+ "    <span class=\"navbar-toggler-icon\"></span>\r\n"
				+ "  </button>\r\n"
				+ "  \r\n"
				+ "  <div class=\"collapse navbar-collapse\" id=\"abc\">\r\n"
				+ "    <ul class=\"navbar nav ml-auto\">\r\n"
				+ "       <span class='bi bi-person-circle'> " +email+"</span>"
				+ "      <a class=\"nav-link text-dark\" href=\"logout_owner\"> Log out</a>\r\n"
				+ "    </ul>\r\n"
				+ "  </div>\r\n"
				+ "</nav>\r\n"
				+ "<!-------------------horizonatal navbar--------------------->\r\n"
				+ "\r\n"
				+ "<!------------------Vertical navbar--------------------->\r\n"
				+ "<div class=\"container-fluid\">\r\n"
				+ "  <div class=\"row\">\r\n"
				+ "    <div class=\"col-lg-2 col-md-3 col-sm-2 bg-light vertical-nav\">\r\n"
				+ "      <h4 class=\"text-info text-center\">PG OWNER DASHBOARD</h5>\r\n"
				+ "      <div class=\"text-center mt-sm-4\">\r\n"
				+ "        <p><a class=\"text-warning active\" href=\"PG_OwnerDashboard\" style=\"text-decoration:none;\">Dashboard</a></p>\r\n"
				+ "        <p><a class=\"text-warning \"  href=\"addpg_front\" style=\"text-decoration:none;\">Add PG Details</a></p>\r\n"
//				+ "        <p><a class=\"text-warning \" href=\"update_pg_form\" style=\"text-decoration:none;\">Update PG Details</a></p>\r\n"
				+ "        <p><a class=\"text-warning\" href=\"#\"  data-toggle=\"modal\" data-target=\"#change_password\" style=\"text-decoration: none;\">Change Password</a></p>\r\n"
				+ "      </div>\r\n"
				+ "    </div>\r\n"
				+ "    <!------------------Vertical navbar--------------------->\r\n"
				+ "    <!------------------Booking Card--------------------->\r\n"
				+ "    <div class=\"col-lg-10 col-sm-10 col-md-10 clr\">\r\n"
				+ "      <div class=\"my-sm-5\">\r\n"
				+ "        <h1 class=\"display-4 text-info\">PG Owner Dashboard</h1>\r\n"
				+ "        <p class=\"text-warning\">Here you can manage the things...!</p>\r\n"
				+ "      </div>\r\n"
				+ "      <div class=\"row mb-3\">\r\n"
				+ "        <div class=\"col-lg-3 col-sm-6 col-md-3 mb-3\">\r\n"
				+ "          <div class=\"card bg-success text-white\">\r\n"
				+ "            <div class=\"card-body text-white\">\r\n"
				+ "              <div class=\"icon\">\r\n"
				+ "                <i class=\"fa fa-user fa-4x\" style=\"float:right\"></i>\r\n"
				+ "                <span class=\"bi bi-person-fill fa-2x mt-0\"></span>\r\n"
				+ "                <a href=\"owner_pgdetails\" style=\"text-decoration:none; color:white\"><h5>Total Added PG (Details)</h5></a>\r\n"
				+ "                <div class=\"\">\r\n"
				+ "                  <h5 class=\"display-4\">"+rs2.getInt(1)+"</h5>\r\n"
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
				+ "                <a href=\"owner_totalbookings?user_id="+user_id+" \"style=\"text-decoration:none; color:white\"><h5 class=\"mt-2\">Total Bookings</h5></a>\r\n"
				+ "                <div class=\"\">\r\n"
				+ "                  <h5 class=\"display-4\">"+numberOfRows+"</h5>\r\n"
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
				+ "                <a href=\"owner_newbookings?user_id="+user_id+"\" style=\"text-decoration:none; color:white\"><h5 >New Bookings</h5></a>\r\n"
				+ "                <div class=\"\">\r\n"
				+ "                  <h5 class=\"display-4\">"+numberOfRows+"</h5>\r\n"
				+ "                </div>\r\n"
				+ "              </div>\r\n"
				+ "            </div>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "        <div class=\"col-lg-3 col-sm-6 col-md-3 mb-3\">\r\n"
				+ "          <div class=\"card bg-info text-white\">\r\n"
				+ "            <div class=\"card-body text-white\">\r\n"
				+ "              <div class=\"icon\">\r\n"
				+ "                <i class=\"bi bi-app-indicator fa-4x\" style=\"float:right\"></i>\r\n"
				+ "                <span class=\"bi bi-app-indicator fa-2x mt-0\"></span>\r\n"
				+ "                <a href=\"owner_confirmedbookings?user_id="+user_id+"\" style=\"text-decoration:none; color:white\"><h5 >Confirmed Bookings</h5></a>\r\n"
				+ "                <div class=\"\">\r\n"
				+ "                  <h5 class=\"display-4\">"+numberOfRows+"</h5>\r\n"
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
				+ "                <a href=\"#\" style=\"text-decoration:none; color:white\"><h5 >Total PG</h5></a>\r\n"
				+ "                <div class=\"\">\r\n"
				+ "                  <h5 class=\"display-4\">"+rs2.getInt(1)+"</h5>\r\n"
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
				+ "<!--------------Booking Cards------------------------->\r\n"
				+ "\r\n"
				+ "<!-------------------Change Password------------------>\r\n"
				+ "<div class=\"container\">\r\n"
				+ "  <div class=\"row\">\r\n"
				+ "    <div class=\"col-lg-12\">\r\n"
				+ "      <div class=\"modal\" id=\"change_password\">\r\n"
				+ "        <div class=\"modal-dialog\">\r\n"
				+ "          <div class=\"modal-content\">\r\n"
				+ "            <div class=\"modal-header\">\r\n"
				+ "              <h5 class=\"modal-title\">Change Password</h5>\r\n"
				+ "              <button class=\"close\" data-dismiss=\"modal\">&times;</button>\r\n"
				+ "            </div>\r\n"
				+ "            <form action=\"change_password\" method=\"POST\" id=\"form1\" onsubmit=\"change_password()\">\r\n"
				+ "              <div class=\"modal-body\">\r\n"
				+ "                <div class=\"form-group\">\r\n"
				+ "                  <label>Old Password</label>\r\n"
				+ "                  <input type=\"password\" class=\"form-control\" placeholder=\"Old Password\" id=\"oldpassword\" name=\"password\" required>\r\n"
				+ "                </div>\r\n"
				+ "\r\n"
				+ "                <div class=\"form-group\">\r\n"
				+ "                  <label>New Password</label>\r\n"
				+ "                  <input type=\"password\" class=\"form-control\" placeholder=\"New Password\" id=\"newpassword\" name=\"new_password\" required>\r\n"
				+ "                </div>\r\n"
				+ "\r\n"
				+ "                <div class=\"form-group\">\r\n"
				+ "                  <label>Confirm Password</label>\r\n"
				+ "                  <input type=\"password\" class=\"form-control\" placeholder=\"confirm Password\" id=\"cpassword\"  name=\"cpassword\"required>\r\n"
				+ "                </div>\r\n"
				+ "                </div>\r\n"
				+ "                <div class=\"modal-footer\">\r\n"
				+ " 				<input type=\"reset\" class=\"btn btn-secondary\"  id=\"reset\" value=\"Reset\">\r\n"
                + "					<input type =\"submit\" class=\"btn btn-success\" id=\"change\" onclick=\"\" value=\"Change Password\"?email="+rs.getString(5)+">\r\n"
//				+ "                  <button class=\"btn btn-secondary\" id=\"\">Reset</button>\r\n"
//				+ "                  <button class=\"btn btn-success\" id=\"\">Change Password</button>\r\n"
				+ "                </div>\r\n"
				+ "              </div>\r\n"
				+ "            </form>\r\n"
				+ "          </div>\r\n"
				+ "        </div>\r\n"
				+ "      </div>\r\n"
				+ "    </div>\r\n"
				+ "  </div>\r\n"
				+ "</div>\r\n"
				+ "\r\n"
				+ "<!-------------------Change Password------------------>\r\n"
				+ "</body>\r\n"
				+ "</html>\r\n"
				+ " ");
	}else 
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
