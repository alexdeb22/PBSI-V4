package fr.gtm.proxibanquesi.domaine;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**Classe representant un gerant d'agence.
 * @author Adminl
 *
 */
@Entity
@DiscriminatorValue("GERANT")
public class Gerant extends Employe {

	/**
	 * Constructeur par defaut.
	 */
	public Gerant() {
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
