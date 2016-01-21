package fr.gtm.proxibanquesi.service;

import fr.gtm.proxibanquesi.domaine.Employe;

/**
 * Interface ServiceEmploye. Elle liste les m�thodes CRUD d'un employ�.
 *
 */
public interface IServiceEmploye {

	public Employe findByLoginAndMdp(String login, String mdp);
	public Employe findOne(Integer id);
	public void createOrUpdate(Employe employe);
}
