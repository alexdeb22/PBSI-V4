package fr.gtm.proxibanquesi.front.beans;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import fr.gtm.proxibanquesi.domaine.Client;


@ManagedBean(name ="ClientBean")
@Scope
@Component
public class ClientBean {
	
	private Client selectedClient;
	private ArrayList<Client> clientList;

	//@Autowired
	//private IServiceClient serviceClient;
	
	@PostConstruct
	public void initBean() {
		selectedClient = null;
		//clientList=new ArrayList<Client>();
		//Client testc = new Client("yael", "candelier", "1 ru blabla", "etampes", "91150", "0671687609");
		//testc.setId(1);
		//c.add(testc);
		
	}
	
	public ClientBean() {
		super();
	}

	public Client getSelectedClient() {
		return selectedClient;
	}

	public void setSelectedClient(Client selectedClient) {
		this.selectedClient = selectedClient;
	}

	public ArrayList<Client> getClientList() {
		ArrayList<Client> test= new ArrayList<Client>();
		Client testc = new Client("yael", "candelier", "1 ru blabla", "etampes", "91150", "0671687609");
		testc.setId(1);
		testc.setEmail("yael.candelier@gmail.com");
		test.add(testc);
		return test;
	}

	public void setClientList(ArrayList<Client> clientList) {
		this.clientList = clientList;
	}
	
	
}
