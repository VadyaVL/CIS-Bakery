package ua.bakery.db.DAO.dependInjection;

import java.util.Collection;
import java.util.List;

import ua.bakery.db.DAO.IRequestProductionDAO;
import ua.bakery.db.jpa.RequestProduction;

public class RequestProductionDAO_DI {

	private IRequestProductionDAO requestproductionDAO;
	
	public RequestProductionDAO_DI(IRequestProductionDAO requestproductionDAO) {
		this.requestproductionDAO = requestproductionDAO;
	}

    
	public void saveRequestProduction(RequestProduction requestproduction) {
		requestproductionDAO.saveRequestProduction(requestproduction);
	}

	public void updateRequestProduction(RequestProduction requestproduction) {
		requestproductionDAO.updateRequestProduction(requestproduction);
	}

	public void deleteRequestProduction(RequestProduction requestproduction) {
		requestproductionDAO.deleteRequestProduction(requestproduction);
	}

	public RequestProduction getRequestProductionById(Integer requestproduction_id) {
		RequestProduction requestproduction = requestproductionDAO.getRequestProductionById(requestproduction_id);
		return requestproduction;
	}

	public Integer getAllRequestProductionCount() {
		Integer cnt = requestproductionDAO.getAllRequestProductionCount();
		return cnt;
	}

	public Collection<RequestProduction> getAllRequestProduction() {
		List<RequestProduction> requestproductions = (List<RequestProduction>) requestproductionDAO.getAllRequestProduction();
		return requestproductions;
	}


}
