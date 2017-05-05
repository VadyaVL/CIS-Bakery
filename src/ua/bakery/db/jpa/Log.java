package ua.bakery.db.jpa;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import ua.bakery.services.ProgramSettings;

@Entity
@Table(name="Log")
public class Log extends DomainSuperClass implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	private String action;
	
	@ManyToOne
	private User user;

	@Override
	public String toString(){
		return "[" + this.getClass().getName() + "] - id: " + id + ", DateTime: " + ProgramSettings.dateFormat.format(dateTime) +
				", Action: " + action + ", User: " + this.user.getUsername();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	public String getAction() {
		return action;
	}

	public void setAction(String action) {
		this.action = action;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
