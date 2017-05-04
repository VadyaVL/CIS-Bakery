package ua.bakery.db.DAO.dependInjection;

import java.util.Collection;
import java.util.List;

import ua.bakery.db.DAO.IProductionOldNewReportDAO;
import ua.bakery.db.jpa.ProductionOldNewReport;

public class ProductionOldNewReportDAO_DI {

	private IProductionOldNewReportDAO productionoldnewreportDAO;
	
	public ProductionOldNewReportDAO_DI(IProductionOldNewReportDAO productionoldnewreportDAO) {
		this.productionoldnewreportDAO = productionoldnewreportDAO;
	}

    
	public void saveProductionOldNewReport(ProductionOldNewReport productionoldnewreport) {
		productionoldnewreportDAO.saveProductionOldNewReport(productionoldnewreport);
	}

	public void updateProductionOldNewReport(ProductionOldNewReport productionoldnewreport) {
		productionoldnewreportDAO.updateProductionOldNewReport(productionoldnewreport);
	}

	public void deleteProductionOldNewReport(ProductionOldNewReport productionoldnewreport) {
		productionoldnewreportDAO.deleteProductionOldNewReport(productionoldnewreport);
	}

	public ProductionOldNewReport getProductionOldNewReportById(Integer productionoldnewreport_id) {
		ProductionOldNewReport productionoldnewreport = productionoldnewreportDAO.getProductionOldNewReportById(productionoldnewreport_id);
		return productionoldnewreport;
	}

	public Integer getAllProductionOldNewReportCount() {
		Integer cnt = productionoldnewreportDAO.getAllProductionOldNewReportCount();
		return cnt;
	}

	public Collection<ProductionOldNewReport> getAllProductionOldNewReport() {
		List<ProductionOldNewReport> productionoldnewreports = (List<ProductionOldNewReport>) productionoldnewreportDAO.getAllProductionOldNewReport();
		return productionoldnewreports;
	}


}
