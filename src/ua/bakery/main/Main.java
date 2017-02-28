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

public class Main {
	
	public static void main(String[] args) {
		demonstrateSelectUser();
	}

	// Демонстрація вибірки користувачі
	public static void demonstrateSelectUser(){
			Connection conn = null;
			Statement stmt = null;
			ResultSet resultSet = null;
			ArrayList<User> users = new ArrayList<>();
			
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
		
			showList(users);
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
	
	public static <T> void showList(ArrayList<T> list){
		for (T ob : list) {
			System.out.println(ob);
		}
	}

}
