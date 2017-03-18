package ua.bakery.db.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "RequestProduction")
public class RequestProduction {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Request request;
	@ManyToOne
	private Production production;
	private int count;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Request getRequest() {
		return request;
	}
	
	public void setRequest(Request request) {
		this.request = request;
	}
	
	public Production getProduction() {
		return production;
	}
	
	public void setProduction(Production production) {
		this.production = production;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
}
