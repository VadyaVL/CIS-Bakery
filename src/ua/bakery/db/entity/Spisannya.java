package ua.bakery.db.entity;

import java.util.Date;

/**
 * Перейменувати
 * @author Vadym
 *
 */
public class Spisannya {

	private User user;
	private Production production;
	private Employee employee;
	private float count;
	private Date dateTime;
	
	public Spisannya(User user, Production prod, Employee emp, float count, Date dateTime){
		setUser(user);
		setProduction(prod);
		setEmployee(emp);
		setCount(count);
		setDateTime(dateTime);
	}
	
	public User getUser() {
		return user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public Production getProduction() {
		return production;
	}
	
	public void setProduction(Production production) {
		this.production = production;
	}
	
	public Employee getEmployee() {
		return employee;
	}
	
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	
	public float getCount() {
		return count;
	}
	
	public void setCount(float count) {
		this.count = count;
	}
	
	public Date getDateTime() {
		return dateTime;
	}
	
	public void setDateTime(Date dateTime) {
		this.dateTime = dateTime;
	}
	
	
	
}
