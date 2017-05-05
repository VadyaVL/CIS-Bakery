package ua.bakery.db.DAO.impl;

import ua.bakery.db.DAO.IProductionIngridientDAO;
import ua.bakery.db.jpa.Brak;
import ua.bakery.db.jpa.ProductionIngridient;

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
public class ProductionIngridientDAOImpl extends GenericDAOImpl<ProductionIngridient> implements IProductionIngridientDAO {
	private static final String PERSISTENCE_UNIT_NAME = "CISBakeryJPA";
	private EntityManagerFactory entityMF = null;
	private EntityManager entityMng = null;
	
	
	public ProductionIngridientDAOImpl() {
		this(Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME));
	}
	
	public ProductionIngridientDAOImpl (EntityManagerFactory emf) {
		super(ProductionIngridient.class, emf); //Запускаем конструктор для GenericDAOImpl
		this.entityMF = emf;
	}

	@Override
	public void save(ProductionIngridient entity) {
		this.saveProductionIngridient(entity);
	}

	@Override
	public void update(ProductionIngridient entity) {
		this.updateProductionIngridient(entity);
	}

	@Override
	public void delete(ProductionIngridient entity) {
		this.deleteProductionIngridient(entity);
	}

	@Override
	public ProductionIngridient getById(Integer entityId) {
		return this.getProductionIngridientById(entityId);
	}

	@Override
	public Integer getAllCount() {
		return this.getAllProductionIngridientCount();
	}

	@Override
	public Collection<ProductionIngridient> getAll() {
		return this.getAllProductionIngridient();
	}

	@Override
	public void saveProductionIngridient(ProductionIngridient productioningridient) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.persist(productioningridient); // Сохранение экземпляра класса
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
	public void updateProductionIngridient(ProductionIngridient productioningridient) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.merge(productioningridient);
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
	public ProductionIngridient getProductionIngridientById(Integer productioningridient_id) {
		ProductionIngridient productioningridient = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			productioningridient = entityMng.find(ProductionIngridient.class, productioningridient_id);
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'findById'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return productioningridient;
	}

	@Override
	public Integer getAllProductionIngridientCount() {
		Integer cnt = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT COUNT obj FROM ProductionIngridient obj");
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
	public Collection<ProductionIngridient> getAllProductionIngridient() {
		List<ProductionIngridient> ProductionIngridients = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT obj from ProductionIngridient obj");
			ProductionIngridients = (List<ProductionIngridient>)query.getResultList();
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'getAll'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return ProductionIngridients;
	}

	@Override
	public void deleteProductionIngridient(ProductionIngridient productioningridient) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.remove(productioningridient);
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