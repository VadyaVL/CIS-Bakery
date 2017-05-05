package ua.bakery.db.DAO;

import java.util.Collection;

import ua.bakery.db.jpa.Produced;

/**
* @author vadym
* @since 0.12
*/
public interface IProducedDAO extends IGenericDAO<Produced> {
	public void saveProduced(Produced produced);
	public void updateProduced(Produced produced);
	public Produced getProducedById(Integer produced_id);
	public Integer getAllProducedCount();
	public Collection<Produced> getAllProduced();
	public void deleteProduced(Produced produced);
}