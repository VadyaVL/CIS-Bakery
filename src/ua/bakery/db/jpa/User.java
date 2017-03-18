package ua.bakery.db.jpa;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;


@Entity
@Table(name="User")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String username;
	private String password;
	private String realName;
	private String photo;		// Посилання (шлях) на фото
	private int accessLevel;	// Рівень прав доступу, рекомендується замінити на enum

	@OneToMany(mappedBy="user")
	private List<Log> logs = new ArrayList<>();		// Логи користувача

	@OneToMany(mappedBy="user")
	private List<Request> requests = new ArrayList<>();	

	@OneToMany(mappedBy="user")
	private List<WriteOff> writeOffs = new ArrayList<>();	

	@OneToMany(mappedBy="user")
	private List<OldNewReport> OldNewReports = new ArrayList<>();	
	
	@OneToMany(mappedBy="user")
	private List<ProductionReportTeam> productionReportTeams = new ArrayList<>();	
	
	@Override
	public String toString(){
		return /*"[" + this.getClass().getName() + "] - id: " + id + ", username: " + username + ", password: " +
				password + ", real name: " + realName + ", photo: " + photo + ", access level: " + accessLevel + "\n" +
				"Logs:\n"*/ /*+ getLogsAsString()*/ this.realName;
	}

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

	public List<Log> getLogs() {
		return logs;
	}

	public void setLogs(List<Log> logs) {
		this.logs = logs;
	}

	public List<Request> getRequests() {
		return requests;
	}

	public void setRequests(List<Request> requests) {
		this.requests = requests;
	}

	public List<WriteOff> getWriteOffs() {
		return writeOffs;
	}

	public void setWriteOffs(List<WriteOff> writeOffs) {
		this.writeOffs = writeOffs;
	}

	public List<OldNewReport> getOldNewReports() {
		return OldNewReports;
	}

	public void setOldNewReports(List<OldNewReport> oldNewReports) {
		OldNewReports = oldNewReports;
	}

	public List<ProductionReportTeam> getProductionReportTeams() {
		return productionReportTeams;
	}

	public void setProductionReportTeams(List<ProductionReportTeam> productionReportTeams) {
		this.productionReportTeams = productionReportTeams;
	}
	
}
