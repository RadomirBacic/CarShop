package service;

import model.UserDetails;
import dao.AddCarDao;
import dao.EditProfileDao;
import model.Car;
import model.User;
import model.UserDetails;

public class AddCarService {

	AddCarDao dao = new AddCarDao();
	EditProfileDao EditProfileDao = new dao.EditProfileDao();
	public User takeUserId(String idUser) {
		
		return EditProfileDao.takeUserId(idUser);
	}
	public UserDetails takeUserDetailsFromUserId(User user) {
		
		return EditProfileDao.takeUserDetailsFromUserId(user);
	}
	public Boolean isRegisterMethod(String isRegisterForm) {
		
		return dao.isRegisterMethod(isRegisterForm);
	}
	public Car fillCar(String manufacturer, String model, Double price, String year, Boolean isRegister,
			UserDetails details) {
		
		return dao.fillCar(manufacturer, model,  price,  year,  isRegister,
				 details);
	}
	public boolean insertCarInTable(Car car) {
		
		return dao.insertCarInTable(car);
	}
	public boolean connectUserDetailsWithCar(UserDetails details, Car car) {
		
		return dao.connectUserDetailsWithCar( details,  car);
	}
	
}
