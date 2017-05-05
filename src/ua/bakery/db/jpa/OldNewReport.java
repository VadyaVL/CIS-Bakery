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
@Table(name = "OldNewReport")
public class OldNewReport extends DomainSuperClass implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date dateTime;
	private boolean old;
	@ManyToOne
	private User user;
	
	@OneToMany(mappedBy="OldNewReport")
	private List<ProductionOldNewReport> productionOldNewReports = new ArrayList<>();

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

	public boolean isOld() {
		return old;
	}

	public void setOld(boolean old) {
		this.old = old;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<ProductionOldNewReport> getProductionOldNewReports() {
		return productionOldNewReports;
	}

	public void setProductionOldNewReports(List<ProductionOldNewReport> productionOldNewReports) {
		this.productionOldNewReports = productionOldNewReports;
	}	
	
}
