package adminactions;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminLogin
 */
@WebServlet("/AdminLogin")
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("sam");
		username = username.toLowerCase();
		String password = request.getParameter("password");
		password = password.toLowerCase();
		boolean lchk = false;
		Checks chk = new Checks();
		lchk = chk.goAdminLoginCheck(username, password);
		
		if(lchk == true )
		{
			HttpSession s = request.getSession();
			s.setAttribute("admin", "admin");
			response.sendRedirect("pages/index.jsp");
		}
		else
		{
			response.sendRedirect("login.jsp");
		}
		
	}

}
