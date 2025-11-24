package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import db.MySQLConn;
import model.Schedule;
import model.Seat;
import model.Ticket;
import model.User;

public class TicketRepositoryImpl implements TicketRepository {
	Connection conn;
	SeatRepository seatRepo;
	UserRepository userRepo;
	ScheduleRepository scheduleRepo;
	public TicketRepositoryImpl(SeatRepository seatRepo, UserRepository userRepo, ScheduleRepository scheduleRepo) {
		try {
			conn = ((MySQLConn)MySQLConn.getConn()).conn;
			this.seatRepo = seatRepo;
			this.userRepo = userRepo;
			this.scheduleRepo = scheduleRepo;
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Ticket mapTicket(ResultSet rs) throws SQLException {
		try {
			Integer id = (rs.getInt("id"));
			double ticketPrice = rs.getDouble("ticketPrice");
			Integer scheduleId = rs.getInt("scheduleId");
			Integer userId = rs.getInt("userId");
			ArrayList<Seat> seats = new ArrayList<>(seatRepo.getSeatByScheduleId(scheduleId.toString()));
			User user = userRepo.getUserById(userId.toString());
			Schedule schedule = scheduleRepo.getScheduleById(scheduleId.toString());
			return new Ticket(id.toString(), ticketPrice, seats, schedule, user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public List<Ticket> getTickets() throws SQLException {
		String query = "SELECT * FROM tickets";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet res = ps.executeQuery();
			List<Ticket> tickets = new ArrayList<>();
			while(res.next()) {
				tickets.add(mapTicket(res));
			}
			return tickets;
		}
		catch(SQLException e) {
			throw e;
		}
		catch(Exception e) {
			throw e;
		}
	}
	public Ticket getTicketById(String id) throws SQLException {
		String query = "SELECT * FROM tickets WHERE id LIKE ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id));
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				return mapTicket(res);
			}
		}
		catch(SQLException e) {
			throw e;
		}
		catch(Exception e) {
			throw e;
		}
		return null;
	}
	
	
	@Override
	public List<Ticket> getTicketByScheduleId(String scheduleId) throws SQLException {
		String query = "SELECT * FROM tickets WHERE scheduleId LIKE ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, scheduleId);
			ResultSet res = ps.executeQuery();
			List<Ticket> tickets = new ArrayList<>();
			while(res.next()) {
				tickets.add(mapTicket(res));
			}
			return tickets;
		}
		catch(SQLException e) {
			throw e;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public List<Ticket> getTicketByUserId(String userId) throws SQLException {
		String query = "SELECT * FROM tickets WHERE userId LIKE ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, userId);
			ResultSet res = ps.executeQuery();
			List<Ticket> tickets = new ArrayList<>();
			while(res.next()) {
				tickets.add(mapTicket(res));
			}
			return tickets;
		}
		catch(SQLException e) {
			throw e;
		}
		catch(Exception e) {
			throw e;
		}
	}
	
	@Override
	public boolean createTicket(double ticketPrice, int scheduleId, int userId) throws SQLException {
		String query = "INSERT INTO tickets (ticketPrice, scheduleId, userId) VALUES (?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, ticketPrice);
			ps.setInt(2, scheduleId);
			ps.setInt(3, userId);
			ps.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			throw e;
		}
		catch(Exception e) {
			throw e;
		}
	}
	@Override
	public boolean updateTicket(String id, double ticketPrice, int scheduleId, int userId) throws SQLException {
		String query = "UPDATE users SET ticketPrice = ?, scheduleId = ?, userId = ? WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setDouble(1, ticketPrice);
			ps.setInt(2, scheduleId);
			ps.setInt(3, userId);
			ps.setInt(4, Integer.parseInt(id));
			ps.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			throw e;
		}
		catch(Exception e) {
			throw e;
		}
	}
	@Override
	public boolean deleteTicket(String id) throws SQLException {
		String query = "DELETE FROM users WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id));
			ps.executeUpdate();
			return true;
		}
		catch(SQLException e) {
			throw e;
		}
		catch(Exception e) {
			throw e;
		}
	}
}
