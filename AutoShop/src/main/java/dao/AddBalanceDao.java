package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.User;
import model.UserDetails;

public class AddBalanceDao {

	SessionFactory sf = HibernateUtil.createSessionFactory();
	
	public User existUser(String userName) {
	
	User user = null;	
		
	Session session = sf.openSession();
	session.beginTransaction();
	
	try {
		
		String hql = "FROM User WHERE userName = :userName";
		Query query = session.createQuery(hql);
		query.setParameter("userName", userName);
	
	user = (User)query.getSingleResult();
		System.out.println("Find user");
		session.getTransaction().commit();
		return user;
	} catch (Exception e) {
		System.out.println("Not find a user add balance dao");
		session.getTransaction().rollback();
		return null;
	}finally {
		session.close();
	}
		
		
	}

	public boolean addBalanceToUser(User user, Double balance) {
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		
		try {
			User userFtomDB = session.get(User.class, user.getIdUser());
			String hql = "FROM UserDetails WHERE user = :userFromDB";
			Query query = session.createQuery(hql);
			query.setParameter("userFromDB", user);
			
		UserDetails details = (UserDetails)query.getSingleResult();	
			System.out.println("Found a user details..");
			
			if (details.getBalance() != null) {
				details.setBalance(details.getBalance() + balance);
			} else {
				details.setBalance(balance);
			}
			
			session.update(details);
			System.out.println("Added balance to user");
			session.getTransaction().commit();
			return true;
		} catch (Exception e) {
			System.out.println("Not added balance to user");
			session.getTransaction().rollback();
			return false;
		}finally {
			session.close();
		}
		
	}

}
