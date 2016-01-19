package fr.gtm.proxibanquesi.service;

import fr.gtm.proxibanquesi.domaine.Compte;

/**
 * Interface ServiceCompte. Elle liste les méthodes CRUD d'un compte et une méthode qui retourne la liste de tous les comptes
 *
 */
public interface IServiceCompte {
	
	public Compte findOne(Integer numcompte);

}
