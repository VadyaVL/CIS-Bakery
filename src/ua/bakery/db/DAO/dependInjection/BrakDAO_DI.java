package ua.bakery.db.DAO.dependInjection;

import java.util.Collection;
import java.util.List;

import ua.bakery.db.DAO.IBrakDAO;
import ua.bakery.db.jpa.Brak;

public class BrakDAO_DI {

	private IBrakDAO brakDAO;
	
	public BrakDAO_DI(IBrakDAO brakDAO) {
		this.brakDAO = brakDAO;
	}

    
	public void saveBrak(Brak brak) {
		brakDAO.saveBrak(brak);
	}

	public void updateBrak(Brak brak) {
		brakDAO.updateBrak(brak);
	}

	public void deleteBrak(Brak brak) {
		brakDAO.deleteBrak(brak);
	}

	public Brak getBrakById(Integer brak_id) {
		Brak brak = brakDAO.getBrakById(brak_id);
		return brak;
	}

	public Integer getAllBrakCount() {
		Integer cnt = brakDAO.getAllBrakCount();
		return cnt;
	}

	public Collection<Brak> getAllBrak() {
		List<Brak> braks = (List<Brak>) brakDAO.getAllBrak();
		return braks;
	}


}
