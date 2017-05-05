package ua.bakery.db.DAO;

import java.util.Collection;

import ua.bakery.db.jpa.Ingridient;

/**
* @author vadym
* @since 0.12
*/
public interface IIngridientDAO extends IGenericDAO<Ingridient> {
	public void saveIngridient(Ingridient ingridient);
	public void updateIngridient(Ingridient ingridient);
	public Ingridient getIngridientById(Integer ingridient_id);
	public Integer getAllIngridientCount();
	public Collection<Ingridient> getAllIngridient();
	public void deleteIngridient(Ingridient ingridient);
}