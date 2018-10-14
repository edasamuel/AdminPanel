package adminactions;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class MenCategoryProductAdd
 */
@WebServlet("/ProductAdd")
public class ProductAdd extends HttpServlet {
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
		
		ProductBean pb = new ProductBean(category,type,item,productName,size,price,photo);
		DbActions da = new DbActions();
		try 
		{
			int i = da.goProductInsert(category);
			
			if( i != 0)
			{
				response.sendRedirect("pages/addcategory.jsp");
			}
			else
			{
				response.sendRedirect("pages/index.jsp");
			}
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

}
