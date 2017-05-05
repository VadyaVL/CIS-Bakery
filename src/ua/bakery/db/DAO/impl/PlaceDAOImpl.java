package ua.bakery.db.DAO.impl;

import ua.bakery.db.DAO.IPlaceDAO;
import ua.bakery.db.jpa.Brak;
import ua.bakery.db.jpa.Client;
import ua.bakery.db.jpa.Place;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 * @author vadym
 * @since 0.12
 */
public class PlaceDAOImpl extends GenericDAOImpl<Place> implements IPlaceDAO {
	private static final String PERSISTENCE_UNIT_NAME = "CISBakeryJPA";
	private EntityManagerFactory entityMF = null;
	private EntityManager entityMng = null;

	
	public PlaceDAOImpl() {
		this(Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME));
	}
	
	public PlaceDAOImpl (EntityManagerFactory emf) {
		super(Place.class, emf); //Р—Р°РїСѓСЃРєР°РµРј РєРѕРЅСЃС‚СЂСѓРєС‚РѕСЂ РґР»СЏ GenericDAOImpl
		this.entityMF = emf;
	}

	@Override
	public void save(Place entity) {
		this.savePlace(entity);
	}

	@Override
	public void update(Place entity) {
		this.updatePlace(entity);
	}

	@Override
	public void delete(Place entity) {
		this.deletePlace(entity);
	}

	@Override
	public Place getById(Integer entityId) {
		return this.getPlaceById(entityId);
	}

	@Override
	public Integer getAllCount() {
		return this.getAllPlaceCount();
	}

	@Override
	public Collection<Place> getAll() {
		return this.getAllPlace();
	}


	@Override
	public void savePlace(Place place) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.persist(place); // Сохранение экземпляра класса
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
	public void updatePlace(Place place) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.merge(place);
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
	public Place getPlaceById(Integer place_id) {
		Place place = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			place = entityMng.find(Place.class, place_id);
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'findById'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return place;
	}

	@Override
	public Integer getAllPlaceCount() {

		Integer cnt = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT COUNT p FROM Place p");
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
	public Collection<Place> getAllPlace() {
		List<Place> places = null; 
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT p from Place p");
			places = (List<Place>)query.getResultList();
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'getAll'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return places;
	}

	@Override
	public void deletePlace(Place place) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.remove(place);
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