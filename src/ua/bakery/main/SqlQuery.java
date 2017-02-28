package ua.bakery.main;

/**
 * Призначення - зберження констант.
 * В ролі констант виступатимуть запити до БД.
 * @author Vadym
 *
 */
public final class SqlQuery {	// Заборотнити можливість наслідування

	public final static String SELECT_USER = "SELECT * FROM User"; 
	public final static String SELECT_LOG = "SELECT * FROM Log"; 
	public final static String SELECT_LOG_BY_USER = "SELECT * FROM Log WHERE User_id = ?"; 
	
	private SqlQuery() { }	// Заборона створити об'єкти
	
}
