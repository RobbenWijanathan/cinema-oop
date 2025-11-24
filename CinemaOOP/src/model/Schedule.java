package model;

import java.sql.Time;
import java.util.ArrayList;

public class Schedule {
	private String id;
	private int time;
	private ArrayList<Seat> seats;
	private Studio studio;
	public Schedule(String id, int time, ArrayList<Seat> seats, Studio studio) {
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
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
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
