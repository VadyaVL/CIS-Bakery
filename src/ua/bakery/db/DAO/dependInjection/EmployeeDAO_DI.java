package ua.bakery.db.DAO.dependInjection;

import java.util.Collection;
import java.util.List;

import ua.bakery.db.DAO.IEmployeeDAO;
import ua.bakery.db.jpa.Employee;

public class EmployeeDAO_DI {

	private IEmployeeDAO employeeDAO;
	
	public EmployeeDAO_DI(IEmployeeDAO employeeDAO) {
		this.employeeDAO = employeeDAO;
	}

    
	public void saveEmployee(Employee employee) {
		employeeDAO.saveEmployee(employee);
	}

	public void updateEmployee(Employee employee) {
		employeeDAO.updateEmployee(employee);
	}

	public void deleteEmployee(Employee employee) {
		employeeDAO.deleteEmployee(employee);
	}

	public Employee getEmployeeById(Integer employee_id) {
		Employee employee = employeeDAO.getEmployeeById(employee_id);
		return employee;
	}

	public Integer getAllEmployeeCount() {
		Integer cnt = employeeDAO.getAllEmployeeCount();
		return cnt;
	}

	public Collection<Employee> getAllEmployee() {
		List<Employee> employees = (List<Employee>) employeeDAO.getAllEmployee();
		return employees;
	}


}
