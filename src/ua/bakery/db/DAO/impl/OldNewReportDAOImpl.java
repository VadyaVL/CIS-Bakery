package ua.bakery.db.DAO.impl;

import ua.bakery.db.DAO.IOldNewReportDAO;
import ua.bakery.db.jpa.Brak;
import ua.bakery.db.jpa.OldNewReport;

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
public class OldNewReportDAOImpl extends GenericDAOImpl<OldNewReport> implements IOldNewReportDAO {
	private static final String PERSISTENCE_UNIT_NAME = "CISBakeryJPA";
	private EntityManagerFactory entityMF = null;
	private EntityManager entityMng = null;
	
	
	public OldNewReportDAOImpl() {
		this(Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME));
	}
	
	public OldNewReportDAOImpl (EntityManagerFactory emf) {
		super(OldNewReport.class, emf); //Запускаем конструктор для GenericDAOImpl
		this.entityMF = emf;
	}

	@Override
	public void save(OldNewReport entity) {
		this.saveOldNewReport(entity);
	}

	@Override
	public void update(OldNewReport entity) {
		this.updateOldNewReport(entity);
	}

	@Override
	public void delete(OldNewReport entity) {
		this.deleteOldNewReport(entity);
	}

	@Override
	public OldNewReport getById(Integer entityId) {
		return this.getOldNewReportById(entityId);
	}

	@Override
	public Integer getAllCount() {
		return this.getAllOldNewReportCount();
	}

	@Override
	public Collection<OldNewReport> getAll() {
		return this.getAllOldNewReport();
	}


	@Override
	public void saveOldNewReport(OldNewReport oldnewreport) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.persist(oldnewreport); // Сохранение экземпляра класса
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
	public void updateOldNewReport(OldNewReport oldnewreport) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.merge(oldnewreport);
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
	public OldNewReport getOldNewReportById(Integer oldnewreport_id) {
		OldNewReport oldnewreport = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			oldnewreport = entityMng.find(OldNewReport.class, oldnewreport_id);
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'findById'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return oldnewreport;
	}

	@Override
	public Integer getAllOldNewReportCount() {
		Integer cnt = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT COUNT obj FROM OldNewReport obj");
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
	public Collection<OldNewReport> getAllOldNewReport() {
		List<OldNewReport> OldNewReports = null;
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			Query query = entityMng.createQuery("SELECT obj from OldNewReport obj");
			OldNewReports = (List<OldNewReport>)query.getResultList();
			entityMng.getTransaction().commit();
		} catch (Exception e) {
			new Exception("Помилка 'getAll'", e.getCause());
		} finally {
			if (entityMng != null && entityMng.isOpen()) {
				entityMng.close();
			}
		}

		return OldNewReports;
	}

	@Override
	public void deleteOldNewReport(OldNewReport oldnewreport) {
		try {
			entityMng = entityMF.createEntityManager();
			entityMng.getTransaction().begin();
			entityMng.remove(oldnewreport);
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