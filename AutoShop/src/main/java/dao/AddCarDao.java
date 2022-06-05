package dao;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Car;
import model.UserDetails;

public class AddCarDao {

	SessionFactory sf = HibernateUtil.createSessionFactory();

	public Boolean isRegisterMethod(String isRegisterForm) {
		Boolean isRegister = false;
		if (isRegisterForm == null) {
			isRegister = false;
		} else {
			isRegister = true;
		}
		return isRegister;
	}

	public Car fillCar(String manufacturer, String model, Double price, String year, Boolean isRegister,
			UserDetails details) {
		
		Car car = new Car();
		
		car.setManufacturer(manufacturer);
		car.setModel(model);
		car.setPrice(price);
		car.setYear(year);
		car.setIsRegister(isRegister);
		car.setUserDetails(details);
		
		return car;
	}

	public boolean insertCarInTable(Car car) {
		Session session = sf.openSession(); 
		session.beginTransaction();
		
		try {
			session.save(car);
			session.getTransaction().commit();
			System.out.println("Insert car in database completed!");
			return true;
		} catch (Exception e) {
			
			session.getTransaction().rollback();
			System.out.println("Something wrong in method insertCarInTable");
			e.printStackTrace();
			return false;
		}finally {
			session.close();
		}
		
	}

	public boolean connectUserDetailsWithCar(UserDetails details, Car car) {
		Session session = sf.openSession();
		session.beginTransaction();
		
		try {
			//Takeing persistent object from base type UserDetails
			UserDetails detailsFromDb = session.get(UserDetails.class, details.getIdUserDetails());
			//Initialize list cars because is fetch type = LAZY
			Hibernate.initialize(detailsFromDb.getCars());
			//Adding car in list
			detailsFromDb.getCars().add(car);
			session.saveOrUpdate(detailsFromDb);
			session.getTransaction().commit();
			System.out.println("Insert car in UserDetails!");
			return true;
		} catch (Exception e) {
			
			session.getTransaction().rollback();
			System.out.println("Something wrong in method connectUserDetailsWithCar...");
			return false;
		}finally {
			session.close();
		}
		
	}
}
