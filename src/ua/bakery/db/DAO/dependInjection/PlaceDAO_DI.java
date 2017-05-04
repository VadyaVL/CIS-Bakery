package ua.bakery.db.DAO.dependInjection;

import java.util.Collection;
import java.util.List;

import ua.bakery.db.DAO.IPlaceDAO;
import ua.bakery.db.jpa.Place;

public class PlaceDAO_DI {

	private IPlaceDAO placeDAO;
	
	public PlaceDAO_DI(IPlaceDAO placeDAO) {
		this.placeDAO = placeDAO;
	}

    
	public void savePlace(Place place) {
		placeDAO.savePlace(place);
	}

	public void updatePlace(Place place) {
		placeDAO.updatePlace(place);
	}

	public void deletePlace(Place place) {
		placeDAO.deletePlace(place);
	}

	public Place getPlaceById(Integer place_id) {
		Place place = placeDAO.getPlaceById(place_id);
		return place;
	}

	public Integer getAllPlaceCount() {
		Integer cnt = placeDAO.getAllPlaceCount();
		return cnt;
	}

	public Collection<Place> getAllPlace() {
		List<Place> places = (List<Place>) placeDAO.getAllPlace();
		return places;
	}


}
