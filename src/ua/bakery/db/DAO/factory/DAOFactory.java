package ua.bakery.db.DAO.factory;

import ua.bakery.db.DAO.*;
import ua.bakery.db.DAO.impl.*;

public class DAOFactory {
	
	private static DAOFactory _instance = null;

	private IBrakDAO brakDAO = null;
	private IClientDAO clientDAO = null;
	private IEmployeeDAO employeeDAO = null;
	private IIngridientDAO ingridientDAO = null;
	private ILogDAO logDAO = null;
	private IOldNewReportDAO oldNewReportDAO = null;
	private IPlaceDAO placeDAO = null;
	private IProducedDAO producedDAO = null;
	private IProductionDAO productionDAO = null;
	private IProductionIngridientDAO productionIngridientDAO = null;
	private IProductionOldNewReportDAO productionOldNewReportDAO = null;
	private IProductionReportTeamDAO productionReportTeamDAO = null;
	private IProductPriceDAO productionPriceDAO = null;
	private IRequestDAO requestDAO = null;
	private IRequestProductionDAO requestProductionDAO = null;
	private IUserDAO userDAO = null;
	private IWriteOffDAO writeOffDAO = null;
	
	private DAOFactory(){
		
	}
	
	public static DAOFactory getInstance(){
		if(_instance == null)
			_instance = new DAOFactory();
		
		return _instance;
	}

	public IBrakDAO getBrakDAO() {
		if(brakDAO == null)
			brakDAO = new BrakDAOImpl();
		return brakDAO;
	}

	public IClientDAO getClientDAO() {
		if(clientDAO == null)
			clientDAO = new ClientDAOImpl();
		return clientDAO;
	}

	public IEmployeeDAO getEmployeeDAO() {
		if(employeeDAO == null)
			employeeDAO = new EmployeeDAOImpl();
		return employeeDAO;
	}

	public IIngridientDAO getIngridientDAO() {
		if(ingridientDAO == null)
			ingridientDAO = new IngridientDAOImpl();
		return ingridientDAO;
	}

	public ILogDAO getLogDAO() {
		if(logDAO == null)
			logDAO = new LogDAOImpl();
		return logDAO;
	}

	public IOldNewReportDAO getOldNewReportDAO() {
		if(oldNewReportDAO == null)
			oldNewReportDAO = new OldNewReportDAOImpl();
		return oldNewReportDAO;
	}

	public IPlaceDAO getPlaceDAO() {
		if(placeDAO == null)
			placeDAO = new PlaceDAOImpl();
		return placeDAO;
	}

	public IProducedDAO getProducedDAO() {
		if(producedDAO == null)
			producedDAO = new ProducedDAOImpl();
		return producedDAO;
	}

	public IProductionDAO getProductionDAO() {
		if(productionDAO == null)
			productionDAO = new ProductionDAOImpl();
		return productionDAO;
	}

	public IProductionIngridientDAO getProductionIngridientDAO() {
		if(productionIngridientDAO == null)
			productionIngridientDAO = new ProductionIngridientDAOImpl();
		return productionIngridientDAO;
	}

	public IProductionOldNewReportDAO getProductionOldNewReportDAO() {
		if(productionOldNewReportDAO == null)
			productionOldNewReportDAO = new ProductionOldNewReportDAOImpl();
		return productionOldNewReportDAO;
	}

	public IProductionReportTeamDAO getProductionReportTeamDAO() {
		if(productionReportTeamDAO == null)
			productionReportTeamDAO = new ProductionReportTeamDAOImpl();
		return productionReportTeamDAO;
	}

	public IProductPriceDAO getProductionPriceDAO() {
		if(productionPriceDAO == null)
			productionPriceDAO = new ProductPriceDAOImpl();
		return productionPriceDAO;
	}

	public IRequestDAO getRequestDAO() {
		if(requestDAO == null)
			requestDAO = new RequestDAOImpl();
		return requestDAO;
	}

	public IRequestProductionDAO getRequestProductionDAO() {
		if(requestProductionDAO == null)
			requestProductionDAO = new RequestProductionDAOImpl();
		return requestProductionDAO;
	}

	public IUserDAO getUserDAO() {
		if(userDAO == null)
			userDAO = new UserDAOImpl();
		return userDAO;
	}

	public IWriteOffDAO getWriteOffDAO() {
		if(writeOffDAO == null)
			writeOffDAO = new WriteOffDAOImpl();
		return writeOffDAO;
	}
}
