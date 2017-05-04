package ua.bakery.db.DAO.dependInjection;

import java.util.Collection;
import java.util.List;

import ua.bakery.db.DAO.IProductionDAO;
import ua.bakery.db.jpa.Production;

public class ProductionDAO_DI {

	private IProductionDAO productionDAO;
	
	public ProductionDAO_DI(IProductionDAO productionDAO) {
		this.productionDAO = productionDAO;
	}

    
	public void saveProduction(Production production) {
		productionDAO.saveProduction(production);
	}

	public void updateProduction(Production production) {
		productionDAO.updateProduction(production);
	}

	public void deleteProduction(Production production) {
		productionDAO.deleteProduction(production);
	}

	public Production getProductionById(Integer production_id) {
		Production production = productionDAO.getProductionById(production_id);
		return production;
	}

	public Integer getAllProductionCount() {
		Integer cnt = productionDAO.getAllProductionCount();
		return cnt;
	}

	public Collection<Production> getAllProduction() {
		List<Production> productions = (List<Production>) productionDAO.getAllProduction();
		return productions;
	}


}
