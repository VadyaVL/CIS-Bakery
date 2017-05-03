package ua.bakery.db.jpa;

import java.util.ArrayList;
import java.util.List;

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
	
	@OneToMany(mappedBy="Place")
	private List<ProductPrice> productionPrice = new ArrayList<>();

	@Override
	public String toString(){
		return this.id + " - " + this.name;
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

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public List<ProductPrice> getProductionPrice() {
		return productionPrice;
	}

	public void setProductionPrice(List<ProductPrice> productionPrice) {
		this.productionPrice = productionPrice;
	}
}
