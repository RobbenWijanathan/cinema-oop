package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.MySQLConn;
import model.IMAXStudio;
import model.Movie;
import model.PremiumStudio;
import model.Schedule;
import model.Studio;
import model.Theatre;

public class StudioRepositoryImpl implements StudioRepository {
	Connection conn;
	MovieRepository movieRepo;
	TheatreRepository theatreRepo;
	ScheduleRepository scheduleRepo;
	public StudioRepositoryImpl(
		MovieRepository movieRepo,
		TheatreRepository theatreRepo,
		ScheduleRepository scheduleRepo
	) {
		try {
			conn = ((MySQLConn)MySQLConn.getConn()).conn;
			this.movieRepo = movieRepo;
			this.theatreRepo = theatreRepo;
			this.scheduleRepo = scheduleRepo;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Studio mapStudio(ResultSet rs) {
		try {
			Integer id = rs.getInt("id");
			Integer number = rs.getInt("number");
			double basePrice = rs.getDouble("basePrice");
			Integer seatCapacity = rs.getInt("seatCapacity");
			String type = rs.getString("type");
			Integer movieId = rs.getInt("movieId");
			Integer theatreId = rs.getInt("theatreId");
			Movie movies = movieRepo.getMovieById(movieId.toString());
			Theatre theatre = theatreRepo.getTheatreById(theatreId.toString());
			ArrayList<Schedule> schedules = new ArrayList<>(scheduleRepo.getScheduleByStudioId(id.toString()));
			if(type.equals("IMAX")) {
				return new IMAXStudio(id.toString(), number, basePrice, theatreId, movies, schedules, theatre);
			}
			else if(type.equals("Premium")) {
				return new PremiumStudio(id.toString(), number, basePrice, theatreId, movies, schedules, theatre);
			}
			else {
				return new Studio(id.toString(), number, basePrice, theatreId, type, movies, schedules, theatre);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Studio> getStudios() throws SQLException {
		String query = "SELECT * FROM studios";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet res = ps.executeQuery();
			List<Studio> studios = new ArrayList<>(); 
			while(res.next()) {
				studios.add(mapStudio(res));
			}
			return studios;
		}
		catch(SQLException e) {
			throw e;
		}
	}
	@Override
	public Studio getStudioById(String id) throws SQLException {
		String query = "SELECT * FROM studios WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id));
			ResultSet res = ps.executeQuery(); 
			while(res.next()) {
				return mapStudio(res);
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
	public List<Studio> getStudioByMovieId(String movieId) throws SQLException {
		String query = "SELECT * FROM studios WHERE movieId = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(movieId));
			ResultSet res = ps.executeQuery();
			List<Studio> studios = new ArrayList<>(); 
			while(res.next()) {
				studios.add(mapStudio(res));
			}
			return studios;
		}
		catch(SQLException e) {
			throw e;
		}
		catch(Exception e) {
			throw e;
		}
	}
	@Override
	public List<Studio> getStudioByTheatreId(String theatreId) throws SQLException {
		String query = "SELECT * FROM studios WHERE theatreId = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(theatreId));
			ResultSet res = ps.executeQuery();
			List<Studio> studios = new ArrayList<>(); 
			while(res.next()) {
				studios.add(mapStudio(res));
			}
			return studios;
		}
		catch(SQLException e) {
			throw e;
		}
		catch(Exception e) {
			throw e;
		}
	}
	@Override
	public boolean createStudio(int number, double basePrice, int seatCapacity, String type, int movieId, int theatreId)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean updateStudio(String id, double basePrice, int seatCapacity, String type, int movieId, int theatreId)
			throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteStudio(String id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}
