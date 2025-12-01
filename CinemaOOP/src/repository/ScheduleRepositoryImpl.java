package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import db.MySQLConn;
import model.Schedule;
import model.Seat;
import model.Studio;

public class ScheduleRepositoryImpl implements ScheduleRepository {
	Connection conn;
	SeatRepository seatRepo;
	StudioRepository studioRepo;
	public ScheduleRepositoryImpl(SeatRepository seatRepo, StudioRepository studioRepo) {
		try {
			conn = ((MySQLConn)MySQLConn.getConn()).conn;
			this.seatRepo = seatRepo;
			this.studioRepo = studioRepo;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	private Schedule mapSchedule(ResultSet rs) throws SQLException {
		try {
			Integer id = rs.getInt("id");
			Date time = rs.getDate("time");
			ArrayList<Seat> seats = new ArrayList<>(seatRepo.getSeatByScheduleId(id.toString()));
			Integer studioId = rs.getInt("studioId");
			Studio studio = studioRepo.getStudioById(studioId.toString());
			return new Schedule(id.toString(), time, seats, studio);
		}
		catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Schedule> getSchedules() throws SQLException {
		String query = "SELECT * FROM schedules";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet res = ps.executeQuery();
			ArrayList<Schedule> schedules = new ArrayList<>();
			while (res.next()) {
				schedules.add(mapSchedule(res));
			}
			return schedules;
		}
		catch (Exception e) {
			throw e;
		}

	}
	@Override
	public Schedule getScheduleById(String id) throws SQLException {
		String query = "SELECT * FROM schedules WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				return mapSchedule(res);
			}
		}
		catch (Exception e) {
			throw e;
		}
		return null;
	}
	@Override
	public List<Schedule> getScheduleByStudioId(String studioId) throws SQLException {
		String query = "SELECT * FROM schedules WHERE studioId = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, studioId);
			ResultSet res = ps.executeQuery();
			ArrayList<Schedule> schedules = new ArrayList<>();
			while (res.next()) {
				schedules.add(mapSchedule(res));
			}
			return schedules;
		}
		catch (Exception e) {
			throw e;
		}
	}
	@Override
	public boolean createSchedule(Date time, String studioId) throws SQLException {
		String query = "INSERT INTO schedules (time, studioId) VALUES (?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDate(1, time);
			ps.setString(2, studioId);
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			throw e;
		}
	}
	@Override
	public boolean updateSchedule(String id, Date time, String studioId) throws SQLException {
		String query = "UPDATE schedules SET time = ?, studioId = ? WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDate(1, time);
			ps.setString(2, studioId);
			ps.setString(3, id);
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			throw e;
		}
	}
	@Override
	public boolean deleteSchedule(String id) throws SQLException {
		String query = "DELETE FROM schedules WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			throw e;
		}
	}
	
}
