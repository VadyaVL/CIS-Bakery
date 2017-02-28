package ua.bakery.db.entity;

import java.util.List;

/**
 * Відображає таблицю БД - користувачі.
 * @author Vadym
 *
 */
public class User {
	
	private int id;
	private String username;
	private String password;
	private String realName;
	private String photo;		// Посилання (шлях) на фото
	private int accessLevel;	// Рівень прав доступу, рекомендується замінити на enum
								// 0 - адміністратор, 1 - експедитор, 2 - пакувальник
	
	private List<Log> logs;		// Логи користувача
	
	public User(int id, String username, String password, String realName, String photo, int accessLevel) {
		setId(id);
		setUsername(username);
		setPassword(password);
		setRealName(realName);
		setPhoto(photo);
		setAccessLevel(accessLevel);
	}
	
	public User(String username, String password, String realName, String photo, int accessLevel) {
		this(-1, username, password, realName, photo, accessLevel);
	}
	
	@Override
	public String toString(){
		return "[" + this.getClass().getName() + "] - id: " + id + ", username: " + username + ", password: " +
				password + ", real name: " + realName + ", photo: " + photo + ", access level: " + accessLevel + "\n" +
				"Logs:\n" + getLogsAsString();
	}
	
	public String getLogsAsString(){
		String result = "";
		
		for (Log log : logs) {
			result += log + "\n";
		}
		
		return result;
	}
	
	// Ділянка реалізації getters and setters
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRealName() {
		return realName;
	}
	
	public void setRealName(String realName) {
		this.realName = realName;
	}
	
	public String getPhoto() {
		return photo;
	}
	
	public void setPhoto(String photo) {
		this.photo = photo;
	}
	
	public int getAccessLevel() {
		return accessLevel;
	}
	
	public void setAccessLevel(int accessLevel) {
		this.accessLevel = accessLevel;
	}
	
	public List<Log> getLogs(){
		return logs;
	}
	
	public void setLogs(List<Log> logs){
		this.logs = logs;
	}
}
