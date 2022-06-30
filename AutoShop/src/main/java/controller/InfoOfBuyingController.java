package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;
import model.User;
import model.UserDetails;
import service.ChosenCarService;

/**
 * Servlet implementation class InfoOfBuyingController
 */
@WebServlet(description = "Info of buying the cars", urlPatterns = { "/InfoOfBuyingController" })
public class InfoOfBuyingController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ChosenCarService service = new ChosenCarService();
		
		String idCar = request.getParameter("idCar");
		String idUser = request.getParameter("idUser");
		
		System.out.println("id car:" + idCar);
		System.out.println("id user: " + idUser);
		
		Car car = service.takeCarId(idCar);
		
		User user = service.takeUserById(idUser);
		
		UserDetails details = service.takeUserDetailsByUserId(user);
		
		request.setAttribute("car", car);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("jspPages/InfoAndBuy.jsp");
		dispatcher.forward(request, response);
	}

}
