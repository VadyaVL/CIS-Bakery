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
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String fullName;
	
	@OneToMany(mappedBy="Employee")
	private List<WriteOff> writeOffs = new ArrayList<>();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public List<WriteOff> getWriteOffs() {
		return writeOffs;
	}

	public void setWriteOffs(List<WriteOff> writeOffs) {
		this.writeOffs = writeOffs;
	}	
		
}