package ua.bakery.db.DAO;

import java.util.Collection;

import ua.bakery.db.jpa.Production;

/**
* @author vadym
* @since 0.12
*/
public interface IProductionDAO extends IGenericDAO<Production> {
	public void saveProduction(Production production);
	public void updateProduction(Production production);
	public Production getProductionById(Integer production_id);
	public Integer getAllProductionCount();
	public Collection<Production> getAllProduction();
	public void deleteProduction(Production production);
}