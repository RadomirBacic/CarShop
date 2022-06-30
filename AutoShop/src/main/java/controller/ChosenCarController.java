package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Car;
import service.ChosenCarService;

/**
 * Servlet implementation class ChosenCarController
 */
@WebServlet(description = "Chosen car", urlPatterns = { "/ChosenCarController" })
public class ChosenCarController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ChosenCarService service = new ChosenCarService();

		String manufacturer = request.getParameter("manufacturer");
		String model = request.getParameter("model");
		String priceFromForm = request.getParameter("priceFrom");
		String priceToForm = request.getParameter("priceTo");
		String yearFrom = request.getParameter("yearFrom");
		String yearTo = request.getParameter("yearTo");
		String registration = request.getParameter("registration");
		Double priceFrom = null;
		Double priceTo = null;
		if (priceFromForm != null && !priceFromForm.equals("")) {
			priceFrom = Double.parseDouble(priceFromForm);
		} if (priceToForm != null && !priceToForm.equals("")) {
			priceTo = Double.parseDouble(priceToForm);
		}
		
		
		 
		
		List<Car> listOfCars = service.getChosenCar(manufacturer, model, priceFrom, priceTo, yearFrom, yearTo, registration);
		
		if (listOfCars !=null) {
			request.setAttribute("listOfCars", listOfCars);
			RequestDispatcher dispatcher = request.getRequestDispatcher("jspPages/ChosenCar.jsp");
			dispatcher.forward(request, response);
			} else {
				response.sendRedirect("jspPages/Buyer.jsp");
			}
}
}
