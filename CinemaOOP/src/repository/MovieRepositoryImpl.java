package repository;

import java.sql.Connection;
import java.sql.SQLException;
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
	@Override
	public List<Movie> getMovies() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public Movie getMovieById(String id) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public List<Movie> getMovieByTitle(String title) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean createMovie(String title, String genre, String director, String actors, int duration,
			String ageRating, double rating) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean updateMovie(String id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public boolean deleteMovie(String id) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
}
