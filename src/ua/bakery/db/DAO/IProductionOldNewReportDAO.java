package ua.bakery.db.DAO;

import java.util.Collection;

import ua.bakery.db.jpa.ProductionOldNewReport;

/**
* @author vadym
* @since 0.12
*/
public interface IProductionOldNewReportDAO {
	public void saveProductionOldNewReport(ProductionOldNewReport productionoldnewreport);
	public void updateProductionOldNewReport(ProductionOldNewReport productionoldnewreport);
	public ProductionOldNewReport getProductionOldNewReportById(Integer productionoldnewreport_id);
	public Integer getAllProductionOldNewReportCount();
	public Collection<ProductionOldNewReport> getAllProductionOldNewReport();
	public void deleteProductionOldNewReport(ProductionOldNewReport productionoldnewreport);

}