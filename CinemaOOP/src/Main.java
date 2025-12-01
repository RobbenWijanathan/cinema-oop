import java.sql.SQLException;
import java.sql.Statement;

import db.DBConn;
import db.MySQLConn;
import ui_ux.Landing;

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
		Landing landing = new Landing();
		landing.loginRegister();
    }
    public static void main(String[] args){
        new Main();
    }
}
