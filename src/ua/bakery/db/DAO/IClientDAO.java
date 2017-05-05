package ua.bakery.db.DAO;

import java.util.Collection;

import ua.bakery.db.jpa.Client;
import ua.bakery.db.jpa.Place;

/**
* @author vadym
* @since 0.12
*/
public interface IClientDAO extends IGenericDAO<Client> {
	public void saveClient(Client client);
	public void updateClient(Client client);
	public Client getClientById(Integer client_id);
	public Collection<Client> getClientsByPlace(Place place);
	public Integer getAllClientsCount(); 
	public Collection<Client> getAllClients();
	public void deleteClient(Client client);
}