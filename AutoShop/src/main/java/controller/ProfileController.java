package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.UserDetails;
import service.EditProfileService;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet(description = "View profiles", urlPatterns = { "/ProfileController" })
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EditProfileService service = new EditProfileService();
		
		String idUser = request.getParameter("idUser");
		
		User user = service.takeUserId(idUser);
		UserDetails details = service.takeUserDetailsFromUserId(user);
		
		if (details != null) {
			request.setAttribute("details", details);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jspPages/ShowProfile.jsp");
			dispatcher.forward(request, response);
		} else {
			response.sendRedirect("htmlPages/NoUserDetailsFound.html");
		}
		
		
		
		
	}

}
