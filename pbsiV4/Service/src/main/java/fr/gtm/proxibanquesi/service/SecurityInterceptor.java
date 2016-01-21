package fr.gtm.proxibanquesi.service;

import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import fr.gtm.proxibanquesi.dao.IDaoTransaction;
import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.domaine.Transaction;


@Aspect
public class SecurityInterceptor {

	@Autowired
	private IDaoTransaction dao;

	public SecurityInterceptor() {
		super();
		System.out.println("Interceptor cree");
	}

	@Pointcut("execution(* fr.gtm.proxibanquesi.service.ServiceCompte.*(. .))")
	public void secure() {
	}

	@Before("secure()")
	public void logAvant(JoinPoint jp) {
		System.out.println("Avant methode");
		Compte source, destination;
		int idDest;
		double montant;
		Object res[] = jp.getArgs();

		if (jp.getSignature().getName().equals("virementIntraClient")) {
			System.out.println("Security Interception avant methode: " + jp.getSignature());
			if (res.length != 0) {
				System.out.println("Arguments transmis :");
				for (int i = 0; i < res.length; i++) {
					System.out.println(res[i]);
				}
				source = (Compte) res[0];
				destination = (Compte) res[1];
				montant = (Double) res[2];
				dao.save(new Transaction(new Date(), source.getNumCompte(), destination.getNumCompte(), montant));
			}
		}

		if (jp.getSignature().getName().equals("virementInterClient")) {
			System.out.println("Security Interception avant methode: " + jp.getSignature());
			if (res.length != 0) {
				System.out.println("Arguments transmis :");
				for (int i = 0; i < res.length; i++) {
					System.out.println(res[i]);
				}
				source = (Compte) res[0];
				idDest = (Integer) res[1];
				montant = (Double) res[2];
				dao.save(new Transaction(new Date(), source.getNumCompte(), idDest, montant));
			}
		}
	}
}


