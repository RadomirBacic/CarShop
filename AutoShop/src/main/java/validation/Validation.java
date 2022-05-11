package validation;

public class Validation {
	//Print parameters
	public void printParameters(String userName, String email, String password, String repeatPassword, String typeUser) {
		System.out.println("Parameter are: ");
		System.out.println("Username is: " + userName);
		System.out.println("Email is: " + email);
		System.out.println("Password is: " + password);
		System.out.println("Repeated password is: " + repeatPassword);
		System.out.println("Type user: " + typeUser);
	}

	//Validation method for password
	public boolean isPassOk(String password) {
		//Check is password contain minimum 8 characters
		int lengthPass = password.length();
		if (lengthPass < 8) {
			System.out.println("Password not contain min 8 characters!");
			return false;
		}
		//Check numbers of numbers and upper case in password
		int counterNumbers = 0;
		int counterUpperCase = 0;
		for (int i = 0; i < lengthPass; i++) {
			char charac = password.charAt(i);
			if (Character.isDigit(charac)) {
				counterNumbers ++;
			}
			if (Character.isUpperCase(charac)) {
				counterUpperCase ++;
			}
		}
		//Check is password contain minimum 1 number and minimum 2 upper case
		if (counterNumbers >= 1 && counterUpperCase >= 2) {
			System.out.println("Password ok");	
			return true;
		} else {
			System.out.println("Password not contain min 1 number and 2 upper case");
			return false;
		}
		
	}

	public boolean isEmailOk(String email) {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
	      return email.matches(regex);
	}

	public boolean isUsernameOk(String userName) {
		int lengthUsername = userName.length();
		if (lengthUsername < 8 ) {
			System.out.println("Username not contain min 8 characters!");
			return false;
			}
		return true;
	}

	public boolean isFieldsEmpty(String userName, String email, String password, String repeatPassword,
			String typeUser) {
		if (userName.isEmpty() && email.isEmpty() && password.isEmpty() && repeatPassword.isEmpty() && typeUser.isEmpty()) {
			System.out.println("Some of fields not filled!");
			return false;
		}
		System.out.println("All fields filled");
		return true;
	}

	public boolean loginValidationUserPass(String userName, String password) {
		if (userName == null || userName.isEmpty() && password == null || password.isEmpty()) {
			System.out.println("Login username or password fields are empty!");
			return false;
		}
		System.out.println("Login fields username and password are filled!");
		return true;
	}
	

	

	
	
}
