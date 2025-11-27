package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.MySQLConn;
import model.Schedule;
import model.Seat;
import model.Ticket;

public class SeatRepositoryImpl implements SeatRepository {
	Connection conn;
	TicketRepository ticketRepo;
	ScheduleRepository scheduleRepo;
	public SeatRepositoryImpl(TicketRepository ticketRepo, ScheduleRepository scheduleRepo) {
		try {
			conn = ((MySQLConn)MySQLConn.getConn()).conn;
			this.ticketRepo = ticketRepo;
			this.scheduleRepo = scheduleRepo;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	private Seat mapSeat(ResultSet rs) throws SQLException {
		try {
			int id = rs.getInt("id");
			boolean booked = rs.getBoolean("booked");
			int row = rs.getInt("row");
			int column = rs.getInt("column");
			int ticketId = rs.getInt("ticketId");
			int scheduleId = rs.getInt("scheduleId");
			Ticket ticket = ticketRepo.getTicketById(Integer.toString(ticketId));
			Schedule schedule = scheduleRepo.getScheduleById(Integer.toString(scheduleId));
			return new Seat(Integer.toString(id), booked, row, column, ticket, schedule);
		}
		catch (SQLException e) {
			throw e;
		}
	}

	@Override
	public List<Seat> getSeats() throws SQLException {
		String query = "SELECT * FROM seats";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet res = ps.executeQuery();
			List<Seat> seats = new ArrayList<>();
			while (res.next()) {
				seats.add(mapSeat(res));
			}
			return seats;
		}
		catch (SQLException e) {
			throw e;
		}

	}
	@Override
	public List<Seat> getSeats(boolean booked) throws SQLException {
		String query = "SELECT * FROM seats WHERE booked = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setBoolean(1, booked);
			ResultSet res = ps.executeQuery();
			List<Seat> seats = new ArrayList<>();
			while (res.next()) {
				seats.add(mapSeat(res));
			}
			return seats;
		}
		catch (Exception e) {
			throw e;
		}
	}
	@Override
	public Seat getSeatById(String id) throws SQLException {
		String query = "SELECT * FROM seats WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ResultSet res = ps.executeQuery();
			List<Seat> seats = new ArrayList<>();
			while (res.next()) {
				return mapSeat(res);
			}
		}
		catch (Exception e) {
			throw e;
		}
		return null;
	}
	@Override
	public List<Seat> getSeatByScheduleId(String scheduleId) throws SQLException {
		String query = "SELECT * FROM seat WHERE scheduleId = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, scheduleId);
			ResultSet res = ps.executeQuery();
			List<Seat> seats = new ArrayList<>();
			while (res.next()) {
				seats.add(mapSeat(res));
			}
			return seats;
		}
		catch (Exception e) {
			throw e;
		}
	}
	@Override
	public List<Seat> getSeatByTicketId(String ticketId) throws SQLException {
		String query = "SELECT * FROM seats WHERE ticketId = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, ticketId);
			ResultSet res = ps.executeQuery();
			List<Seat> seats = new ArrayList<>();
			while (res.next()) {
				seats.add(mapSeat(res));
			}
			return seats;
		}
		catch (Exception e) {
			throw e;
		}
	}
	@Override
	public boolean createSeat(boolean booked, int row, int column, String scheduleId, String ticketId)
			throws SQLException {
		String query = "INSERT INTO seats (booked, row, column, scheduleId, ticketId) VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setBoolean(1, booked);
			ps.setInt(2, row);
			ps.setInt(3, column);
			ps.setInt(4, Integer.parseInt(scheduleId));
			ps.setInt(5, Integer.parseInt(ticketId));
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			throw e;
		}
	}
	@Override
	public boolean updateSeat(String id, boolean booked, int row, int column, String scheduleId, String ticketId)
			throws SQLException {
		String query = "UPDATE seats SET booked = ?, row = ?, column = ?, scheduleId = ?, ticketId = ? WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setBoolean(1, booked);
			ps.setInt(2, row);
			ps.setInt(3, column);
			ps.setInt(4, Integer.parseInt(scheduleId));
			ps.setInt(5, Integer.parseInt(ticketId));
			ps.setInt(6, Integer.parseInt(id));
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			throw e;
		}
	}
	@Override
	public boolean deleteSeat(String id) throws SQLException {
		String query = "DELETE FROM seats WHERE id = ?";
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
