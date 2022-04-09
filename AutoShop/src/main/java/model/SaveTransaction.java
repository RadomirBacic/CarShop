package model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class SaveTransaction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idTransaction;
	private Integer idBuyer;
	private Integer idSeller;
	private Integer idCar;
	private Date date;
	
	public Integer getIdTransaction() {
		return idTransaction;
	}
	public void setIdTransaction(Integer idTransaction) {
		this.idTransaction = idTransaction;
	}
	public Integer getIdBuyer() {
		return idBuyer;
	}
	public void setIdBuyer(Integer idBuyer) {
		this.idBuyer = idBuyer;
	}
	public Integer getIdSeller() {
		return idSeller;
	}
	public void setIdSeller(Integer idSeller) {
		this.idSeller = idSeller;
	}
	public Integer getIdCar() {
		return idCar;
	}
	public void setIdCar(Integer idCar) {
		this.idCar = idCar;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
	
	

}
