package adminactions;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ShowWomenProducts
 */
@WebServlet("/ShowWomenProducts")
public class ShowWomenProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String type = request.getParameter("selecttype");
		String tablename = "womencollections";
		ResultSet rs = null;
		DbActions da = new DbActions();
		rs = da.getProducts(type,tablename);
		String ss[] = new String[20];
		
		
		PrintWriter out = response.getWriter();
		out.println(" <!doctype html>\r\n" + 
				"\r\n" + 
				"<head>\r\n" + 
				"    <meta charset=\"utf-8\">\r\n" + 
				"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
				"    <title>Sufee Admin - Women Collection </title>\r\n" + 
				"    <meta name=\"description\" content=\"Sufee Admin - HTML5 Admin Template\">\r\n" + 
				"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
				"\r\n" + 
				"    <link rel=\"apple-touch-icon\" href=\"apple-icon.png\">\r\n" + 
				"    <link rel=\"shortcut icon\" href=\"favicon.ico\">\r\n" + 
				"\r\n" + 
				"    <link rel=\"stylesheet\" href=\"assets/css/normalize.css\">\r\n" + 
				"    <link rel=\"stylesheet\" href=\"assets/css/bootstrap.min.css\">\r\n" + 
				"    <link rel=\"stylesheet\" href=\"assets/css/font-awesome.min.css\">\r\n" + 
				"    <link rel=\"stylesheet\" href=\"assets/css/themify-icons.css\">\r\n" + 
				"    <link rel=\"stylesheet\" href=\"assets/css/flag-icon.min.css\">\r\n" + 
				"    <link rel=\"stylesheet\" href=\"assets/css/cs-skin-elastic.css\">\r\n" + 
				"    <!-- <link rel=\"stylesheet\" href=\"assets/css/bootstrap-select.less\"> -->\r\n" + 
				"    <link rel=\"stylesheet\" href=\"assets/scss/style.css\">\r\n" + 
				"\r\n" + 
				"    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,600,700,800' rel='stylesheet' type='text/css'>\r\n" + 
				"\r\n" + 
				"    <!-- <script type=\"text/javascript\" src=\"https://cdn.jsdelivr.net/html5shiv/3.7.3/html5shiv.min.js\"></script> -->\r\n" + 
				"\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"             <!-- Left Panel -->\r\n" + 
				"\r\n" + 
				"    <aside id=\"left-panel\" class=\"left-panel\">\r\n" + 
				"        <nav class=\"navbar navbar-expand-sm navbar-default\">\r\n" + 
				"\r\n" + 
				"            <div class=\"navbar-header\">\r\n" + 
				"                <button class=\"navbar-toggler\" type=\"button\" data-toggle=\"collapse\" data-target=\"#main-menu\" aria-controls=\"main-menu\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\r\n" + 
				"                    <i class=\"fa fa-bars\"></i>\r\n" + 
				"                </button>\r\n" + 
				"                <a class=\"navbar-brand\" href=\"pages/index.jsp\"><img src=\"images/logo.png\" alt=\"Logo\"></a>\r\n" + 
				"                <a class=\"navbar-brand hidden\" href=\"pages/index.jsp\"><img src=\"images/logo2.png\" alt=\"Logo\"></a>\r\n" + 
				"            </div>\r\n" + 
				"\r\n" + 
				"            <div id=\"main-menu\" class=\"main-menu collapse navbar-collapse\">\r\n" + 
				"                <ul class=\"nav navbar-nav\">\r\n" + 
				"                    <li class=\"active\">\r\n" + 
				"                        <a href=\"pages/index.jsp\"> <i class=\"menu-icon fa fa-dashboard\"></i>Dashboard </a>\r\n" + 
				"                    </li>\r\n" + 
				"                    <h3 class=\"menu-title\">Admin Actions</h3><!-- /.menu-title -->\r\n" + 
				"                    <li class=\"menu-item-has-children dropdown\">\r\n" + 
				"                        <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"> <i class=\"menu-icon fa fa-laptop\"></i>Category</a>\r\n" + 
				"                        <ul class=\"sub-menu children dropdown-menu\">\r\n" + 
				"                            <li><i class=\"fa fa-id-badge\"></i><a href=\"pages/addcategory.jsp\">Add Product</a></li>\r\n" + 
				"                            <li><i class=\"fa fa-id-badge\"></i><a href=\"pages/updatecategory.jsp\">Update Product</a></li>\r\n" + 
				"                            <li><i class=\"fa fa-id-badge\"></i><a href=\"pages/deleteproduct.jsp\">Delete Product</a></li>\r\n" + 
				"                        </ul>\r\n" + 
				"                    </li>\r\n" + 
				"                    <li class=\"menu-item-has-children dropdown\">\r\n" + 
				"                        <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"> <i class=\"menu-icon fa fa-table\"></i>Products</a>\r\n" + 
				"                        <ul class=\"sub-menu children dropdown-menu\">\r\n" + 
				"                            <h3 class=\"menu-title\">Collection List</h3>\r\n" + 
				"                            <li><i class=\"fa fa-id-badge\"></i><a href=\"pages/mencollection.jsp\">Men</a></li>\r\n" + 
				"                            <li><i class=\"fa fa-id-badge\"></i><a href=\"pages/womencollection.jsp\">Women</a></li> "+
				"                        </ul>\r\n" + 
				"                    </li>\r\n" + 
				"                    <li class=\"menu-item-has-children dropdown\">\r\n" + 
				"                        <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"> <i class=\"menu-icon fa fa-th\"></i>Subordinates</a>\r\n" + 
				"                        <ul class=\"sub-menu children dropdown-menu\">\r\n" + 
				"                            <li><i class=\"menu-icon fa fa-id-badge\"></i><a href=\"#\">Add Users</a></li>\r\n" + 
				"                            <li><i class=\"menu-icon fa fa-id-badge\"></i><a href=\"#\">Controls</a></li>\r\n" + 
				"                        </ul>\r\n" + 
				"                    </li>\r\n" + 
				"\r\n" + 
				"                    \r\n" + 
				"                </ul>\r\n" + 
				"            </div><!-- /.navbar-collapse -->\r\n" + 
				"        </nav>\r\n" + 
				"    </aside><!-- /#left-panel -->\r\n" + 
				"    <!-- Left Panel -->\r\n" + 
				"\r\n" + 
				"    <!-- Right Panel -->\r\n" + 
				"\r\n" + 
				"    <div id=\"right-panel\" class=\"right-panel\">\r\n" + 
				"\r\n" + 
				"        <!-- Header-->\r\n" + 
				"        <header id=\"header\" class=\"header\">\r\n" + 
				"\r\n" + 
				"            <div class=\"header-menu\">\r\n" + 
				"\r\n" + 
				"                <div class=\"col-sm-7\">\r\n" + 
				"                    <a id=\"menuToggle\" class=\"menutoggle pull-left\"><i class=\"fa fa fa-tasks\"></i></a>\r\n" + 
				"                   \r\n" + 
				"                </div>\r\n" + 
				"\r\n" + 
				"                <div class=\"col-sm-5\">\r\n" + 
				"                    <div class=\"user-area dropdown float-right\">\r\n" + 
				"                        <a href=\"#\" class=\"dropdown-toggle\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\">\r\n" + 
				"                            <img class=\"user-avatar rounded-circle\" src=\"images/Admin1.png\" alt=\"User Avatar\">\r\n" + 
				"                        </a>\r\n" + 
				"\r\n" + 
				"                        <div class=\"user-menu dropdown-menu\">\r\n" + 
				"\r\n" + 
				"                                <a class=\"nav-link\" href=\"pages/logout.jsp\"><i class=\"fa fa-power -off\"></i>Logout</a>\r\n" + 
				"                        </div>\r\n" + 
				"                    </div>\r\n" + 
				"\r\n" + 
				"                  \r\n" + 
				"\r\n" + 
				"                </div>\r\n" + 
				"            </div>\r\n" + 
				"\r\n" + 
				"        </header><!-- /header -->\r\n" + 
				"        <!-- Header-->\r\n" + 
				"        \r\n" + 
				"        <div class=\"col-lg-10\">\r\n" + 
				"                    <div class=\"card\">\r\n" + 
				"                      <div class=\"card-header\">\r\n" + 
				"                        <strong>Show</strong> Men Collection Products\r\n" + 
				"                      </div>\r\n" + 
				"                      <div class=\"card-body card-block\">\r\n" + 
				"                      <form action=\"ShowWomenProducts\" method=\"post\">\r\n" + 
				"                      			    \r\n" + 
				"						    <div class=\"form-group\">\r\n" + 
				"                      		 <label for=\"email\">Collection Type : </label>\r\n" + 
				"                      		 <select name=\"selecttype\" id=\"selectcollection\" class=\"form-control\">\r\n" + 
				"                                <option value=\"clothing\">Clothing</option>\r\n" + 
				"                                <option value=\"footwear\">Footwear</option>\r\n" + 
				"                              </select>\r\n" + 
				"                      		</div>\r\n" + 
				"						    \r\n" + 
				"						    <input type=\"submit\" class=\"btn btn-default\" value=\"Sumbit\">\r\n" + 
				"						  </form>\r\n" + 
				"                    </div>\r\n" + 
				"                   </div>\r\n" + 
				"              </div>\r\n");
							
				out.println("<div class=\"col-lg-10\">\r\n" + 
				"                    <div class=\"card\">\r\n" + 
				"                      <div class=\"card-header\">\r\n" + 
				"                        <strong>Products </strong>List\r\n" + 
				"                      </div>\r\n"); 
				
				out.println("<div class=\"card-body card-block\">\r\n" + 
				"                      \r\n"); 
				if(rs != null)
				{
					try
					{
						while(rs.next())
						{
							for(int i =0,j=0 ; i<9 ;i++,j++)
							{
								if( j == 7)
								{
									da.imageCreate(rs.getString(9),tablename);
								}
								else
								{
								ss[i] = rs.getString(j+1);
								}
							}
				 out.println("<div class=\"col-md-4\">\r\n" + 
							"                        <div class=\"card\">\r\n");
				 
						 out.println("<img class=\"card-img-top\" src=\"images/gimages/"+rs.getString(7)+"\" alt=\"Card image cap\">\r\n" + 
							"                            <div class=\"card-body\">\r\n" + 
							"   <h4 class=\"card-title mb-3\"> Product Id : "+rs.getString(9)); 
				out.println("</h4>\r\n" + rs.getString(4)+
							"                                <p class=\"card-text\">Price: Rs."+rs.getString(6));
							
						
					out.println("</p>\r\n" + 
							"                            </div>\r\n" + 
							"                        </div>\r\n" + 
							"                    </div>\r\n"); 
					}
					out.println("</div></div></div></div>\r\n"); 
						} 
						catch (SQLException e)
						{
							e.printStackTrace();
						}
					}		
				
							
							
				out.println("       \r\n" + 
				"     \r\n" + 
				"    <!-- /#right-panel -->\r\n" + 
				"    <!-- Right Panel -->\r\n" + 
				" \r\n" + 
				"    <script src=\"assets/js/vendor/jquery-2.1.4.min.js\"></script>\r\n" + 
				"    <script src=\"assets/js/popper.min.js\"></script>\r\n" + 
				"    <script src=\"assets/js/plugins.js\"></script>\r\n" + 
				"    <script src=\"assets/js/main.js\"></script>\r\n" + 
				"\r\n" + 
				"\r\n" + 
				"</body>\r\n" + 
				"</html>\r\n" + 
				" ");
		
	}

}
