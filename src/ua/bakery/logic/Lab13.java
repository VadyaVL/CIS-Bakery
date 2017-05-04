package ua.bakery.logic;

import java.util.List;

import ua.bakery.db.DAO.dependInjection.ClientDAO_DI;
import ua.bakery.db.DAO.factory.DAOFactory;
import ua.bakery.db.DAO.impl.ClientDAOImpl;
import ua.bakery.db.jpa.Client;
import ua.bakery.db.jpa.Place;
import ua.bakery.db.jpa.ProductPrice;

public class Lab13 {

	public static void main(String[] args) {
		String pattern = "%-35s %35s\n";
		ClientDAO_DI diClient = new ClientDAO_DI(new ClientDAOImpl());
		System.out.println("Всі клієнти:");
		for(Client client : diClient.getAllClient()){
			System.out.format(pattern, client.getName(), client.getPlace().getName());
		}

		System.out.println("*********************");
		System.out.println("Прайс-лист по містам:");
		List<Place> places = (List<Place>) DAOFactory.getInstance().getPlaceDAO().getAllPlace();
		
		for(Place place : places){
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
