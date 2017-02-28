package ua.bakery.main;

/**
 * ����������� - ��������� ��������.
 * � ��� �������� ������������� ������ �� ��.
 * @author Vadym
 *
 */
public final class SqlQuery {	// ����������� ��������� �����������

	public final static String SELECT_USER = "SELECT * FROM User"; 
	public final static String SELECT_LOG = "SELECT * FROM Log"; 
	public final static String SELECT_LOG_BY_USER = "SELECT * FROM Log WHERE User_id = ?"; 
	
	private SqlQuery() { }	// �������� �������� ��'����
	
}
