package fr.gtm.proxibanquesi.test;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import fr.gtm.proxibanquesi.dao.IDaoCompte;
import fr.gtm.proxibanquesi.service.ServiceCompte;

public class TestServiceCompte {
	
	@Mock
	IDaoCompte dao;
	
	ServiceCompte ser;
	
	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		ser = new ServiceCompte();
		ser.setDao(dao);
	}

	@Test
	public void testCallFindOne(){
		ser.findOne(1);
		Mockito.verify(dao).findOne(1);
		
	}
}
