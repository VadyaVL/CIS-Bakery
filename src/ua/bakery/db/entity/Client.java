package ua.bakery.db.entity;

/**
 * 
 * @author Vadym
 *
 */
public class Client {
	private int id;
	private String name;
	private Place place;
		
	public Client(int id, String name){
		setId(id);
		setName(name);
	}
	
	public Client(String name){
		this(-1, name);
	}
	
	@Override
	public String toString(){
		return " Î≥∫ÌÚ π" + id + ": " + name;
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
	
	public Place getPlace() {
		return place;
	}
	
	public void setPlace(Place place) {
		this.place = place;
	}
}
