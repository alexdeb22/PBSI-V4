package fr.gtm.proxibanquesi.front.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.domaine.Employe;

@ManagedBean
@Scope
@Component
public class LoginBean {
	
	private Employe employe;
	
	/**
	 * Methode d'initialisation du bean
	 */
	@PostConstruct
	public void initBean() {
		System.out.println("Creation bean login");
		employe = new Conseiller();
	}
	
	@PreDestroy
	public void finBean() {
		System.out.println("Destruction bean login");
	}
	
	/**
	 * Constructeur par default du bean
	 */
	public LoginBean() {
		super();
	}

	public Employe getEmploye() {
		return employe;
	}

	public void setEmploye(Employe employe) {
		this.employe = employe;
	}
	
	public void authentification() {
		
	}
}
