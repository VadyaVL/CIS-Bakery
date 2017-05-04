package ua.bakery.db.DAO.dependInjection;

import java.util.Collection;
import java.util.List;

import ua.bakery.db.DAO.IRequestDAO;
import ua.bakery.db.jpa.Request;

public class RequestDAO_DI {

	private IRequestDAO requestDAO;
	
	public RequestDAO_DI(IRequestDAO requestDAO) {
		this.requestDAO = requestDAO;
	}

    
	public void saveRequest(Request request) {
		requestDAO.saveRequest(request);
	}

	public void updateRequest(Request request) {
		requestDAO.updateRequest(request);
	}

	public void deleteRequest(Request request) {
		requestDAO.deleteRequest(request);
	}

	public Request getRequestById(Integer request_id) {
		Request request = requestDAO.getRequestById(request_id);
		return request;
	}

	public Integer getAllRequestCount() {
		Integer cnt = requestDAO.getAllRequestCount();
		return cnt;
	}

	public Collection<Request> getAllRequest() {
		List<Request> requests = (List<Request>) requestDAO.getAllRequest();
		return requests;
	}


}
