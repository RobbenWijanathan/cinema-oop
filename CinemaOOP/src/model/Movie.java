package model;

import java.util.ArrayList;

public class Movie {
	private String id;
	private String title;
	private String genre;
	private String director;
	private ArrayList<String> actors;
	private int duration;
	private String ageRating;
	private double rating;
	public Movie(String id, String title, String genre, String director, ArrayList<String> actors, int duration,
			String ageRating, double rating) {
		super();
		this.id = id;
		this.title = title;
		this.genre = genre;
		this.director = director;
		this.actors = actors;
		this.duration = duration;
		this.ageRating = ageRating;
		this.rating = rating;
	}
	public String getId() {
		return id;
	}
	public String getTitle() {
		return title;
	}
	public String getGenre() {
		return genre;
	}
	public String getDirector() {
		return director;
	}
	public ArrayList<String> getActors() {
		return new ArrayList<>(actors);
	}
	public int getDuration() {
		return duration;
	}
	public String getAgeRating() {
		return ageRating;
	}
	public double getRating() {
		return rating;
	}	
}
