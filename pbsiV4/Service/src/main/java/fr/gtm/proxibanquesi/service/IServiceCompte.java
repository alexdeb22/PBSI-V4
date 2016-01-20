package fr.gtm.proxibanquesi.service;

import java.util.List;

import fr.gtm.proxibanquesi.domaine.Compte;

/**
 * Interface ServiceCompte. Elle liste les méthodes CRUD d'un compte et une méthode qui retourne la liste de tous les comptes
 *
 */
public interface IServiceCompte {
	
	public Compte findOne(Integer numcompte);
	public List<Compte> findAll();
	public void virementIntraClient(Compte cDeb, Compte cCre, double montant);
	public void virementInterClient(Compte cDeb, Integer numCompteCre, double montant);
	public void createOrUpdate(Compte compte);
	public void delete(Compte compte);
}
