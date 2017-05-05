package ua.bakery.db.DAO.impl;

import ua.bakery.db.DAO.IUserDAO;
import ua.bakery.db.jpa.Brak;
import ua.bakery.db.jpa.User;

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
public class UserDAOImpl extends GenericDAOImpl<User> implements IUserDAO {
	private static final String PERSISTENCE_UNIT_NAME = "CISBakeryJPA";
	private EntityManagerFactory entityMF = null;
	private EntityManager entityMng = null;
	
	
	public UserDAOImpl() {
		this(Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME));
	}
	
	public UserDAOImpl (EntityManagerFactory emf) {
		super(User.class, emf); //Запускаем конструктор для GenericDAOImpl
		this.entityMF = emf;
	}

	@Override
	public void save(User entity) {
		this.saveUser(entity);
	}

	@Override
	public void update(User entity) {
		this.updateUser(entity);
	}

	@Override
	public void delete(User entity) {
		this.deleteUser(entity);
	}

	@Override
	public User getById(Integer entityId) {
		return this.getUserById(entityId);
	}

	@Override
	public Integer getAllCount() {
		return this.getAllUserCount();
	}

	@Override
	public Collection<User> getAll() {
		return this.getAllUser();
	}

	@Override
	public void saveUser(User user) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.persist(user); // Сохранение экземпляра класса
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
	public void updateUser(User user) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.merge(user);
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
	public User getUserById(Integer user_id) {
		User user = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			user = entityMng.find(User.class, user_id);
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'findById'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return user;
	}

	@Override
	public Integer getAllUserCount() {
		Integer cnt = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT COUNT obj FROM User obj");
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
	public Collection<User> getAllUser() {
		List<User> Users = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT obj from User obj");
			Users = (List<User>)query.getResultList();
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'getAll'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return Users;
	}

	@Override
	public void deleteUser(User user) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.remove(user);
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