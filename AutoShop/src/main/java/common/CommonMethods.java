package common;

import model.TypeUser;
import model.User;

public class CommonMethods {

	public User fillUser(String userName, String email, String password, String repeatPassword, String typeUser) {
		User user = new User();
		user.setUserName(userName);
		user.setEmail(email);
		user.setPassword(password);
		user.setRepeatPassword(repeatPassword);
		if (typeUser.equals("0") ) {
			user.setTypeUser(TypeUser.BUYER);
		} else {
			user.setTypeUser(TypeUser.SELLER);
		}
		return user  ;
	}

	public void writeParameters(String userName, String password) {
		System.out.println("Login parameters are: ");
		System.out.println("Username: " + userName);
		System.out.println("Password: " + password);
		
	}

}
