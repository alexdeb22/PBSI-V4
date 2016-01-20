package fr.gtm.proxibanquesi.test;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import fr.gtm.proxibanquesi.dao.IDaoClient;


@Transactional
public class TestIDaoClient {
	
	private static IDaoClient dao;
	private static ApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
		dao = (IDaoClient) context.getBean("dao");
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testFindAll() {
		System.out.println(dao.findAll());
	}

}
