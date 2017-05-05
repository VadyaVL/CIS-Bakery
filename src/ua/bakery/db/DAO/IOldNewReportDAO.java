package ua.bakery.db.DAO;

import java.util.Collection;

import ua.bakery.db.jpa.OldNewReport;

/**
* @author vadym
* @since 0.12
*/
public interface IOldNewReportDAO extends IGenericDAO<OldNewReport> {
	public void saveOldNewReport(OldNewReport oldnewreport);
	public void updateOldNewReport(OldNewReport oldnewreport);
	public OldNewReport getOldNewReportById(Integer oldnewreport_id);
	public Integer getAllOldNewReportCount();
	public Collection<OldNewReport> getAllOldNewReport();
	public void deleteOldNewReport(OldNewReport oldnewreport);
}