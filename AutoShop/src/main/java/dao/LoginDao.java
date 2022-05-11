package dao;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;

public class LoginDao {

	SessionFactory sf = HibernateUtil.createSessionFactory();
	
	public User existsUserAndPassword(String userName, String password) {
		User user = null;
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		try {
			String hql = "from User where userName = :name and password = :pass";
			Query query = session.createQuery(hql);
				query.setParameter("name", userName);
				query.setParameter("pass" , password);
				
				user = (User) query.getSingleResult();
			
				
					session.getTransaction().commit();
					System.out.println("User with username: " + userName + " exist");
					return user;
				
			
			
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("did not find a user" );
			return null;
		}finally {
			session.close();
		}
		
	}

	

}
