package ua.bakery.db.DAO;

import java.util.Collection;

/**
 * Общие методы для всех сущностей вынесены в интерфейс IGenericDAO
 * @author Vadym
 *
 * @param <T>
 */
public interface IGenericDAO<T> {
	/**
	 * Сохраняем новый объект в базу данных. 
	 * @param entity Объект для сохранения
	 */
	public void save(T entity);

	/**
	 * Обновляем объект в базе данных.  
	 * @param entity Объект для обновления
	 */
	public void update(T entity);

	/**
	 * Удаление объекта из базы данных 
	 * @param entity Объект для удаления
	 */
	public void delete(T entity);   

	/**
	 * Находим объект по его уникальному идентификатору 
	 * @param entityId Уникальный идентификатор объекта
	 * @return Найденный объект или <code>null</code>
	 */
	public T getById(Integer entityId);

	/**
	 * Получаем количество записей в БД
	 * @return Количество записей в БД
	 */
	public Integer getAllCount(); 

	/**
	 * Получаем коллекцию всех объектов 
	 * @return Коллекция всех объектов
	 */
	public Collection<T> getAll(); 
}