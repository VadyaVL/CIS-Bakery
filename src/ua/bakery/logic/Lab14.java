package ua.bakery.logic;

import javax.persistence.Persistence;

import ua.bakery.db.DAO.IGenericDAO;
import ua.bakery.db.DAO.impl.GenericDAOImpl;
import ua.bakery.db.jpa.Client;
import ua.bakery.db.jpa.Place;
import ua.bakery.db.jpa.ProductPrice;

/**
 * Клас для реалізації завдання з лабораторної роботи №14
 * @author Vadym
 * @deprecated
 */
public class Lab14 {

	public static void main(String[] args) {

		IGenericDAO<Client> clientDAO = new GenericDAOImpl<Client>(Client.class, 
				Persistence.createEntityManagerFactory("CISBakeryJPA"));
		IGenericDAO<Place> placesDAO = new GenericDAOImpl<Place>(Place.class, 
				Persistence.createEntityManagerFactory("CISBakeryJPA"));
		
		
		String pattern = "%-35s %35s\n";
		System.out.println("Всі клієнти:");
		for(Client client : clientDAO.getAll()){
			System.out.format(pattern, client.getName(), client.getPlace().getName());
		}

		System.out.println("*********************");
		System.out.println("Прайс-лист по містам:");
		
		for(Place place : placesDAO.getAll()){
			System.out.println("\nМісто: " + place.getName());
			
			if(place.getProductionPrice().size() == 0 )
				System.out.println("Дані відсутні");
				
			for(ProductPrice pp : place.getProductionPrice()){
				System.out.format(pattern, 
						pp.getProduction().getName(), 
						Float.toString(pp.getPrice()));
			}
		}
		
	}

}
