package ua.bakery.db.DAO.dependInjection;

import java.util.Collection;
import java.util.List;

import ua.bakery.db.DAO.IClientDAO;
import ua.bakery.db.jpa.Client;
import ua.bakery.db.jpa.Place;

public class ClientDAO_DI {

	private IClientDAO clientDAO;
	
	public ClientDAO_DI(IClientDAO clientDAO) {
		this.clientDAO = clientDAO;
	}

	public void saveClient(Client client) {
		clientDAO.saveClient(client);
	}

	public void updateClient(Client client) {
		clientDAO.updateClient(client);
	}

	public void deleteClient(Client client) {
		clientDAO.deleteClient(client);
	}

	public Client getClientById(Integer client_id) {
		Client client = clientDAO.getClientById(client_id);
		return client;
	}

	public Integer getAllClientCount() {
		Integer cnt = clientDAO.getAllClientsCount();
		return cnt;
	}

	public Collection<Client> getAllClient() {
		List<Client> clients = (List<Client>) clientDAO.getAllClients();
		return clients;
	}
	
	public Collection<Client> getClientsByPlace(Place place){
		List<Client> clients = (List<Client>) clientDAO.getClientsByPlace(place);
		return clients;
	}
}
