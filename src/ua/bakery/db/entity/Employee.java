package ua.bakery.db.entity;

/**
 * ����������� �� �� ��������� � ��, � ������ ����������: �����, ������������� � �.�.
 * ��� ��� ����� ������ �������� - ����� ������ ����� ����� ������� ���������.
 * @author Vadym
 *
 */
public class Employee {

	private int id;
	private String fullName;
	
	public Employee(int id, String fullName){
		setId(id);
		setFullName(fullName);
	}
	
	public Employee(String fullName){
		this(-1, fullName); 
	}
	
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
	
}
