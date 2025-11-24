package repository;

import java.sql.SQLException;
import java.util.List;

import model.Seat;
import model.Studio;

public interface SeatRepository {
	public List<Seat> getSeats() throws SQLException;
	public List<Seat> getSeats(boolean booked) throws SQLException;
	public Seat getSeatById(String id) throws SQLException;
	public Seat getSeatByScheduleId(String scheduleId) throws SQLException;
	public Seat getSeatByTicketId(String ticketId) throws SQLException;
	public boolean createSeat(boolean booked, int row, int column, String scheduleId, String ticketId) throws SQLException;
	public boolean updateSeat(String id, boolean booked, int row, int column, String scheduleId, String ticketId) throws SQLException;
	public boolean deleteSeat(String id) throws SQLException;
}
