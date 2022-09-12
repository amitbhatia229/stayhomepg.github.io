package com.pgproject;
import java.sql.*;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class user_page
 */
public class user_page extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public user_page() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			
			HttpSession session2=request.getSession(false);
		
			try 
			{
				Class.forName("com.mysql.jdbc.Driver");
				
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/pg","root","");
				
				PreparedStatement pst= con.prepareStatement("select*from add_pg");	
				
				ResultSet rs= pst.executeQuery();
				if(session2!=null)
				{
				
					String email=String.valueOf(session2.getAttribute("username"));
					String user_id=String.valueOf(session2.getAttribute("user_id"));
					
				out.println("<!DOCTYPE html>   <!------@created and designed by AMIT BHATIA-------->\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "	<meta charset=\"utf-8\">\r\n"
						+ "	<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
						+ "	<title>User_Page</title>\r\n"
						+ "	<link rel=\"icon\" href=\"PG home logo.jpg\">\r\n"
						+ "	<link rel=\"stylesheet\" type=\"text/css\" href=\"bootstrap-4.6.1-dist\\css\\bootstrap.min.css\">\r\n"
						+ "	<link rel=\"stylesheet\" href=\"font-awesome-4.7.0\\css\\font-awesome.min.css\">\r\n"
						+ "	<link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css\"> <!----bootstrap icons---->\r\n"
						+ "	<script src=\"https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js\"></script>\r\n"
						+ "  	<script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n"
						+ "  	<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
						+ "  	\r\n"
						+ "  	<script type=\"text/javascript\">\r\n"
						+ " \r\n"
						+ "  	</script>\r\n"
						+ "  	<style>\r\n"
						+ "  		.services{\r\n"
						+ "\r\n"
						+ " 			text-align: center;\r\n"
						+ " 			padding-top: 10px;\r\n"
						+ " 			font-family: cursive;\r\n"
						+ " 		}\r\n"
						+ "\r\n"
						+ "  		.image\r\n"
						+ "  		{\r\n"
						+ "  			background-image: url(contact2.jpg);\r\n"
						+ "  			background-position: center;\r\n"
						+ "  			height: 400px;\r\n"
						+ "  			border-radius: 5px;\r\n"
						+ "  			filter: blur(1.5px);\r\n"
						+ "  		}\r\n"
						+ "\r\n"
						+ "  		.clr{\r\n"
						+ "  			background-color: #f5f5f5;\r\n"
						+ "  		}\r\n"
						+ "\r\n"
						+ "  		.card{\r\n"
						+ "  			height:100%\r\n"
						+ "  		}\r\n"
						+ "\r\n"
						+ "  		.touch{\r\n"
						+ "\r\n"
						+ "  			position: relative;\r\n"
						+ "  			top: -120px;\r\n"
						+ "  			height: 750px;\r\n"
						+ "  			}\r\n"
						+ "  			\r\n"
						+ "		.c{\r\n"
						+ "  				padding-top: 25px;\r\n"
						+ "  			}\r\n"
						+ "  			.card:hover\r\n"
						+ " 		{\r\n"
						+ "     		transform: scale(1.01);\r\n"
						+ "  			box-shadow: 0 10px 20px rgba(0,0,0,.12), 0 4px 8px rgba(0,0,0,.06);\r\n"
						+ "  		}\r\n"
						+ "\r\n"
						+ "  		.offer{\r\n"
						+ "  			text-align: center;\r\n"
						+ "  		}\r\n"
						+ "\r\n"
						+ "  	</style>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "\r\n"
						+ "<!--------------------Navigation Bar-------------->\r\n"
						+ "\r\n"
						+ "<div class=\"container-fluid\" style=\"height: 50px;\">\r\n"
						+ "	<p class=\"text-danger\">\r\n"
						+ "		<marquee scrollamount=\"12\" style=\"padding: 10px;\">\r\n"
						+ "		You can also Book PG from our Website.</marquee>\r\n"
						+ "	</p>	\r\n"
						+ "</div>\r\n"
						+ "\r\n"
						+ "<nav class=\"navbar navbar-expand-lg bg-light navbar-light sticky-top\">\r\n"
						+ "	<a class=\"navbar-brand\" href=\"#\" style=\"margin-left:-9px;\"><img src=\"PG home logo.jpg\" alt=\"logo\" width=\"50px\" height=\"40px\"> Stay Home\r\n"
						+ "	</a>\r\n"
						+ "     \r\n"
						+ "	<form action=\"user_search\" method=\"POST\">\r\n"
						+ "		<div class=\"form-inline mr-auto\">     <!-------.input-sm-2 for resize the search box-------->\r\n"
						+ "			<input type=\"search\" class=\"form-control mr-sm-2\" placeholder=\"    search PG here...\" name=\"search\" id=\"search\">\r\n"
						+ "			<!-- <button type=\"submit\" class=\"btn btn-warning\">search</button> --->\r\n"
						+ "			<input type =\"submit\" class=\"btn btn-warning\" value=\"Submit\" onclick=\"searching()\">\r\n"
						+ "		</div>\r\n"
						+ "	</form>"
						+ "\r\n"
						+ "	<button type=\"button\"class=\"navbar-toggler mr-sm-1\" data-toggle=\"collapse\" data-target=\"#abc\">\r\n"
						+ "		<span class=\"navbar-toggler-icon\"></span>\r\n"
						+ "	</button>\r\n"
						+ "\r\n"
						+ "	<div class=\"collapse navbar-collapse\" id=\"abc\">\r\n"
						+ "		<ul class=\"navbar-nav ml-auto mr-sm-3\">\r\n"
						+ "			<!-- <li class=\"nav-item  \"><a class=\"nav-link\" href=\"Home_Tab.html\"><span class=\"bi bi-house-door\"></span> Home</a></li> -->\r\n"
						+ "\r\n"
						+ "			<li class=\"nav-item active\"><a class=\"nav-link\" href=\"user_page\"><span class=\"bi bi-building\"></span> Book Now</a></li>\r\n"
						+ "\r\n"
						+ "			<li class=\"nav-item dropdown\"><a class=\"nav-link dropdown-toggle\" href=\"#\" data-toggle=\"dropdown\"><span class=\"bi bi-geo-alt\"></span> Locations</a>\r\n"
						+ "					<ul class=\"dropdown-menu\">\r\n"
						+ "						<div class=\"dropdown-header\">Himachal Pradesh</div>\r\n"
						+ "						   <a class=\"dropdown-item\" href=\"Shimla_location\">Shimla</a>\r\n"
						+ "						   <a class=\"dropdown-item disabled\">Hamirpur (Coming Soon)</a>\r\n"
						+ "						   <a class=\"dropdown-item disabled\">Kangra (Coming Soon)</a>\r\n"
						+ "						<div class=\"dropdown-divider\"></div>\r\n"
						+ "							<div class=\"dropdown-header\">Other Cities/States </div>\r\n"
						+ "							<a class=\"dropdown-item\" href=\"gurgaon_location\">Gurgaon</a>\r\n"
						+ "							<a class=\"dropdown-item\" href=\"Chandigarh_location\">Chandigarh</a>\r\n"
						+ "							<a class=\"dropdown-item disabled\">Noida (Coming Soon)</a>\r\n"
						+ "							<a class=\"dropdown-item disabled\">New Delhi (Coming Soon)</a>\r\n"
						+ "					</ul>"
						+ "			</li>\r\n"
						+ "			\r\n"
						+ "			<li class=\"nav-item dropdown\"><a class=\"nav-link dropdown-toggle\" href=\"#\" data-toggle=\"dropdown\" style=\"\"><span class= \"bi bi-pencil-square\"></span> Manage</a>\r\n"
						+ "					<ul class=\"dropdown-menu\">\r\n"
						+ "						<a class=\"dropdown-item\" href=\"user_booking_manage\">Manage Booking</a>\r\n"
						+ "						<a class=\"dropdown-item\" href=\"#\" data-toggle=\"modal\" data-target=\"#change_password\" style=\"text-decoration:none;\">Change Password</a>\r\n"
						+ "						<a href=\"delete_user\" class=\"dropdown-item\">Delete Account</a>\r\n"
						+ "					</ul>\r\n"
						+ "			</li>\r\n"
						+ "		</ul>\r\n"
						+ "\r\n"
						+ "		<div>\r\n"
						+ "			<!-- <button class=\"btn btn-success\" data-toggle=\"modal\" data-target=\"#signin\">Sign in</button>\r\n"
						+ "			<button class=\"btn btn-danger\" data-toggle=\"modal\" data-target=\"#signup\">Sign up</button> -->\r\n"
						+ "\r\n"
						+ "           <span class='bi bi-person-circle'> " +email+"</span>"
						+ "			<a href=\"logout_user\" class=\"text-danger\" class=\"btn btn-danger\" style=\"text-decoration:none;\">Sign Out</a>\r\n"
						+ "		</div>\r\n"
						+ "	</div>\r\n"
						+ "\r\n"
						+ "</nav><br>\r\n"
						+ "<!--------------------Navigation Bar-------------->\r\n"
						+ "<!--------------------contact-banner-------------->\r\n"
						+ "\r\n"
						+ "<div class=\"container-fluid\">\r\n"
						+ "	<div class=\"image\">\r\n"
						+ "		<h1 class=\"text-center text-light\"style=\"padding-top: 10%; font-family:cursive; font-size:65px;\">Book PG</h1>\r\n"
						+ "	</div>\r\n"
						+ "</div><br>\r\n"
						+ "<!--------------------contact-banner-------------->\r\n"
						+ "\r\n"
						+ "\r\n"
						+"<!----------------our services heading------------------>\r\n"
						+ "<div class=\"clr\">\r\n"
						+ "<div class=\"container-fluid\" style=\"height: 100px; width: 100%;\">\r\n"
						+ "	<div class=\"row\">\r\n"
						+ "		<div class=\"col-lg-12 col-sm-12\">\r\n"
						+ "			<div class=\"services\">\r\n"
						+ "				<h1 class=\"text-primary\">You can Book Your PG from Here.</h1>\r\n"
						+ "				<p class=\"text-dark\" style=\"margin-top:20px;\">ACROSS THE STREET FROM THE ORDINARY</p>\r\n"
						+ "			</div>\r\n"
						+ "		</div>\r\n"
						+ "	</div>\r\n"
						+ "</div><br>\r\n"
						+ "\r\n"
						+ "<!----------------our services heading------------------>\r\n"
						+ "\r\n"
						+ "\r\n");
				out.println( "<div class=\"container\">\r\n");
				int colsInRow = 3;
				
				int pgCount = 0;
				while(rs.next())
				{
		out.println("<!----------------card---------------------------->\r\n");
					
				if(pgCount%colsInRow == 0) {
					out.println("	<div class=\"row\" id=\"car\" >\r\n");
				} 
				out.println(
					"		<div class=\"col-lg-4 col-sm-4\">\r\n"
					+ "			<div class=\"card\">\r\n"
					+ "				<img class=\"card-img-top\" src=\"bedroom3.jpg\" alt=\"image1\">\r\n"
					+ "				<div class=\"card-body\">\r\n"
					+ "					<h4 class=\"card-title\" align=\"center\">"+rs.getString(2)+"</h4>\r\n"
					+ "					<p class=\"card-text\">"+rs.getString(2)+" offers you the best co-living or Single room PG for boys at a minimum cost price, they offers you the best quality of food, and all other necessities.\r\n"
					+ "					</p>\r\n"
					+ "					<span class =\"text-danger\" style=\"font-size: 17px;\">Rs <strong> "+rs.getString(8)+"/- </strong><small><del> Rs 8000/-</del></small></span>\r\n"
					+ "					<a class=\"btn btn-primary float-right\" href=\"booking?pg_id="+rs.getString(1)+"\" >Book Now</a>\r\n"
					+ "				</div>\r\n"
					+ "			</div>\r\n"
					+ "			</div>\r\n"
					);
				
		         pgCount++;
		         if(pgCount%colsInRow == 0) {
						out.println("</div>\r\n<br>");
			     } 
				}
				
				if(pgCount%colsInRow != 0) {
						out.println("</div>\r\n<br>");
			     } 
				
				
				
				out.println("</div>\r\n<br>");
				out.println("</div>\r\n<br>");
				
					/*while(rs.next())
					{
			out.println("<!----------------card---------------------------->\r\n"
						
						+ "	<div class=\"row\" id=\"car\" >\r\n"
						+ "		<div class=\"col-lg-4 col-sm-4\">\r\n"
						+ "			<div class=\"card\">\r\n"
						+ "				<img class=\"card-img-top\" src=\"bedroom3.jpg\" alt=\"image1\">\r\n"
						+ "				<div class=\"card-body\">\r\n"
						+ "					<h4 class=\"card-title\" align=\"center\">"+rs.getString(2)+"</h4>\r\n"
						+ "					<p class=\"card-text\">"+rs.getString(2)+" offers you the best co-living or Single room PG for boys at a minimum cost price, they offers you the best quality of food, and all other necessities.\r\n"
						+ "					</p>\r\n"
						+ "					<span class =\"text-danger\" style=\"font-size: 17px;\">Rs <strong> "+rs.getString(8)+"/- </strong><small><del> Rs 8000/-</del></small></span>\r\n"
						+ "					<a class=\"btn btn-primary float-right\" href=\"booking?pg_id="+rs.getString(1)+"\" >Book Now</a>\r\n"
						+ "				</div>\r\n"
						+ "			</div>\r\n"
						+ "		</div>\r\n"
						+ "		<div class=\"col-lg-4 col-sm-4\">\r\n"
						+ "			<div class=\"card\">\r\n"
						+ "				<img class=\"card-img-top\" src=\"hall1.jpg\" alt=\"image2\">\r\n"
						+ "				<div class=\"card-body\">\r\n"
						+ "					<h4 class=\"card-title\" align=\"center\">"+rs.getString(2)+"</h4>\r\n"
						+ "					<p class=\"card-text\">"+rs.getString(2)+"offers you the single and double sharing room for boys and girls separately, they offers you the amenities like food, almirah and all others household things.\r\n"
						+ "					</p>\r\n"
						+ "					<span class =\"text-danger\" style=\"font-size: 17px;\">Rs <strong> "+rs.getString(8)+"/- </strong><small><del> Rs 9000/-</del></small></span>\r\n"
						+ "					<a href=\"booking\" class=\"btn btn-primary float-right\">Book Now</a>\r\n"
						+ "				</div>\r\n"
						+ "			</div>\r\n"
						+ "		</div>\r\n"
						+ "		<div class=\"col-lg-4 col-sm-4\">\r\n"
						+ "			<div class=\"card\">\r\n"
						+ "				<img class=\"card-img-top\" src=\"bedroom4.jpg\" alt=\"image2\">\r\n"
						+ "				<div class=\"card-body\">\r\n"
						+ "					<h4 class=\"card-title\" align=\"center\">"+rs.getString(2)+"</h4>\r\n"
						+ "					<p class=\"card-text\"> "+rs.getString(2)+" is the girls pg, which provides girls single, double and triple sharing rooms, they offers you the all basic necessities.\r\n"
						+ "					</p>\r\n"
						+ "					<span class =\"text-danger\" style=\"font-size: 17px;\">Rs <strong> "+rs.getString(8)+"/- </strong><small><del> Rs 8000/-</del></small></span>\r\n"
						+ "					<a href=\"booking\" class=\"btn btn-primary float-right\">Book Now</a>\r\n"
						+ "				</div>\r\n"
						+ "			</div>\r\n"
						+ "		</div>\r\n"
						+ "</div>\r\n"
						+"</div><br>\r\n"
						+ "\r\n"
						+ "<!----------------card---------------------------->\r\n"
						+ "\r\n");
					}*/
	
			out.println("<!----------------footer content------------------->\r\n"
						+ "<footer>\r\n"
						+ "	<div class=\"container-fluid bg-warning text-light mx-auto py-3\">\r\n"
						+ "		<div class=\"row\">\r\n"
						+ "			<div class=\"col-lg-12 col-sm-12\">\r\n"
						+ "				<div class=\"services\">\r\n"
						+ "					<h5 style=\"text-align: center;\">Get connected with us on social networks!</h5>\r\n"
						+ "				</div>\r\n"
						+ "			</div>\r\n"
						+ "		</div>\r\n"
						+ "	</div>\r\n"
						+ "		<div class=\"clr\"><br>\r\n"
						+ "		<div class=\"container mt-4\" style=\"text-align: center;\">\r\n"
						+ "			<div class=\"row\">\r\n"
						+ "				<div class=\"col-lg-4 col-sm-4\">\r\n"
						+ "					<h5> Our Locations</h5>\r\n"
						+ "					<div id=\"link\">\r\n"
						+ "					<p class=\"mt-3\"><a href=\"#\" class=\"text-warning\" style=\"text-decoration: none;\">Shimla</a></p>\r\n"
						+ "					<p><a href=\"#\" class=\"text-warning\" style=\"text-decoration: none;\">New Delhi</a></p>\r\n"
						+ "					<p><a href=\"#\" class=\"text-warning\"style=\"text-decoration: none;\">Gurugram</a></p>\r\n"
						+ "					<p><a href=\"#\" class=\"text-warning\"style=\"text-decoration: none;\">Noida</a></p>	\r\n"
						+ "					</div>	\r\n"
						+ "			</div>\r\n"
						+ "			<div class=\"col-lg-4 col-sm-4\">\r\n"
						+ "					<h5> Quick Links</h5>\r\n"
						+ "					<p class=\"mt-3\"><a href=\"contact_tab.html\" class=\"text-warning\" style=\"text-decoration: none;\">Complaints</a></p>\r\n"
						+ "					<p><a href=\"privacyPolicy.html\" class=\"text-warning\" style=\"text-decoration: none;\">Privacy Policy</a></p>\r\n"
						+ "					<p><a href=\"aboutus.html\" class=\"text-warning\" style=\"text-decoration: none;\">About Us</a></p>\r\n"
						+ "					<p><a href=\"contact_tab.html\" class=\"text-warning\" style=\"text-decoration: none;\">Contact Us</a></p>		\r\n"
						+ "			</div>\r\n"
						+ "			<div class=\"col-lg-4 col-sm-4\">\r\n"
						+ "					<h5> Follow us on!</h5>\r\n"
						+ "					<address class=\"pt-sm-3 text-warning\"><span class=\"fa fa-map-marker\" style=\"color: black;\"></span>\r\n"
						+ "						&nbsp;House no.: 123\r\n"
						+ "						Sector:15,\r\n"
						+ "						Near jharsa Chowk<br>\r\n"
						+ "						Gurugram, Haryana.<br> \r\n"
						+ "						122001\r\n"
						+ "					</address>\r\n"
						+ "					<p class=\"d-inline-block\">\r\n"
						+ "						<a href=\"https://twitter.com/amitbhatia229\" target=\"_blank\"><span class=\"fa fa-twitter fa-lg\"></span></a>&nbsp;&nbsp;\r\n"
						+ "						<a href=\"https://fb.com/amitbhatia229\" target=\"_blank\"><span class=\"fa fa-facebook fa-lg\"></span></a>&nbsp;&nbsp;\r\n"
						+ "						<a href=\"https://wa.me/7018464412\"target=\"_blank\"><span class=\"fa fa-whatsapp fa-lg\"></span></a>&nbsp;&nbsp;\r\n"
						+ "						<a href=\"https://instagram.com/i_amit_bhatia\" target=\"_blank\"><span class=\"fa fa-instagram fa-lg\"></span></a>&nbsp;&nbsp;\r\n"
						+ "						<a href=\"mailto:amitbhatia.hpushimla@gmail.com\"target=\"_blank\"><span class=\"fa fa-envelope-o fa-lg\"></span></a>&nbsp;&nbsp;\r\n"
						+ "						<a href=\"https://telegram.me/ab_hpu\" target=\"_blank\"><span class=\"fa fa-telegram fa-lg\"></span></a>&nbsp;&nbsp;\r\n"
						+ "						\r\n"
						+ "					</p>\r\n"
						+ "			</div>\r\n"
						+ "		</div>\r\n"
						+ "	</div>\r\n"
						+ "</div>\r\n"
						+ "<div class=\"clr\">\r\n"
						+ "	<div class=\"row mx-auto py-sm-3\" style=\"text-align:center; font-family: sans-serif;\">\r\n"
						+ "		<div class=\"col-lg-12 col-sm-12\">\r\n"
						+ "			<h6 ><small>Copyright &copy; 2022. All rights are reserved.</small></h6>\r\n"
						+ "			<p><small>This website is designed &amp; created by<strong> AMIT BHATIA</strong>.</small></p>\r\n"
						+ "			<p align=\"right\" class=\"my-sm-0 text-warning\"> <small>**Pictures are used only for the pictorial representations.</small></p>\r\n"
						+ "		</div>\r\n"
						+ "	</div>\r\n"
						+ "</div>\r\n"
						+ "</footer>\r\n"
						+ "<!----------------footer content------------------->\r\n"
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
						+ "            <form action=\"user_password\" method=\"POST\">\r\n"
						+ "              <div class=\"modal-body\">\r\n"
						+ "                <div class=\"form-group\">\r\n"
						+ "                  <label>Old Password</label>\r\n"
						+ "                  <input type=\"password\" class=\"form-control\" placeholder=\"Old Password\" name=\"password\">\r\n"
						+ "                </div>\r\n"
						+ "\r\n"
						+ "                <div class=\"form-group\">\r\n"
						+ "                  <label>New Password</label>\r\n"
						+ "                  <input type=\"password\" class=\"form-control\" placeholder=\"New Password\" name=\"new_password\">\r\n"
						+ "                </div>\r\n"
						+ "\r\n"
						+ "                <div class=\"form-group\">\r\n"
						+ "                  <label>Confirm Password</label>\r\n"
						+ "                  <input type=\"password\" class=\"form-control\" placeholder=\"confirm Password\" name=\"cpassword\">\r\n"
						+ "                </div>\r\n"
						+ "                </div>\r\n"
						+ "                <div class=\"modal-footer\">\r\n"
						+ "\r\n"
						+ "                  <input type=\"reset\" class=\"btn btn-secondary\" value=\"Reset\" onclick=\"reset()\">\r\n"
						+ "                  <input type=\"submit\" class=\"btn btn-success\" value=\"Change Password\" onclick=\"change()\">\r\n"
						+ "                 <!--  <button class=\"btn btn-secondary\" id=\"\">Reset</button>\r\n"
						+ "                  <button class=\"btn btn-success\" id=\"\">Change Password</button> -->\r\n"
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
						+ "<!-------------------Change Password------------------>\r\n");
						
			out.println("</body>\r\n"
						+ "</html>");
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
				out.println("<h3 align='center'class='text-danger'><em>Connection is not established with the database...please try after some time</em></h3>");
				
				
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
