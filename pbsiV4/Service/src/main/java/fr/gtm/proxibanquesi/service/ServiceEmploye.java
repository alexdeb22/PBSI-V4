package fr.gtm.proxibanquesi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.proxibanquesi.dao.IDaoEmploye;
import fr.gtm.proxibanquesi.domaine.Employe;

/**
 * Classe ServiceEmploye. Elle implémente IServiceEmploye
 * Elle implémente les méthodes CRUD d'un employé.
 *
 */
@Service("serviceEmploye")
public class ServiceEmploye implements IServiceEmploye {

	@Autowired
	IDaoEmploye dao;
	
	public Employe findByLoginAndMdp(String login, String mdp) {
		return dao.findByLoginAndMdp(login, mdp);
	}

	public void createOrUpdate(Employe employe) {
		dao.save(employe);
	}

	public Employe findOne(Integer id) {
		return dao.findOne(id);
	}

}
