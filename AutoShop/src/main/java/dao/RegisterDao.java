package dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;

public class RegisterDao {
	
	SessionFactory sf = HibernateUtil.createSessionFactory();

	public boolean writeUserInBase(User user) {
		
		Session session = sf.openSession();
		
		session.beginTransaction();
		try {
			session.save(user);
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
