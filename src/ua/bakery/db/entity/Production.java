package ua.bakery.db.entity;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author Vadym
 *
 */
public class Production {
	private int id;
	private String name;
	private float countOnStorage;	// ʳ������ �������� �� �����
	
	// ��������� Many-to-Many � ���������� ����� ����
	private Map<Place, Float> placePrice = new LinkedHashMap<>();

	// ��������� Many-to-Many � ���������� ����� �������
	private Map<Ingridient, Float> ingridientCount = new LinkedHashMap<>();
	
	// ��������� Many-to-Many � ���������� ����� �������
	private Map<Request, Float> requestCount = new LinkedHashMap<>();
	
	// ��������� Many-to-Many � ���������� ����� �������
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

	public Production(int id, String name, float cntOnStorage){
		setId(id);
		setName(name);
		setCountOnStorage(cntOnStorage);
	}
	
	public Production(String name, float cntOnStorage){
		this(-1, name, cntOnStorage);
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
	
	public float getCountOnStorage() {
		return countOnStorage;
	}
	
	public void setCountOnStorage(float countOnStorage) {
		this.countOnStorage = countOnStorage;
	}

	public Map<Place, Float> getPlacePrice() {
		return placePrice;
	}

	public void setPlacePrice(Map<Place, Float> placePrice) {
		this.placePrice = placePrice;
	}
	
	
}
