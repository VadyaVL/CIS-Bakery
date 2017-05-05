package ua.bakery.db.DAO;

import java.util.Collection;

import ua.bakery.db.jpa.Client;
import ua.bakery.db.jpa.Place;

/**
* @author vadym
* @since 0.12
*/
public interface IPlaceDAO extends IGenericDAO<Place> {
	public void savePlace(Place place);
	public void updatePlace(Place place);
	public Place getPlaceById(Integer place_id);
	public Integer getAllPlaceCount(); 
	public Collection<Place> getAllPlace();
	public void deletePlace(Place place);
}