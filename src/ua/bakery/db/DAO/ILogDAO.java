package ua.bakery.db.DAO;

import java.util.Collection;

import ua.bakery.db.jpa.Log;

/**
* @author vadym
* @since 0.12
*/
public interface ILogDAO {
	public void saveLog(Log log);
	public void updateLog(Log log);
	public Log getLogById(Integer log_id);
	public Integer getAllLogCount();
	public Collection<Log> getAllLog();
	public void deleteLog(Log log);
}