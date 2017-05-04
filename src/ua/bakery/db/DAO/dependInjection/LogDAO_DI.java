package ua.bakery.db.DAO.dependInjection;

import java.util.Collection;
import java.util.List;

import ua.bakery.db.DAO.ILogDAO;
import ua.bakery.db.jpa.Log;

public class LogDAO_DI {

	private ILogDAO logDAO;
	
	public LogDAO_DI(ILogDAO logDAO) {
		this.logDAO = logDAO;
	}

    
	public void saveLog(Log log) {
		logDAO.saveLog(log);
	}

	public void updateLog(Log log) {
		logDAO.updateLog(log);
	}

	public void deleteLog(Log log) {
		logDAO.deleteLog(log);
	}

	public Log getLogById(Integer log_id) {
		Log log = logDAO.getLogById(log_id);
		return log;
	}

	public Integer getAllLogCount() {
		Integer cnt = logDAO.getAllLogCount();
		return cnt;
	}

	public Collection<Log> getAllLog() {
		List<Log> logs = (List<Log>) logDAO.getAllLog();
		return logs;
	}


}
