package ua.bakery.db.DAO.dependInjection;

import java.util.Collection;
import java.util.List;

import ua.bakery.db.DAO.IProductionIngridientDAO;
import ua.bakery.db.jpa.ProductionIngridient;

public class ProductionIngridientDAO_DI {

	private IProductionIngridientDAO productioningridientDAO;
	
	public ProductionIngridientDAO_DI(IProductionIngridientDAO productioningridientDAO) {
		this.productioningridientDAO = productioningridientDAO;
	}

    
	public void saveProductionIngridient(ProductionIngridient productioningridient) {
		productioningridientDAO.saveProductionIngridient(productioningridient);
	}

	public void updateProductionIngridient(ProductionIngridient productioningridient) {
		productioningridientDAO.updateProductionIngridient(productioningridient);
	}

	public void deleteProductionIngridient(ProductionIngridient productioningridient) {
		productioningridientDAO.deleteProductionIngridient(productioningridient);
	}

	public ProductionIngridient getProductionIngridientById(Integer productioningridient_id) {
		ProductionIngridient productioningridient = productioningridientDAO.getProductionIngridientById(productioningridient_id);
		return productioningridient;
	}

	public Integer getAllProductionIngridientCount() {
		Integer cnt = productioningridientDAO.getAllProductionIngridientCount();
		return cnt;
	}

	public Collection<ProductionIngridient> getAllProductionIngridient() {
		List<ProductionIngridient> productioningridients = (List<ProductionIngridient>) productioningridientDAO.getAllProductionIngridient();
		return productioningridients;
	}


}
