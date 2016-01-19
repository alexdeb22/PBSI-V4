package fr.gtm.proxibanquesi.domaine;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe abstraite représentant un compte en banque générique.
 */
public abstract class Compte {

	// Propriétés
	/** Numéro du compte */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer numCompte;
	/** Solde du compte */
	private double solde;
	/** Date d'ouverture du compte */
	private Date dateOuverture;
	/** Numéro d'identification du client auquel le compte appartient */
	private Integer idcli;
	
	// Getters & Setters
	/**
	 * Getter de la propriété numCompte
	 * 
	 * @return La propriété numCompte
	 */
	public Integer getNumCompte() {
		return numCompte;
	}
	/**
	 * Setter de la propriété numCompte
	 * 
	 * @return void
	 */
	public void setNumCompte(Integer numCompte) {
		this.numCompte = numCompte;
	}
	/**
	 * Getter de la propriété solde
	 * 
	 * @return La propriété solde
	 */
	public double getSolde() {
		return solde;
	}
	/**
	 * Setter de la propriété solde
	 * 
	 * @return void
	 */
	public void setSolde(double d) {
		this.solde = d;
	}
	/**
	 * Getter de la propriété dateOuverture
	 * 
	 * @return La propriété dateOuverture
	 */
	public Date getDateOuverture() {
		return dateOuverture;
	}
	/**
	 * Setter de la propriété dateOuverture
	 * 
	 * @return void
	 */
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	/**
	 * Getter de la propriété idcli
	 * 
	 * @return La propriété idcli
	 */
	public Integer getIdcli() {
		return idcli;
	}
	/**
	 * Setter de la propriété idcli
	 * 
	 * @return void
	 */
	public void setIdcli(Integer idcli) {
		this.idcli = idcli;
	}
	// Affichage
	/**
	 * Méthode permettant de retourner un String avec les propriétés de l'objet Compte
	 * 
	 * @return String décrivant le compte
	 */
	@Override
	public String toString() {
		return "CompteBancaire [numCompte=" + numCompte + ", solde=" + solde
				+ "]";
	}
	
}
