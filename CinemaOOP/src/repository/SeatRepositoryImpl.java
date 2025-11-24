package repository;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import db.MySQLConn;
import model.Seat;

public class SeatRepositoryImpl implements SeatRepository {
	Connection conn;
	public SeatRepositoryImpl() {
		try {
			conn = ((MySQLConn)MySQLConn.getConn()).conn;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	@Override
	public List<Seat> getSeats() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Seat> getSeats(boolean booked) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Seat getSeatById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Seat> getSeatByScheduleId(String scheduleId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Seat> getSeatByTicketId(String ticketId) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean createSeat(boolean booked, int row, int column, String scheduleId, String ticketId)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean updateSeat(String id, boolean booked, int row, int column, String scheduleId, String ticketId)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteSeat(String id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}
