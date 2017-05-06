package ua.bakery.db.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Request")
public class Request extends DomainSuperClass implements Serializable {
	
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

	@OneToMany(mappedBy="Request", cascade = CascadeType.ALL)	// PERSIST - при видаленні виникла помилка
	private List<RequestProduction> requestProductionCount = new ArrayList<RequestProduction>();

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

	public Date getDate_Request() {
		return date_Request;
	}

	public void setDate_Request(Date date_Request) {
		this.date_Request = date_Request;
	}

	public Date getDate_Oformleniya() {
		return date_Oformleniya;
	}

	public void setDate_Oformleniya(Date date_Oformleniya) {
		this.date_Oformleniya = date_Oformleniya;
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

	public List<RequestProduction> getRequestProductionCount() {
		return requestProductionCount;
	}

	public void setRequestProductionCount(List<RequestProduction> requestProductionCount) {
		this.requestProductionCount = requestProductionCount;
	}
	
}