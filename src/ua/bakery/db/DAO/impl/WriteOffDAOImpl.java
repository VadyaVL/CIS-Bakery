package ua.bakery.db.DAO.impl;

import ua.bakery.db.DAO.IWriteOffDAO;
import ua.bakery.db.jpa.Brak;
import ua.bakery.db.jpa.WriteOff;

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
public class WriteOffDAOImpl extends GenericDAOImpl<WriteOff> implements IWriteOffDAO {
	private static final String PERSISTENCE_UNIT_NAME = "CISBakeryJPA";
	private EntityManagerFactory entityMF = null;
	private EntityManager entityMng = null;
	
	
	public WriteOffDAOImpl() {
		this(Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME));
	}
	
	public WriteOffDAOImpl (EntityManagerFactory emf) {
		super(WriteOff.class, emf); //Запускаем конструктор для GenericDAOImpl
		this.entityMF = emf;
	}

	@Override
	public void save(WriteOff entity) {
		this.saveWriteOff(entity);
	}

	@Override
	public void update(WriteOff entity) {
		this.updateWriteOff(entity);
	}

	@Override
	public void delete(WriteOff entity) {
		this.deleteWriteOff(entity);
	}

	@Override
	public WriteOff getById(Integer entityId) {
		return this.getWriteOffById(entityId);
	}

	@Override
	public Integer getAllCount() {
		return this.getAllWriteOffCount();
	}

	@Override
	public Collection<WriteOff> getAll() {
		return this.getAllWriteOff();
	}

	@Override
	public void saveWriteOff(WriteOff writeoff) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.persist(writeoff); // Сохранение экземпляра класса
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
	public void updateWriteOff(WriteOff writeoff) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.merge(writeoff);
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
	public WriteOff getWriteOffById(Integer writeoff_id) {
		WriteOff writeoff = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			writeoff = entityMng.find(WriteOff.class, writeoff_id);
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'findById'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return writeoff;
	}

	@Override
	public Integer getAllWriteOffCount() {
		Integer cnt = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT COUNT obj FROM WriteOff obj");
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
	public Collection<WriteOff> getAllWriteOff() {
		List<WriteOff> WriteOffs = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT obj from WriteOff obj");
			WriteOffs = (List<WriteOff>)query.getResultList();
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'getAll'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return WriteOffs;
	}

	@Override
	public void deleteWriteOff(WriteOff writeoff) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.remove(writeoff);
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