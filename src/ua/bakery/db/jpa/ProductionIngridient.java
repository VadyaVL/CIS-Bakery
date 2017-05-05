package ua.bakery.db.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ProductionIngridient")
public class ProductionIngridient extends DomainSuperClass implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Production production;
	@ManyToOne
	private Ingridient ingridient;
	private int count;
	
	@Override
	public String toString(){
		return this.production.getName() + " - " + this.ingridient.getName() + ": " + this.count;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Production getProduction() {
		return production;
	}

	public void setProduction(Production production) {
		this.production = production;
	}

	public Ingridient getIngridient() {
		return ingridient;
	}

	public void setIngridient(Ingridient ingridient) {
		this.ingridient = ingridient;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}
	
}
