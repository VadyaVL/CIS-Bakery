package ua.bakery.db.entity;

import java.util.LinkedHashMap;
import java.util.Map;

public class Ingridient {

	private int id;
	private String name;
	private float countOnStorage;	// Кількість наявного на складі
	
	// Реалізація Many-to-Many з додатковим полем кількість
	private Map<Production, Float> productionCount = new LinkedHashMap<>();
	
	public Ingridient(int id, String name, float countOnStorage){
		setId(id);
		setName(name);
		setCountOnStorage(countOnStorage);
	}
	
	public Ingridient(String name, float countOnStorage){
		this(-1, name, countOnStorage);
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
	
}
