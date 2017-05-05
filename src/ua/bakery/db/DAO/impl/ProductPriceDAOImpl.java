package ua.bakery.db.DAO.impl;

import ua.bakery.db.DAO.IProductPriceDAO;
import ua.bakery.db.jpa.Brak;
import ua.bakery.db.jpa.ProductPrice;

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
public class ProductPriceDAOImpl extends GenericDAOImpl<ProductPrice> implements IProductPriceDAO {
	private static final String PERSISTENCE_UNIT_NAME = "CISBakeryJPA";
	private EntityManagerFactory entityMF = null;
	private EntityManager entityMng = null;
	
	
	public ProductPriceDAOImpl() {
		this(Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME));
	}
	
	public ProductPriceDAOImpl (EntityManagerFactory emf) {
		super(ProductPrice.class, emf); //Запускаем конструктор для GenericDAOImpl
		this.entityMF = emf;
	}

	@Override
	public void save(ProductPrice entity) {
		this.saveProductPrice(entity);
	}

	@Override
	public void update(ProductPrice entity) {
		this.updateProductPrice(entity);
	}

	@Override
	public void delete(ProductPrice entity) {
		this.deleteProductPrice(entity);
	}

	@Override
	public ProductPrice getById(Integer entityId) {
		return this.getProductPriceById(entityId);
	}

	@Override
	public Integer getAllCount() {
		return this.getAllProductPriceCount();
	}

	@Override
	public Collection<ProductPrice> getAll() {
		return this.getAllProductPrice();
	}


	@Override
	public void saveProductPrice(ProductPrice productprice) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.persist(productprice); // Сохранение экземпляра класса
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
	public void updateProductPrice(ProductPrice productprice) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.merge(productprice);
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
	public ProductPrice getProductPriceById(Integer productprice_id) {
		ProductPrice productprice = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			productprice = entityMng.find(ProductPrice.class, productprice_id);
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'findById'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return productprice;
	}

	@Override
	public Integer getAllProductPriceCount() {
		Integer cnt = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT COUNT obj FROM ProductPrice obj");
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
	public Collection<ProductPrice> getAllProductPrice() {
		List<ProductPrice> ProductPrices = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT obj from ProductPrice obj");
			ProductPrices = (List<ProductPrice>)query.getResultList();
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'getAll'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return ProductPrices;
	}

	@Override
	public void deleteProductPrice(ProductPrice productprice) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.remove(productprice);
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