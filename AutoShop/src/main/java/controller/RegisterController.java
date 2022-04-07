package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.RegisterService;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet(description = "Servlet for registration", urlPatterns = { "/RegisterController" })
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Welcome to doPost method!");
		
		//Connect to Register service
		RegisterService service = new RegisterService();
		
		//Take parameters
		String userName = request.getParameter("userName");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String repeatPassword = request.getParameter("repeatPassword");
		String typeUser = request.getParameter("typeUser");
		
		//Print parameters
		service.printParameters(userName, email, password, repeatPassword, typeUser);
		
		
		//Checking is password contain minimum requirements
		boolean isPassOk = service.isPassOk(password);
		//Checking is email contain @
		boolean isEmailOk = service.isEmailOk(email);
		//Checking username
		boolean isUsernameOk = service.isUsernameOk(userName);
		//Checking fields
		boolean isFieldsEmpty = service.isFieldsEmpty(userName, email, password, repeatPassword,typeUser);
		
		
		if (isFieldsEmpty) {
			
			if (isPassOk) {
				if (password.equals(repeatPassword)) {
					if (isEmailOk) {
						if (isUsernameOk) {
						//All good,we continue to registration
							
							
						} else {
							response.sendRedirect("htmlPages/IncorrectUsernamePage.html");
						}
					} else {
						//Incorrect email
						response.sendRedirect("htmlPages/IncorrectEmailPage.html");
					}
				}else {
					//If pass and rep pass not equals
					response.sendRedirect("htmlPages/PassAndRepPassNotEqual.html");
				}
				}else {
					//If pass not contain min requirements go on this page
					response.sendRedirect("htmlPages/IncorrectPasswordPage.html");
				}
	}else {
		response.sendRedirect("htmlPages/EmptyFieldsPage.html");
	}
			}
	
	
	
	
	
	
	
	}


