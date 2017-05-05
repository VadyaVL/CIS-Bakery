package ua.bakery.db.jpa;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
@Table(name = "ProductionReportTeam")
public class ProductionReportTeam extends DomainSuperClass implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	private User user;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;

	@OneToMany(mappedBy="ProductionReportTeam")
	private List<Brak> braks = new ArrayList<>();	
	
	@OneToMany(mappedBy="ProductionReportTeam")
	private List<Produced> produceds = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Date getDateTime() {
		return dateTime;
	}

	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
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
		
}
