package ua.bakery.db.DAO.impl;

import ua.bakery.db.DAO.IRequestDAO;
import ua.bakery.db.DAO.factory.DAOFactory;
import ua.bakery.db.jpa.Brak;
import ua.bakery.db.jpa.Request;

import java.util.ArrayList;
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
public class RequestDAOImpl extends GenericDAOImpl<Request> implements IRequestDAO {
	private static final String PERSISTENCE_UNIT_NAME = "CISBakeryJPA";
	private EntityManagerFactory entityMF = null;
	private EntityManager entityMng = null;
	
	
	public RequestDAOImpl() {
		this(Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME));
	}
	
	public RequestDAOImpl (EntityManagerFactory emf) {
		super(Request.class, emf); //Запускаем конструктор для GenericDAOImpl
		this.entityMF = emf;
	}

	@Override
	public void save(Request entity) {
		this.saveRequest(entity);
	}

	@Override
	public void update(Request entity) {
		this.updateRequest(entity);
	}

	@Override
	public void delete(Request entity) {
		this.deleteRequest(entity);
	}

	@Override
	public Request getById(Integer entityId) {
		return this.getRequestById(entityId);
	}

	@Override
	public Integer getAllCount() {
		return this.getAllRequestCount();
	}

	@Override
	public Collection<Request> getAll() {
		return this.getAllRequest();
	}


	@Override
	public void saveRequest(Request request) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.persist(request); // Сохранение экземпляра класса
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
	public void updateRequest(Request request) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.merge(request);
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
	public Request getRequestById(Integer request_id) {
		Request request = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			request = entityMng.find(Request.class, request_id);
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'findById'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return request;
	}

	@Override
	public Integer getAllRequestCount() {
		Integer cnt = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT COUNT obj FROM Request obj");
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
	public Collection<Request> getAllRequest() {
		List<Request> Requests = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT obj from Request obj");
			Requests = (List<Request>)query.getResultList();
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'getAll'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return Requests;
	}

	@Override
	public void deleteRequest(Request request) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.remove(request);
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка при видаленні!", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}
	}


	@Override
	public Collection<Request> getRequestByUserRealName(String name) {
		List<Request> requests = (List<Request>) getAll();
		List<Request> needed = new ArrayList<>();
		
		for(Request r : requests){
			if(r.getUser().getRealName().equals(name))
				needed.add(r);
		}
		
		return needed;
	}
}