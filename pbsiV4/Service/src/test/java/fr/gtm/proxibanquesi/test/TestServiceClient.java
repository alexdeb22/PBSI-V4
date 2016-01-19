package fr.gtm.proxibanquesi.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.mockito.verification.VerificationMode;

import fr.gtm.proxibanquesi.dao.IDaoClient;
import fr.gtm.proxibanquesi.service.ServiceClient;

@RunWith(MockitoJUnitRunner.class)
public class TestServiceClient {
	@Mock
	IDaoClient dao;
	
	ServiceClient ser;
	VerificationMode vf;

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
