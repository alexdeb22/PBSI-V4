package fr.gtm.proxibanquesi.domaine;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/** Classe representant un conseiller de l'agence.
 * @author Adminl
 *
 */
@Entity
@DiscriminatorValue("CONSEILLER")
public class Conseiller extends Employe {

	/**
	 * Liste des clients a la charge du conseiller.
	 */
	@OneToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	private List<Client> listeClients;

	/**
	 * Constructeur par defaut.
	 */
	public Conseiller() {
	}
	
	/** Constructeur a partir d'un nom et d' un prenom.
	 * @param nom
	 * @param prenom
	 */
	public Conseiller(String nom, String prenom) {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
	}

	public List<Client> getListeClients() {
		return listeClients;
	}

	public void setListeClients(List<Client> listeClients) {
		this.listeClients = listeClients;
	}
}
