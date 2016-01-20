package fr.gtm.proxibanquesi.front.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.gtm.proxibanquesi.domaine.Client;
import fr.gtm.proxibanquesi.domaine.Compte;

@ManagedBean
@Scope
@Component
public class CompteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Compte selectedCompte;
	private List<Compte> compteList;
	
	@Value("#{clientBean}")
	private ClientBean ownerBean;

	@PostConstruct
	public void initBean() {
		System.out.println("Creation bean compte");
		System.out.println("Owner= " + ownerBean.getSelectedClient());
//		compteList = ownerBean.getSelectedClient().getListeComptes();
//		WebApplicationContext context = ContextLoader.getCurrentWebApplicationContext();
//		ClientBean clibean = (ClientBean) context.getBean("clientBean");
//		owner = clibean.getSelectedClient();
		
//		System.out.println("Proprietaire" + owner);
//		selectedCompte = null;
//		compteList = owner.getListeComptes();
		
		// compteList= new ArrayList<Compte>();
		// CompteCourant testc = new CompteCourant(1566.60);
		// CompteEpargne testc2 = new CompteEpargne(500.00);
		// testc.setNumCompte(1);testc2.setNumCompte(2);
		// testc.setDateOuverture(new Date());testc2.setDateOuverture(new
		// Date());
		// compteList.add(testc);compteList.add(testc2);
	}

	@PreDestroy
	public void finBean() {
		System.out.println("Destruction du bean compte");
	}
	
	public CompteBean() {
		super();
	}

	public String update() {

		addMessage("Mise a jour compte effectuée");
		return "compte";
	}

	public String virement() {
		addMessage("Virement effectué");
		return "compte";
	}

	public String create() {
		addMessage("Ajout compte effectué");
		return "compte";
	}

	public String delete() {
		addMessage("Supression de compte effectuée");
		return "compte";
	}

	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public Compte getSelectedCompte() {
		return selectedCompte;
	}

	public void setSelectedCompte(Compte selectedCompte) {
		this.selectedCompte = selectedCompte;
	}

	public List<Compte> getCompteList() {
		return compteList;
	}

	public void setCompteList(ArrayList<Compte> compteList) {
		this.compteList = compteList;
	}

	public ClientBean getOwnerBean() {
		return ownerBean;
	}

	public void setOwnerBean(ClientBean ownerBean) {
		this.ownerBean = ownerBean;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public void onCompteSelect(SelectEvent event) {
		this.selectedCompte = (Compte) event.getObject();
		System.out.println("compte selectionné" + selectedCompte);
	}

	public void onCompteUnselect(UnselectEvent event) {
		System.out.println("unselect");
		this.selectedCompte = null;
	}

	public void rowSelect(SelectEvent event) {
		this.selectedCompte = (Compte) event.getObject();
	}

}
