package fr.gtm.proxibanquesi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.gtm.proxibanquesi.dao.IDaoCompte;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.exceptions.CompteInexistantException;
import fr.gtm.proxibanquesi.exceptions.SoldeException;

/**
 * Classe ServiceCompte. Elle implémente IServiceCompte Elle implémente les
 * méthodes CRUD d'un compte et une méthode qui retourne la liste de tous les
 * comptes
 *
 */
@Service("serviceCompte")
public class ServiceCompte implements IServiceCompte {

	@Autowired
	private IDaoCompte dao;

	/**
	 * Methode qui retourne un compte à partir de son numéro
	 * 
	 * @param Integer
	 *            numcompte : l'identifiant d'un compte
	 */
	public Compte findOne(Integer numcompte) {
		return dao.findOne(numcompte);
	}

	/** Methode qui retourne tous les comptes
	 * @return
	 */
	public List<Compte> findAll() {
		return dao.findAll();
	}
	


	/**
	 * Getter de l'attribut IDaoClient
	 * 
	 * @return instance du DaoClient
	 */
	public IDaoCompte getDao() {
		return dao;
	}

	/**
	 * Setter de l'attribut IDaoClient
	 * 
	 * @param instance
	 *            du DaoClient
	 */
	public void setDao(IDaoCompte dao) {
		this.dao = dao;
	}

	public void virementIntraClient(Compte cDeb, Compte cCre, double montant) throws SoldeException {
		if (cDeb instanceof CompteEpargne && cDeb.getSolde() >= montant || cDeb instanceof CompteCourant && cDeb.getSolde()+ ((CompteCourant)cDeb).getAutorisationDecouvert() >= montant) {
			cDeb.setSolde(cDeb.getSolde()-montant);
			cCre.setSolde(cCre.getSolde()+montant);
			dao.save(cDeb);
			dao.save(cCre);
		} else {
			throw new SoldeException();
		}
		
	}

	public void createOrUpdate(Compte compte) {
		dao.save(compte);
	}

	public void delete(Compte compte) {
		dao.delete(compte);
	}


	public void virementInterClient(Compte cDeb, Integer numCompteCre, double montant) throws SoldeException, CompteInexistantException {
		Compte cCre = dao.findOne(numCompteCre);
		if (null==cCre) throw new CompteInexistantException();
		if (cDeb instanceof CompteEpargne && cDeb.getSolde() >= montant || cDeb instanceof CompteCourant && cDeb.getSolde()+ ((CompteCourant)cDeb).getAutorisationDecouvert() >= montant) {
			cDeb.setSolde(cDeb.getSolde()-montant);
			cCre.setSolde(cCre.getSolde()+montant);
			dao.save(cDeb);
			dao.save(cCre);
		} else {
			throw new SoldeException();
		}
	}

}
