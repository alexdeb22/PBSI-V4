package fr.gtm.proxibanquesi.domaine;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

/**
 * Classe représentant un client de la banque. Toutes les informations
 * personnelles hormis le numéro d'identification sont de type String.
 * 
 * 
 */
@Entity
@Component
public class Client {

	/** Numéro d'identification du client. */
	@Id
	@GeneratedValue()
	private Integer id;
	/**
	 * Nom de famille du client.
	 */
	private String nom;
	/**
	 * Prenom d'usage du client.
	 */
	private String prenom;
	/**
	 * Numero, type et nom de voie de l'adresse du client.
	 */
	private String adresse;
	/**
	 * Code postal de la ville de residence du client.
	 */
	private String codePostal;
	/**
	 * Nom de la ville de residence du client.
	 */
	private String ville;
	/**
	 * Numero de telephone du client.
	 */
	private String telephone;
	/**
	 * Adresse email du client.
	 */
	private String email;

	// Constructeurs
	/**
	 * Constructeur sans argument
	 */
	public Client() {
		super();
	}

	/**
	 * Constructeur a partir des informations personnelles d'un client.
	 * 
	 * @param nom
	 * @param prenom
	 * @param adresse
	 * @param codePostal
	 * @param ville
	 * @param telephone
	 */
	public Client(String nom, String prenom, String adresse, String codePostal, String ville, String telephone) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}

	// Getters & Setters
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getCodePostal() {
		return this.codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getVille() {
		return this.ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	// Affichage
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", telephone=" + telephone + ", id=" + id + "]";
	}

}