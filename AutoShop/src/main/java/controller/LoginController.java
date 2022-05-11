package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.TypeUser;
import model.User;
import service.LoginService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet(description = "Servlet for login", urlPatterns = { "/LoginController" })
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		LoginService service = new LoginService();
		
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		
		service.writeParameters(userName, password);
		
		//Validation: user and pass must be filled
		boolean isUserAndPassFilled = service.loginValidationUserPass(userName, password);
		if (!isUserAndPassFilled) {
			response.sendRedirect("htmlPages/LoginFailed.html");
		}
		//Searching for a user in database
		User user = service.existsUserAndPassword(userName, password);
		if (user == null) {
			response.sendRedirect("htmlPages/LoginFailed.html");
		} else {
			//if user exist,send him on his page
			//Create http session object 
			HttpSession session = request.getSession();
			//Set in user in session object
			session.setAttribute("user", user);
			if (user.getTypeUser().equals(TypeUser.BUYER)) {
			//Send him on buyer page	
				response.sendRedirect("jspPages/Buyer.jsp");
			} else if(user.getTypeUser().equals(TypeUser.SELLER)) {
			//Send him on seller page
				response.sendRedirect("jspPages/Seller.jsp");
			}else {
			//Send him on admin page
				response.sendRedirect("jspPages/Admin.jsp");
			}
		}
		
	}

}
