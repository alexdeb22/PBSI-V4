package fr.gtm.proxibanquesi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("serviceClient")
public class ServiceClient implements IServiceClient {
	
	@Autowired
	private IDaoClient dao;

	public List<Client> findAll() {
		return dao.findAll();
	}

	public IDaoClient getDao() {
		return dao;
	}

	public void setDao(IDaoClient dao) {
		this.dao = dao;
	}
	
	

}
