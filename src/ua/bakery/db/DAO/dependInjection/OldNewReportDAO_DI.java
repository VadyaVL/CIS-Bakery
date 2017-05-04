package ua.bakery.db.DAO.dependInjection;

import java.util.Collection;
import java.util.List;

import ua.bakery.db.DAO.IOldNewReportDAO;
import ua.bakery.db.jpa.OldNewReport;

public class OldNewReportDAO_DI {

	private IOldNewReportDAO oldnewreportDAO;
	
	public OldNewReportDAO_DI(IOldNewReportDAO oldnewreportDAO) {
		this.oldnewreportDAO = oldnewreportDAO;
	}

    
	public void saveOldNewReport(OldNewReport oldnewreport) {
		oldnewreportDAO.saveOldNewReport(oldnewreport);
	}

	public void updateOldNewReport(OldNewReport oldnewreport) {
		oldnewreportDAO.updateOldNewReport(oldnewreport);
	}

	public void deleteOldNewReport(OldNewReport oldnewreport) {
		oldnewreportDAO.deleteOldNewReport(oldnewreport);
	}

	public OldNewReport getOldNewReportById(Integer oldnewreport_id) {
		OldNewReport oldnewreport = oldnewreportDAO.getOldNewReportById(oldnewreport_id);
		return oldnewreport;
	}

	public Integer getAllOldNewReportCount() {
		Integer cnt = oldnewreportDAO.getAllOldNewReportCount();
		return cnt;
	}

	public Collection<OldNewReport> getAllOldNewReport() {
		List<OldNewReport> oldnewreports = (List<OldNewReport>) oldnewreportDAO.getAllOldNewReport();
		return oldnewreports;
	}


}
