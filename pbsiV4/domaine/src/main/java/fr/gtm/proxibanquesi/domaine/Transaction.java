package fr.gtm.proxibanquesi.domaine;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class Transaction {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private Date dateVirement;
	private Integer sourceId;
	private Integer destinationId;
	private double montant;
	
	public Transaction() {
		super();
	}

	public Transaction(Date dateVirement, Integer sourceId, Integer destinationId, double montant) {
		super();
		this.dateVirement = dateVirement;
		this.sourceId = sourceId;
		this.destinationId = destinationId;
		this.montant = montant;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDateVirement() {
		return dateVirement;
	}

	public void setDateVirement(Date dateVirement) {
		this.dateVirement = dateVirement;
	}

	public Integer getSourceId() {
		return sourceId;
	}

	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}

	public Integer getDestinationId() {
		return destinationId;
	}

	public void setDestinationId(Integer destinationId) {
		this.destinationId = destinationId;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", dateVirement=" + dateVirement + ", sourceId=" + sourceId
				+ ", destinationId=" + destinationId + ", montant=" + montant + "]";
	}
	
	
	
	
}

