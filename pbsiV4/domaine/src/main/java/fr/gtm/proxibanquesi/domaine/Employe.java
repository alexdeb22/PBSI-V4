package fr.gtm.proxibanquesi.domaine;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;

import org.springframework.stereotype.Component;

/** Classe abstraite representant un employe de la banque.
 * @author Adminl
 *
 */
@Entity
@Component
@Inheritance
@DiscriminatorColumn(name="ROLE")
public abstract class Employe {

	/**
	 * Numero d'identification
	 */
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	/**
	 * Nom de famille.
	 */
	private String nom;
	/**
	 * Prenom usuel.
	 */
	private String prenom;
	/**
	 * Identifiant de connection a l'application.
	 */
	private String login;
	/**
	 * Mot de passe utilise pour la connection.
	 */
	private String mdp;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	@Override
	public String toString() {
		return "Employe [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", login=" + login + ", mdp=" + mdp + "]";
	}


}
