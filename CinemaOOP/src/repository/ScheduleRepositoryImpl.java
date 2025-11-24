package repository;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import db.MySQLConn;
import model.Schedule;
import model.Studio;

public class ScheduleRepositoryImpl implements ScheduleRepository {
	Connection conn;
	public ScheduleRepositoryImpl() {
		try {
			conn = ((MySQLConn)MySQLConn.getConn()).conn;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Schedule> getSchedules() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Schedule getScheduleById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Schedule> getScheduleByStudioId(String studioId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean createSchedule(Date time, String studioId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean updateSchedule(String id, Date time, String studioId) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteSchedule(String id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	
}
