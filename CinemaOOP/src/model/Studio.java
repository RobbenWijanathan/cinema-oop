package model;

import java.util.ArrayList;

public class Studio {
	private String id;
	private int number;
	private double basePrice;
	private int seatCapacity;
	private Movie movie;
	private ArrayList<Schedule> schedules;
	private Theatre theatre;
	
	public Studio(String id, int number, double basePrice, int seatCapacity, Movie movie, ArrayList<Schedule> schedules,
			Theatre theatre) {
		super();
		this.id = id;
		this.number = number;
		this.basePrice = basePrice;
		this.seatCapacity = seatCapacity;
		this.movie = movie;
		this.schedules = schedules;
		this.theatre = theatre;
	}

	public String getId() {
		return id;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getBasePrice() {
		return basePrice;
	}

	public void setBasePrice(double basePrice) {
		this.basePrice = basePrice;
	}

	public int getSeatCapacity() {
		return seatCapacity;
	}

	public void setSeatCapacity(int seatCapacity) {
		this.seatCapacity = seatCapacity;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public ArrayList<Schedule> getSchedules() {
		return schedules;
	}

	public void setSchedules(ArrayList<Schedule> schedules) {
		this.schedules = schedules;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}		 
}
