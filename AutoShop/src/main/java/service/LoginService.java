package service;

import common.CommonMethods;
import dao.LoginDao;
import model.User;
import validation.Validation;

public class LoginService {
	//Connections with other clases
	CommonMethods commonMethods = new CommonMethods();
	Validation validation = new Validation();
	LoginDao loginDao = new LoginDao();

	public void writeParameters(String userName, String password) {
		
		commonMethods.writeParameters( userName, password);
		
	}

	public boolean loginValidationUserPass(String userName, String password) {
		
		return validation.loginValidationUserPass(userName, password);
	}

	public User existsUserAndPassword(String userName, String password) {
		
		return loginDao.existsUserAndPassword(userName, password);
	}

	

}
