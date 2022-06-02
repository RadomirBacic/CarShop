package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import model.TypeUser;
import service.AdminService;

/**
 * Servlet implementation class AdminController
 */
@WebServlet(description = "Admin servlet", urlPatterns = { "/AdminController" })
public class AdminController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AdminService service = new AdminService();
		
		String typeUser = request.getParameter("typeUser");
		System.out.println("Parameter: " + typeUser);
		
		TypeUser type = service.takeUserType(typeUser);
		//Take all users depends on user type
		List<User> users = service.backUserType(type);
		
		if (users != null && !users.isEmpty()) {
			request.setAttribute("users", users);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jspPages/ShowUsers.jsp");
			dispatcher.forward(request, response);
		}else {
			response.sendRedirect("jspPages/Admin.jsp");
		}
		
		

	}

}
