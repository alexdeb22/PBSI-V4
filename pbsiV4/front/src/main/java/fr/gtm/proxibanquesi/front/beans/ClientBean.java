package fr.gtm.proxibanquesi.front.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;
import org.primefaces.event.UnselectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.gtm.proxibanquesi.domaine.Client;



/**
 * @author bobi
 * Managed bean de gestion de la vue client
 * Permet de creer un nouveau client en base, d'afficher la liste des clients, de modifier les information clients et de supprimer un client
 */
@ManagedBean
@Scope
@Component
public class ClientBean implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Client selectedClient;
	private ArrayList<Client> clientList;

	//@Autowired
	//private IServiceClient serviceClient;
	
	/**
	 * Methode d'initialisation du bean
	 */
	@PostConstruct
	public void initBean() {
		clientList= new ArrayList<Client>();
		Client testc = new Client("yael", "candelier", "1 ru blabla", "etampes", "91150", "0671687609");
		Client testc2 = new Client("yael2", "candelier2", "1 ru blabla2", "etampes2", "911502", "0671687609");
		testc.setId(1);testc2.setId(2);
		testc.setEmail("yael.candelier@gmail.com");testc2.setEmail("yael.candelier2@gmail.com");
		clientList.add(testc);clientList.add(testc2);
	}
	
	/**
	 * Constructeur par default du bean
	 */
	public ClientBean() {
		super();
	}

	/**
	 * Mehtode de mise à jour des infos client
	 * @return une chaine de caratere referencant une page xhtml client
	 */
	public String update() {
		
		addMessage("Mise a jour client effectuée");
		return "client";
	}
	
	/**
	 * Méthode de redirection vers la page de gestion de comptes
	 * @return une chaine de caratere referencant une page xhtml comptes
	 */
	public String afficherComptes() {
		if (selectedClient != null)
			return "compte";
		else
			addMessage("Erreur : pas de client selectionné!");
		return "client";
	}
	
	/**
	 * Methode de supression d'un client en base
	 * @return une chaine de caratere referencant la page xhtml client (maj)
	 */
	public String delete()
	{
		addMessage("Supression client effectuée");
		clientList.remove(selectedClient);
		return "client";
	}
	
	/**
	 * Methode d'affichage de notifications 
	 * @param summary le message a emettre
	 */
	public void addMessage(String summary) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, null);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	/**
	 * getter de l'attribut selectedClient
	 * @return
	 */
	public Client getSelectedClient() {
		return selectedClient;
	}

	/**
	 * setter de l'attribut selectedClient
	 * @param selectedClient
	 */
	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}

	/**
	 * getter de l'attribut clientList appel le service d'acces à la couche de persistence
	 * @return la liste des clients en base
	 */
	public ArrayList<Client> getClientList() {
		
		//clientList=(ArrayList<Client>) serviceClient.findAll();
		System.out.println(clientList);
		return clientList;
	}

	/**
	 * setter de l'attribut clientList
	 * @param clientList
	 */
	public void setClientList(ArrayList<Client> clientList) {
		this.clientList = clientList;
	}


	/**
	 * Methode permettant de detecter la selection d'une ligne client en table dans la vue client
	 * @param event l evenement selection
	 */
	public void onClientSelect(SelectEvent event) {
		this.selectedClient = (Client) event.getObject();
		System.out.println("client selectionné" + selectedClient);
	}

	/**
	 * Methode permettant de detecter la deselection d'une ligne client en table dans la vue client
	 * @param event l evenement deselection
	 */
	public void onClientUnselect(UnselectEvent event) {
		System.out.println("unselect");
		this.selectedClient = null;
	}
	
	/**
	 * Methode permettant de detecter la selection d'une ligne client en table dans la vue client
	 * @param event l evenement selection
	 */
	public void rowSelect(SelectEvent event) {
		this.selectedClient = (Client) event.getObject();
	}
}
