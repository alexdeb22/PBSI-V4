package fr.gtm.proxibanquesi.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquesi.dao.IDaoCompte;
import fr.gtm.proxibanquesi.domaine.Compte;

@Transactional
public class TestDaoCompte {
	
	private static IDaoCompte dao;
	private static ApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		dao = (IDaoCompte) context.getBean("daoCompte");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testFindOneIsNotNull() {
		assertNotNull(dao.findOne(1));
	}
	
	@Test
	public void testFindOneReturnCompte(){
		assertTrue(dao.findOne(1) instanceof Compte);
	}

}
