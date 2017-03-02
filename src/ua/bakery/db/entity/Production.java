package ua.bakery.db.entity;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author Vadym
 *
 */
public class Production {
	private int id;
	private String name;
	private float countOnStorage;	// Кількість наявного на складі
	// Реалізація Many-to-Many з додатковим полем ціна
	private Map<Place, Float> placePrice = new LinkedHashMap<>();

	// Реалізація Many-to-Many з додатковим полем кількість
	private Map<Ingridient, Float> ingridientCount = new LinkedHashMap<>();
	
	public Production(int id, String name, float cntOnStorage){
		setId(id);
		setName(name);
		setCountOnStorage(cntOnStorage);
	}
	
	public Production(String name, float cntOnStorage){
		this(-1, name, cntOnStorage);
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public float getCountOnStorage() {
		return countOnStorage;
	}
	
	public void setCountOnStorage(float countOnStorage) {
		this.countOnStorage = countOnStorage;
	}

	public Map<Place, Float> getPlacePrice() {
		return placePrice;
	}

	public void setPlacePrice(Map<Place, Float> placePrice) {
		this.placePrice = placePrice;
	}
	
	
}
