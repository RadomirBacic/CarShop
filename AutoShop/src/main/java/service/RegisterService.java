package service;

import common.CommonMethods;
import dao.RegisterDao;
import model.User;
import validation.Validation;

public class RegisterService {
	Validation validation = new Validation();
	CommonMethods commonMethods = new CommonMethods();
	RegisterDao registerDao = new RegisterDao();
	
	public void printParameters(String userName, String email, String password, String repeatPassword, String typeUser) {
		validation.printParameters(userName, email, password, repeatPassword, typeUser);
	}

	public boolean isPassOk(String password) {
		
		return validation.isPassOk(password);
	}

	public boolean isEmailOk(String email) {
		
		return validation.isEmailOk(email);
	}

	public boolean isUsernameOk(String userName) {
		
		return validation.isUsernameOk(userName);
	}

	public boolean isFieldsEmpty(String userName, String email, String password, String repeatPassword,
			String typeUser) {
		
		return validation.isFieldsEmpty(userName, email, password, repeatPassword,typeUser);
	}

	public User fillUser(String userName, String email, String password, String repeatPassword, String typeUser) {
		
		return commonMethods.fillUser(userName, email, password, repeatPassword, typeUser);
	}

	public boolean writeUserInBase(User user) {
		
		return registerDao.writeUserInBase(user);
	}

	
}
