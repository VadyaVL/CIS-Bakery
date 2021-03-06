package ua.bakery.db.entity;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author Vadym
 *
 */
public class Request {
	private int id;
	private Date dateRequest;
	private Date dateOformleniya;	// ���� ����������, ���� �������� ��'�
	private boolean ok;				// �� �������� ����������

	private Client client;
	private User user;
	
	// ��������� Many-to-Many � ���������� ����� �������
	private Map<Production, Float> productionCount = new LinkedHashMap<>();
	
	
	public Map<Production, Float> getProductionCount() {
		return productionCount;
	}

	public void setProductionCount(Map<Production, Float> productionCount) {
		this.productionCount = productionCount;
	}

	public Request(int id, Date dR, Date dO, boolean ok){
		setId(id);
		setDateRequest(dR);
		setDateOformleniya(dO);
		setOk(ok);
	}
	
	public Request(Date dR, Date dO, boolean ok){
		this(-1, dR, dO, ok); 
	}
	

	@Override
	public String toString(){
		return "������ �" + id + ": " + dateOformleniya + ": " + (ok ? "��������": "�� ��������");
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDateRequest() {
		return dateRequest;
	}
	
	public void setDateRequest(Date dateRequest) {
		this.dateRequest = dateRequest;
	}
	
	public Date getDateOformleniya() {
		return dateOformleniya;
	}
	
	public void setDateOformleniya(Date dateOformleniya) {
		this.dateOformleniya = dateOformleniya;
	}
	
	public boolean isOk() {
		return ok;
	}
	
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	
	public Client getClient() {
		return client;
	}
	
	public void setClient(Client client) {
		this.client = client;
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
}