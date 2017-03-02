package ua.bakery.db.entity;

import java.util.Date;

/**
 * 
 * @author Vadym
 *
 */
public class Request {
	private int id;
	private Date dateRequest;
	private Date dateOformleniya;	// Дата оформлення, дати коректне ім'я
	private boolean ok;				// Чи виконано замовлення

	private Client client;
	private User user;
	
	
	public Request(int id, Date dR, Date dO, boolean ok){
		setId(id);
		setDateRequest(dR);
		setDateOformleniya(dO);
		setOk(ok);
	}
	
	public Request(Date dR, Date dO, boolean ok){
		this(-1, dR, dO, ok); 
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
