package repository;

import java.sql.SQLException;
import java.util.List;

import model.Studio;

public interface StudioRepository {
	public List<Studio> getStudios() throws SQLException;
	public Studio getStudioById(String id) throws SQLException;
	public Studio getStudioByMovieId(String movieId) throws SQLException;
	public Studio getStudioByTheatreId(String theatreId) throws SQLException;
	public boolean createStudio(int number, double basePrice, int seatCapacity, String type, int movieId, int theatreId) throws SQLException;
	public boolean updateStudio(String id, double basePrice, int seatCapacity, String type, int movieId, int theatreId) throws SQLException;
	public boolean deleteStudio(String id) throws SQLException;
}
