package ua.bakery.db.DAO.impl;

import ua.bakery.db.DAO.IProducedDAO;
import ua.bakery.db.jpa.Brak;
import ua.bakery.db.jpa.Produced;

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
public class ProducedDAOImpl extends GenericDAOImpl<Produced> implements IProducedDAO {
	private static final String PERSISTENCE_UNIT_NAME = "CISBakeryJPA";
	private EntityManagerFactory entityMF = null;
	private EntityManager entityMng = null;
	
	
	public ProducedDAOImpl() {
		this(Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME));
	}
	
	public ProducedDAOImpl (EntityManagerFactory emf) {
		super(Produced.class, emf); //Запускаем конструктор для GenericDAOImpl
		this.entityMF = emf;
	}

	@Override
	public void save(Produced entity) {
		this.saveProduced(entity);
	}

	@Override
	public void update(Produced entity) {
		this.updateProduced(entity);
	}

	@Override
	public void delete(Produced entity) {
		this.deleteProduced(entity);
	}

	@Override
	public Produced getById(Integer entityId) {
		return this.getProducedById(entityId);
	}

	@Override
	public Integer getAllCount() {
		return this.getAllProducedCount();
	}

	@Override
	public Collection<Produced> getAll() {
		return this.getAllProduced();
	}


	@Override
	public void saveProduced(Produced produced) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.persist(produced); // Сохранение экземпляра класса
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
	public void updateProduced(Produced produced) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.merge(produced);
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
	public Produced getProducedById(Integer produced_id) {
		Produced produced = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			produced = entityMng.find(Produced.class, produced_id);
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'findById'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return produced;
	}

	@Override
	public Integer getAllProducedCount() {
		Integer cnt = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT COUNT obj FROM Produced obj");
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
	public Collection<Produced> getAllProduced() {
		List<Produced> Produceds = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT obj from Produced obj");
			Produceds = (List<Produced>)query.getResultList();
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'getAll'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return Produceds;
	}

	@Override
	public void deleteProduced(Produced produced) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.remove(produced);
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