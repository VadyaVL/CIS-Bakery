package ua.bakery.logic;

import java.util.List;

import ua.bakery.db.DAO.factory.DAOFactory;
import ua.bakery.db.jpa.Client;
import ua.bakery.db.jpa.Place;
import ua.bakery.db.jpa.ProductPrice;

/**
 * Клас для реалізації завдання з лабораторної роботи №12
 * @author Vadym
 *
 */
public class Lab12 {
	
	public static void main(String[] args) {
		String pattern = "%-40s %10s\n";
		System.out.println("Price-list на продукцію по містам:");

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