package adminactions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductDelete
 */
@WebServlet("/ProductDelete")
public class ProductDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pid = request.getParameter("pid");
		String category = request.getParameter("selectcategory");
		
		DbActions da = new DbActions();
		int i = da.goProductDelete(pid, category);
		if( i != 0)
		{
			response.sendRedirect("pages/deleteproduct.jsp");
		}
		else
		{
			response.sendRedirect("pages/index.jsp");
		}
	}

}
