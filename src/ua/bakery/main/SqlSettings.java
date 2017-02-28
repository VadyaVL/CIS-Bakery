package ua.bakery.main;

/**
 * Клас зберігання даних про налаштування доступу до БД.
 * @author Vadym
 *
 */
public final class SqlSettings {

	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String IP = "127.0.0.1";	// або localhost
	public static final String PORT = "3306";
	public static final String DB_NAME = "Bakery";
	public static final String DB_URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DB_NAME;
	public static final String USERNAME = "root";
	public static final String PASSWORD = "1111";

	// Для реалізації завантаження даних підключення до БД з файлу, або
	// для надання можливості їх зміни - потрібно буде зробити поля не final.
	static {
		// Реалізувати завантаження налаштувань підключення з файлу
		System.out.println("Завантаження даних підключення розпочато.");
		
		System.out.println("Завантаження даних підключення завершено.");
	}
	
	private SqlSettings() { }
	
}
