package ua.bakery.db.DAO.dependInjection;

import java.util.Collection;
import java.util.List;

import ua.bakery.db.DAO.IIngridientDAO;
import ua.bakery.db.jpa.Ingridient;

public class IngridientDAO_DI {

	private IIngridientDAO ingridientDAO;
	
	public IngridientDAO_DI(IIngridientDAO ingridientDAO) {
		this.ingridientDAO = ingridientDAO;
	}

    
	public void saveIngridient(Ingridient ingridient) {
		ingridientDAO.saveIngridient(ingridient);
	}

	public void updateIngridient(Ingridient ingridient) {
		ingridientDAO.updateIngridient(ingridient);
	}

	public void deleteIngridient(Ingridient ingridient) {
		ingridientDAO.deleteIngridient(ingridient);
	}

	public Ingridient getIngridientById(Integer ingridient_id) {
		Ingridient ingridient = ingridientDAO.getIngridientById(ingridient_id);
		return ingridient;
	}

	public Integer getAllIngridientCount() {
		Integer cnt = ingridientDAO.getAllIngridientCount();
		return cnt;
	}

	public Collection<Ingridient> getAllIngridient() {
		List<Ingridient> ingridients = (List<Ingridient>) ingridientDAO.getAllIngridient();
		return ingridients;
	}


}
