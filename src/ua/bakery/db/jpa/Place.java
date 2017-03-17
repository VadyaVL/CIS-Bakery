package ua.bakery.db.jpa;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Place")
public class Place {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	
	@OneToMany(mappedBy="Place")
	private List<Client> clients = new ArrayList<>();
	
	// Реалізація Many-to-Many з додатковим полем ціна
	//private Map<Production, Float> productionPrice = new LinkedHashMap<>();
	

	
	public int getId() {
		return id;
	}
	
	/**
	 * @return the clents
	 */
	public List<Client> getClients() {
		return clients;
	}

	/**
	 * @param clents the clents to set
	 */
	public void setClients(List<Client> clents) {
		this.clients = clents;
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
/*
	public Map<Production, Float> getProductionPrice() {
		return productionPrice;
	}

	public void setProductionPrice(Map<Production, Float> productionPrice) {
		this.productionPrice = productionPrice;
	}
	*/
}
