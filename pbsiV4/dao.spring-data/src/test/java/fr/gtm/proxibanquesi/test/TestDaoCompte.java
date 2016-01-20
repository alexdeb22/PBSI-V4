package fr.gtm.proxibanquesi.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquesi.dao.IDaoCompte;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;

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
	
	@Test
	public void testCreateCompte() {
		CompteCourant compte = new CompteCourant(5000);
		compte.setDateOuverture(new Date());
		dao.save(compte);
		assertNotNull(dao.findOne(compte.getNumCompte()));
		CompteEpargne compte2 = new CompteEpargne(5000);
		compte2.setDateOuverture(new Date());
		dao.save(compte2);
		assertNotNull(dao.findOne(compte2.getNumCompte()));
	}
	
	@Test
	public void testFindAll() {
		System.out.println(dao.findAll());
		assertNotNull(dao.findAll());
	}

}
