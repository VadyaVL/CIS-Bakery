package ua.bakery.db.DAO.impl;

import ua.bakery.db.DAO.IEmployeeDAO;
import ua.bakery.db.jpa.Brak;
import ua.bakery.db.jpa.Employee;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityManagerFactory;

/**
* @author vadym
* @since 0.12
*/
public class EmployeeDAOImpl extends GenericDAOImpl<Employee> implements IEmployeeDAO {
	private static final String PERSISTENCE_UNIT_NAME = "CISBakeryJPA";
	private EntityManagerFactory entityMF = null;
	private EntityManager entityMng = null;
	
	
	public EmployeeDAOImpl() {
		this(Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME));
	}
	
	public EmployeeDAOImpl (EntityManagerFactory emf) {
		super(Employee.class, emf); //Запускаем конструктор для GenericDAOImpl
		this.entityMF = emf;
	}

	@Override
	public void save(Employee entity) {
		this.saveEmployee(entity);
	}

	@Override
	public void update(Employee entity) {
		this.updateEmployee(entity);
	}

	@Override
	public void delete(Employee entity) {
		this.deleteEmployee(entity);
	}

	@Override
	public Employee getById(Integer entityId) {
		return this.getEmployeeById(entityId);
	}

	@Override
	public Integer getAllCount() {
		return this.getAllEmployeeCount();
	}

	@Override
	public Collection<Employee> getAll() {
		return this.getAllEmployee();
	}


	@Override
	public void saveEmployee(Employee employee) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.persist(employee); // Сохранение экземпляра класса
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка при збереженні!", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}
	}

	@Override
	public void updateEmployee(Employee employee) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.merge(employee);
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка при оновленні!", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}
	}

	@Override
	public Employee getEmployeeById(Integer employee_id) {
		Employee employee = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			employee = entityMng.find(Employee.class, employee_id);
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'findById'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return employee;
	}

	@Override
	public Integer getAllEmployeeCount() {
		Integer cnt = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT COUNT obj FROM Employee obj");
			cnt = (Integer) query.getSingleResult();
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка ", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return cnt;
	}

	@SuppressWarnings("unchecked")
	@Override
	public Collection<Employee> getAllEmployee() {
		List<Employee> Employees = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT obj from Employee obj");
			Employees = (List<Employee>)query.getResultList();
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'getAll'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return Employees;
	}

	@Override
	public void deleteEmployee(Employee employee) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.remove(employee);
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка при видаленні!", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}
	}
}