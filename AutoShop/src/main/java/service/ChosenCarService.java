package service;

import java.util.List;

import dao.ChosenCarDao;
import dao.EditProfileDao;
import model.Car;
import model.User;
import model.UserDetails;

public class ChosenCarService {
	
	ChosenCarDao dao = new ChosenCarDao();
	EditProfileDao dao1 = new EditProfileDao();

	public Boolean stringToBoolean(String registration) {
		
		return dao.stringToBoolean(registration);
	}

	public List<Car> getChosenCar(String manufacturer, String model, Double priceFrom, Double priceTo, String yearFrom,
			String yearTo, String registration) {
		
		return dao.getChosenCar( manufacturer,  model,  priceFrom,  priceTo,  yearFrom, yearTo,  registration);
	}

	public Car takeCarId(String idCar) {
		
		return dao.takeCarId(idCar);
	}

	public User takeUserById(String idUser) {
		
		return dao1.takeUserId(idUser);
	}

	public UserDetails takeUserDetailsByUserId(User user) {
		 
		return dao1.takeUserDetailsFromUserId(user);
	}

	

	
	
}
