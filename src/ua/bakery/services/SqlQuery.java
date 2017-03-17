package ua.bakery.services;

/**
 * Призначення - зберження констант.
 * В ролі констант виступатимуть запити до БД.
 * @author Vadym
 *
 */
public final class SqlQuery {	// Заборотнити можливість наслідування

	public final static String SELECT_USER = "SELECT * FROM User"; 
	public final static String SELECT_CLIENT = "SELECT * FROM Client"; 
	public final static String SELECT_LOG = "SELECT * FROM Log"; 
	public final static String SELECT_LOG_BY_USER = "SELECT * FROM Log WHERE User_id = ?"; 
	public final static String SELECT_REQUEST_BY_CLIENT = "SELECT * FROM Request WHERE Client_id = ?";
	public final static String INSERT_REQUEST = "INSERT INTO Request (Client_id, Date_Request, Date_Oformleniya, OK, User_id) VALUES (?, ?, ?, ?, ?)";
	public final static String DELETE_REQUEST = "DELETE FROM Request WHERE id = ?"; 
	
	private SqlQuery() { }	// Заборона створити об'єкти
	
}
