package repository;

import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

import model.Studio;

public interface ScheduleRepository {
	public List<Studio> getStudios() throws SQLException;
	public Studio getStudioById(String id) throws SQLException;
	public Studio getStudioByMovieId(String movieId) throws SQLException;
	public Studio getStudioByTheatreId(String theatreId) throws SQLException;
	public boolean createStudio(Date time, String studioId) throws SQLException;
	public boolean updateStudio(String id, Date time, String studioId) throws SQLException;
	public boolean deleteStudio(String id) throws SQLException;
}
