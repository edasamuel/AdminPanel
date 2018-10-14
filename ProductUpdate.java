package adminactions;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductUpdate
 */
@WebServlet("/ProductUpdate")
public class ProductUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
				String pid = request.getParameter("pid");
				String category = request.getParameter("selectcategory");
				ResultSet rs = null;
				HttpSession s = request.getSession();
				DbActions db = new DbActions();
				rs = db.getDetails(pid,category);
				String[] ss = new String[20];
				int i = 0;
				int j = 1;
				try 
				{	
					while(rs.next())
					{
						for(i=0,j=1; j<=6; i++,j++)
						{
							ss[i] = rs.getString(j);
						}
					}
					
					s.setAttribute("ud1",ss[0]);
					s.setAttribute("ud2",ss[1]);
					s.setAttribute("ud3",ss[2]);
					s.setAttribute("ud4",ss[3]);
					s.setAttribute("ud5",ss[4]);
					s.setAttribute("ud6",ss[5]);
					s.setAttribute("upid",pid);
					s.setAttribute("utab", category);
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
				
				response.sendRedirect("pages/updateproduct.jsp");
	}

}
