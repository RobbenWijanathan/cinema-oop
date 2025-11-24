package repository;

import java.sql.Connection;
import java.sql.SQLException;

import db.MySQLConn;

public class StudioRepositoryImpl {
	Connection conn;
	public StudioRepositoryImpl() {
		try {
			conn = ((MySQLConn)MySQLConn.getConn()).conn;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
