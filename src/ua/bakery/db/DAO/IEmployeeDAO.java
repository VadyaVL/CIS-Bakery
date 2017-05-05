package ua.bakery.db.DAO;

import java.util.Collection;

import ua.bakery.db.jpa.Employee;

/**
* @author vadym
* @since 0.12
*/
public interface IEmployeeDAO extends IGenericDAO<Employee> {
	public void saveEmployee(Employee employee);
	public void updateEmployee(Employee employee);
	public Employee getEmployeeById(Integer employee_id);
	public Integer getAllEmployeeCount();
	public Collection<Employee> getAllEmployee();
	public void deleteEmployee(Employee employee);
}