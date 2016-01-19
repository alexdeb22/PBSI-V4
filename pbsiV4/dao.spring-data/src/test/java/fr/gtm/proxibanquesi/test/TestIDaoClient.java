package fr.gtm.proxibanquesi.test;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import fr.gtm.proxibanquesi.dao.IDaoClient;

public class TestIDaoClient {
	
	@Autowired
	private static IDaoClient dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void testFindAll() {
		System.out.println(dao.findAll());
	}

}
