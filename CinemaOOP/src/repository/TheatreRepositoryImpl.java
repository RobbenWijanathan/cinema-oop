package repository;

import java.sql.Connection;
import java.sql.SQLException;

import db.MySQLConn;

public class TheatreRepositoryImpl {
	Connection conn;
	public TheatreRepositoryImpl() {
		try {
			conn = ((MySQLConn)MySQLConn.getConn()).conn;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
