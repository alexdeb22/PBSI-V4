package fr.gtm.proxibanquesi.front.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.domaine.Employe;
import fr.gtm.proxibanquesi.service.IServiceEmploye;

@ManagedBean
@Scope
@Component
public class LoginBean {
	
	private Employe employe;
	
	@Autowired
	private IServiceEmploye serv;
	
	/**
	 * Methode d'initialisation du bean
	 */
	@PostConstruct
	public void initBean() {
		System.out.println("Creation bean login");
		employe = new Conseiller();
		System.out.println("Employe : " + employe);
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
	
	public IServiceEmploye getServ() {
		return serv;
	}

	public void setServ(IServiceEmploye serv) {
		this.serv = serv;
	}

	public void authentification() {
		employe = serv.findByLoginAndMdp(employe.getLogin(), employe.getMdp());
		System.out.println("Auth");
	}
}
