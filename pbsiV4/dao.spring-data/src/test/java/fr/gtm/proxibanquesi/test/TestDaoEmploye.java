package fr.gtm.proxibanquesi.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquesi.dao.IDaoEmploye;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.domaine.Employe;
import fr.gtm.proxibanquesi.domaine.Gerant;

@Transactional
public class TestDaoEmploye {
	private static IDaoEmploye dao;
	private static ApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		dao = (IDaoEmploye) context.getBean("daoEmploye");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}
	
//	@Test
//	public void testCreate() {
//		Conseiller cons = new Conseiller("Titi", "titi");
//		cons.setLogin("titi");
//		cons.setMdp("titi");
//		dao.save(cons);
//		assertNotNull(dao.findOne(cons.getId()));
//		Gerant ger = new Gerant("Tata", "tata");
//		ger.setLogin("tata");
//		ger.setMdp("tata");
//		dao.save(ger);
//		assertNotNull(dao.findOne(ger.getId()));
//	}
	
	@Test
	public void testFindByLogAndMdp() {
		Employe emp = dao.findByLoginAndMdp("ger", "ger");
		
		System.out.println(emp);
	}
}
