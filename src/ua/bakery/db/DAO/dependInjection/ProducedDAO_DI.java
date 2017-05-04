package ua.bakery.db.DAO.dependInjection;

import java.util.Collection;
import java.util.List;

import ua.bakery.db.DAO.IProducedDAO;
import ua.bakery.db.jpa.Produced;

public class ProducedDAO_DI {

	private IProducedDAO producedDAO;
	
	public ProducedDAO_DI(IProducedDAO producedDAO) {
		this.producedDAO = producedDAO;
	}

    
	public void saveProduced(Produced produced) {
		producedDAO.saveProduced(produced);
	}

	public void updateProduced(Produced produced) {
		producedDAO.updateProduced(produced);
	}

	public void deleteProduced(Produced produced) {
		producedDAO.deleteProduced(produced);
	}

	public Produced getProducedById(Integer produced_id) {
		Produced produced = producedDAO.getProducedById(produced_id);
		return produced;
	}

	public Integer getAllProducedCount() {
		Integer cnt = producedDAO.getAllProducedCount();
		return cnt;
	}

	public Collection<Produced> getAllProduced() {
		List<Produced> produceds = (List<Produced>) producedDAO.getAllProduced();
		return produceds;
	}


}
