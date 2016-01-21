package fr.gtm.proxibanquesi.front.beans;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Conseiller;
import fr.gtm.proxibanquesi.domaine.Employe;
import fr.gtm.proxibanquesi.domaine.Gerant;
import fr.gtm.proxibanquesi.service.IServiceEmploye;

@ManagedBean
@Scope
@Component
public class LoginBean {
	
	private Employe employe;
	
	private Client nouveauClient;
	
	@Autowired
	private IServiceEmploye serv;
	
	/**
	 * Methode d'initialisation du bean
	 */
	@PostConstruct
	public void initBean() {
		System.out.println("Creation bean login");
		employe = new Conseiller();
		nouveauClient = new Client();
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

	public Client getNouveauClient() {
		return nouveauClient;
	}

	public void setNouveauClient(Client nouveauClient) {
		this.nouveauClient = nouveauClient;
	}

	public String authentification() {
		System.out.println(employe.getLogin() + " " + employe.getMdp() );
		if (serv.findByLoginAndMdp(employe.getLogin(), employe.getMdp()) != null) {
		employe = serv.findByLoginAndMdp(employe.getLogin(), employe.getMdp());
		}
		try {
			((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).login(employe.getLogin(), employe.getMdp());
		} catch (ServletException e) {
			e.printStackTrace();
			return "/faces/erreur.xhtml";
		}
		if (employe instanceof Conseiller) {
		return "/faces/cons/client.xhtml";
		} else if (employe instanceof Gerant) {
			return "/faces/ger/cons.xhtml";
		}
		return "/faces/erreur.xhtml";
	}
	
	public String logout() {
		employe = new Conseiller();
		try {
			((HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest()).logout();
		} catch (ServletException e) {
			e.printStackTrace();
			return "/faces/erreur.xhtml";
		}
		return "/faces/accueil.xhtml";
	}
	
	public String create() {
		System.out.println("appel create client");
		System.out.println("nouveau client :" + nouveauClient);
		((Conseiller) employe).getListeClients().add(nouveauClient);
		serv.createOrUpdate(employe);
		employe = serv.findOne(employe.getId());
		addMessage("Ajout client effectué");
		return "/faces/cons/client.xhtml";
	}
	
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
}
