package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.TypeUser;
import model.User;
import model.UserDetails;
import service.EditProfileService;

/**
 * Servlet implementation class EditProfileController
 */
@WebServlet(description = "Edit user details", urlPatterns = { "/EditProfileController" })
public class EditProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		EditProfileService service = new EditProfileService();
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String country = request.getParameter("country");
		String city = request.getParameter("city");
		String street = request.getParameter("street");
		String idUser = request.getParameter("idUser");
		
		
		User user = service.takeUserId(idUser);
		UserDetails details = service.takeUserDetailsFromUserId(user);
		 
		if (details == null) {
			
			response.sendRedirect("htmlPages/NoUserDetailsFound.html");
		}else {
			boolean editUserDetails = service.editUserDetails(firstName, lastName, phone, email, country, city, street, details);
			if (editUserDetails) {
				response.sendRedirect("jspPages/EditSuccessfully.jsp");
			}else {
				response.sendRedirect("htmlPages/NoUserDetailsFound.html");
			} 
		}
		
		
		
	}

}
