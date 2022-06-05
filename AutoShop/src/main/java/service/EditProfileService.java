package service;

import dao.EditProfileDao;
import model.User;
import model.UserDetails;

public class EditProfileService {
	
	EditProfileDao dao = new EditProfileDao();

	public User takeUserId(String idUser) {
		
		return dao.takeUserId(idUser);
	}

	public UserDetails takeUserDetailsFromUserId(User user) {
		
		return dao.takeUserDetailsFromUserId(user);
	}

	public boolean editUserDetails(String firstName, String lastName, String phone, String email, String country,
			String city, String street, UserDetails details) {
		
		return dao.editUserDetails(firstName, lastName,  phone, email,  country, city, street,  details);
	}

}
