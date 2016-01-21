package fr.gtm.proxibanquesi.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquesi.dao.IDaoClient;
import fr.gtm.proxibanquesi.domaine.Client;


@Transactional
public class TestDaoClient {
	
	private static IDaoClient dao;
	private static ApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		dao = (IDaoClient) context.getBean("daoClient");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testFindAll() {
		System.out.println(dao.findAll());
	}
	
	@Test
	public void testSave() {
		Client newClient = new Client("create","test","lambda","01234","beta","0123456789","gamma@teta.fr");
		dao.save(newClient);
		assertNotNull(dao.findOne(newClient.getId()));
	}
	
	@Test
	public void testDelete() {
		Client newClient = dao.findAll().get(0);
		dao.delete(newClient);
		assertNull(dao.findOne(newClient.getId()));
	}

}
