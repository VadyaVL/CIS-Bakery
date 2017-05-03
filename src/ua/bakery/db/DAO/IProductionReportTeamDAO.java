package ua.bakery.db.DAO;

import java.util.Collection;

import ua.bakery.db.jpa.ProductionReportTeam;

/**
* @author vadym
* @since 0.12
*/
public interface IProductionReportTeamDAO {
	public void saveProductionReportTeam(ProductionReportTeam productionreportteam);
	public void updateProductionReportTeam(ProductionReportTeam productionreportteam);
	public ProductionReportTeam getProductionReportTeamById(Integer productionreportteam_id);
	public Integer getAllProductionReportTeamCount();
	public Collection<ProductionReportTeam> getAllProductionReportTeam();
	public void deleteProductionReportTeam(ProductionReportTeam productionreportteam);

}