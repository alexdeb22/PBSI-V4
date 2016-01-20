package fr.gtm.proxibanquesi.test;


import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.gtm.proxibanquesi.dao.IDaoCompte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
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
	
	@Test
	public void testCallVirementIntra() {
		CompteCourant cDeb = new CompteCourant(500);
		CompteCourant cCre = new CompteCourant(200);
		ser.virementIntraClient(cDeb, cCre, 200);
		Mockito.verify(dao).save(cCre);
		Mockito.verify(dao).save(cDeb);
	}
	
	@Test
	public void testTestVirement() {
		CompteCourant cDeb = new CompteCourant(500);
		CompteCourant cCre = new CompteCourant(200);
		ser.virementIntraClient(cDeb, cCre, 2000);
		Mockito.verify(dao, Mockito.times(0)).save(cCre);
		Mockito.verify(dao, Mockito.times(0)).save(cDeb);
	}
	
	@Test
	public void testVirementIntra() {
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {"service-context.xml","ApplicationContext.xml"});
		ServiceCompte ser2 = (ServiceCompte) context.getBean("serviceCompte");
		System.out.println("Avant : "+ser2.findOne(1).getSolde());
		System.out.println("Avant : "+ser2.findOne(2).getSolde());
		ser2.virementIntraClient(ser2.findOne(1), ser2.findOne(2), 20);
		System.out.println("Après : "+ser2.findOne(1).getSolde());
		System.out.println("Après : "+ser2.findOne(2).getSolde());
	}
	
}
