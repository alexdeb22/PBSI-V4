package fr.gtm.proxibanquesi.service;

import java.util.List;

import fr.gtm.proxibanquesi.domaine.Client;

/**
 * Interface ServiceClient. Elle liste les m�thodes CRUD d'un client et une m�thode qui retourne la liste de tous les clients
 *
 */
public interface IServiceClient {
	
	/**
	 * Methode qui retourne la liste de tous les clients
	 */
	public List<Client> findAll();

}
