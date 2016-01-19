package fr.gtm.proxibanquesi.test;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

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
//		ser.setDao(dao);
	}
	
	@Test
	public void testCallFindAll(){
		ser.findAll();
		Mockito.verify(dao).findAll();
		
	}
	
	@Test
	public void testFindAllDao() {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"service-context.xml","ApplicationContext.xml"});
		ServiceClient ser2 = (ServiceClient) context.getBean("serviceClient");
		System.out.println(ser2.findAll());
	}
}
