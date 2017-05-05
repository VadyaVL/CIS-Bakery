package ua.bakery.db.DAO.impl;

import ua.bakery.db.DAO.IIngridientDAO;
import ua.bakery.db.jpa.Brak;
import ua.bakery.db.jpa.Ingridient;

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
public class IngridientDAOImpl extends GenericDAOImpl<Ingridient> implements IIngridientDAO {
	private static final String PERSISTENCE_UNIT_NAME = "CISBakeryJPA";
	private EntityManagerFactory entityMF = null;
	private EntityManager entityMng = null;
	
	
	public IngridientDAOImpl() {
		this(Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME));
	}
	
	public IngridientDAOImpl (EntityManagerFactory emf) {
		super(Ingridient.class, emf); //Запускаем конструктор для GenericDAOImpl
		this.entityMF = emf;
	}

	@Override
	public void save(Ingridient entity) {
		this.saveIngridient(entity);
	}

	@Override
	public void update(Ingridient entity) {
		this.updateIngridient(entity);
	}

	@Override
	public void delete(Ingridient entity) {
		this.deleteIngridient(entity);
	}

	@Override
	public Ingridient getById(Integer entityId) {
		return this.getIngridientById(entityId);
	}

	@Override
	public Integer getAllCount() {
		return this.getAllIngridientCount();
	}

	@Override
	public Collection<Ingridient> getAll() {
		return this.getAllIngridient();
	}


	@Override
	public void saveIngridient(Ingridient ingridient) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.persist(ingridient); // Сохранение экземпляра класса
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
	public void updateIngridient(Ingridient ingridient) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.merge(ingridient);
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
	public Ingridient getIngridientById(Integer ingridient_id) {
		Ingridient ingridient = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			ingridient = entityMng.find(Ingridient.class, ingridient_id);
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'findById'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return ingridient;
	}

	@Override
	public Integer getAllIngridientCount() {
		Integer cnt = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT COUNT obj FROM Ingridient obj");
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
	public Collection<Ingridient> getAllIngridient() {
		List<Ingridient> Ingridients = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT obj from Ingridient obj");
			Ingridients = (List<Ingridient>)query.getResultList();
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'getAll'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return Ingridients;
	}

	@Override
	public void deleteIngridient(Ingridient ingridient) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.remove(ingridient);
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