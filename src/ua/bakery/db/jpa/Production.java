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
@Table(name = "Production")
public class Production extends DomainSuperClass implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private float countOnStorage;	// Кількість наявного на складі

	@OneToMany(mappedBy="Production")
	private List<ProductPrice> productionPrice = new ArrayList<ProductPrice>();
	
	@OneToMany(mappedBy="Production")
	private List<ProductionIngridient> productionIngridient = new ArrayList<ProductionIngridient>();
	
	@OneToMany(mappedBy="Production")
	private List<RequestProduction> requestProductionCount = new ArrayList<RequestProduction>();

	@OneToMany(mappedBy="Production")
	private List<WriteOff> writeOffs = new ArrayList<WriteOff>();	
	
	@OneToMany(mappedBy="Production")
	private List<ProductionOldNewReport> productionOldNewReports = new ArrayList<ProductionOldNewReport>();	
	
	@OneToMany(mappedBy="Production")
	private List<Brak> braks = new ArrayList<Brak>();	
	
	@OneToMany(mappedBy="Production")
	private List<Produced> produceds = new ArrayList<Produced>();

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

	public List<ProductPrice> getProductionPrice() {
		return productionPrice;
	}

	public void setProductionPrice(List<ProductPrice> productionPrice) {
		this.productionPrice = productionPrice;
	}

	public List<ProductionIngridient> getProductionIngridient() {
		return productionIngridient;
	}

	public void setProductionIngridient(List<ProductionIngridient> productionIngridient) {
		this.productionIngridient = productionIngridient;
	}

	public List<RequestProduction> getRequestProductionCount() {
		return requestProductionCount;
	}

	public void setRequestProductionCount(List<RequestProduction> requestProductionCount) {
		this.requestProductionCount = requestProductionCount;
	}

	public List<WriteOff> getWriteOffs() {
		return writeOffs;
	}

	public void setWriteOffs(List<WriteOff> writeOffs) {
		this.writeOffs = writeOffs;
	}

	public List<ProductionOldNewReport> getProductionOldNewReports() {
		return productionOldNewReports;
	}

	public void setProductionOldNewReports(List<ProductionOldNewReport> productionOldNewReports) {
		this.productionOldNewReports = productionOldNewReports;
	}

	public List<Brak> getBraks() {
		return braks;
	}

	public void setBraks(List<Brak> braks) {
		this.braks = braks;
	}

	public List<Produced> getProduceds() {
		return produceds;
	}

	public void setProduceds(List<Produced> produceds) {
		this.produceds = produceds;
	}	
	
	@Override
	public String toString(){
		return name;
	}
}
