package fr.gtm.proxibanquesi.service;

import java.util.List;

import fr.gtm.proxibanquesi.domaine.Client;

public interface IServiceClient {
	
	public List<Client> findAll();

}
