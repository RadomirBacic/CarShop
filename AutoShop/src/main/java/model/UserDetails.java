package model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idUser;
	private String firstName;
	private String lastName;
	private Double balance;
	@OneToOne
	private User user;
	@Embedded
	private Contact contact;
	@Embedded
	private Address address;
	@OneToMany
	private List<Car> cars = new ArrayList<>();
	
	
	
	
	
	
	

}
