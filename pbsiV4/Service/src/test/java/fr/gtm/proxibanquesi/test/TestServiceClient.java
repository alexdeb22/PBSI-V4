package fr.gtm.proxibanquesi.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import fr.gtm.proxibanquesi.dao.IDaoClient;
import fr.gtm.proxibanquesi.service.ServiceClient;


public class TestServiceClient {
	
	@Mock
	IDaoClient dao;
	
	ServiceClient ser;

	@Before
	public void setUp(){
		MockitoAnnotations.initMocks(this);
		ser = new ServiceClient();
		ser.setDao(dao);
	}
	
	@Test
	public void testCallFindAll(){
		ser.findAll();
		Mockito.verify(dao).findAll();
		
	}
}
