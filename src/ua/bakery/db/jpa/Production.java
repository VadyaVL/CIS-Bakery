package ua.bakery.db.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Production")
public class Production {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private float countOnStorage;	// Кількість наявного на складі
	
	/*
	// Реалізація Many-to-Many з додатковим полем ціна
	private Map<Place, Float> placePrice = new LinkedHashMap<>();

	// Реалізація Many-to-Many з додатковим полем кількість
	private Map<Ingridient, Float> ingridientCount = new LinkedHashMap<>();
	
	// Реалізація Many-to-Many з додатковим полем кількість
	private Map<Request, Float> requestCount = new LinkedHashMap<>();
	
	// Реалізація Many-to-Many з додатковим полем кількість
	private Map<OldNewReport, Float> oldNewReportCount = new LinkedHashMap<>();
	

	public Map<Request, Float> getRequestCount() {
		return requestCount;
	}

	public void setRequestCount(Map<Request, Float> requestCount) {
		this.requestCount = requestCount;
	}

	public Map<OldNewReport, Float> getOldNewReportCount() {
		return oldNewReportCount;
	}

	public void setOldNewReportCount(Map<OldNewReport, Float> oldNewReportCount) {
		this.oldNewReportCount = oldNewReportCount;
	}

	public Map<TheProductionReportTeam, Float> getBrak() {
		return brak;
	}

	public void setBrak(Map<TheProductionReportTeam, Float> brak) {
		this.brak = brak;
	}

	public Map<TheProductionReportTeam, Float> getPoduced() {
		return poduced;
	}

	public void setPoduced(Map<TheProductionReportTeam, Float> poduced) {
		this.poduced = poduced;
	}

	private Map<TheProductionReportTeam, Float> brak = new LinkedHashMap<>();
	private Map<TheProductionReportTeam, Float> poduced = new LinkedHashMap<>();
	
	public Map<Ingridient, Float> getIngridientCount() {
		return ingridientCount;
	}

	public void setIngridientCount(Map<Ingridient, Float> ingridientCount) {
		this.ingridientCount = ingridientCount;
	}

	public Map<Place, Float> getPlacePrice() {
		return placePrice;
	}

	public void setPlacePrice(Map<Place, Float> placePrice) {
		this.placePrice = placePrice;
	}
	*/
	
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
