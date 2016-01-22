package fr.gtm.proxibanquesi.front.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.gtm.proxibanquesi.domaine.Compte;
import fr.gtm.proxibanquesi.exceptions.CompteInexistantException;
import fr.gtm.proxibanquesi.exceptions.SoldeException;
import fr.gtm.proxibanquesi.service.IServiceCompte;


@ManagedBean
@Scope()
@Component
public class CompteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Compte selectedCompte;
	private List<Compte> compteList;
	private Compte destination;
	private double montant;
	private int idCompteExterneDestination;
	
	@Autowired
	private IServiceCompte iservCompte;

	@Value("#{clientBean}")
	private ClientBean ownerBean;

	@PostConstruct
	public void initBean() {
		System.out.println("Creation bean compte");
		System.out.println("Owner= " + ownerBean.getSelectedClient());
		selectedCompte = null;
		destination=null;
	}

	@PreDestroy
	public void finBean() {
		System.out.println("Destruction du bean compte");
	}

	public CompteBean() {
		super();
	}

	public String virementInit() {
		System.out.println("Owner= " + ownerBean.getSelectedClient());
		compteList = ownerBean.getSelectedClient().getListeComptes();

		if (compteList.size() == 2) {

			if (selectedCompte.toString().equalsIgnoreCase("COURANT")) {
				if (compteList.get(0).toString().equalsIgnoreCase("COURANT")) {
					destination = compteList.get(1);
				} else {
					destination = compteList.get(0);
				}
			} else if (selectedCompte.toString().equalsIgnoreCase("EPARGNE")) {
				if (compteList.get(0).toString().equalsIgnoreCase("EPARGNE")) {
					destination = compteList.get(1);
				} else {
					destination = compteList.get(0);
				}
			}
			else {
				addMessage("erreur type de compte inconnu");
			}
		} else {
			addMessage("erreur pas 2 comptes presents");
		}
		System.out.println(destination);
		return "compte";
	}

	public String update() {

		System.out.println("appel update compte");
		addMessage("Mise a jour compte effectuée");
		return "compte";
	}

	public String virement() {
		System.out.println("appel virement compte");
		try {
			iservCompte.virementIntraClient(selectedCompte, destination,montant);
		} catch (SoldeException e) {
			addMessage(e.getMessage());
			return "compte";
		}
		addMessage("Virement effectué");
		return "compte";
	}
	
	public void virementExterne() {
		System.out.println("appel virement externe compte");
		try {
			iservCompte.virementInterClient(selectedCompte, idCompteExterneDestination, montant);
			addMessage("Virement effectué");
		} catch (SoldeException e) {
			addMessage(e.getMessage());
		} catch (CompteInexistantException e) {
			addMessage(e.getMessage());
		}

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

	public Compte getDestination() {
		return destination;
	}

	public void setDestination(Compte destination) {
		this.destination = destination;
	}

	public double getMontant() {
		return montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}

	public int getIdCompteExterneDestination() {
		return idCompteExterneDestination;
	}

	public void setIdCompteExterneDestination(int idCompteExterneDestination) {
		this.idCompteExterneDestination = idCompteExterneDestination;
	}

	public void setCompteList(List<Compte> compteList) {
		this.compteList = compteList;
	}

	public IServiceCompte getIservCompte() {
		return iservCompte;
	}

	public void setIservCompte(IServiceCompte iservCompte) {
		this.iservCompte = iservCompte;
	}
	
	

}
