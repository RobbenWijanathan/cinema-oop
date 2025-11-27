package repository;

import java.sql.SQLException;
import java.util.List;

import model.Ticket;

public interface TicketRepository {
	public List<Ticket> getTickets() throws SQLException;
	public Ticket getTicketById(String id) throws SQLException;
	public List<Ticket> getTicketByScheduleId(String scheduleId) throws SQLException;
	public List<Ticket> getTicketByUserId(String userId) throws SQLException;
	public boolean createTicket(double ticketPrice, int scheduleId, int userId) throws SQLException;
	public boolean updateTicket(String id, double ticketPrice, int scheduleId, int userId) throws SQLException;
	public boolean deleteTicket(String id) throws SQLException;
}
