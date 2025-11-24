package repository;

import java.sql.SQLException;
import java.util.List;

import model.Studio;

public interface StudioRepository {
	public List<Studio> getStudios() throws SQLException;
	public Studio getStudioById(String id) throws SQLException;
	public List<Studio> getStudioByMovieId(String movieId) throws SQLException;
	public List<Studio> getStudioByTheatreId(String theatreId) throws SQLException;
	public boolean createStudio(int number, double basePrice, int seatCapacity, String type, int movieId, int theatreId) throws SQLException;
	public boolean updateStudio(String id, int number, double basePrice, int seatCapacity, String type, String movieId, String theatreId) throws SQLException;
	public boolean deleteStudio(String id) throws SQLException;
}
