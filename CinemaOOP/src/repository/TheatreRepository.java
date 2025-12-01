package repository;

import java.sql.SQLException;
import java.util.List;

import model.Theatre;
import model.Ticket;

public interface TheatreRepository {
	public List<Theatre> getTheatres() throws SQLException;
	public Theatre getTheatreById(String id) throws SQLException;
	public Theatre getTheatreByName(String name) throws SQLException;
	public boolean createTheatre(String name) throws SQLException;
	public boolean updateTheatre(String id, String name) throws SQLException;
	public boolean deleteTheatre(String id) throws SQLException;
}
