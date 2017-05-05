package ua.bakery.db.DAO.impl;

import ua.bakery.db.DAO.IRequestProductionDAO;
import ua.bakery.db.jpa.Brak;
import ua.bakery.db.jpa.RequestProduction;

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
public class RequestProductionDAOImpl extends GenericDAOImpl<RequestProduction> implements IRequestProductionDAO {
	private static final String PERSISTENCE_UNIT_NAME = "CISBakeryJPA";
	private EntityManagerFactory entityMF = null;
	private EntityManager entityMng = null;
	
	
	public RequestProductionDAOImpl() {
		this(Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME));
	}
	
	public RequestProductionDAOImpl (EntityManagerFactory emf) {
		super(RequestProduction.class, emf); //Запускаем конструктор для GenericDAOImpl
		this.entityMF = emf;
	}

	@Override
	public void save(RequestProduction entity) {
		this.saveRequestProduction(entity);
	}

	@Override
	public void update(RequestProduction entity) {
		this.updateRequestProduction(entity);
	}

	@Override
	public void delete(RequestProduction entity) {
		this.deleteRequestProduction(entity);
	}

	@Override
	public RequestProduction getById(Integer entityId) {
		return this.getRequestProductionById(entityId);
	}

	@Override
	public Integer getAllCount() {
		return this.getAllRequestProductionCount();
	}

	@Override
	public Collection<RequestProduction> getAll() {
		return this.getAllRequestProduction();
	}

	@Override
	public void saveRequestProduction(RequestProduction requestproduction) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.persist(requestproduction); // Сохранение экземпляра класса
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
	public void updateRequestProduction(RequestProduction requestproduction) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.merge(requestproduction);
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
	public RequestProduction getRequestProductionById(Integer requestproduction_id) {
		RequestProduction requestproduction = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			requestproduction = entityMng.find(RequestProduction.class, requestproduction_id);
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'findById'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return requestproduction;
	}

	@Override
	public Integer getAllRequestProductionCount() {
		Integer cnt = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT COUNT obj FROM RequestProduction obj");
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
	public Collection<RequestProduction> getAllRequestProduction() {
		List<RequestProduction> RequestProductions = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT obj from RequestProduction obj");
			RequestProductions = (List<RequestProduction>)query.getResultList();
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'getAll'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return RequestProductions;
	}

	@Override
	public void deleteRequestProduction(RequestProduction requestproduction) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.remove(requestproduction);
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