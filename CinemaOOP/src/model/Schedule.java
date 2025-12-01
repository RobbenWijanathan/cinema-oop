package model;

import java.sql.Date;
import java.util.ArrayList;

public class Schedule {
	private String id;
	private Date time;
	private ArrayList<Seat> seats;
	private Studio studio;
	public Schedule(String id, Date time, ArrayList<Seat> seats, Studio studio) {
		super();
		this.id = id;
		this.time = time;
		this.seats = seats;
		this.studio = studio;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public ArrayList<Seat> getSeats() {
		return seats;
	}
	public void setSeats(ArrayList<Seat> seats) {
		this.seats = seats;
	}
	public Studio getStudio() {
		return studio;
	}
	public void setStudio(Studio studio) {
		this.studio = studio;
	}
}
