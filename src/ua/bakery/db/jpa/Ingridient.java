package ua.bakery.db.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="Ingridient")
public class Ingridient extends DomainSuperClass implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private float countOnStorage;
	
	@OneToMany(mappedBy="Ingridient")
	private List<ProductionIngridient> productionIngridientCount = new ArrayList<>();

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

	public List<ProductionIngridient> getProductionIngridientCount() {
		return productionIngridientCount;
	}

	public void setProductionIngridientCount(List<ProductionIngridient> productionIngridientCount) {
		this.productionIngridientCount = productionIngridientCount;
	}
	
}
