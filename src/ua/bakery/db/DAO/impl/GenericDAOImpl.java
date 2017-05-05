package ua.bakery.db.DAO.impl;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import ua.bakery.db.DAO.IGenericDAO;

/**
 * Реализация общих методов для всех сущностей 
 * в интерфейсе IGenericDAO
 * @param <T>
 */
public class GenericDAOImpl<T> implements IGenericDAO<T> {

	private EntityManagerFactory emf = null;
	private EntityManager em = null;

	/** 
	 * Создание ссылки Class<T> persistentClass. Эта ссылка используется 
	 * для указания на персистенс класс, передаваемый в качестве параметра T
	 */
	protected Class<T> persistentClass;

	/**
	 * В тексте запроса тип представлен подстановочной строкой %s, 
	 * которая обрабатывается с помощью String.format  
	 */
	//Запросы настраиваются с помощью String.format
	private static final String QUERY_SELECT_ALL = "SELECT x FROM %s x";
	private static final String QUERY_COUNT_ALL = "SELECT COUNT(x) FROM %s x";

	/**
	 * EntityManagerFactory создается в DAOFactory и передается классу 
	 * через параметр конструктора.
	 * Конструктор с 2-мя полями
	 * Класс, который будет использовать этот DAO  
	 * @param persistentClass Используемый EntityManager
	 * @param emf	
	 */			
	public GenericDAOImpl (Class<T> persistentClass, EntityManagerFactory emf) {
		super(); 				// Чей super конструктор ???
		this.persistentClass = persistentClass;	
		this.emf = emf;			// Создаем EntityManager для работы с сущностями класса
	}

	public void save(T entity) {
		if (entity == null) {
			System.out.println("Entity для сохранения не может быть null!");
		}
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(entity); // Сохранение экземпляра класса
			// Сохранить объект в БД можно и с помощью JPQL	
			em.getTransaction().commit();	 		
		} catch (Exception e) {
			System.out.println("Ошибка сохранения");
			em.getTransaction().rollback();
		} finally {		
			//Хорошая практика закрыть entity manager
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}	  

	public void update(T entity) {		 
		if (entity == null) {
			System.out.println("Entity для обновления не может быть null!");
		}	 
		try {
			em = emf.createEntityManager();
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.merge(entity); // Обновление сущности в БД
			// Обновить объект в БД можно и с помощью JPQL		    	 
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Ошибка при вставке");    
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	public void delete(T entity) {	 
		if (entity == null) {
			System.out.println("Entity для удаления не может быть null!");
		}
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			em.remove(entity);
			em.getTransaction().commit();
		} catch (Exception e) {
			System.out.println("Ошибка при удалении");
			em.getTransaction().rollback();
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
	}

	public void delete(Integer entityId) {
		delete(getById(entityId));
	}

	public T getById(Integer entityId) {
		T entity = null;
		if (entityId == null) {
			System.out.println("Id сущности для извлечения null!");
		}		 
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();	    	 
			entity = (T) em.find(persistentClass, entityId);
		} catch (Exception e) {
			System.out.println("Ошибка 'findById'");
			em.getTransaction().rollback();  
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		return entity;
	}

	public Integer getAllCount() {		
		Integer cnt = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery(String.format(QUERY_COUNT_ALL, persistentClass.getSimpleName()));
			cnt =  (Integer) query.getSingleResult();
			em.getTransaction().commit(); 
		}	catch (Exception e) {
			System.out.println("Ошибка getAllCount");   
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		return cnt;
	}		

	public Collection<T> getAll() {
		List<T> entites = null;
		try {
			em = emf.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createQuery(String.format(QUERY_SELECT_ALL, persistentClass.getSimpleName()));
			entites = (List<T>) query.getResultList();
			em.getTransaction().commit();    	 
		} catch (Exception e) {
			System.out.println("ООшибка 'getAll'");   
		} finally {
			if (em != null && em.isOpen()) {
				em.close();
			}
		}
		return entites;
	}




}
