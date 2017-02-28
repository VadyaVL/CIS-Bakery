package ua.bakery.main;

/**
 * ���� ��������� ����� ��� ������������ ������� �� ��.
 * @author Vadym
 *
 */
public final class SqlSettings {

	public static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
	public static final String IP = "127.0.0.1";	// ��� localhost
	public static final String PORT = "3306";
	public static final String DB_NAME = "Bakery";
	public static final String DB_URL = "jdbc:mysql://" + IP + ":" + PORT + "/" + DB_NAME;
	public static final String USERNAME = "root";
	public static final String PASSWORD = "1111";

	// ��� ��������� ������������ ����� ���������� �� �� � �����, ���
	// ��� ������� ��������� �� ���� - ������� ���� ������� ���� �� final.
	static {
		// ���������� ������������ ����������� ���������� � �����
		System.out.println("������������ ����� ���������� ���������.");
		
		System.out.println("������������ ����� ���������� ���������.");
	}
	
	private SqlSettings() { }
	
}
