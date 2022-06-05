package dao;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import model.Address;
import model.Contact;
import model.User;
import model.UserDetails;

public class EditProfileDao {
	
	SessionFactory sf = HibernateUtil.getSessionFactory();

	
	public User takeUserId(String idUser) {
		User user = new User();
		
		int userId = Integer.parseInt(idUser);
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		try {
			user = session.get(User.class, userId);
			
			session.getTransaction().commit();
			System.out.println("User with this idUser: " + userId + " exist");
			return user;
		}  catch (Exception e) {
			
			session.getTransaction().rollback();
			System.out.println("Something wrong in method takeUserId");
			return null;
		}finally {
			
			session.close();
		}
		
	}


	public UserDetails takeUserDetailsFromUserId(User userFromDb) {
		UserDetails details = new UserDetails();

		Session session = sf.openSession();
		session.beginTransaction();
		try {

			String hql = "from UserDetails where user = :userFromDb";
			Query query = session.createQuery(hql);
			query.setParameter("userFromDb", userFromDb);

			details = (UserDetails) query.getSingleResult();

			session.getTransaction().commit();
			System.out.println("Exist user details with id " + details.getIdUserDetails());
			return details;

		} catch (NonUniqueResultException e) {
			System.out.println("We have more users with this id...");
			return null;
		} catch (NoResultException e) {
			System.out.println("Does not exist user with this id...");
			return null;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.out.println("Something wrong in takeUserDetailsFromUserId...");
			e.printStackTrace();
			return null;
		} finally {
			session.close();
		}
		
	}


	public boolean editUserDetails(String firstName, String lastName, String phone, String email, String country,
			String city, String street, UserDetails details) {
		 
		boolean updateUserDetails = false;
		
		Session session = sf.openSession();
		session.beginTransaction();
		
		try {
			UserDetails persistedUserDetails = session.get(UserDetails.class, details.getIdUserDetails());
			System.out.println("Persisted user details: " + persistedUserDetails.getIdUserDetails());
			
			persistedUserDetails.setFirstName(firstName);
			persistedUserDetails.setLastName(lastName);
			if (persistedUserDetails.getContact() == null) {
				Contact contact = new Contact();
				contact.setEmail("defaultMail");
				contact.setPhone("defaultPhone");
				persistedUserDetails.setContact(contact);
				
				persistedUserDetails.getContact().setPhone(phone);
				persistedUserDetails.getContact().setEmail(email);
			}else {
				persistedUserDetails.getContact().setPhone(phone);
				persistedUserDetails.getContact().setEmail(email);
			}
			
			if (persistedUserDetails.getAddress() == null) {
				Address address = new Address();
				address.setCity("defaultCity");
				address.setCountry("defaultCountry");
				address.setStreet("defaultStreet");
				persistedUserDetails.setAddress(address);
				
				persistedUserDetails.getAddress().setCountry(country);
				persistedUserDetails.getAddress().setCity(city);
				persistedUserDetails.getAddress().setStreet(street);
			}else {
				persistedUserDetails.getAddress().setCountry(country);
				persistedUserDetails.getAddress().setCity(city);
				persistedUserDetails.getAddress().setStreet(street);
			}
			
			
			
			session.update(persistedUserDetails);
			updateUserDetails = true;
			session.getTransaction().commit();
			System.out.println("Update user details is successuful!");
			return updateUserDetails;
		} catch (Exception e) {
			
			session.getTransaction().rollback();
			System.out.println("Update user details unsuccessuful!");
			return false;
		}finally {
			session.close();
		}
		
	}
}
