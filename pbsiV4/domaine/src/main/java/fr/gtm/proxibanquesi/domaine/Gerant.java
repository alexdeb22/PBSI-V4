package fr.gtm.proxibanquesi.domaine;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**Classe representant un gerant d'agence.
 * @author Adminl
 *
 */
@Entity
@DiscriminatorValue("GERANT")
public class Gerant extends Employe {

	/**
	 * Liste des clients a la charge du conseiller.
	 */
	@OneToMany(fetch=FetchType.EAGER)
	private List<Conseiller> listeConseillers;
	
	/**
	 * Constructeur par defaut.
	 */
	public Gerant() {
	}
	
	public List<Conseiller> getListeConseillers() {
		return listeConseillers;
	}

	public void setListeConseillers(List<Conseiller> listeConseillers) {
		this.listeConseillers = listeConseillers;
	}

	/** Constructeur a partir d'un nom et d' un prenom.
	 * @param nom
	 * @param prenom
	 */
	public Gerant(String nom, String prenom) {
		super();
		this.setNom(nom);
		this.setPrenom(prenom);
	}
}
