package repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import db.MySQLConn;
import model.Movie;

public class MovieRepositoryImpl implements MovieRepository {
	Connection conn;
	public MovieRepositoryImpl() {
		try {
			conn = ((MySQLConn)MySQLConn.getConn()).conn;
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	public Movie mapMovie(ResultSet rs) throws SQLException {
		int id = rs.getInt("id");
		String title = rs.getString("title");
		String genre = rs.getString("genre");
		String director = rs.getString("director");
		String actors = rs.getString("actors");
		String[] actorsList = actors.split(";");
		ArrayList<String> actorsArrayList = new ArrayList<>(Arrays.asList(actorsList));
		int duration = rs.getInt("duration");
		String ageRating = rs.getString("ageRating");
		double rating = rs.getDouble("rating");
		return new Movie(Integer.toString(id), title, genre, director, actorsArrayList, duration, ageRating, rating);
	}

	@Override
	public List<Movie> getMovies() throws SQLException {
		String query = "SELECT * FROM movies";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			List<Movie> movies = new ArrayList<>();
			while (rs.next()) {
				movies.add(mapMovie(rs));
			}
			return movies;
		}
		catch (Exception e) {
			throw e;
		}
	}
	@Override
	public Movie getMovieById(String id) throws SQLException {
		String query = "SELECT * FROM movies WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return mapMovie(rs);
			}
		}
		catch (Exception e) {
			throw e;
		}
		return null;
	}
	@Override
	public List<Movie> getMovieByTitle(String title) throws SQLException {
		String query = "SELECT * FROM movies WHERE title LIKE ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, title);
			ResultSet rs = ps.executeQuery();
			List<Movie> movies = new ArrayList<>();
			while (rs.next()) {
				movies.add(mapMovie(rs));
			}
			return movies;
		}
		catch (Exception e) {
			throw e;
		}

	}
	@Override
	public boolean createMovie(String title, String genre, String director, String actors, Date duration,
			String ageRating, double rating) throws SQLException {
		String query = "INSERT INTO movies (title, genre, director, actors, duration, ageRating, rating) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, genre);
			ps.setString(3, director);
			ps.setString(4, actors);
			ps.setDate(5, duration);
			ps.setString(6, ageRating);
			ps.setDouble(7, rating);
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			throw e;
		}
	}
	@Override
	public boolean updateMovie(String id, String title, String genre, String director, String actors, Date duration, String ageRating, double rating) throws SQLException {
		String query = "UPDATE movies SET title = ?, genre = ?,  director = ?, actors = ?, duration = ?, ageRating = ?, rating = ? WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, title);
			ps.setString(2, genre);
			ps.setString(3, director);
			ps.setString(4, actors);
			ps.setDate(5, duration);
			ps.setString(6, ageRating);
			ps.setDouble(7, rating);
			ps.setString(8, id);
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			throw e;
		}
	}
	@Override
	public boolean deleteMovie(String id) throws SQLException {
		String query = "DELETE FROM movies WHERE id = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, id);
			ps.executeUpdate();
			return true;
		}
		catch (Exception e) {
			throw e;
		}
	}
}
