package ua.bakery.db.jpa;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ProductionOldNewReport")
public class ProductionOldNewReport extends DomainSuperClass implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Production production;
	@ManyToOne
	private OldNewReport oldNewReport;
	private int count;
	
	
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
	
	public OldNewReport getOldNewReport() {
		return oldNewReport;
	}
	
	public void setOldNewReport(OldNewReport oldNewReport) {
		this.oldNewReport = oldNewReport;
	}
	
	public int getCount() {
		return count;
	}
	
	public void setCount(int count) {
		this.count = count;
	}
	
	
	
	
}
