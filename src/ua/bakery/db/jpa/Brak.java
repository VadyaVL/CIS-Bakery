package ua.bakery.db.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Brak")
public class Brak {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private Production production;
	@ManyToOne
	private ProductionReportTeam productionReportTeam;
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
	public ProductionReportTeam getProductionReportTeam() {
		return productionReportTeam;
	}
	public void setProductionReportTeam(ProductionReportTeam productionReportTeam) {
		this.productionReportTeam = productionReportTeam;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}	
}
