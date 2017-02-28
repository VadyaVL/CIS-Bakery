package ua.bakery.db.entity;

import java.util.Date;

import ua.bakery.main.ProgramSettings;

/**
 * Лог дії користувача.
 * @author Vadym
 *
 */
public class Log {
	
	private int id;
	private Date dateTime;
	private String action;
	private User user;
	
	public Log(int id, Date dateTime, String action, User user){
		setId(id);
		setDateTime(dateTime);
		setAction(action);
		setUser(user);
	}
	
	public Log(Date dateTime, String action, User user){
		this(-1, dateTime, action, user);
	}
	
	@Override
	public String toString(){
		return "[" + this.getClass().getName() + "] - id: " + id + ", DateTime: " + ProgramSettings.dateFormat.format(dateTime) +
				", Action: " + action;
	}
	
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the dateTime
	 */
	public Date getDateTime() {
		return dateTime;
	}

	/**
	 * @param dateTime the dateTime to set
	 */
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}

	/**
	 * @return the action
	 */
	public String getAction() {
		return action;
	}

	/**
	 * @param action the action to set
	 */
	public void setAction(String action) {
		this.action = action;
	}

	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}

	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
