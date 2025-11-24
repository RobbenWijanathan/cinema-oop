package repository;

import java.sql.Connection;
import java.sql.SQLException;

import db.MySQLConn;

public class TicketRepositoryImpl {
	Connection conn;
	public TicketRepositoryImpl() {
		try {
			conn = ((MySQLConn)MySQLConn.getConn()).conn;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
}
