package fr.gtm.proxibanquesi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.proxibanquesi.dao.IDaoCompte;
import fr.gtm.proxibanquesi.domaine.Compte;

/**
 * Classe ServiceCompte. Elle impl�mente IServiceCompte
 * Elle impl�mente les m�thodes CRUD d'un compte et une m�thode qui retourne la liste de tous les comptes
 *
 */
@Service("serviceCompte")
public class ServiceCompte implements IServiceCompte {
	
	@Autowired
	private IDaoCompte dao;

	/**
	 * Methode qui retourne un compte � partir de son num�ro
	 * @param Integer numcompte : l'identifiant d'un compte
	 */
	public Compte findOne(Integer numcompte) {
		return dao.findOne(numcompte);
	}

	/**
	 * Getter de l'attribut IDaoClient
	 * @return instance du DaoClient
	 */
	public IDaoCompte getDao() {
		return dao;
	}

	
	/**
	 * Setter de l'attribut IDaoClient
	 * @param instance du DaoClient
	 */
	public void setDao(IDaoCompte dao) {
		this.dao = dao;
	}

}
