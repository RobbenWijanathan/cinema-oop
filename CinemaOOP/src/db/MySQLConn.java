package db;
import java.sql.*;
public class MySQLConn implements DBConn {
	private UrlConn connUrl = new MySQLUrlConn("finalcinema");
	public Connection conn;
	private static DBConn db;
	private MySQLConn() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		String tempUrl = ((MySQLUrlConn)connUrl).getUrl();
		String tempUsername = ((MySQLUrlConn)connUrl).getUsername();
		String tempPass = ((MySQLUrlConn)connUrl).getPassword();
		conn = DriverManager.getConnection(tempUrl, tempUsername, tempPass);
	}
	public static DBConn getConn() throws SQLException, ClassNotFoundException {		
		if(MySQLConn.db == null) {
			MySQLConn.db = new MySQLConn();
		}
		return MySQLConn.db;
	}
}
