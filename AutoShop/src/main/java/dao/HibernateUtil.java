package dao;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	
	private static SessionFactory sf = null;
	
	
	public static SessionFactory createSessionFactory() {
		
		return new Configuration().configure().buildSessionFactory();
		
	}
	
	public static SessionFactory getSessionFactory() {
		
		 if (sf == null) {
			sf = createSessionFactory();
		}
		 return sf;
	}
	
	
	
	
}
