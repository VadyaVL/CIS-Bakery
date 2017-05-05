package ua.bakery.db.DAO;

import java.util.Collection;

import ua.bakery.db.jpa.Brak;

/**
* @author vadym
* @since 0.12
*/
public interface IBrakDAO extends IGenericDAO<Brak> {
	public void saveBrak(Brak brak);
	public void updateBrak(Brak brak);
	public Brak getBrakById(Integer brak_id);
	public Integer getAllBrakCount();
	public Collection<Brak> getAllBrak();
	public void deleteBrak(Brak brak);
}