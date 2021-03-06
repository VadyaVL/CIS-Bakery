package ua.bakery.db.DAO;

import java.util.Collection;

import ua.bakery.db.jpa.Request;

/**
* @author vadym
* @since 0.12
*/
public interface IRequestDAO extends IGenericDAO<Request> {
	public void saveRequest(Request request);
	public void updateRequest(Request request);
	public Request getRequestById(Integer request_id);
	public Collection<Request> getRequestByUserRealName(String name);
	public Integer getAllRequestCount();
	public Collection<Request> getAllRequest();
	public void deleteRequest(Request request);

}