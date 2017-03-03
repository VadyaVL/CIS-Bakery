package ua.bakery.db.entity;

import java.sql.Date;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Виробничий звіт
 * @author Vadym
 *
 */
public class TheProductionReportTeam {

	private int id;
	private Date dateTime;
	private User user;
	

	// Реалізація Many-to-Many з додатковим полем кількість
	private Map<Production, Float> brak = new LinkedHashMap<>();
	private Map<Production, Float> poduced = new LinkedHashMap<>();
	
	public TheProductionReportTeam(int id, Date dateTime, User user){
		setId(id);
		setDateTime(dateTime);
		setUser(user);
	}
	
	public TheProductionReportTeam(Date dateTime, User user){
		this(-1, dateTime, user);
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
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
}
