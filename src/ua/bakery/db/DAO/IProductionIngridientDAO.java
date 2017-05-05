package ua.bakery.db.DAO;

import java.util.Collection;

import ua.bakery.db.jpa.ProductionIngridient;

/**
* @author vadym
* @since 0.12
*/
public interface IProductionIngridientDAO extends IGenericDAO<ProductionIngridient> {

	public void saveProductionIngridient(ProductionIngridient productioningridient);
	public void updateProductionIngridient(ProductionIngridient productioningridient);
	public ProductionIngridient getProductionIngridientById(Integer productioningridient_id);
	public Integer getAllProductionIngridientCount();
	public Collection<ProductionIngridient> getAllProductionIngridient();
	public void deleteProductionIngridient(ProductionIngridient productioningridient);

}