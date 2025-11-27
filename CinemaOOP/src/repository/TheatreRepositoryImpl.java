package repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import db.MySQLConn;
import model.Studio;
import model.Theatre;

public class TheatreRepositoryImpl implements TheatreRepository {
	Connection conn;
	StudioRepository studioRepo;
	public TheatreRepositoryImpl(StudioRepository studioRepo) {
		try {
			conn = ((MySQLConn)MySQLConn.getConn()).conn;
			this.studioRepo = studioRepo;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	private Theatre mapTheatre(ResultSet res) {
		try {
			Integer id = res.getInt("id");
			Integer theatreId = res.getInt("theatreId");
			String name = res.getString("name");
			ArrayList<Studio> studios = new ArrayList<>(studioRepo.getStudioByTheatreId(theatreId.toString()));
			return new Theatre(id.toString(), name, studios);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public List<Theatre> getTheatres() throws SQLException {
		String query = "SELECT * FROM theatres";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet res = ps.executeQuery();
			List<Theatre> theatres = new ArrayList<>();
			while(res.next()) {
				theatres.add(mapTheatre(res));
			}
			return theatres;
		}
		catch(SQLException e) {
			throw e;
		}
		catch(Exception e) {
			throw e;
		}
	}
	@Override
	public Theatre getTheatreById(String id) throws SQLException {
		String query = "SELECT * FROM theatres WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setInt(1, Integer.parseInt(id));
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				return mapTheatre(res);
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
	public Theatre getTheatreByName(String name) throws SQLException {
		String query = "SELECT * FROM theatres WHERE name LIKE ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ResultSet res = ps.executeQuery();
			while(res.next()) {
				return mapTheatre(res);
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
	public boolean createTheatre(String name) throws SQLException {
		String query = "INSERT INTO theatres (name) VALUES (?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, name);
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
	public boolean updateTheatre(String id, String name) throws SQLException {
		String query = "UPDATE theatres SET name = ? WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, name);
			ps.setInt(2, Integer.parseInt(id));
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
	public boolean deleteTheatre(String id) throws SQLException {
		String query = "DELETE FROM theatres WHERE id = ?";
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
