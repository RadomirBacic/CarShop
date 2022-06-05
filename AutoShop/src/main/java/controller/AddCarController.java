package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;
import model.User;
import model.UserDetails;
import service.AddCarService;

/**
 * Servlet implementation class AddCarController
 */
@WebServlet(description = "Add cars", urlPatterns = { "/AddCarController" })
public class AddCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AddCarService service = new AddCarService();
		
		String idUser = request.getParameter("idUser");
		String manufacturer = request.getParameter("manufacturer");
		String model = request.getParameter("model");
		String priceFromForm = request.getParameter("price");
		Double price = Double.parseDouble(priceFromForm);
		String year = request.getParameter("year");
		String isRegisterForm = request.getParameter("isRegister");
		Boolean isRegister = service.isRegisterMethod(isRegisterForm);
		
		
		User user = service.takeUserId(idUser);
		UserDetails details = service.takeUserDetailsFromUserId(user);
		
		Car car = service.fillCar(manufacturer, model, price, year, isRegister, details);
		
		boolean insertCarInTable = service.insertCarInTable(car);
		
		if (insertCarInTable) {
			boolean connectUserDetailsWithCar = service.connectUserDetailsWithCar(details, car);
			if (connectUserDetailsWithCar) {
				response.sendRedirect("htmlPages/ConnectedUserDetailsWithCar.html");
			} else {
				response.sendRedirect("htmlPages/NotConnectedUserDetailsWithCar.html");
			}
		} else {
			response.sendRedirect("htmlPages/InsertCarNotCompleted.html");
		}

}
}
