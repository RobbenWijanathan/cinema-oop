import java.sql.SQLException;
import java.sql.Statement;

import db.DBConn;
import db.MySQLConn;

public class Main {
    public Main() {
    	MySQLConn test;
		try {
			test = (MySQLConn) MySQLConn.getConn();
			Statement st = test.conn.createStatement();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
    }
    public static void main(String[] args){
        new Main();
    }
}
