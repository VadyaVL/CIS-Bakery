package ua.bakery.db.jpa;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Request")
public class Request {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_Request;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date_Oformleniya;	// Дата оформлення, дати коректне ім'я
	private boolean ok;				// Чи виконано замовлення

	@ManyToOne
	private Client client;
	@ManyToOne
	private User user;
	
	/*
	// Реалізація Many-to-Many з додатковим полем кількість
	private Map<Production, Float> productionCount = new LinkedHashMap<>();
	
	
	public Map<Production, Float> getProductionCount() {
		return productionCount;
	}

	public void setProductionCount(Map<Production, Float> productionCount) {
		this.productionCount = productionCount;
	}*/


	@Override
	public String toString(){
		return "Заявка №" + id + ": " + date_Oformleniya + ": " + (ok ? "виконано": "не виконано");
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDateRequest() {
		return date_Request;
	}
	
	public void setDateRequest(Date dateRequest) {
		this.date_Request = dateRequest;
	}
	
	public Date getDateOformleniya() {
		return date_Oformleniya;
	}
	
	public void setDateOformleniya(Date dateOformleniya) {
		this.date_Oformleniya = dateOformleniya;
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