package adminactions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ProductUpdate1
 */
@WebServlet("/ProductUpdate1")
public class ProductUpdate1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("selectcategory");
		category = category.toLowerCase();
		String type = request.getParameter("selecttype");
		type = type.toLowerCase();
		String item = request.getParameter("selectitem");
		item = item.toLowerCase();
		String productName = request.getParameter("pname");
		productName = productName.toLowerCase();
		String size = request.getParameter("size");
		size = size.toLowerCase();
		String price = request.getParameter("price");
		String photo = request.getParameter("photo");
		HttpSession s = request.getSession();
		String pid = (String) s.getAttribute("upid");
		String utab = (String) s.getAttribute("utab");
		
		try
		{
		DbActions da = new DbActions();
		int i = da.goProductUpdate(category,type,item,productName,size,price,photo,pid,utab);
		if( i != 0)
		{
			response.sendRedirect("pages/updatecategory.jsp");
		}
		else
		{
			response.sendRedirect("pages/index.jsp");
		}
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
