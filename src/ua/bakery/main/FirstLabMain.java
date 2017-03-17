package ua.bakery.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import ua.bakery.db.entity.*;
import ua.bakery.services.ProgramSettings;
import ua.bakery.services.SqlQuery;
import ua.bakery.services.SqlSettings;

@Deprecated
public class FirstLabMain {

	private static ArrayList<User> users;
	private static ArrayList<Client> clients;
	private static ArrayList<Request> requests;
	
	
	public static void main(String[] args) {
		demonstrateSelectUser();
		showList(users);
		demonstrateSelectClientAndRequest();
		showList(clients);
		demonstrateSelectRequestByClient(clients.get(0));
		showList(requests);
		
		// Додати заявку по юзеру і клієнту
		demonstrateInsertRequest(users.get(0), clients.get(0));
		
		// Видалити заявку юзера
		demonstrateRemoveRequest(requests.get(requests.size()-1));
	}
	
	// Демонстарція вибірки клієнтів і всіх замовлень певного клієнта
	public static void demonstrateSelectClientAndRequest(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		clients = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(SqlSettings.DB_URL, SqlSettings.USERNAME, SqlSettings.PASSWORD);
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(SqlQuery.SELECT_CLIENT);
			  
			while(resultSet.next()){
				int id  = resultSet.getInt("id");
				String name = resultSet.getString("name");
				
				Client client = new Client(id, name);
				clients.add(client);
			}
			  
			resultSet.close();
			stmt.close();
			conn.close();
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	public static void demonstrateSelectRequestByClient(Client client){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		requests = new ArrayList<>();
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(SqlSettings.DB_URL, SqlSettings.USERNAME, SqlSettings.PASSWORD);
			stmt = conn.prepareStatement(SqlQuery.SELECT_REQUEST_BY_CLIENT);
			stmt.setInt(1, client.getId());
			resultSet = stmt.executeQuery();
			  
			while(resultSet.next()){
				int id  = resultSet.getInt("id");
				Date dateReq = resultSet.getTimestamp("Date_Request");
				Date dateOf = resultSet.getTimestamp("Date_Oformleniya");
				Boolean ok = resultSet.getBoolean("OK");

				requests.add(new Request(id, dateReq, dateOf, ok));
			}
			  
			//STEP 6: Clean-up environment
			resultSet.close();
			stmt.close();
			conn.close();
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	// Демонстрація вибірки користувачі
	public static void demonstrateSelectUser(){
		Connection conn = null;
		Statement stmt = null;
		ResultSet resultSet = null;
		users = new ArrayList<>();
		
		try {
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 3: Open a connection
			conn = DriverManager.getConnection(SqlSettings.DB_URL, SqlSettings.USERNAME, SqlSettings.PASSWORD);
			//STEP 4: Execute a query
			stmt = conn.createStatement();
			resultSet = stmt.executeQuery(SqlQuery.SELECT_USER);
			  
			//STEP 5: Extract data from result set
			while(resultSet.next()){
				int id  = resultSet.getInt("id");
				String username = resultSet.getString("username");
				String password = resultSet.getString("password");
				String realName = resultSet.getString("realName");
				String photo = resultSet.getString("photo");
				int accessLevel = resultSet.getInt("accessLevel");
				
				User user = new User(id, username, password, realName, photo, accessLevel);
				user.setLogs(selectLogByUser(user));
				
				users.add(user);
			}
			  
			//STEP 6: Clean-up environment
			resultSet.close();
			stmt.close();
			conn.close();
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	// Демонстрація вибірки логів по користувачу
	public static List<Log> selectLogByUser(User user){
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet resultSet = null;
		ArrayList<Log> logs = new ArrayList<>();
		
		try {
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 3: Open a connection
			conn = DriverManager.getConnection(SqlSettings.DB_URL, SqlSettings.USERNAME, SqlSettings.PASSWORD);
			//STEP 4: Execute a query
			stmt = conn.prepareStatement(SqlQuery.SELECT_LOG_BY_USER);
			stmt.setInt(1, user.getId());
			resultSet = stmt.executeQuery();
			  
			//STEP 5: Extract data from result set
			while(resultSet.next()){
				int id  = resultSet.getInt("id");
				Date dateTime = resultSet.getTimestamp("DateTime");
				String action = resultSet.getString("Action");

				logs.add(new Log(id, dateTime, action, user));
			}
			  
			//STEP 6: Clean-up environment
			resultSet.close();
			stmt.close();
			conn.close();
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	
		return logs;
	}
	
	//
	public static void demonstrateInsertRequest(User user, Client client){
		// Сформували нову заявку
		Request req = new Request(new Date(2017, 3, 25), new Date(), false);
		req.setClient(client);
		req.setUser(user);
		// Потім можна додати продукцію, але в демонстрації цього не робтимемо
		
		Connection conn = null;
		PreparedStatement pStmt = null;
		
		try {
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 3: Open a connection
			conn = DriverManager.getConnection(SqlSettings.DB_URL, SqlSettings.USERNAME, SqlSettings.PASSWORD);
			//STEP 4: Execute a query
			pStmt = conn.prepareStatement(SqlQuery.INSERT_REQUEST);
			pStmt.setInt(1, client.getId());
			pStmt.setString(2, ProgramSettings.dateFormat.format(req.getDateRequest()));
			pStmt.setString(3, ProgramSettings.dateFormat.format(req.getDateOformleniya()));
			pStmt.setInt(4, (req.isOk() ? 1 : 0));
			pStmt.setInt(5, user.getId());

			pStmt.executeUpdate();
						  
			pStmt.close();
			conn.close();
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
		}
		
	}
	
	public static void demonstrateRemoveRequest(Request req){
		
		// Спочатку необхідно видалити дані many-to-many, але цього не робитимемо в демонстраційному коді
		
		Connection conn = null;
		PreparedStatement pStmt = null;
		
		try {
			//STEP 2: Register JDBC driver
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 3: Open a connection
			conn = DriverManager.getConnection(SqlSettings.DB_URL, SqlSettings.USERNAME, SqlSettings.PASSWORD);
			//STEP 4: Execute a query
			pStmt = conn.prepareStatement(SqlQuery.DELETE_REQUEST);
			pStmt.setInt(1, req.getId());

			pStmt.executeUpdate();
						  
			pStmt.close();
			conn.close();
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	// Метод відображення списку
	public static <T> void showList(ArrayList<T> list){
		for (T ob : list) {
			System.out.println(ob);
		}
	}

}
