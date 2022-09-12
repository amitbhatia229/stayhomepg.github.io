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
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Servlet implementation class update_pg_form
 */
public class update_pg_form extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public update_pg_form() {
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
		
		PreparedStatement pst= con.prepareStatement("select * from add_pg");
		
		ResultSet rs=pst.executeQuery();
	
		rs.next();
	
		if(owner!=null)
			
		{
		String email=String.valueOf(owner.getAttribute("ownername"));
		
		out.println("<!DOCTYPE html>     <!------@created and designed by AMIT BHATIA-------->\r\n"
						+ "<html>\r\n"
						+ "<head>\r\n"
						+ "  <meta charset=\"utf-8\">\r\n"
						+ "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
						+ "  <title>PG_Details</title>\r\n"
						+ "  <link rel=\"icon\" href=\"PG home logo.jpg\">\r\n"
						+ "  <link rel=\"stylesheet\" href=\"bootstrap-4.6.1-dist\\css\\bootstrap.min.css\">\r\n"
						+ "  <link rel=\"stylesheet\" href=\"font-awesome-4.7.0\\css\\font-awesome.min.css\">\r\n"
						+ "  <link rel=\"stylesheet\" href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.8.3/font/bootstrap-icons.css\">\r\n"
						+ "  <script src=\"https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js\"></script>\r\n"
						+ "    <script src=\"https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js\"></script>\r\n"
						+ "    <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js\"></script>\r\n"
						+ "    \r\n"
						+ "    \r\n"
						+ "    <script  type=\"text/javascript\">\r\n"
						+ "    \r\n"
						+ "    \r\n"
						+ "    function reset(){\r\n"
						+ "    	\r\n"
						+ "    	document.getElementById(\"form\").reset();\r\n"
						+ "    }\r\n"
						+ "    \r\n"
						+ "    </script>\r\n"
						+ "    \r\n"
						+ "    <style type=\"text/css\">\r\n"
						+ "      .clr\r\n"
						+ "      {\r\n"
						+ "        background-color: #f5f5f5;\r\n"
						+ "      }\r\n"
						+ "      \r\n"
						+ "    .vertical-nav \r\n"
						+ "    {\r\n"
						+ "      padding-top: 50px;\r\n"
						+ "      width: 100%;\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "    }\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "\r\n"
						+ "</style>\r\n"
						+ "</head>\r\n"
						+ "<body>\r\n"
						+ "<!-------------------horizontal navbar--------------------->\r\n"
						+ "<nav class=\"navbar navbar-expand-lg bg-light navbar-light sticky-top py-0\">\r\n"
						+ "  <a class=\"navbar-brand\" href=\"Home_Tab.html\" style=\"margin-left:-9px;\"><img src=\"PG home logo.jpg\" alt=\"logo\" width=\"50px\" height=\"40px\"> Stay Home</a>\r\n"
						+ "\r\n"
						+ "  <button type=\"button\" class=\"navbar-toggler\" data-toggle=\"collapse\" data-target=\"#abc\">\r\n"
						+ "    <span class=\"navbar-toggler-icon\"></span>\r\n"
						+ "  </button>\r\n"
						+ "  \r\n"
						+ "  <div class=\"collapse navbar-collapse\" id=\"abc\">\r\n"
						+ "    <ul class=\"navbar nav ml-auto\">\r\n"
						+ "      <li class=\"nav-item\"><a class=\"nav-link text-dark\" href=\"#\"><span class=\"bi bi-person-circle\">"+email+"</span></a></li>\r\n"
						+ "    </ul>\r\n"
						+ "  </div>\r\n"
						+ "</nav>\r\n"
						+ "<!-------------------horizonatal navbar--------------------->\r\n"
						+ "\r\n"
						+ "<!-------------------vertical navbar--------------------->\r\n"
						+ "<div class=\"container-fluid\">\r\n"
						+ "  <div class=\"row\">\r\n"
						+ "    <div class=\"col-lg-2 col-md-3 col-sm-2 bg-light vertical-nav\">\r\n"
						+ "      <h4 class=\"text-info text-center\">PG OWNER DASHBOARD</h4>\r\n"
						+ "      <div class=\"text-center mt-sm-4\">\r\n"
						+ "        <p><a class=\"text-warning\" href=\"PG_OwnerDashboard\">Dashboard</a></p>\r\n"
						+ "        <p><a class=\"text-warning\"  href=\"addpg_front\">Add PG Details</a></p>\r\n"
						+ "        <p><a class=\"text-warning active\" href=\"update_pg_form\">Update PG Details</a></p>\r\n"
						+ "        <p><a class=\"text-warning\" href=\"#\" data-toggle=\"modal\" data-target=\"#change_password\">Change Password</a></p>\r\n"
						+ "      </div>\r\n"
						+ "    </div>\r\n"
						+ "    <!--------------vertical-navbar------------------------->\r\n"
						+ "\r\n"
						+ "    <!--------------------------Add PG Details Content---------------->\r\n"
						+ "    <div class=\"col-lg-10 col-md-10 col-sm-10 clr\">\r\n"
						+ "\r\n"
						+ "      <div class=\"text-center text-info\">\r\n"
						+ "        <h3 style=\"padding-top:60px;\">Update PG Details</h3>\r\n"
						+ "      </div>\r\n"
						+ "      <form action=\"update_pg\" method=\"POST\" id=\"form\">\r\n"
						+ "      <div class=\"row mt-5\" style=\"justify-content: safe center;\">\r\n"
						+ "        <div class=\"col-lg-4 col-sm-4 col-md-4 mx-5\">\r\n"
						+ "          <div class=\"form-group\">\r\n"
						+ "            <label>PG Name</label>\r\n"
						+ "            <input type=\"text\" class=\"form-control\" placeholder=\"PG name\" id=\"\" name=\"pg_name\" required>\r\n"
						+ "          </div>\r\n"
						+ "\r\n"
						+ "          <div class=\"form-group\">\r\n"
						+ "            <label>Select State</label>\r\n"
						+ "            <select id=\"type\" class=\"form-control\" name=\"state\" required>\r\n"
						+ "              <option value=\"Himachal\">Himachal</option>\r\n"
						+ "              <option value=\"Haryana\">Haryana</option>\r\n"
						+ "              <option value=\"Chandigarh\">Chandigarh</option>\r\n"
						+ "            </select>   \r\n"
						+ "          </div>\r\n"
						+ "\r\n"
						+ "          <div class=\"form-group\">\r\n"
						+ "            <label>No. of Rooms</label>\r\n"
						+ "            <input type=\"number\" class=\"form-control\" placeholder=\"Rooms\" id=\"\" name=\"rooms\" required>\r\n"
						+ "          </div>\r\n"
						+ "\r\n"
						+ "          <div class=\"form-group\">\r\n"
						+ "            <label>Room Rent</label><br>\r\n"
						+ "            <input type=\"text\" class=\"form-control\" placeholder=\"Enter Rent\"  name=\"rent\" required>\r\n"
						+ "          </div>\r\n"
						+ "        \r\n"
						+ "          \r\n"
						+ "        </div>\r\n"
						+ "        <div class=\"col-lg-4 col-sm-4 col-md-4 mx-5\">\r\n"
						+ "          \r\n"
						+ "          <div class=\"form-group\">\r\n"
						+ "            <label>Type of PG</label>\r\n"
						+ "            <select id=\"type\" class=\"form-control\" name=\"type\" required>\r\n"
						+ "              <option value=\"Boys\">Boys</option>\r\n"
						+ "              <option value=\"Girls\">Girls</option>\r\n"
						+ "              <option value=\"Both\">Both</option>\r\n"
						+ "            </select>\r\n"
						+ "          </div>\r\n"
						+ "\r\n"
						+ "          <div class=\"form-group\">\r\n"
						+ "            <label>Select City</label>\r\n"
						+ "            <select id=\"type\" class=\"form-control\" name=\"city\" required>\r\n"
						+ "              <option value=\"Shimla\">Shimla</option>\r\n"
						+ "              <option value=\"Chandigarh\">Chandigarh</option>\r\n"
						+ "              <option value=\"Gurgaon\">Gurgaon</option>\r\n"
						+ "            </select>\r\n"
						+ "          </div>\r\n"
						+ "\r\n"
						+ "          <div class=\"form-group\">\r\n"
						+ "            <label>Address</label><br>\r\n"
						+ "            <textarea rows=\"1\" placeholder=\"Address\" class=\"form-control\" name=\"address\" required></textarea>\r\n"
						+ "          </div>\r\n"
						+ "\r\n"
						+ "          <div class=\"form-group\">\r\n"
						+ "            <label>Upload Image</label>\r\n"
						+ "            <input type=\"file\" class=\"form-control-file\" id=\"\" name=\"image\">\r\n"
						+ "            <button class=\"btn btn-secondary my-2 btn-sm\" value=\"upload\">Upload</button>\r\n"
						+ "          </div>\r\n"
						+ "          \r\n"
						+ "        </div>  \r\n"
						+ "        </div><hr class=\"mx-sm-4\">\r\n"
						+ "        \r\n"
						+ "        <div class=\"row\">\r\n"
						+ "          <div class=\"mx-sm-5\">\r\n"
						+ "            <h5 class=\"text-info\">Amenities Offered:-</h5>\r\n"
						+ "          </div>\r\n"
						+ "\r\n"
						+ "          <div class=\"container\">\r\n"
						+ "            <div class=\"row mx-sm-5 px-sm-2\">\r\n"
						+ "              <div class=\"col-lg-12 col-sm-12 col-md-12\">\r\n"
						+ "                <table class=\"table table-borderless\">\r\n"
						+ "                  <tbody>\r\n"
						+ "                    <tr>\r\n"
						+ "                      <td>Electricity:-</td>\r\n"
						+ "                      <td class=\"form-check form-check-inline\">\r\n"
						+ "                        <input class=\"form-check-input\" type=\"radio\" id=\"\" value=\"yes\" name=\"electricity\">\r\n"
						+ "                        <label class=\"form-check-label\" for=\"\">Yes</label>\r\n"
						+ "                      </td>\r\n"
						+ "                      <td class=\"form-check form-check-inline\">\r\n"
						+ "                        <input class=\"form-check-input\" type=\"radio\" id=\"\" value=\"no\" name=\"electricity\">\r\n"
						+ "                        <label class=\"form-check-label\" for=\"\">No</label>\r\n"
						+ "                      </td>\r\n"
						+ "                    </tr>\r\n"
						+ "                    <tr>\r\n"
						+ "                      <td>Wi-fi:-</td>\r\n"
						+ "                      <td class=\"form-check form-check-inline\">\r\n"
						+ "                        <input class=\"form-check-input\" type=\"radio\" id=\"\" value=\"yes\" name=\"wi_fi\">\r\n"
						+ "                        <label class=\"form-check-label\" for=\"\">Yes</label>\r\n"
						+ "                      </td>\r\n"
						+ "                      <td class=\"form-check form-check-inline\">\r\n"
						+ "                        <input class=\"form-check-input\" type=\"radio\" id=\"\" value=\"no\" name=\"wi_fi\">\r\n"
						+ "                        <label class=\"form-check-label\" for=\"\">No</label>\r\n"
						+ "                      </td>\r\n"
						+ "                    </tr>\r\n"
						+ "                    <tr>\r\n"
						+ "                      <td>Power-Backup:-</td>\r\n"
						+ "                      <td class=\"form-check form-check-inline\">\r\n"
						+ "                        <input class=\"form-check-input\" type=\"radio\" id=\"\" value=\"yes\" name=\"power\">\r\n"
						+ "                        <label class=\"form-check-label\" for=\"\">Yes</label>\r\n"
						+ "                      </td>\r\n"
						+ "                      <td class=\"form-check form-check-inline\">\r\n"
						+ "                        <input class=\"form-check-input\" type=\"radio\" id=\"\" value=\"no\" name=\"power\">\r\n"
						+ "                        <label class=\"form-check-label\" for=\"\">No</label>\r\n"
						+ "                      </td>\r\n"
						+ "                    </tr>\r\n"
						+ "                    <tr>\r\n"
						+ "                      <td>Television</td>\r\n"
						+ "                      <td class=\"form-check form-check-inline\">\r\n"
						+ "                        <input class=\"form-check-input\" type=\"radio\" id=\"\" value=\"yes\" name=\"tv\">\r\n"
						+ "                        <label class=\"form-check-label\" for=\"\">Yes</label>\r\n"
						+ "                      </td>\r\n"
						+ "                      <td class=\"form-check form-check-inline\">\r\n"
						+ "                        <input class=\"form-check-input\" type=\"radio\" id=\"\" value=\"no\" name=\"tv\">\r\n"
						+ "                        <label class=\"form-check-label\" for=\"\">No</label>\r\n"
						+ "                      </td>\r\n"
						+ "                    </tr>\r\n"
						+ "                    <tr>\r\n"
						+ "                      <td>Security</td>\r\n"
						+ "                      <td class=\"form-check form-check-inline\">\r\n"
						+ "                        <input class=\"form-check-input\" type=\"radio\" id=\"\" value=\"yes\" name=\"security\">\r\n"
						+ "                        <label class=\"form-check-label\" for=\"\">Yes</label>\r\n"
						+ "                      </td>\r\n"
						+ "                      <td class=\"form-check form-check-inline\">\r\n"
						+ "                        <input class=\"form-check-input\" type=\"radio\" id=\"\" value=\"no\" name=\"security\">\r\n"
						+ "                        <label class=\"form-check-label\" for=\"\">No</label>\r\n"
						+ "                      </td>\r\n"
						+ "                    </tr>\r\n"
						+ "                    <tr>\r\n"
						+ "                      <td>Parking</td>\r\n"
						+ "                      <td class=\"form-check form-check-inline\">\r\n"
						+ "                        <input class=\"form-check-input\" type=\"radio\" id=\"\" value=\"yes\" name=\"parking\">\r\n"
						+ "                        <label class=\"form-check-label\" for=\"\">Yes</label>\r\n"
						+ "                      </td>\r\n"
						+ "                      <td class=\"form-check form-check-inline\">\r\n"
						+ "                        <input class=\"form-check-input\" type=\"radio\" id=\"\" value=\"no\" name=\"parking\">\r\n"
						+ "                        <label class=\"form-check-label\" for=\"\">No</label>\r\n"
						+ "                      </td>\r\n"
						+ "                    </tr>\r\n"
						+ "                    <tr>\r\n"
						+ "                      <td>CCTV</td>\r\n"
						+ "                      <td class=\"form-check form-check-inline\">\r\n"
						+ "                        <input class=\"form-check-input\" type=\"radio\" id=\"\" value=\"yes\" name=\"cctv\">\r\n"
						+ "                        <label class=\"form-check-label\" for=\"\">Yes</label>\r\n"
						+ "                      </td>\r\n"
						+ "                      <td class=\"form-check form-check-inline\">\r\n"
						+ "                        <input class=\"form-check-input\" type=\"radio\" id=\"\" value=\"no\" name=\"cctv\">\r\n"
						+ "                        <label class=\"form-check-label\" for=\"\">No</label>\r\n"
						+ "                      </td>\r\n"
						+ "                    </tr>\r\n"
						+ "                  </tbody>\r\n"
						+ "                </table>\r\n"
						+ "              </div>    \r\n"
						+ "            </div>\r\n"
						+ "          </div> \r\n"
						+ "        </div><hr class=\"mx-sm-4\">\r\n"
						+ "        <div class=\"row\">\r\n"
						+ "          <div class=\"col-lg-12 col-sm-12 col-md-12\">\r\n"
						+ "            <div class=\"mx-sm-5\">\r\n"
						+ "              <h5 class=\"text-info\">Meal Offered:-</h5>\r\n"
						+ "            </div>\r\n"
						+ "            <div class=\" my-sm-3 mx-sm-5\" style=\" padding-left: 100px;\">\r\n"
						+ "              <div class=\"form-check-inline\">\r\n"
						+ "                <label class=\"form-check-label\">\r\n"
						+ "                  <input type=\"checkbox\" class=\"form-check-input\" value=\"yes\" name=\"breakfast\">Breakfast\r\n"
						+ "                </label>\r\n"
						+ "              </div>\r\n"
						+ "              <div class=\"form-check-inline\">\r\n"
						+ "                <label class=\"form-check-label\">\r\n"
						+ "                  <input type=\"checkbox\" class=\"form-check-input\" value=\"yes\" name=\"lunch\">Lunch\r\n"
						+ "                </label>\r\n"
						+ "              </div>\r\n"
						+ "              <div class=\"form-check-inline\">\r\n"
						+ "                <label class=\"form-check-label\">\r\n"
						+ "                  <input type=\"checkbox\" class=\"form-check-input\" value=\"yes\" name=\"dinner\">Dinner\r\n"
						+ "                </label>\r\n"
						+ "              </div>\r\n"
						+ "            </div>\r\n"
						+ "\r\n"
						+ "            <div class=\"mx-sm-5 px-sm-5 mt-sm-4 text-center\">\r\n"
						+ "              <!-- <button type=\"button\" class=\"btn btn-secondary\" id=\"\" value=\"\">Reset</button>\r\n"
						+ "              <button type=\"button\" class=\"btn btn-success\" id=\"\" value=\"\">Submit</button> -->\r\n"
						+ "              \r\n"
						+ "              <input type=\"reset\" value=\"Reset\" class=\"btn btn-secondary\" onclick=\"reset()\">\r\n"
						+ "              <input type=\"submit\" value=\"Update\" class=\"btn btn-success\" onclick=\"submit()\">\r\n"
						+ "            </div></form><hr class=\"mx-sm-4\">\r\n"
						+ "            <footer class=\"text-center my-0 py-0\">\r\n"
						+ "              <p><small>All Rights Reserved</small></p>\r\n"
						+ "              <p><small>Designed &amp; Created By <strong>AMIT BHATIA</strong></small></p>\r\n"
						+ "            </footer> \r\n"
						+ "          </div>\r\n"
						+ "        </div>\r\n"
						+ "      </div>\r\n"
						+ "    </div>\r\n"
						+ "  </div>\r\n"
						+ "\r\n"
						+ "<!-------------------Add PG Details Content--------------------->\r\n"
						+ "\r\n"
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
						+ "            <form action=\"change_password\" method=\"POST\">\r\n"
						+ "              <div class=\"modal-body\">\r\n"
						+ "                <div class=\"form-group\">\r\n"
						+ "                  <label>Old Password</label>\r\n"
						+ "                  <input type=\"password\" class=\"form-control\" placeholder=\"Old Password\" id=\"\">\r\n"
						+ "                </div>\r\n"
						+ "\r\n"
						+ "                <div class=\"form-group\">\r\n"
						+ "                  <label>New Password</label>\r\n"
						+ "                  <input type=\"password\" class=\"form-control\" placeholder=\"New Password\" id=\"\">\r\n"
						+ "                </div>\r\n"
						+ "\r\n"
						+ "                <div class=\"form-group\">\r\n"
						+ "                  <label>Confirm Password</label>\r\n"
						+ "                  <input type=\"password\" class=\"form-control\" placeholder=\"confirm Password\" id=\"\">\r\n"
						+ "                </div>\r\n"
						+ "              </div>\r\n"
						+ "              <div class=\"modal-footer\">\r\n"
						+ "                <button class=\"btn btn-secondary\" id=\"\">Reset</button>\r\n"
						+ "                <button class=\"btn btn-success\" id=\"\">Change Password</button>\r\n"
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
						+ "</html>");
		}
			
		else 
			{
	
				out.println("<h1>session expired</h1>");
				out.println("please login again");
				out.println("<a href='index.html'>Back to login page</a>");
				
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
