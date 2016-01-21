package fr.gtm.proxibanquesi.domaine;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

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

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/** Numéro d'identification du client. */
	@Id
	@SequenceGenerator(name="clientSeq", sequenceName="SEQ_CLIENT", allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="clientSeq")
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
	@OneToMany(fetch=FetchType.EAGER)
	private List<Compte> listeComptes;
	

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
	 * @param email
	 */
	public Client(String nom, String prenom, String adresse, String codePostal, String ville, String telephone, String email) {
		this();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.email = email;
	}

	// Getters & Setters
	/**
	 * Getter de la propriété nom
	 * 
	 * @return La propriété nom
	 */
	public String getNom() {
		return this.nom;
	}

	/**
	 * Setter de la propriété nom
	 * 
	 * @return void
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Getter de la propriété prenom
	 * 
	 * @return La propriété prenom
	 */
	public String getPrenom() {
		return this.prenom;
	}

	/**
	 * Setter de la propriété prenom
	 * 
	 * @return void
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * Getter de la propriété adresse
	 * 
	 * @return La propriété adresse
	 */
	public String getAdresse() {
		return this.adresse;
	}

	/**
	 * Setter de la propriété adresse
	 * 
	 * @return void
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * Getter de la propriété code postal
	 * 
	 * @return La propriété code postal
	 */
	public String getCodePostal() {
		return this.codePostal;
	}

	/**
	 * Setter de la propriété code postal
	 * 
	 * @return void
	 */
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * Getter de la propriété ville
	 * 
	 * @return La propriété ville
	 */
	public String getVille() {
		return this.ville;
	}

	/**
	 * Setter de la propriété ville
	 * 
	 * @return void
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

	/**
	 * Getter de la propriété telephone
	 * 
	 * @return La propriété telephone
	 */
	public String getTelephone() {
		return this.telephone;
	}

	/**
	 * Setter de la propriété telephone
	 * 
	 * @return void
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * Getter de la propriété id
	 * 
	 * @return La propriété id
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * Setter de la propriété id
	 * 
	 * @return void
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * Getter de la propriété email
	 * 
	 * @return La propriété email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Setter de la propriété email
	 * 
	 * @return void
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	public List<Compte> getListeComptes() {
		return listeComptes;
	}

	public void setListeComptes(List<Compte> listeComptes) {
		this.listeComptes = listeComptes;
	}

	// Affichage
	@Override
	public String toString() {
		return "Client [nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + ", codePostal=" + codePostal
				+ ", ville=" + ville + ", telephone=" + telephone + ", id=" + id + ", liste des comptes: " + listeComptes + "]";
	}

}