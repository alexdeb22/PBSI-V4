package fr.gtm.proxibanquesi.test;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.proxibanquesi.dao.IDaoCompte;
import fr.gtm.proxibanquesi.service.ServiceClient;
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
	
	@Test
	public void testFindAllDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"service-context.xml","ApplicationContext.xml"});
		ServiceCompte ser2 = (ServiceCompte) context.getBean("serviceCompte");
		System.out.println(ser2.findAll());
	}
}
