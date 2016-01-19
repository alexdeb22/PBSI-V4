package fr.gtm.proxibanquesi.domaine;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Classe abstraite repr�sentant un compte en banque g�n�rique.
 */
public abstract class Compte {

	// Propri�t�s
	/** Num�ro du compte */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer numCompte;
	/** Solde du compte */
	private double solde;
	/** Date d'ouverture du compte */
	private Date dateOuverture;
	/** Num�ro d'identification du client auquel le compte appartient */
	private Integer idcli;
	
	// Getters & Setters
	/**
	 * Getter de la propri�t� numCompte
	 * 
	 * @return La propri�t� numCompte
	 */
	public Integer getNumCompte() {
		return numCompte;
	}
	/**
	 * Setter de la propri�t� numCompte
	 * 
	 * @return void
	 */
	public void setNumCompte(Integer numCompte) {
		this.numCompte = numCompte;
	}
	/**
	 * Getter de la propri�t� solde
	 * 
	 * @return La propri�t� solde
	 */
	public double getSolde() {
		return solde;
	}
	/**
	 * Setter de la propri�t� solde
	 * 
	 * @return void
	 */
	public void setSolde(double d) {
		this.solde = d;
	}
	/**
	 * Getter de la propri�t� dateOuverture
	 * 
	 * @return La propri�t� dateOuverture
	 */
	public Date getDateOuverture() {
		return dateOuverture;
	}
	/**
	 * Setter de la propri�t� dateOuverture
	 * 
	 * @return void
	 */
	public void setDateOuverture(Date dateOuverture) {
		this.dateOuverture = dateOuverture;
	}
	/**
	 * Getter de la propri�t� idcli
	 * 
	 * @return La propri�t� idcli
	 */
	public Integer getIdcli() {
		return idcli;
	}
	/**
	 * Setter de la propri�t� idcli
	 * 
	 * @return void
	 */
	public void setIdcli(Integer idcli) {
		this.idcli = idcli;
	}
	// Affichage
	/**
	 * M�thode permettant de retourner un String avec les propri�t�s de l'objet Compte
	 * 
	 * @return String d�crivant le compte
	 */
	@Override
	public String toString() {
		return "CompteBancaire [numCompte=" + numCompte + ", solde=" + solde
				+ "]";
	}
	
}
