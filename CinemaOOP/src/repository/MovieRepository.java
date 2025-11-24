package repository;

import java.sql.SQLException;
import java.util.List;

import model.Movie;

public interface MovieRepository {
	public List<Movie> getMovies() throws SQLException;
	public Movie getMovieById(String id) throws SQLException;
	public List<Movie> getMovieByTitle(String title) throws SQLException;
	public boolean createMovie(String title, String genre, String director, String actors, int duration, String ageRating, double rating) throws SQLException;
	public boolean updateMovie(String id) throws SQLException;
	public boolean deleteMovie(String id) throws SQLException;
}
