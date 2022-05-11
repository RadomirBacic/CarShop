package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.User;
import service.AddBalanceService;

/**
 * Servlet implementation class AddBalanceController
 */
@WebServlet(description = "Here add balance controller", urlPatterns = { "/AddBalanceController" })
public class AddBalanceController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddBalanceService service = new AddBalanceService();
		
		String userName = request.getParameter("userName");
		String balance = request.getParameter("balance");
		
		Double balanceForInsert = Double.parseDouble(balance);
		//check does user exist,if exist-take him
		User user = service.existUser(userName);
		
		if (user != null) {
			
			boolean isBalanceAdded = service.addBalanceToUser(user, balanceForInsert);
			if (isBalanceAdded) {
				response.sendRedirect("jspPages/Admin.jsp");
			} else {
				response.sendRedirect("jspPages/AddBalance.jsp");
			}
		} else {
			response.sendRedirect("htmlPages/UserFailed.html");
		}
	}

}
