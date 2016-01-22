package fr.gtm.proxibanquesi.front.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
import fr.gtm.proxibanquesi.domaine.CompteCourant;
import fr.gtm.proxibanquesi.domaine.CompteEpargne;
import fr.gtm.proxibanquesi.exceptions.CompteInexistantException;
import fr.gtm.proxibanquesi.exceptions.SoldeException;
import fr.gtm.proxibanquesi.service.IServiceClient;
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
	private CompteCourant nouveauCompteCourant;
	private CompteEpargne nouveauCompteEpargne;
	private String typeCompteACree;
	private double option;
	private double solde;

	@Autowired
	private IServiceCompte iservCompte;

	@Autowired
	private IServiceClient iservClient;

	@Value("#{clientBean}")
	private ClientBean ownerBean;

	@PostConstruct
	public void initBean() {
		System.out.println("Creation bean compte");
		System.out.println("Owner= " + ownerBean.getSelectedClient());
		selectedCompte = null;
		destination = null;
		nouveauCompteCourant = new CompteCourant();
		nouveauCompteEpargne = new CompteEpargne();
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
			} else {
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
			iservCompte.virementIntraClient(selectedCompte, destination, montant);
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
		System.out.println("typeCompteACree : " + typeCompteACree);
		System.out.println("option " + option);
		compteList = ownerBean.getSelectedClient().getListeComptes();
		System.out.println(ownerBean.getSelectedClient().getListeComptes());

		if (typeCompteACree.equalsIgnoreCase("COURANT")) {
			nouveauCompteCourant.setDateOuverture(new Date());
			nouveauCompteCourant.setAutorisationDecouvert(option);
			nouveauCompteCourant.setSolde(solde);

			iservCompte.createOrUpdate(nouveauCompteCourant);
			compteList.add(nouveauCompteCourant);
			iservClient.createOrUpdate(ownerBean.getSelectedClient());

		} else if (typeCompteACree.equalsIgnoreCase("EPARGNE")) {
			nouveauCompteEpargne.setDateOuverture(new Date());
			nouveauCompteEpargne.setTauxRemuneration(option);
			nouveauCompteEpargne.setSolde(solde);
			iservCompte.createOrUpdate(nouveauCompteEpargne);
			compteList.add(nouveauCompteEpargne);
			iservClient.createOrUpdate(ownerBean.getSelectedClient());
		} else {
			addMessage("erreur");
		}
		addMessage("Ajout compte effectué");
		return "client";
	}

	public String delete() {
		compteList = ownerBean.getSelectedClient().getListeComptes();
		compteList.remove(selectedCompte);
		System.out.println(compteList);
		System.out.println(ownerBean.getSelectedClient().getListeComptes());
		iservClient.createOrUpdate(ownerBean.getSelectedClient());
		iservCompte.delete(selectedCompte);
		selectedCompte = null;

		addMessage("Supression de compte effectuée");
		return "client";
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

	public CompteCourant getNouveauCompteCourant() {
		return nouveauCompteCourant;
	}

	public void setNouveauCompteCourant(CompteCourant nouveauCompteCourant) {
		this.nouveauCompteCourant = nouveauCompteCourant;
	}

	public CompteEpargne getNouveauCompteEpargne() {
		return nouveauCompteEpargne;
	}

	public void setNouveauCompteEpargne(CompteEpargne nouveauCompteEpargne) {
		this.nouveauCompteEpargne = nouveauCompteEpargne;
	}

	public String getTypeCompteACree() {
		return typeCompteACree;
	}

	public void setTypeCompteACree(String typeCompteACree) {
		this.typeCompteACree = typeCompteACree;
	}

	public double getOption() {
		return option;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public IServiceClient getIservClient() {
		return iservClient;
	}

	public void setIservClient(IServiceClient iservClient) {
		this.iservClient = iservClient;
	}

	public void setOption(double option) {
		this.option = option;
	}

}
