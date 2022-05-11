package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;
import model.UserDetails;

public class RegisterDao {
	
	
	SessionFactory sf = HibernateUtil.createSessionFactory();

	public boolean writeUserInBase(User user) {
		UserDetails details = new UserDetails();
		details.setUser(user);
		
		Session session = sf.openSession();
		
		session.beginTransaction();
		try {
			session.save(user);
			session.save(details);
			session.getTransaction().commit();
			System.out.println("User with username: " + user.getUserName() + " is saved in database");
			return true;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Error,user with username: " + user.getUserName() + " not saved in database");
			return false;
		}finally {
			session.close();
		}
	}
	
	
	
	
	

}
