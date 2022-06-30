package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Car;

public class ChosenCarDao {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	public Boolean stringToBoolean(String registration) {
		Boolean backBoolean = null;
		
		if (registration.equals("0")) {
			backBoolean = false;
		} else if(registration.equals("1")){
			backBoolean = true;
		}
		return null;
	}

	public List<Car> getChosenCar(String manufacturer, String model, Double priceFrom, Double priceTo, String yearFrom,
			String yearTo, String registration) {
		
		List<Car> listOfCars = new ArrayList<>();
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		try {
			String hql = "from Car" + 
							" where 1=1";
			
			if (manufacturer != null && !manufacturer.equals("")) {
				hql += " and manufacturer = :manufacturer";
			}
			if (model != null && !model.equals("")) {
				hql += " and model = :model";
			}
			if (priceFrom != null) {
				hql += " and price >= :priceFrom";
			}
			if (priceTo != null) {
				hql += " and price <= :priceTo";
			}
			if (!yearFrom.equals("0")) {
				hql += " and year >= :yearFrom";
			}
			if (!yearTo.equals("0")) {
				hql += " and year <= :yearTo";
			}
				if(registration.equals("1")) {
				hql += " and isRegister= true";
				}else if(registration.equals("0")){
					hql += " and isRegister= false"; 
				}	
			
			
			System.out.println(hql);
			Query query = session.createQuery(hql);
			
			if (manufacturer != null && !manufacturer.equals("")) {
				query.setParameter("manufacturer", manufacturer);
			}
			if (model != null && !model.equals("")) {
				query.setParameter("model", model);
			}
			if (priceFrom != null) {
				query.setParameter("priceFrom", priceFrom);
				
			}
			if (priceTo != null) {
				query.setParameter("priceTo", priceTo);
			}
			if (!yearFrom.equals("0")) {
				query.setParameter("yearFrom", yearFrom);
			} 
			if (!yearTo.equals("0")) {
				query.setParameter("yearTo", yearTo);
			}
			
			listOfCars = (List<Car>)query.getResultList();
			
			session.getTransaction().commit();
			System.out.println("List of cars have: " + listOfCars.size() + " rows");
			return listOfCars;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Something wrong in getChosenCar method!");
			e.printStackTrace();
			return null;
		}finally {
		session.close();	
		}
		
		

	}

	public Car takeCarId(String idCar) {
		
		Car car = new Car();
		Session session = sf.openSession();
		session.beginTransaction();
		
		try {
			car = session.get(Car.class, Integer.parseInt(idCar));
			
			session.getTransaction().commit();
			System.out.println("Exist car with id number: " + idCar);
			return car;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Something wrong in method takeCarId");
			e.printStackTrace();
			return null;
		}finally {
			session.close();
		}
	
	}
}
