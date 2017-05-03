package ua.bakery.logic;

import java.util.List;

import ua.bakery.db.DAO.factory.DAOFactory;
import ua.bakery.db.jpa.Client;
import ua.bakery.db.jpa.Place;
import ua.bakery.db.jpa.ProductPrice;

/**
 * ���� ��� ��������� �������� � ����������� ������ �12
 * @author Vadym
 *
 */
public class Lab12 {
	
	public static void main(String[] args) {
		String pattern = "%-40s %10s\n";
		System.out.println("Price-list �� ��������� �� �����:");

		List<Place> places = (List<Place>) DAOFactory.getInstance().getPlaceDAO().getAllPlace();
		
		for(Place place : places){
			System.out.println("\n̳���: " + place.getName());
			
			if(place.getProductionPrice().size() == 0 )
				System.out.println("��� ������");
				
			for(ProductPrice pp : place.getProductionPrice()){
				System.out.format(pattern, 
						pp.getProduction().getName(), 
						Float.toString(pp.getPrice()));
			}
		}
	}
}