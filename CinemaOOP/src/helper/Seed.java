package helper;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import db.DBConn;
import db.MySQLConn;

public class Seed {
	public static boolean migrate(MySQLConn conn) throws SQLException {
		String sql = 
		PreparedStatement ps = conn.conn.prepareStatement(sql);
		statement 
		return true;
	}
}
