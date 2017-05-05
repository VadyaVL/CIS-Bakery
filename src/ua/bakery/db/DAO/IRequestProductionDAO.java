package ua.bakery.db.DAO;

import java.util.Collection;

import ua.bakery.db.jpa.RequestProduction;

/**
* @author vadym
* @since 0.12
*/
public interface IRequestProductionDAO extends IGenericDAO<RequestProduction> {
	public void saveRequestProduction(RequestProduction requestproduction);
	public void updateRequestProduction(RequestProduction requestproduction);
	public RequestProduction getRequestProductionById(Integer requestproduction_id);
	public Integer getAllRequestProductionCount();
	public Collection<RequestProduction> getAllRequestProduction();
	public void deleteRequestProduction(RequestProduction requestproduction);

}