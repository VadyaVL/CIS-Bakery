package ua.bakery.db.entity;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;

public class OldNewReport {

	private int id;
	private Date dateTime;
	private boolean old;
	private User user;

	public Map<Production, Float> getProductionCount() {
		return productionCount;
	}

	public void setProductionCount(Map<Production, Float> productionCount) {
		this.productionCount = productionCount;
	}

	// Реалізація Many-to-Many з додатковим полем кількість
	private Map<Production, Float> productionCount = new LinkedHashMap<>();
	
	public OldNewReport(int id, Date date, boolean old, User user){
		setId(id);
		setDateTime(date);
		setOld(old);
		setUser(user);
	}
	
	public OldNewReport(Date date, boolean old, User user){
		this(-1, date, old, user);
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
	
	
	
}
