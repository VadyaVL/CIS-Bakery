package ua.bakery.db.DAO.dependInjection;

import java.util.Collection;
import java.util.List;

import ua.bakery.db.DAO.IProductionReportTeamDAO;
import ua.bakery.db.jpa.ProductionReportTeam;

public class ProductionReportTeamDAO_DI {

	private IProductionReportTeamDAO productionreportteamDAO;
	
	public ProductionReportTeamDAO_DI(IProductionReportTeamDAO productionreportteamDAO) {
		this.productionreportteamDAO = productionreportteamDAO;
	}

    
	public void saveProductionReportTeam(ProductionReportTeam productionreportteam) {
		productionreportteamDAO.saveProductionReportTeam(productionreportteam);
	}

	public void updateProductionReportTeam(ProductionReportTeam productionreportteam) {
		productionreportteamDAO.updateProductionReportTeam(productionreportteam);
	}

	public void deleteProductionReportTeam(ProductionReportTeam productionreportteam) {
		productionreportteamDAO.deleteProductionReportTeam(productionreportteam);
	}

	public ProductionReportTeam getProductionReportTeamById(Integer productionreportteam_id) {
		ProductionReportTeam productionreportteam = productionreportteamDAO.getProductionReportTeamById(productionreportteam_id);
		return productionreportteam;
	}

	public Integer getAllProductionReportTeamCount() {
		Integer cnt = productionreportteamDAO.getAllProductionReportTeamCount();
		return cnt;
	}

	public Collection<ProductionReportTeam> getAllProductionReportTeam() {
		List<ProductionReportTeam> productionreportteams = (List<ProductionReportTeam>) productionreportteamDAO.getAllProductionReportTeam();
		return productionreportteams;
	}


}
