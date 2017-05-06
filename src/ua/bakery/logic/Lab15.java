package ua.bakery.logic;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.persistence.Persistence;

import ua.bakery.db.DAO.IGenericDAO;
import ua.bakery.db.DAO.impl.GenericDAOImpl;
import ua.bakery.db.jpa.Place;
import ua.bakery.db.jpa.ProductPrice;

public class Lab15 {

	private static final String PERSISTENCE_UNIT_NAME = "CISBakeryJPA";

	public static void main(String[] args) {
		// Згенерувати БД з існуючих класів JPA
		/*
		try{
			System.out.println((new Date()) + ": початок генерації БД!");
			Persistence.generateSchema(PERSISTENCE_UNIT_NAME, null);
			System.out.println((new Date()) + ": БД згенеровано успышно!");
		}
		catch(Exception ex){
			System.err.println((new Date()) + ": Помилка: " + ex.getMessage());
		}
		*/
		
		/*
		List<String> places = new ArrayList<>();
		places.add("Рокитне, центр");
		places.add("Біла Церква");
		places.add("Київ");
		
		IGenericDAO<Place> genericDAO = new GenericDAOImpl<Place>(Place.class, 
				Persistence.createEntityManagerFactory("CISBakeryJPA"));
		
		for(String strPlace : places) {
			Place currentPlace = new Place();
			currentPlace.setName(strPlace);
			genericDAO.save(currentPlace);
		}*/

		/*
		List<String> products = new ArrayList<>();
		products.add("Батон");
		products.add("Чорний хліб");
		products.add("Пампушки");
		
		IGenericDAO<Production> genericDAO = new GenericDAOImpl<Production>(Production.class, 
				Persistence.createEntityManagerFactory("CISBakeryJPA"));
		
		for(String strProds : products) {
			Production currentProduction = new Production();
			currentProduction.setName(strProds);
			genericDAO.save(currentProduction);
		}
		*/
		/*
		Random rand = new Random();

		IGenericDAO<Place> placeDAO = new GenericDAOImpl<Place>(Place.class, 
				Persistence.createEntityManagerFactory("CISBakeryJPA"));

		IGenericDAO<Production> productionDAO = new GenericDAOImpl<Production>(Production.class, 
				Persistence.createEntityManagerFactory("CISBakeryJPA"));
		
		IGenericDAO<ProductPrice> productPriceDAO = new GenericDAOImpl<ProductPrice>(ProductPrice.class, 
				Persistence.createEntityManagerFactory("CISBakeryJPA"));

		List<Place> places = (List<Place>) placeDAO.getAll();
		List<Production> produs = (List<Production>) productionDAO.getAll();

		System.out.println(places.size());
		System.out.println(produs.size());
		
		for(Place pl :  places){
			for(Production pr : produs){
				ProductPrice pp = new ProductPrice();
				pp.setPlace(pl);
				pp.setProduction(pr);
				pp.setPrice(rand.nextFloat()*15.0f);
				productPriceDAO.save(pp);
			}
		}
		*/

		IGenericDAO<Place> placeDAO = new GenericDAOImpl<Place>(Place.class, 
				Persistence.createEntityManagerFactory("CISBakeryJPA"));
		System.out.println("Прайс-лист по містам:");
		
		for(Place place : placeDAO.getAll()){
			System.out.println("\nМісто: " + place.getName());
			
			if(place.getProductionPrice().size() == 0 )
				System.out.println("Дані відсутні");
				
			for(ProductPrice pp : place.getProductionPrice()){
				System.out.format("%-25s %25.2f UAH\n", 
						pp.getProduction().getName(), 
						pp.getPrice());
			}
		}
	}
}
