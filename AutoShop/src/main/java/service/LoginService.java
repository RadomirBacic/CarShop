package service;

import common.CommonMethods;
import dao.LoginDao;
import validation.Validation;

public class LoginService {
	//Connections with other clases
	CommonMethods commonMethods = new CommonMethods();
	Validation validation = new Validation();
	LoginDao loginDao = new LoginDao();

	public void writeParameters(String userName, String password) {
		
		commonMethods.writeParameters( userName, password);
		
	}

}
