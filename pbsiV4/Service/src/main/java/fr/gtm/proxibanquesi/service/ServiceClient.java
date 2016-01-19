package fr.gtm.proxibanquesi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.proxibanquesi.dao.IDaoClient;
import fr.gtm.proxibanquesi.domaine.Client;

/**
 * Classe ServiceClient. Elle implemente IServiceClient
 * Elle implemente les méthodes CRUD d'un client et une méthode qui retourne la liste de tous les clients
 *
 */
@Service("serviceClient")
public class ServiceClient implements IServiceClient {
	
	/**
	 * Interface IDAOClient injecté par Spring
	 */
	@Autowired
	private IDaoClient dao;

	/**
	 * Methode qui retourne la liste de tous les clients
	 */
	public List<Client> findAll() {
		return dao.findAll();
	}


	/**
	 * Getter de l'attribut IDaoClient
	 * @return instance du DaoClient
	 */
	public IDaoClient getDao() {
		return dao;
	}

	/**
	 * Setter de l'attribut IDaoClient
	 * @param instance du DaoClient
	 */
	public void setDao(IDaoClient dao) {
		this.dao = dao;
	}
	
	

}
