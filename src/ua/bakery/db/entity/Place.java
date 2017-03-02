package ua.bakery.db.entity;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author Vadym
 *
 */
public class Place {
	private int id;
	private String name;
	// Реалізація Many-to-Many з додатковим полем ціна
	private Map<Production, Float> productionPrice = new LinkedHashMap<>();
	
	public Place(int id, String name){
		setId(id);
		setName(name);
	}
	
	public Place(String name){
		this(-1, name);
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

	public Map<Production, Float> getProductionPrice() {
		return productionPrice;
	}

	public void setProductionPrice(Map<Production, Float> productionPrice) {
		this.productionPrice = productionPrice;
	}
	
}
